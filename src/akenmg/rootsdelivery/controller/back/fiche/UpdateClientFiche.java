package akenmg.rootsdelivery.controller.back.fiche;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.model.Client;
import akenmg.rootsdelivery.model.view.ClientView;
import akenmg.rootsdelivery.service.DataAccess;
import akenmg.rootsdelivery.service.modelform.UpdateClientForm;

/**
 * Servlet implementation class UpdateClientFiche
 */
@WebServlet("/backoffice/fiches/UpdateClientFiche")
public class UpdateClientFiche extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String url = "Fiche_Client";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClientFiche() {
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
//		doGet(request, response);
		
		
		UpdateClientForm form = new UpdateClientForm();
		ClientView clientV = new ClientView(form.updateClient(request));
		
		
		request.setAttribute("form", form);
		
		if(form.isValide()){
			DataAccess.UpdateClient(clientV);
//			request.setAttribute("clientV", clientV);
		}else{
//			clientV = DataAccess.findClient(clientV.getId());
//			request.setAttribute("clientV", clientV);
		}
		request.setAttribute("clientV", clientV);
//		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
