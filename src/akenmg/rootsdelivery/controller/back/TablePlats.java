package akenmg.rootsdelivery.controller.back;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.model.Plat;
import akenmg.rootsdelivery.model.view.PlatView;
import akenmg.rootsdelivery.service.DataAccess;

/**
 * Servlet implementation class TablePlats
 */
@WebServlet("/backoffice/Table_Plats")
public class TablePlats extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String url = "table_plats.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TablePlats() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PlatView> plats = DataAccess.getAllPlat();
		request.setAttribute("plats", plats);
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
