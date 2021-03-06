package akenmg.rootsdelivery.fonctiontest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.dao.DaoPlat;
import akenmg.rootsdelivery.model.Commande;
import akenmg.rootsdelivery.model.PlaCom;
import akenmg.rootsdelivery.model.Plat;

/**
 * Servlet implementation class AjoutPlatCommande
 */
@WebServlet("/daotest/AddPlatCommande")
public class AddPlatCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlatCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Plat plat = DaoPlat.find(Integer.parseInt(id));
		PlaCom placom = null;
		Commande commande = (Commande)request.getSession().getAttribute("commande");
		if(commande!=null){
			boolean isHere = false;
			for(PlaCom p : commande.getPlacoms()){
				if(p.getPlat().getId()==plat.getId()){
					p.addQuantite(1);
					isHere=true;
					break;
				}
			}
			if(!isHere){
				placom = new PlaCom();
				placom.setPlat(plat);
				commande.getPlacoms().add(placom);
				placom.setQuantite(1);
			}
		}else{
			commande = new Commande();
			request.getSession().setAttribute("commande", commande);
			placom = new PlaCom();
			placom.setPlat(plat);
			placom.setQuantite(1);
			commande.getPlacoms().add(placom);
		}
		response.sendRedirect("daocommande.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
