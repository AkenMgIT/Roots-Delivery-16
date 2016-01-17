package akenmg.rootsdelivery.daotest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.dao.DaoPlat;
import akenmg.rootsdelivery.model.Plat;

/**
 * Servlet implementation class CreatePlat
 */
@WebServlet("/daotest/CreatePlat")
public class CreatePlat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePlat() {
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
		String titre = request.getParameter("titre");
		String description = request.getParameter("description");
		String prix = request.getParameter("prix");
		String img = request.getParameter("img");
		
		System.out.println(titre);
		System.out.println(description);
		System.out.println(prix);
		System.out.println(img);
		
		Plat plat = new Plat();
		plat.setTitre(titre);
		plat.setDescription(description);
		plat.setPrix(Integer.parseInt(prix));
		plat.setImg(img);
		
		DaoPlat.create(plat);
		
		response.sendRedirect("daoplat.jsp");
	}

}
