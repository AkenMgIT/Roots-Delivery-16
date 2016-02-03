package akenmg.rootsdelivery.controller.back.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.model.Commande;
import akenmg.rootsdelivery.service.DataAccess;

/**
 * Servlet implementation class BoUpdateCommandeEtat
 */
@WebServlet("/backoffice/BoUpdateCommandeEtat")
public class BoUpdateCommandeEtat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String url = "Table_Commandes";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoUpdateCommandeEtat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		String etat = request.getParameter("etat");
		
		Commande commande = new Commande();
		commande.setId(id);
		
		if(etat.equals("encours")){
			commande.setEtat(Commande.ETAT.ENCOURS);
		}else if(etat.equals("payee")){
			commande.setEtat(Commande.ETAT.PAYEE);
		}else if(etat.equals("annulee")){
			commande.setEtat(Commande.ETAT.ANNULLEE);
		}
		
		DataAccess.updateEtatCommande(commande);
		
		response.sendRedirect(url);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
