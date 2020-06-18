package bomnie.guestbook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bomnie.guestbook.dto.Guestbook;
import bomnie.guestbook.service.GuestbookService;

@Controller
public class GuestbookController {

	@Autowired
	GuestbookService guestbookService;

	@GetMapping(path="/list")
	public String list(@RequestParam(name="start", required=false, defaultValue="0") int start,
			   ModelMap model, @CookieValue(value="visitCount", defaultValue = "0", required = true) String visitCnt, HttpServletResponse response) {

		// HttpServletRequest request 대신 spring mvc에서 제공하는 어노테이션 사용 
		//@CookieValue : 쿠키 값을 인자에 저장해서 사용 가능 - 아래 주석처리 한 코드를 줄일 수 있음 
		
		
		// 쿠키를 이용한 방문 횟수 구현
//		String visitCnt = null;
//		boolean find = false;
		
		// 쿠키가 여러 개일수 있으므로 항상 배열로 return 
//		Cookie[] cookies = request.getCookies();
//		
//		if(cookies != null) {
//			for(Cookie cookie : cookies) {
//				if("visitCount".equals(cookie.getName())) {
//					find = true;
//					visitCnt = cookie.getValue();
//					break;
//					
//				}
//			}
//		}
		
      
		// 처음 요청이 들어온 경우 (첫 방문)
		// find == false
//		if(!find) {
//			visitCnt = "1";
//			
//		}else { // 쿠키를 찾았다면
			try { 
				int i = Integer.parseInt(visitCnt);
				visitCnt = Integer.toString(++i);
			}catch(Exception ex) {
				visitCnt = "1";
		}
		
   
		// 쿠키 객체 생성
		Cookie cookie = new Cookie("visitCount", visitCnt);
		cookie.setMaxAge(60 * 60 * 24 * 365); // 1년 동안 유지
		// -1 로 설정하면 브라우저가 닫힐 때 사라짐
		
		cookie.setPath("/"); // '/' 경로 이하에 모두 쿠키 적용
		
		// 보낼 응답 결과에 쿠키 추가 
		// 동일한 이름의 쿠키를 생성하여 전송하면, 기존의 쿠키와 교체 
		response.addCookie(cookie); 
		
		
		// 방명록 목록 구하기 (start 부터 limit 개의 레코드 조회)
		List<Guestbook> list = guestbookService.getGuestbooks(start);

		// 전체 페이지 수 구하기
		int count = guestbookService.getCount();
		int pageCount = count / GuestbookService.LIMIT;
		if(count % GuestbookService.LIMIT > 0)
			pageCount++; // 나누어 떨어지지 않고 남는 레코드가 있다면 페이지 1개 더 필요
		

		// 페이지 수만큼 start의 값을 리스트로 저장
		// 예를 들면 페이지수가 3이면
		// 0, 5, 10 이렇게 저장된다.
		// list?start=0 , list?start=5, list?start=10 으로 링크가 걸린다.
		List<Integer> pageStartList = new ArrayList<>();
		for(int i = 0; i < pageCount; i++) {
			pageStartList.add(i * GuestbookService.LIMIT);
		}

		// jsp에서 사용할 수 있도록 값 설정
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pageStartList", pageStartList);
		model.addAttribute("cookieCnt", visitCnt);

		return "list"; 
		// list.jsp에서 보여줌
	}

	@PostMapping(path = "/write")
	public String write(@ModelAttribute Guestbook guestbook, HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		System.out.println("clientIp : " + clientIp);
		guestbookService.addGuestbook(guestbook, clientIp);
		// 작업 종료 후 list.jsp 로 리다이렉트
		return "redirect:list";
	}
	
	@GetMapping(path="/delete") // 값을 queryString 으로 보내므로 get 
	public String delete(@RequestParam(name="id", required=true) Long id, 
			             @SessionAttribute("isAdmin") String isAdmin,
			             HttpServletRequest request,
			             RedirectAttributes redirectAttr) {
		
		if(isAdmin == null || !"true".equals(isAdmin)) { // 세션값이 true가 아닐 경우
			redirectAttr.addFlashAttribute("errorMessage", "로그인을 하지 않았습니다.");
			return "redirect:loginform";
		}
		
		// 클라이언트의 ip 얻어와서 log 찍기
		String clientIp = request.getRemoteAddr();
		guestbookService.deleteGuestbook(id, clientIp);
		return "redirect:list";		
	}
	
	
}
