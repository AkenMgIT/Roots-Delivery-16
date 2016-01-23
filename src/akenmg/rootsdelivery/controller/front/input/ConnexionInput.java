package akenmg.rootsdelivery.controller.front.input;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.model.Client;
import akenmg.rootsdelivery.service.LoginService;

/**
 * Servlet implementation class ConnexionInput
 */
@WebServlet("/Connexion-Input")
public class ConnexionInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String urlSuccess = "Commande-Client";
	private static String urlFail = "Connexion";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionInput() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		
		LoginService loginService = new LoginService();
		
		if(loginService.loginClient(email, email)){
			System.out.println("Login Client : success");
			Client client = loginService.findClient(email);
			System.out.println("Client id : "+client.getId());
			System.out.println("Client nom : ");
			System.out.println("Client prenom : ");
			System.out.println("Client email : ");
			response.sendRedirect(urlSuccess);
		}
		
		response.sendRedirect(urlFail);
//		doGet(request, response);
	}

}
