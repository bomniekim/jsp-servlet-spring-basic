package bomnie.guestbook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuessNumController {
	@GetMapping( "/guess")
	public String guess(@RequestParam(name="number", required = false) Integer number, HttpSession session, ModelMap model) {
		// 스프링에서는 request.getSession() 알아서 처리
		
		String msg = null;
		if(number == null) {
			// 사용자의 입력 값이 없는 경우
			session.setAttribute("count", 0); // 입력 횟수 설정
			session.setAttribute("random", (int)(Math.random()*100)+1);
			// double 값이 return되므로 형변환 필요 
			msg = "Guess Number!";	
			
		}else {
			// 세션에 저장되는 값은 Object이므로 형변환 필요 
			int count = (Integer)session.getAttribute("count");
			int randomNum = (Integer)session.getAttribute("random");
			
			if(number < randomNum) {
				msg = "Smaller than what I thought!";
				session.setAttribute("count", ++count);
				
			} else if (number > randomNum) {
				msg = "Larger than what I thought!";
				session.setAttribute("count", ++count);
				
			} else {
				msg = "Congratulation! You got the Number in "+ ++count + "th time!"+ number +"is correct!";
				session.removeAttribute("count");
				session.removeAttribute("random");
			}
		}
		
		model.addAttribute("msg", msg);
		
		return "guess"; // guess.jsp로 이동
	} 
	
}
