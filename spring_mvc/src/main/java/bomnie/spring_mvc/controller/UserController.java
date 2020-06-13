package bomnie.spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bomnie.spring_mvc.dto.User;

@Controller
public class UserController {
	@RequestMapping(path="/userform", method=RequestMethod.GET)
	public String userform() {
		return "userForm"; // userForm.jsp 
	}
	
	@RequestMapping(path = "/regist", method = RequestMethod.POST)
	public String regist(@ModelAttribute User user) {
		
		// @ModelAttribute  
		// 각각의 변수를 하나씩 파라미터로 전달받지 않고 DTO 객체를 생성하여 한꺼번에 저장한 뒤 객체 파라미터로 받음
		// 이들에 담긴 모델 데이터가 뷰에 전달 (이 예제에서는 console로 출력)
		
		System.out.println("사용자가 입력한 user 정보입니다. 해당 정보를 이용하는 코드가 와야합니다.");
		System.out.println(user);
		
		return "regist"; // regist.jsp
	}

}
