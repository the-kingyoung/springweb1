package springweb.a02_mvc.a01_controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.a02_mvc.a02_service.A01_EmpService;
import springweb.z02_vo.Dept;
import springweb.z02_vo.Emp;
import springweb.z03_vo.EmpDept;

@Controller
public class A01_EmpController {
	@Autowired(required = false)
	private A01_EmpService service;
	
	// http://localhost:7080/springweb/empList2.do
	@RequestMapping("/empList2.do")
	public String empList2(@ModelAttribute("sch") Emp sch, Model d) {
		System.out.println("데이터 건수 : " +service.emplist(sch).size());
		d.addAttribute("emplist", service.emplist(sch));
		return "WEB-INF\\views\\a02_mvc\\a01_empList.jsp";
	}
	// http://localhost:7080/springweb/insEmpForm.do
	@RequestMapping("/insEmpForm.do")
	public String insEmpForm() {
		return "WEB-INF\\views\\a02_mvc\\a01_empInsertForm.jsp";
	}
	@RequestMapping("/insertEmp.do")
	public String insertEmp(Emp ins) {
		System.out.println("# 등록 처리 : "+ins.getEname());
		service.empInsert(ins);
		return "WEB-INF\\views\\a02_mvc\\a01_empInsertForm.jsp";
	}
	
	
	
	
	
	
	// http://localhost:7080/springweb/empDeptList.do
	@RequestMapping("/empDeptList.do")
	public String empDeptList(@ModelAttribute("sch") EmpDept sch, Model d) {
		d.addAttribute("empDeptList", service.schEDGList(sch));
		return "WEB-INF\\views\\a02_mvc\\a03_empDeptList.jsp";
	}
	//직책/부서명/급여등급 jobs depts
	
	
	@ModelAttribute("jobs")
	public ArrayList<String> getJobs(){
		return service.getJobs();
	}
	
	@ModelAttribute("depts")
	public ArrayList<Dept> getDepts(){
		return service.getDepts();
	}
	
	@ModelAttribute("mgrs")
	public ArrayList<Emp> getMgrs(){
		return service.getMgrs();
	}

}
