package bomnie.guestbook.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bomnie.guestbook.dto.Guestbook;
import bomnie.guestbook.service.GuestbookService;

@RestController
// 웹서비스의 controller
// 사용자의 요청이 오면 MessageConverter를 통해서 application/json, text/plain 등 알맞는 형태로 리턴

@RequestMapping(path="/guestbooks")
// 해당 api 클래스 안에서 같은 매핑 path로 여러 mapping 수행 
public class GuestbookApiController {
	@Autowired
	GuestbookService guestbookService;
	
	
		@GetMapping
		// contentType = application/json + "GET" 요청이 들어오면 실행되는 메소드
		// path가 없는 이유는 위에서 공통의 RequestMapping을 설정해주었기 때문.
		public Map<String, Object> list(@RequestParam(name="start", required =false, defaultValue = "0") int start) {
		// dispatcherServlet이 jsonMessageConvertor를 내부적으로 사용하여
		// 해당 Map객체를 json으로 변환하여 전송
			
			List<Guestbook> list = guestbookService.getGuestbooks(start);
			
			// 전체 페이지수 구하기 
			int count = guestbookService.getCount();
			int pageCount = count/guestbookService.LIMIT;
			if (count % guestbookService.LIMIT > 0) {
				pageCount++; 
			}
			
			// 페이지 수만큼 start의 값을 리스트로 저장 
			List<Integer> pageStartList = new ArrayList<>();
			for (int i = 0; i < pageCount; i++) {
				pageStartList.add(i * guestbookService.LIMIT);
			}
			
			Map<String,Object> map = new HashMap<>();
			map.put("list", list);
			map.put("count", count);
			map.put("pageStartList", pageStartList);
			
			return map;
			// application/json 요청이므로
			// DispatcherServlet 은 JSONMessageConvertor 를 사용해서 Map 객체를 json 으로 변환하여 응답한다.
		}
		
		@PostMapping
		public Guestbook write(@RequestBody Guestbook guestbook, HttpServletRequest request) {
			String clientIp = request.getRemoteAddr();
			
			Guestbook resultGuestbook = guestbookService.addGuestbook(guestbook, clientIp);
			return resultGuestbook;
			// DispatcherServlet 은 JSONMessageConvertor 를 사용해서
			// Guestbook 객체를 json 으로 변환하여 응답
		}
		
		@DeleteMapping("/{id}") // PathVariable
		public Map<String, String> delete(@PathVariable(name="id") Long id, HttpServletRequest request) {
			String clientIp = request.getRemoteAddr();
			int deleteCount = guestbookService.deleteGuestbook(id, clientIp);
			
			// 값이 1개인 Map 객체를 생성하여 리턴한다. (key, value)
			return Collections.singletonMap("success", deleteCount > 0 ? "true" : "false");
		}

}



//@Controller 는 View Page를 반환하지만,
//@RestController는 객체(VO,DTO)를 반환하기만 하면,
// 객체데이터는 application/json 형식의 HTTP ResponseBody에 직접 작성되게 된다.
