package akenmg.rootsdelivery.controller.back.fiche;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.model.view.ClientView;
import akenmg.rootsdelivery.service.DataAccess;

/**
 * Servlet implementation class FicheClient
 */
@WebServlet("/backoffice/fiches/Fiche_Client")
public class FicheClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String url = "fiche_client.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FicheClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		
		ClientView clientV = DataAccess.findClient(id);
		
		request.setAttribute("clientV", clientV);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//		if(request.getAttribute("clientV")==null){
//			
//		}
//		String ids = (String) request.getAttribute("id");
//		int id = Integer.parseInt(ids);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
