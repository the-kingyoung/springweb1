package springweb.a01_start;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.z03_vo.Product;

@Controller
public class A06_FormExp {
	
	@ModelAttribute("buyList")
	public ArrayList<String> buyList(){
		ArrayList<String> blist = new ArrayList<String>();
		blist.add("전자제품");
		blist.add("식품류");
		blist.add("잡화");
		return blist;
	}
	/*
	# 주의
	1. 공통된 모델어트리뷰트와 요청값에 의해서나 모델에 의해서 처리하는 데이터의 차이
	2. 
		물건 종류 [전자제품/식품류/잡화] ==> 공통모델어트리뷰트에서 선언..
				
				[submit] 클릭해서 요청값으로 선택한 내용을 처리하는 부분..
						public String postBuy(@ModelAttribute("prod") Product sch		==> 요청값 처리		
							Product의 setKind() 선택한 물건 종류를 할당 처리.
	*/
	
	// http://localhost:7080/springweb/buy.do
	@GetMapping("buy.do")
	public String buy(Model d) {
		d.addAttribute("prod",new Product());
		return "WEB-INF\\views\\a01_start\\a14_formExp.jsp";
	}
	
	@PostMapping("buy.do")
	public String buyPost(@ModelAttribute("prod") Product prod) {
		return "WEB-INF\\views\\a01_start\\a14_formExp.jsp";
	}
	
	/*
	ModelAttribute("kind")
	public List<String> kinds(){
		return Arrays.asList("전자제품", "식품류", "잡화");
	}
	
	ModelAttribute("price")
	public List<Integer> prices(){
		return Arrays.asList(1000,2000,3000,4000,
				5000,6000,7000,8000,9000,10000);
	}
	
	ModelAttribute("cnt")
	public List<Integer> cnts(){
		return Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	}
	
	
	RequestMapping(method=RequestMethod.GET)
	public String form1(@ModelAttribute("prodInfo") ProdPrac pro) {
		return "WEB-INF\\views\\a01_start\\a14_formExp.jsp";
	}
	
	RequestMapping(method=RequestMethod.POST)
	public String form2(@ModelAttribute("prodInfo") ProdPrac pro) {
		return "WEB-INF\\views\\a01_start\\a14_formExp.jsp";
	}
	// http://localhost:7080/springweb/formexp.do

	 */
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
