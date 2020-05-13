package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NextServlet
 */
@WebServlet("/Next")
public class NextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NextServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// FrontServlet 에게서 요청을 포워드 받으면서 request, response 객체도 전달 받음
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>form</title></head>");
        out.println("<body>");
        

		// 전달 받은 request 객체에 저장된 "diceValue"라는 이름의 값을 얻어내
		// 얻어낸 값의 타입은 Object 이므로 적절한 형변환이 필요
        // 여기서는I Integer로...

        int dice = (Integer)request.getAttribute("diceValue");
        // FrontServlet 에서 받아온 랜덤 값의 수만큼 hello 표
        out.println("dice : " + dice);
        for(int i = 0; i < dice; i++) {
            out.print("<br>hello");
        }
        out.println("</body>");
        out.println("</html>");
    
  
	}

}
