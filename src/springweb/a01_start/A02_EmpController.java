package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//springweb.a01_start.A02_EmpController
import org.springframework.web.bind.annotation.RequestMapping;

import jspexp.a03_database.A00_DeptDao;
import jspexp.a03_database.A01_Dao;
import jspexp.z01_vo.Dept;
import jspexp.z01_vo.Emp;

@Controller
public class A02_EmpController {
	// emp검색 수정 처리.
	//http://localhost:7080/springweb/empList.do
	@RequestMapping("empList.do")
	public String empList(Emp sch, Model d) {
		A01_Dao dao = new A01_Dao();
		if(sch.getEname()==null) sch.setEname("");
		if(sch.getJob()==null) sch.setJob("");
		d.addAttribute("emplist", dao.empList(sch.getEname(), sch.getJob()));		
		return "WEB-INF\\views\\a01_start\\a08_empList.jsp";
	}
//	//ex) http://localhost:7080/springweb/deptList.do
//	@RequestMapping("deptList.do")
//	public String deptList(Dept sch, Model d) {
//		A00_DeptDao dao = new A00_DeptDao();
//		if(sch.getDname()==null) sch.setDname("");
//		if(sch.getLoc()==null) sch.setLoc("");
//		d.addAttribute("deptlist", dao.display(sch.getDname(), sch.getLoc()));
//		return "WEB-INF\\views\\a01_start\\a09_deptList.jsp";
//	}
}
	