package springweb.a02_mvc.a01_controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springdi.z01_vo.Person;
import springweb.a02_mvc.a02_service.A01_EmpService;
import springweb.a02_mvc.a02_service.A02_DeptService;
import springweb.a02_mvc.a02_service.A03_AjaxService;
import springweb.z02_vo.Dept;
import springweb.z02_vo.Emp;

@Controller
public class A03_AjaxController {
	@Autowired(required = false)
	private A01_EmpService service;
	@Autowired(required=false)
	private A02_DeptService dservice;
	
	@Autowired(required=false)
	private A03_AjaxService aservice;
	
	// 기본 화면 호출..
	// http://localhost:7080/springweb/ajaxEmpForm.do
	@GetMapping("ajaxEmpForm.do")
	public String ajaxForm() {
		return "WEB-INF\\views\\a03_ajax\\a01_empAjax.jsp";
	}
	
	
	// json데이터 가져오기 http://localhost:7080/springweb/jsonEmp.do
	//
	@RequestMapping("jsonEmp.do")
	public String ajaxStart(Emp sch, Model d) {
		d.addAttribute("emp", service.emplist(sch));
		return "pageJsonReport";
	}
/*
ex) dept기준 ajax처리..
a02_mvc\a01_controller\A03_AjaxController.java
WEB-INF\views\a03_ajax\a02_deptAjax.jsp
1) json 데이터 가져오기 jsonDept.do
2) 초기화면 구현
3) 부서명과 부서번호로 ajax처리하기
*/
	
	// http://localhost:7080/springweb/jsonDept.do
	// PostMapping 5.0 이후 post방식을 url을 호출할 때
	// 기본 4.XX 요청 방식 : 
	// @RequestMapping(value="jsonDept.do", method=RequestMethod.POST)
	// 5.0 이후 요청 방식 요청 + post방식 선언
	@PostMapping("jsonDept.do")
	public String ajaxStart(Dept sch, Model d) {
		d.addAttribute("dept", dservice.deptList(sch));
		return "pageJsonReport";
	}
	// http://localhost:7080/springweb/ajaxDeptForm.do
	@GetMapping("ajaxDeptForm.do")
	public String ajaxDeptForm() {
		return "WEB-INF\\views\\a03_ajax\\a02_deptAjax.jsp";
	}
	
	
//ex) member
	// hasMember.do?id=##
	// hasMember.do ==> id를 공백으로 처리 ""
	// http://localhost:7080/springweb/hasMember.do
	@RequestMapping("hasMember.do")
	public String hasMember(
			@RequestParam(value="id",defaultValue = "")
				String id, Model d) {
		d.addAttribute("mCnt", aservice.schMember(id));
		return "pageJsonReport";
	}
	// http://localhost:7080/springweb/regMemberForm.do
	@GetMapping("regMemberForm.do")
	public String regMemberForm() {
		return "WEB-INF\\views\\a03_ajax\\a03_regMember.jsp";
	}
	// http://localhost:7080/springweb/jsonExp01.do
	@RequestMapping("jsonExp01.do")
	public String jsonExp01(Model d) {
		d.addAttribute("num01",25);
		return "pageJsonReport";
	}
	// http://localhost:7080/springweb/jsonExp02.do
	@RequestMapping("jsonExp02.do")
	public String jsonExp02(Model d) {
		d.addAttribute("name","홍길동");
		return "pageJsonReport";
	}
	// http://localhost:7080/springweb/jsonExp03.do
	// js에서
	// success:function(data){
	//		data.p01.name : 이름을 사용
	//		var p01 = data.01;
	//		p01.name, p01.age, p01.loc
	// }
	@RequestMapping("jsonExp03.do")
	public String jsonExp03(Model d) {
		d.addAttribute("p01",new Person("홍길동",25,"서울 신림"));
		return "pageJsonReport";
	}
	// http://localhost:7080/springweb/jsonExp04.do
	@RequestMapping("jsonExp04.do")
	public String jsonExp04(Model d) {
		ArrayList<Person> list = new ArrayList<Person>();
			list.add(new Person("홍길동",25,"서울 신림"));
			list.add(new Person("신길동",23,"서울 방배"));
			list.add(new Person("마길동",22,"서울 강남"));
		d.addAttribute("list",list);
		return "pageJsonReport";
	}
	/*
	success:function(){
		var plist = data.list;
		$.each(plist,function(idx,person,arry){
			person.name, person.age, person.loc
		});
	}
	 */
	// 초기 화면 호출
	
	// http://localhost:7080/springweb/ajaxFinal.do
	@GetMapping("ajaxFinal.do")
	public String ajaxFinal() {
		return "WEB-INF\\views\\a03_ajax\\a05_ajaxFinal.jsp";
	}
	
	
	
}

