package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicationScope02
 */
@WebServlet("/ApplicationScope02")
public class ApplicationScope02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationScope02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html; charset=UTF-8");
	        
	     PrintWriter out = response.getWriter();
	       
	     ServletContext application = getServletContext();
	     
	     
	     // application.getAttribute() 값이 없는 경우 예외 발생 가능
		 // try-catch를 통한 예외처리
	     try {
	    	 // Application Scope 에 저장되어 있는 value 가져오기
		     int value = (int)application.getAttribute("value");
		     
		     // value의 값을 바꾼 후 다시 추가하기
		     value++;
		     application.setAttribute("value", value);
		     out.println("<h1>value : " + value + "</h1>");
		     
	     }catch(NullPointerException e) {
	    	 out.println("value의 값이 설정되지 않았습니다.");
	    	 
	     }
	     
	}

}
