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

import fr.eni.jpa.service.GestionBouteille;


/**
 * Servlet implementation class ListerServlet
 */
@WebServlet("/lister")
public class ListerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	GestionBouteille gb;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListerServlet() {
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
		
		
		request.setAttribute("listeB", gb.listeBouteille());
		
		RequestDispatcher rd = request.getRequestDispatcher("listeVins.jsp");
		rd.forward(request, response);
	}

}
