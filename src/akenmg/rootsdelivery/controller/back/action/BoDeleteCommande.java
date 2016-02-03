package akenmg.rootsdelivery.controller.back.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.service.DataAccess;

/**
 * Servlet implementation class BoDeleteCommande
 */
@WebServlet("/backoffice/BoDeleteCommande")
public class BoDeleteCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String url = "Table_Commandes";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoDeleteCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCom = request.getParameter("id");
		int id = Integer.parseInt(idCom);
		DataAccess.deleteCommande(id);
		
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
