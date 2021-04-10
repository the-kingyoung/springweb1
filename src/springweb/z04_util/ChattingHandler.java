package springweb.z04_util;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
/*
	# chatting Handler 구현
		0. client와 url pattern 방식으로 접속, 메시지 전송,
			메시지 받기, 접속 종료, 예외 처리를 해주는 모듈
			컨테이너에 chatHandler ==> /chat.do
		1. TextWebSocketHandler를 기본 클래스로 상속
			1) overriding 해야할 메서드 정의
				(client의 처리 함수와 연동 처리)
				- 접속 시 처리할 내용
				- 채팅 시 처리할 내용
				- 접속 후 처리할 내용
				- 예외가 발생 시 처리할 내용
				chatHandler" path="/chat-ws.do"
			2) 화면에서 해당 js 기능메서드와 핸들러 클래스의 메서드와 연동되어 처리된다
 */


@Component("chatHandler")
public class ChattingHandler extends TextWebSocketHandler{
   // 접속한 사용자들에 대한 정보를 저장하는 전역변수
   private Map<String, WebSocketSession> 
   	users = new ConcurrentHashMap();
   
   // 접속 시
   @Override
   public void afterConnectionEstablished(WebSocketSession session) throws Exception {
      // TODO Auto-generated method stub
      super.afterConnectionEstablished(session);
      log(session.getId()+"님 접속합니다.");
      // 접속한 id와 session을 누적처리
      users.put(session.getId(), session);
   }
// 메시지를 보낼 때 : 
   //   1) 접속한 사용자 중에서 메시지를 보낼 때(메시지 수신)
   //   2) 접속한 사용자들에게 메시지를 전송(메시지 발송) : 접속할 때,
   //      접속한 사용자를 전역변수로 선언하여 할당처리한다.
   @Override
   protected void handleTextMessage(WebSocketSession session, 
         TextMessage message) throws Exception {
      // TODO Auto-generated method stub
      super.handleTextMessage(session, message);
      System.out.println(session.getId()
            +"가 보낸 메시지:"
            +message.getPayload());
      // 각 접속자에게 메시지를 전송(모두에게 전송)
      //   특정한 접속자에게 전송시 조건문 처리.
      for(WebSocketSession ws:users.values()) {
         ws.sendMessage(message);
         System.out.println(ws.getId()+"에게 메시지 전달!!");
      }
      
   }
   // 접속을 종료 후
   @Override
   public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
      // TODO Auto-generated method stub
      super.afterConnectionClosed(session, status);
      System.out.println(session.getId()+"접속을 종료합니다.");
      users.remove(session.getId());// 접속한 사용자에서 제외 처리.
      
   }
   
   // 예외가 발생했을 때
   @Override
   public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
      // TODO Auto-generated method stub
      super.handleTransportError(session, exception);
      System.out.println(session.getId()+"사용자 에러 발생 "
    		  	+exception.getMessage());
      
   }
   // 시간 표시 로그 처리
   private void log(String msg) {
	   System.out.println(new Date()+":"+msg);
   }

   

}