package akenmg.rootsdelivery.controller.back.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.model.Plat;
import akenmg.rootsdelivery.service.DataAccess;
import akenmg.rootsdelivery.service.modelform.CreatePlatForm;

/**
 * Servlet implementation class BoCreatePlat
 */
@WebServlet("/backoffice/BoCreatePlat")
public class BoCreatePlat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String url = "Table_Plats";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoCreatePlat() {
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
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		CreatePlatForm form = new CreatePlatForm();
		Plat plat = form.ajoutPlat(request);
		
		if(form.isValide()){
			DataAccess.createPlat(plat);
		}
		
		request.setAttribute("form", form);
		request.setAttribute("plat", plat);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
