package akenmg.rootsdelivery.controller.back.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.model.Client;
import akenmg.rootsdelivery.service.DataAccess;
import akenmg.rootsdelivery.service.modelform.CreateClientForm;

/**
 * Servlet implementation class BoCreateClient
 */
@WebServlet("/backoffice/BoCreate-Client")
public class BoCreateClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String url = "Table_Clients";
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoCreateClient() {
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
		CreateClientForm form = new CreateClientForm();
		Client client = form.inscrireUtilisateur(request);
		
		if(form.isValide()){
			DataAccess.CreateClient(client);
		}
		
		request.setAttribute("form", form);
		request.setAttribute("client", client);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
