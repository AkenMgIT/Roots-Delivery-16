package akenmg.rootsdelivery.daotest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.dao.DaoCommande;
import akenmg.rootsdelivery.model.Commande;

/**
 * Servlet implementation class PlaComFind
 */
@WebServlet("/daotest/PlaComFind")
public class PlaComFind extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(request.getParameter("id"));
		Commande commande = DaoCommande.find(Integer.parseInt(request.getParameter("id")),true);
		request.setAttribute("commandeDetail", commande);
		request.getRequestDispatcher("daocommande.jsp").forward(request, response);
		
	}

}
