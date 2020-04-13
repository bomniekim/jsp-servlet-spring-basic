package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet("/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LifeCycleServlet() {
       System.out.println("LifeCycleServlet 생성");
    }


	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 호출");
	}

	
	public void destroy() {
		System.out.println("destroy 호출");
		// TODO Auto-generated method stub
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		out.println("<form method='post' action='/firstweb/LifecycleServlet'>");
		out.println("name : <input type='text' name='name'><br>");
		out.println("<input type='submit' value='ok'><br>");                                                 
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		out.println("<h1> hello " + name + "</h1>");
		out.close();
	}

//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("service 호출");
		// service)를 오버라이드 하지 않으면 부모인 HttpServlet의 service()를 호출 	



}

// 서블릿은 서버에 객체를 여러 개 만들지 않고 실제 요청된 객체의 유무를 판단 후 service() 메소드만 호출
// 어플리케이션 자체가 변경된 경우에는 destroy()하고 새로운 요청을 받으면 그 때 다시 init 
