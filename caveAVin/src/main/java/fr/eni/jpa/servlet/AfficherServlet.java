package fr.eni.jpa.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jpa.bean.Bouteille;
import fr.eni.jpa.service.GestionBouteille;


/**
 * Servlet implementation class AfficherServlet
 */
@WebServlet("/afficher")
public class AfficherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AfficherServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean ok = false;
		try {
			int id = Integer.parseInt(request.getParameter("index"));
			GestionBouteille gf = new GestionBouteille();
			Bouteille f = gf.trouverBouteille(id);
			if (f != null){
				ok = true;
				request.setAttribute("bouteille", f);
			}
		} catch (Exception e) {
		}

		if (ok){
			RequestDispatcher rd = request.getRequestDispatcher("afficherVin.jsp");
			rd.forward(request, response);
		}
		else{
			response.sendRedirect("lister");
		}
		
	}

}
