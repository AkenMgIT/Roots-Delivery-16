package akenmg.rootsdelivery.controller.back.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.model.view.AdminView;
import akenmg.rootsdelivery.service.DataAccess;
import akenmg.rootsdelivery.service.modelform.CreateAdminForm;
import akenmg.rootsdelivery.service.modelform.UpdateAdminForm;

/**
 * Servlet implementation class BoCreateAdmin
 */
@WebServlet("/backoffice/BoCreateAdmin")
public class BoCreateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String url = "Table_Admins";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoCreateAdmin() {
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
		CreateAdminForm form = new CreateAdminForm();
		AdminView admin = new AdminView(form.inscriptionAdmin(request));
		
		request.setAttribute("form", form);
		
		if(form.isValide()){
			DataAccess.CreateAdmin(admin);
		}else{
		}
		request.setAttribute("admin", admin);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
