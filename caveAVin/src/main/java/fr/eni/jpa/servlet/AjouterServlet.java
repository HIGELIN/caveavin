package fr.eni.jpa.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

/**
 * Servlet implementation class AjouterServlet
 */
@WebServlet("/ajouter")
public class AjouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	GestionBouteille gb;
	GestionCouleur gc;
	GestionRegion gr;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void init(ServletConfig config) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionCouleur gc = new GestionCouleur();	
		request.setAttribute("listeCouleur", gc.listeCouleur());
		
		GestionRegion gr = new GestionRegion();	
		request.setAttribute("listeRegion", gr.listeRegion());
		
		RequestDispatcher rd = request.getRequestDispatcher("ajouterVin.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			Couleur c = gc.trouverCouleur(Integer.parseInt(request.getParameter("couleur")));
			

			Region r = gr.trouverRegion(Integer.parseInt(request.getParameter("region")));
			
			Bouteille b = new Bouteille();
			b.setId(Integer.parseInt(request.getParameter("id")));
			b.setNom(request.getParameter("nom"));
			b.setMillesime(request.getParameter("millesime"));
			b.setPetillant(Boolean.parseBoolean(request.getParameter("petillant")));
			b.setQuantite(Integer.parseInt(request.getParameter("quantite")));
			
			Couleur couleur = new Couleur();
			couleur.setNom(request.getParameter("couleur"));

			
			List<Region> listeR = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				String nom = request.getParameter("nom"+i).trim();

				if (!nom.equals(""))
				{
					listeR.add(new Region(nom));
				}
					
			}
			 /* b.setRegion(listeR); */
			
			gb.ajoutBouteille(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("lister");
	}

}
