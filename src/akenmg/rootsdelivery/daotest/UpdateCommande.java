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
 * Servlet implementation class UpdateCommande
 */
@WebServlet("/daotest/UpdateCommande")
public class UpdateCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		
		Commande commande = DaoCommande.find(Integer.parseInt(id));
		commande.setEtat(Commande.stringToEnum(action));
		DaoCommande.update(commande);
		
		response.sendRedirect("daocommande.jsp");
	}

}
