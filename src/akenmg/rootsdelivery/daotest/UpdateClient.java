package akenmg.rootsdelivery.daotest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import akenmg.rootsdelivery.dao.DaoAdmin;
import akenmg.rootsdelivery.dao.DaoClient;
import akenmg.rootsdelivery.model.Admin;
import akenmg.rootsdelivery.model.Client;

/**
 * Servlet implementation class UpdateClient
 */
@WebServlet("/daotest/UpdateClient")
public class UpdateClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClient() {
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
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String numero = request.getParameter("numero");
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		
		System.out.println(nom);
		System.out.println(prenom);
		System.out.println(numero);
		System.out.println(email);
		System.out.println(mdp);
		
		Client client = new Client();
		client.setId(Integer.parseInt(id));
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setNumero(numero);
		client.setEmail(email);
		client.setMdp(mdp);
		
		DaoClient.update(client);
		
		response.sendRedirect("daoclient.jsp");
	}

}
