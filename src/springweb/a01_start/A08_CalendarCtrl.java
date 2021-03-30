package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("calendarExp.do")
public class A08_CalendarCtrl {
	// http://localhost:7080/springweb/calendarExp.do?method=list
	@GetMapping(params="method=list")
	public String list(){
		return "WEB-INF\\views\\a01_start\\a17_calendarExp.jsp";
	}

}
