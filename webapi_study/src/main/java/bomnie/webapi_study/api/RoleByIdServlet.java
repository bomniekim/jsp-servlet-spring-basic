package bomnie.webapi_study.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import bomnie.webapi_study.dao.RoleDao;
import bomnie.webapi_study.dto.Role;


// role_id 한 건에 대하여 role 정보를 읽어오는 서블릿 


//roles/ 뒤에 어떤 문자가 와도 해당 서블릿을 찾음
@WebServlet("/roles/*")
public class RoleByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RoleByIdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		String pathInfo = request.getPathInfo(); // /roles/{roleId}
		String[] pathParts = pathInfo.split("/");
		int id = Integer.parseInt(pathParts[1]); // {roleId}에 해당하는 문자열을 int 값으로 바꾸기

		RoleDao dao = new RoleDao();

		Role role = dao.getRole(id);

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(role);

		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();
	}

}
