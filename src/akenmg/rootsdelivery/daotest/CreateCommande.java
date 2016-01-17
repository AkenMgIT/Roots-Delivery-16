package akenmg.rootsdelivery.daotest;

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

/**
 * Servlet implementation class CreateCommande
 */
@WebServlet("/daotest/CreateCommande")
public class CreateCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idClient = request.getParameter("idClient");
		String adresse = request.getParameter("adresse");
		System.out.println(idClient);
		System.out.println(adresse);
		Commande commande = (Commande)request.getSession().getAttribute("commande");
		if(commande!=null){
			commande.setClient(DaoClient.find(Integer.parseInt(idClient)));
			commande.setAdresse(adresse);
			commande.setDate(new Date());
			commande.setEtat(Commande.ETAT.ENCOURS);
			System.out.println("size="+commande.getPlacoms().size());
			System.out.println("date="+commande.getDate());
			
			DaoCommande.create(commande);
		}
		response.sendRedirect("daocommande.jsp");
	}

}
