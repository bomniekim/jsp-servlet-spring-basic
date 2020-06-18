package bomnie.guestbook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GuestbookAdminController {
	
	@GetMapping(path="/loginform")
	public String loginform() {
		return "loginForm";
	}
	
	
	// loginForm.jsp 로부터 암호를 받아서 암호가 일치할 경우
	// 세션에 로그인 정보 저장
	@PostMapping(path = "/login")
	public String login(@RequestParam(name = "passwd", required = true) String pwd,
						HttpSession session, RedirectAttributes redirectAttr) {
		
		if ("1234".equals(pwd)) {
			session.setAttribute("isAdmin", "true");
		} else {
			// DispatcherServlet 이 관리하는 Flash Map 에 값을 저장
			// redirect 시 요청이 2 번 발생하므로, forward 와 달리 request 저장값을 사용할 수 없음 
			// 따라서 리다이렉트시 값을 유지할 목적으로 addFlashAttribute() 메소드를 사용한다.
			redirectAttr.addFlashAttribute("errorMessage", "암호가 틀렸습니다.");
			return "redirect:/loginform";
		}
		return "redirect:/list";
	}
	
    @GetMapping(path="/logout")
		public String logout(HttpSession session) {
			session.removeAttribute("isAdmin");
			return "redirect:/list";
	}
}
