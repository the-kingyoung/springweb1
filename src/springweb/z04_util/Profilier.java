package springweb.z04_util;

import org.aspectj.lang.ProceedingJoinPoint;

// springweb.z04_util.Profilier
// 수행할 내용 처리 advice 클래스
public class Profilier {
	// 특정한 시점에서 해당 프로그램 내용이 진행되게 처리
	public Object trace(ProceedingJoinPoint jointPoint) {
		Object result=null;
		// 해당 객체의 특정 메서드의 수행시간 check
		// 1. 시작 시간
		String sign = jointPoint.getSignature().toShortString();
		System.out.println(sign+"의 시작!!");
		long start = System.currentTimeMillis();
		// 2. 처리 시간
		try {
			result = jointPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("수행 처리 에러 : "+ e.getMessage());
		} finally {
			// 3. 처리 완료 시간
			long finish = System.currentTimeMillis();
			System.out.println(sign + "의 종료!!!");
			System.out.println("수행시간:"+(finish-start)+"MS");
		}
		return result;
	}

}
