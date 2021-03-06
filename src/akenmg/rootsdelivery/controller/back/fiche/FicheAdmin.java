package akenmg.rootsdelivery.controller.back.fiche;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.model.view.AdminView;
import akenmg.rootsdelivery.model.view.ClientView;
import akenmg.rootsdelivery.service.DataAccess;

/**
 * Servlet implementation class FicheAdmin
 */
@WebServlet("/backoffice/fiches/Fiche_Admin")
public class FicheAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String url = "fiche_admin.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FicheAdmin() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		
		AdminView admin = DataAccess.findAdmin(id);
		
		request.setAttribute("admin", admin);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(url).forward(request, response);
	}

}
