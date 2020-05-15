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
 * Servlet implementation class ApplicationScope01
 */
@WebServlet("/ApplicationScope01")
public class ApplicationScope01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationScope01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html; charset=UTF-8");
	        
	     PrintWriter out = response.getWriter();
	       
	     // application scope에 해당하는 ServletContext 객체 얻어오기
	     ServletContext application = getServletContext();
	     
	     // application 객체에 값 추가하기
	     int value = 1;	     
	     application.setAttribute("value", value);
	     
	     out.println("<h1>value : " + value + "</h1>");
	}

}
