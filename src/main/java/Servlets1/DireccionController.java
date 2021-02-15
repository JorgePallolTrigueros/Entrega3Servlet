package Servlets1;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import util.AppConstants;

import entities.Direccion;
import entities.User;
import modeloDAO.DireccionDAO;
import modeloDAO.DireccionDAOImplement;
import modeloDAO.UsersDAO;
import modeloDAO.UsersDAOImplement;


/**
 * Servlet implementation class DireccionController
 */








@WebServlet(name = "DireccionController", urlPatterns = { "/direccion" })
public class DireccionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	
	UsersDAO UsersDAO = new UsersDAOImplement();
	DireccionDAO DireccionDAO = new DireccionDAOImplement();
	
	public DireccionController() {
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null || action.length() == 0) 
			action = AppConstants.ACTION_RETRIEVE;
		
		switch (action) {
			case AppConstants.ACTION_RETRIEVE:
				retrieve(request, response);
				break;
			case AppConstants.ACTION_UPDATE:
				update(request, response);
				break;
			case AppConstants.ACTION_DELETE:
				delete(request, response);
				break;
			default:
				retrieve(request, response);
		}
		
	}



	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		DireccionDAO.delete(Long.valueOf(id));
		retrieve(request, response);
	}

	
	
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(AppConstants.SESSION_USER);
		
		Direccion Direccion = DireccionDAO.findById(Long.valueOf(id));
		request.setAttribute("User", user);
		request.setAttribute("Direccion", Direccion);
		request.getRequestDispatcher(AppConstants.CREATE_DIRECCION_PAGE).forward(request, response);
	}

	
	
	
	
	private void retrieve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(AppConstants.SESSION_USER);
		List<Direccion> DireccionList = DireccionDAO.findDireccionByUserId(user.getId());

		// Direccion list is request scoped to avoid storing and synchronizing it in
		// session for each CRUD operation
		request.setAttribute("DireccionList", DireccionList);

		request.getRequestDispatcher(AppConstants.HOME_PAGE).forward(request, response);		
	}

	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Direccion Direccion = new Direccion();
		Direccion.setDireccion_personal(request.getParameter("description"));

		Direccion.setUser((User)request.getSession().getAttribute(AppConstants.SESSION_USER));
		
		if (id != null && !id.isEmpty()) {
			// update
			Direccion.setId(Long.valueOf(id));
			DireccionDAO.update(Direccion);
		} else {
			// create
			DireccionDAO.create(Direccion);

		}
		retrieve(request, response);
		
	}

}
