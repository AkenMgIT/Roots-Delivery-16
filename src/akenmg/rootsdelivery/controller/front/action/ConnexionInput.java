package akenmg.rootsdelivery.controller.front.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.model.Client;
import akenmg.rootsdelivery.service.LoginService;
import akenmg.rootsdelivery.service.modelform.ConnexionForm;
import akenmg.rootsdelivery.service.modelform.CreateClientForm;

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
		
		ConnexionForm form = new ConnexionForm();
		Client client = form.connexionClient(request);
		
		request.setAttribute("form", form);
//		request.setAttribute("client", client);
		
		if(form.isValide()){
			response.sendRedirect(urlSuccess);
		}else{
			request.getRequestDispatcher(urlFail).forward(request, response);
		}
		
	}

}
