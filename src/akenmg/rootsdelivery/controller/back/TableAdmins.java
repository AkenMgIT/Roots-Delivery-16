package akenmg.rootsdelivery.controller.back;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.model.view.AdminView;
import akenmg.rootsdelivery.model.view.ClientView;
import akenmg.rootsdelivery.service.DataAccess;

/**
 * Servlet implementation class TableAdmins
 */
@WebServlet("/backoffice/Table_Admins")
public class TableAdmins extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String url = "table_admins.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TableAdmins() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AdminView> admins = DataAccess.GetAllAdmin();
		request.setAttribute("admins", admins);
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<AdminView> admins = DataAccess.GetAllAdmin();
		request.setAttribute("admins", admins);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
