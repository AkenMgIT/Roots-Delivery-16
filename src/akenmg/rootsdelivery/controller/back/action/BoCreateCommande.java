package akenmg.rootsdelivery.controller.back.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.dao.DaoClient;
import akenmg.rootsdelivery.dao.DaoCommande;
import akenmg.rootsdelivery.model.Commande;
import akenmg.rootsdelivery.service.DataAccess;
import akenmg.rootsdelivery.service.modelform.CreateCommandeForm;

/**
 * Servlet implementation class BoCreateCommande
 */
@WebServlet("/backoffice/BoCreateCommande")
public class BoCreateCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String url = "Table_Commandes";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoCreateCommande() {
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
		
		
		CreateCommandeForm form = new CreateCommandeForm();
		Commande commande = form.ajoutCommande(request);
		if(form.isValide()){
			DataAccess.createCommande(commande);
			request.getSession().removeAttribute("commande");
		}else{
			request.getSession().setAttribute("commandeF", commande);
		}
		
		request.setAttribute("form", form);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
