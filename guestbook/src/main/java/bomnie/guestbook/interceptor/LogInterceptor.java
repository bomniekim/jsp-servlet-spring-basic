package bomnie.guestbook.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter {
	
	// controller 가 실행되기 전에 실행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(handler.toString() + " 를 호출했습니다.");
		return true;
		// boolean type return 값을 통해 controller를 수행할 지 여부를 결정
	}
	
	
	// controller 가 실행된 후에 실행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println(handler.toString() + " 가 종료되었습니다.  " + modelAndView.getViewName() + "을 view로 사용합니다.");
	}

}

// Interceptor는 Dispatcher servlet에서 Handler(Controller)로 요청을 보낼 때,
// Handler에서 Dispathcer servlet으로 응답을 보낼 때 동작합니다.