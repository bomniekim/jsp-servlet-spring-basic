package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TenServlet
 */
@WebServlet("/TenServlet")
public class TenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서블릿은 동적으로 응답결과를 만들어냄
		// 요청이 들어온 경우 서블릿이 실행되면서 응답할 코드를 만들어냄 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =response.getWriter();
		out.print("<h1>1-10까지 출력</h1>");
		
		for(int i=0; i<10; i++) {
			out.print(i+"<br>");
		}
		out.close();
	}
}
