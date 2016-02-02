package akenmg.rootsdelivery.controller.back.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.service.DataAccess;

/**
 * Servlet implementation class BoDeletePlat
 */
@WebServlet("/backoffice/BoDeletePlat")
public class BoDeletePlat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String url = "Table_Plats";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoDeletePlat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		
		DataAccess.deletePlat(id);
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
