package bomnie.spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlusController {
	@GetMapping(path="/plusform")
	public String plusform() {
		return "plusForm"; // plusForm.jsp를 보여줌
	}

	@PostMapping(path = "/plus")
	public String plus(@RequestParam(name = "value1", required = true) int value1,
			@RequestParam(name = "value2", required = true) int value2, ModelMap modelMap) {
				
		int result = value1 + value2;
		
		// request.setAttribute() 를 이용해서 request scope 에 값을 저장할 수도 있지만
		// request 에 종속되지 않기 위해 스프링이 제공하는 ModelMap 객체를 이용
		// ModelMap 객체에 값을 추가하면, 스프링이 자동으로 request scope에 매핑시켜줌.
		
		modelMap.addAttribute("value1", value1);
		modelMap.addAttribute("value2", value2);
		modelMap.addAttribute("result", result);
				
		return "plusResult"; // plusResult.jsp를 보여줌
	}
	
}
