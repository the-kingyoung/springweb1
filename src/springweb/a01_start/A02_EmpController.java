package springweb.a01_start;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
//springweb.a01_start.A02_EmpController
import org.springframework.web.bind.annotation.RequestMapping;

import jspexp.a03_database.A01_Dao;
import jspexp.z01_vo.Dept;
import jspexp.z01_vo.Emp;

@Controller
public class A02_EmpController {
	
	@Autowired(required = false)
	private B01_EmpService service;
	
	// spring에서는 가능한한 container에서 객체가 생성되어 메모리가 로딩된
	// 상태에서 객체를 활용하기 때문에
	// autowiring에 의해서 메모리 할당으로 객체를 활용할 수 있다.
	// 컨테이너 메모리에 할당된 객체는 new XXX()을 사용할 수 없다.
	@Autowired(required = false)
	private A01_Dao dao;
	
	@Value("${user}")
	private String user;	// 공통으로 설정된 변수가 할당된다.
	@Value("${pass}")
	private String pass;
	// 공통 모델 어트리뷰터 선언.
	@ModelAttribute("deptList")
	public ArrayList<Dept> getDlist(){
		return dao.deptList();
	}
	@ModelAttribute("mgrList")
	public ArrayList<Emp> mgrList(){
		return dao.mgrList();
	}
	
	
	
	// emp검색 수정 처리.
	// http://localhost:7080/springweb/empList.do
	@RequestMapping("empList.do")
	public String empList(@ModelAttribute("sch") Emp sch, Model d) {
		//객체 생성없이 호출 처리됨!!
		service.call();
		// DAO객체 생성 부분 삭제..
		if(sch.getEname()==null) sch.setEname("");
		if(sch.getJob()==null) sch.setJob("");
		d.addAttribute("emplist", dao.empList(sch));		
		return "WEB-INF\\views\\a01_start\\a08_empList.jsp";
	}
	
/*
SELECT DISTINCT m.mgr, m.ename
FROM emp e, emp m
WHERE e.mgr=m.empno;
--관리자 mgr의 실제 이름 정보

1. dao 추가 작성
2. modelattribute
3. 검색 내용 추가 : 관리자
	<select name="mgr"
		<option value="0">관리자</option>
		<option value="7566">JONES</option>
			7566	JONES
			7782	CLARK
			7839	KING
			7902	FORD
4. 검색리스트 출력 처리.
	조회 리스트 sql 변경..
	
 */

}










////ex) http://localhost:7080/springweb/deptList.do
//@RequestMapping("deptList.do")
//public String deptList(Dept sch, Model d) {
//	A00_DeptDao dao = new A00_DeptDao();
//	if(sch.getDname()==null) sch.setDname("");
//	if(sch.getLoc()==null) sch.setLoc("");
//	d.addAttribute("deptlist", dao.display(sch.getDname(), sch.getLoc()));
//	return "WEB-INF\\views\\a01_start\\a09_deptList.jsp";
//}