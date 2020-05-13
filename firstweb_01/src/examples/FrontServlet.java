package examples;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontServlet
 */
@WebServlet("/front")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		int diceValue = (int)(Math.random() * 6) + 1; 
		
		// 클라이언트 요청정보를 담은 request 객체에 "diceValue" 라는 이름으로 값을 추가
		// (세탁소에 옷을 맡길 때 알려주는 이름과 같다고 보면 됨)
		// 값의 타입은 Object (모든 타입의 값을 저장할 수 있도록)
		// 추후 값을 얻어낼 때도 Object 타입으로 받음
		
		request.setAttribute("diceValue", diceValue);
		
		
		// RequestDispatcher 객체를 생성
		// 이동할 경로를 인자값으로 줌(경로는 / 로 시작)
		// 요청 포워딩은 같은 웹 어플리케이션 안에서만 가능
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Next");
		
		// forward(request, response) 메소드를 사용해 포워딩
		requestDispatcher.forward(request, response);
	}

}
