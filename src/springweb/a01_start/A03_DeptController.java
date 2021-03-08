package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jspexp.a03_database.A02_DeptDao;
import jspexp.z01_vo.Dept;

@Controller
public class A03_DeptController {
	
	//ex) http://localhost:7080/springweb/deptList.do
	@RequestMapping("deptList.do")
	public String deptList(Dept dept, Model d) {
		A02_DeptDao dao = new A02_DeptDao();
		
		d.addAttribute("dlist", dao.deptList2(dept));
		return "WEB-INF\\views\\a01_start\\a09_deptList.jsp";
	}
}
