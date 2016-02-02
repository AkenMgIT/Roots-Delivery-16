package akenmg.rootsdelivery.controller.back.fiche;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.model.Commande;
import akenmg.rootsdelivery.model.view.PlatView;
import akenmg.rootsdelivery.service.DataAccess;

/**
 * Servlet implementation class FicheCommande
 */
@WebServlet("/backoffice/fiches/Fiche_Commande")
public class FicheCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String url = "fiche_commande.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FicheCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		
		Commande commande = DataAccess.findCommande(id);
		
		request.setAttribute("commande", commande);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
