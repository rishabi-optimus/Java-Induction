package optimus.addressbook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PrintWriter out;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out = response.getWriter();
		out.println("Get Method Implementation");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email;
		String password;
		email = request.getParameter("email");
		password = request.getParameter("password");
		String check;
		check = new AuthenticationDAO().checkAdminLogin(email, password);
		if(check.equals("Valid User")){
			response.sendRedirect("adminhome.jsp");
			
		}
		else{
			response.sendRedirect("loginerror.jsp");
		}
		
	}

}
