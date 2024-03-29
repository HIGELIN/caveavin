package fr.eni.jpa.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fr.eni.jpa.bean.Bouteille;
import fr.eni.jpa.bean.Couleur;
import fr.eni.jpa.bean.Region;
import fr.eni.jpa.service.GestionBouteille;
import fr.eni.jpa.service.GestionCouleur;
import fr.eni.jpa.service.GestionRegion;

@WebServlet("/ajouter")
public class AjouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	GestionBouteille gb;
	@Autowired
	GestionCouleur gc;
	@Autowired
	GestionRegion gr;

	@Override
	public void init(ServletConfig config) throws ServletException {

		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("listeRegion", gr.getListeRegions());
		request.setAttribute("listeCoul", gc.getListeCouleurs());
		RequestDispatcher rd = request.getRequestDispatcher("/ajouterB.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nom = request.getParameter("nom");
			String millesime = request.getParameter("millesime");
			Boolean petillant = Boolean.parseBoolean(request.getParameter("petillant"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			int couleurId = Integer.parseInt(request.getParameter("couleurId"));
			int regionId = Integer.parseInt(request.getParameter("regionId"));
			Couleur couleur = gc.getCouleur(couleurId);
			Region region = gr.getRegion(regionId);
			
			Bouteille b = new Bouteille(nom, region, couleur, petillant, millesime, quantite);
			
			System.out.println(b);
			gb.ajouterBouteille(b);

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		response.sendRedirect("lister");
	}

}
