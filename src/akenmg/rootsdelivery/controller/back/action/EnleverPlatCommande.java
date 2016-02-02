package akenmg.rootsdelivery.controller.back.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.dao.DaoPlat;
import akenmg.rootsdelivery.model.Commande;
import akenmg.rootsdelivery.model.Plat;

/**
 * Servlet implementation class EnleverPlatCommande
 */
@WebServlet("/backoffice/EnleverPlatCommande")
public class EnleverPlatCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String url = "Table_Commandes";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnleverPlatCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Plat plat = DaoPlat.find(Integer.parseInt(id));
		Commande commande = (Commande)request.getSession().getAttribute("commande");
		if(commande!=null){
//			for(int i=0;i<commande.getPlacoms().size();i++){
//				if(commande.getPlacoms().get(i).getPlat().getId()==plat.getId()){
//					commande.getPlacoms().remove(i);
//					break;
//				}
//			}
			
			for(int i=0;i<commande.getPlacoms().size();i++){
				if(commande.getPlacoms().get(i).getPlat().getId()==plat.getId()){
					if(commande.getPlacoms().get(i).getQuantite()==1){
						commande.getPlacoms().remove(i);
						break;
					}else{
						commande.getPlacoms().get(i).removeQuantite(1);
					}
				}
			}
			
//			for(PlaCom p : commande.getPlacoms()){
//				if(p.getPlat().getId()==plat.getId()){
//					if()
//				}
//			}
		}else{
			System.out.println("pat de commande disponible");
			System.out.println("Creer une commande?");
		}
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
