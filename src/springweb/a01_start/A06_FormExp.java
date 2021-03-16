package springweb.a01_start;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springweb.z02_vo.Code;
import springweb.z02_vo.ProdPrac;

@Controller
@RequestMapping("formexp.do")
public class A06_FormExp {
	@ModelAttribute("kind")
	public List<String> kinds(){
		return Arrays.asList("전자제품", "식품류", "잡화");
	}
	
	@ModelAttribute("price")
	public List<Integer> prices(){
		return Arrays.asList(1000,2000,3000,4000,
				5000,6000,7000,8000,9000,10000);
	}
	
	@ModelAttribute("cnt")
	public List<Integer> cnts(){
		return Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String form1(@ModelAttribute("prodInfo") ProdPrac pro) {
		return "WEB-INF\\views\\a01_start\\a14_formExp.jsp";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String form2(@ModelAttribute("prodInfo") ProdPrac pro) {
		return "WEB-INF\\views\\a01_start\\a14_formExp.jsp";
	}
	// http://localhost:7080/springweb/formexp.do
/*
# 구매물품
물건 종류 [전자제품/식품류/잡화]
가격 : [1000~10000] 천단위로 10000까지
갯수 : [1~10]

form:form modelattribute를 이용해서
get/post방식으로 출력..

WebContent\WEB-INF\views\a01_start\a14_formExp.jsp

*/
}
