package bomnie.guestbook.argumentresolver;

import java.util.Iterator;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class HeaderMapArgumentResolver implements HandlerMethodArgumentResolver{

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// controller 메서드의 인자 개수에 맞추어 매번 호출됨
		// 인자의 정보를 파라미터로 전달
		// 해당 파라미터 정보에 원하는 정보가 있다면 true 반환 
		return parameter.getParameterType() == HeaderInfo.class;
	}

	//  supportsParameter() 가 true 를 반환할 때만 호출됨  
	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {

		HeaderInfo headerInfo = new HeaderInfo();
		
		// Header 이름 얻어오기
		Iterator<String> headerNames = webRequest.getHeaderNames();
		while (headerNames.hasNext()) {
			String headerName = headerNames.next();
			String headerValue = webRequest.getHeader(headerName);
			headerInfo.put(headerName, headerValue);
			
			System.out.println("헤더 정보 : " + headerName + " - " + headerValue);
		}
		// 반환되는 HeaderInfo 객체는 Controller 메소드의 인자값으로 전달됨 
		return headerInfo;
	}

}
