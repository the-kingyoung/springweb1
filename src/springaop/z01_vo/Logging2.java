package springaop.z01_vo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// springaop.z01_vo.Logging2
public class Logging2 {
	// 로그 처리 기능 클래스 선언.
	private static final Logger logger
	=LoggerFactory.getLogger(Logging2.class);
	// 1. 이전 시점
	public void logBeforme(JoinPoint joinPoint) {
		logger.debug("logBefore()");
	}
	// 2. 이후 시점
	public void logAfter(JoinPoint joinPoint) {
		logger.debug("logAfter()");
	}
	// 3. 수행하는 중간에 처리
	public Object logAround(ProceedingJoinPoint jointPoint) throws Throwable {
		// 1) jointPoint 객체 리턴 (대상)
		Object thisObj = jointPoint.getTarget();
		// 2) 대상객체의 이름, 메서드명, 매개변수..
		String className = thisObj.getClass().getName();
		String methodName = jointPoint.getSignature().getName();
		Object[] args = jointPoint.getArgs();
		// 3) 시간 측정
		long currentTime = System.currentTimeMillis();
		logger.debug("###########################");
		logger.debug("########시	   작#########");
		logger.debug("[class]:"+className);
		logger.debug("[methodName]:"+methodName+"()");
		Object returnObj = jointPoint.proceed();
		// 수행처리. 예외 처리는 throws Throwable
		logger.debug("########수행이후#########");
		logger.debug("[class]:"+className);
		logger.debug("소요시간:"+(System.currentTimeMillis()-currentTime)+"ms");
		
		
		logger.debug("########종료#########");
		
		return thisObj;
	}
	
}
