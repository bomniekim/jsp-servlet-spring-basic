package bomnie.spring_mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class GoodsController {

	// goods/ 뒤의 값을 PathVariable 로 받겠다.
		@GetMapping(path = "/goods/{id}")
		public String getGoodsById(@PathVariable(name = "id") int id,
				@RequestHeader(value = "User-Agent", defaultValue = "myBrowser") String userAgent,
				HttpServletRequest request,
				ModelMap model) {
			
			// @PathVariable : url 에 포함된 id 값을 int id 변수에 저장
			// @RequestHeader : request 헤더의 정보를 String userAgent 변수에 저장
			
			String path = request.getServletPath();
			
			// 콘솔 출력
			System.out.println("id : " + id);
			System.out.println("user_agent : " + userAgent);
			System.out.println("path : " + path);
					
			// ModelMap 객체에 값 저장
			model.addAttribute("id", id);
			model.addAttribute("userAgent", userAgent);
			model.addAttribute("path", path);
			
			return "goodsById";
		}
	
		
		
}
