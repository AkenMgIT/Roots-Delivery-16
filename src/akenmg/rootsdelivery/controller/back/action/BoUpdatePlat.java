package akenmg.rootsdelivery.controller.back.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.model.view.PlatView;
import akenmg.rootsdelivery.service.DataAccess;
import akenmg.rootsdelivery.service.modelform.UpdatePlatForm;

/**
 * Servlet implementation class BoUpdatePlat
 */
@WebServlet("/backoffice/fiches/BoUpdatePlat")
public class BoUpdatePlat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String url = "Fiche_Plat";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoUpdatePlat() {
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
		UpdatePlatForm form = new UpdatePlatForm();
		PlatView plat = new PlatView(form.ajoutPlat(request));
		request.setAttribute("form", form);
		if(form.isValide()){
			DataAccess.updatePlat(plat);
		}
		request.setAttribute("plat", plat);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
