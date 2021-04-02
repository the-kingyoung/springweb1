package springweb.a02_mvc.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.a02_mvc.a02_service.A04_CalenService;
import springweb.z02_vo.Calendar;

@Controller 
@RequestMapping("calendar.do")
public class A04_CalendarController {
	@Autowired(required=false)
	private A04_CalenService service;
	// http://localhost:7080/springweb/calendar.do?method=list 
	@GetMapping(params="method=list")
	public String list() {
		return "WEB-INF/views/a03_ajax/a04_fullcalendar.jsp";
	}
	// ex) springweb/a01_start/A08_CalendarCtrl.java
	//  WEB-INF/views/a01_start/a17_callendarExp.jsp
	
	// http://localhost:7080/springweb/calendar.do?method=data 
	@GetMapping(params="method=data")
	public String data(Model d) {
		d.addAttribute("list",service.calenList());
		return "pageJsonReport";
	}
	// http://localhost:7080/springweb/calendar.do?method=insert 
	@RequestMapping(params="method=insert")
	public String insertCalendar(Calendar ins, Model d) {
		service.insertCalendar(ins);
		// 등록 후 정상처리된 것을 model로 넘겨준다. 
		d.addAttribute("success","Y");
		return "pageJsonReport";
	}
	// http://localhost:7080/springweb/calendar.do?method=update 
		@RequestMapping(params="method=update")
		public String updateCalendar(Calendar upt, Model d) {
			service.updateCalen(upt);
			// 등록 후 정상처리된 것을 model로 넘겨준다. 
			d.addAttribute("success","Y");
			return "pageJsonReport";
		}
		
		// http://localhost:7080/springweb/calendar.do?method=delete
		@RequestMapping(params="method=delete")
		public String deleteCalendar(@RequestParam("id") int id, Model d) {
			service.deleteCalen(id);
			// 등록 후 정상처리된 것을 model로 넘겨준다. 
			d.addAttribute("success","Y");
			return "pageJsonReport";
		}
	
	
}