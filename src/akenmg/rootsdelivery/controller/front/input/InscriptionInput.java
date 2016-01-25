package akenmg.rootsdelivery.controller.front.input;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.model.Client;
import akenmg.rootsdelivery.service.modelform.InscriptionForm;

/**
 * Servlet implementation class InscriptionInput
 */
@WebServlet("/Inscription-Input")
public class InscriptionInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String urlSuccess = "Commande-Client";
	private static String urlFail = "Connexion";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionInput() {
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
		InscriptionForm form = new InscriptionForm();
		Client client = form.inscrireUtilisateur(request);
		
		request.setAttribute("form", form);
		request.setAttribute("client", client);
		
		request.getRequestDispatcher(urlFail).forward(request, response);
	}

}
