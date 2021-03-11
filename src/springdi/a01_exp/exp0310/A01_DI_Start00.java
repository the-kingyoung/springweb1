package springdi.a01_exp.exp0310;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.a01_exp.z01_vo.Ceo;
import springdi.a01_exp.z01_vo.Company;
import springdi.a01_exp.z01_vo.Emp;
import springdi.a01_exp.z01_vo.Manager;

public class A01_DI_Start00 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가상의 컨테이너 xml 파일 호출하기.
		AbstractApplicationContext ctx
		=new GenericXmlApplicationContext(
				"springdi\\a01_exp\\exp0310\\container00.xml");
		Company company = ctx.getBean("company",Company.class);
		Ceo ceo = ctx.getBean("ceo",Ceo.class);
		ceo.setName("홍길동");
		
		Manager manager = ctx.getBean("manager",Manager.class);
		manager.setName("김길동");
		
		Emp emp = ctx.getBean("emp",Emp.class);
		emp.setName("신길동");
		
		company.show();
	}

}
