package bomnie.guestbook.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter {
	
	// Logger 객체 생성 
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// controller 가 실행되기 전에 실행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.debug("{} 를 호출했습니다.", handler.toString());
//		System.out.println(handler.toString() + " 를 호출했습니다.");
		return true;
		// boolean type return 값을 통해 controller를 수행할 지 여부를 결정
	}
	
	
	// controller 가 실행된 후에 실행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		logger.debug("{} 가 종료되었습니다. {} 를 view로 사용합니다.", handler.toString(), modelAndView.getViewName());
		// {} 에 해당하는 값을 인자로 각각 매핑
//		System.out.println(handler.toString() + " 가 종료되었습니다.  " + modelAndView.getViewName() + "을 view로 사용합니다.");
	}

}


// interceptor: 클라이언트의 요청이 컨트롤러에 가기 전에 가로채고, 응답이 클라이언트에게 가기전에 가로챔!

