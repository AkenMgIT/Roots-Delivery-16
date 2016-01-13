package akenmg.rootsdelivery.fonctiontest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.model.Admin;
import akenmg.rootsdelivery.service.LoginService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/daotest/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
		
		System.out.println(login);
		System.out.println(mdp);
		Admin admin = null;
		
		if(LoginService.loginAdmin(login, mdp)){
			request.setAttribute("message", "Login success");
			admin = LoginService.findAdmin(login);
			request.getSession().setAttribute("user", admin);
		}else{
			request.setAttribute("message", "Login fail");
		}
		
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
//		response.sendRedirect("login.jsp");
	}

}
