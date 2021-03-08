package springweb.z01_exp;
//springweb.z01_exp.A02_MemberController
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jspexp.a03_database.A04_MemberDao;
import jspexp.z01_vo.Member;

@Controller
public class A02_MemberController {

	//http://localhost:7080/springweb/memberList.do
	@RequestMapping("memberList.do")
	public String memberList(Member mem, Model d) {
		A04_MemberDao dao = new A04_MemberDao();
		if(mem.getId()==null) mem.setId("");
		if(mem.getName()==null) mem.setName("");
		d.addAttribute("memberList", dao.memberList(mem.getId(), mem.getName()));
		return "WEB-INF\\views\\a01_start\\a00_memberList.jsp";
	}
}
