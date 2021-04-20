package springaop.z01_vo;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;
// springaop.z01_vo.Logging
// aop 처리할 메서드 선언.
public class Logging implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invoke) throws Throwable {
		// TODO Auto-generated method stub
		// MethodInvocation : 대상 객체에 대한 정보를 가지고 올 수 있음.
		// 1. getMethod.getName() : 대상 객체의 메서드 이름
		// 2. proceed() : 수행되는 대상 객체.
		// 처리할 내용 : 해당 기능 객체의 메서드가 수행하는 시간을 처리..
		// 1. 시간 측정을 위한 StopWatch 클래스 선언..
		// 		.start() : 스탑워치의 시작시간 설정
		//		.stop()	: 스탑워치의 마지막시간 설정
		//		.getTotalTimeMillis() : 위에 수행한 시작메서드와 마지막메서드
		//			를 통해 수행한 시작을 1/1000초 단위로 가져온다.
		String methodName = invoke.getMethod().getName();
		System.out.println("대상 객체의 수행 메서드(시작):"+methodName);
		StopWatch sw = new StopWatch();
		// 시작시간 check
		sw.start();
		
		Object obj = invoke.proceed(); // 대상 객체의 수행 처리 process
		// 수행후 시작 check
		sw.stop();
		System.out.println("대상 객체의 수행 메서드(종료):"+methodName);
		System.out.println("대상 객체의 수행 시간:"
					+(sw.getTotalTimeMillis()/1000.0)+"초");
		return obj;
	}

}
