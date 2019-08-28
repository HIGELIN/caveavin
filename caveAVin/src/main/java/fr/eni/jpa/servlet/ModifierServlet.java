package fr.eni.jpa.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jpa.bean.Bouteille;
import fr.eni.jpa.bean.Couleur;
import fr.eni.jpa.bean.Region;
import fr.eni.jpa.service.GestionBouteille;
import fr.eni.jpa.service.GestionCouleur;
import fr.eni.jpa.service.GestionRegion;

/**
 * Servlet implementation class ModifierServlet
 */
@WebServlet("/modifier")
public class ModifierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			GestionCouleur gc = new GestionCouleur();
			request.setAttribute("listeCouleur", gc.listeCouleur());
			
			GestionBouteille gb = new GestionBouteille();
			Bouteille b = gb.trouverBouteille(Integer.parseInt(request.getParameter("index").substring(1)));
			request.setAttribute("bouteille", b);
			RequestDispatcher rd = request.getRequestDispatcher("editerVin.jsp");
			rd.forward(request, response);
			return;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("lister");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			GestionCouleur gc = new GestionCouleur();
			GestionRegion gr = new GestionRegion();
			GestionBouteille gb = new GestionBouteille();
			
			Couleur c = gc.trouverCouleur(Integer.parseInt(request.getParameter("couleur")));
			Region r = gr.trouverRegion(Integer.parseInt(request.getParameter("region")));
			
			int index = Integer.parseInt(request.getParameter("id"));
			Bouteille b = gb.trouverBouteille(index);
			b.setId(Integer.parseInt(request.getParameter("id")));
			b.setNom(request.getParameter("nom"));
			b.setMillesime(request.getParameter("millesime"));
			b.setPetillant(Boolean.parseBoolean(request.getParameter("petillant")));
			b.setQuantite(Integer.parseInt(request.getParameter("quantite")));
			
			Couleur couleur = new Couleur();
			r.setNom(request.getParameter("vin.nom"));
			
			List<Region> listeA = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				String nom = request.getParameter("nom"+i).trim();
				if (!nom.equals(""))
					listeA.add(new Region(nom));
			}
			/* b.setCouleur(listeA); */
			
			gb.modifierBouteille(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("lister");
	}

}
