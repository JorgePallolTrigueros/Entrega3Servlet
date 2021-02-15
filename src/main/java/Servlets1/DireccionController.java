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








@WebServlet("/DireccionController")
public class DireccionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	
	UsersDAO UsersDAO = new UsersDAOImplement();
	DireccionDAO DireccionDAO = new DireccionDAOImplement();
	
	public DireccionController() {
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listDireccion(request, response);
				break;
				
			case "EDIT":
				getSingleDireccion(request, response);
				break;
				
			case "DELETE":
				deleteDireccion(request, response);
				break;
				
			case "VIEW":
				
				break;			
				
			default:
				listDireccion(request, response);
				break;
				
		}
		
	}



	
	
	private void deleteDireccion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		if(DireccionDAO.delete(Long.parseLong(id))) {
			request.setAttribute("NOTIFICATION", "Direccion Borrada!");
		}
		listDireccion(request, response);
	}
	
	
	
	
	
	
	

	private void getSingleDireccion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		Direccion theDireccion = DireccionDAO.get(Long.parseLong(id));
		request.setAttribute("direccion", theDireccion);
		dispatcher = request.getRequestDispatcher("/views/Direccion-form.jsp");
		dispatcher.forward(request, response);
	}

	
	
	
	
	private void listDireccion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Direccion> theList = DireccionDAO.get();
		request.setAttribute("list", theList);
		HttpSession session = request.getSession();
		request.setAttribute("nombreSession", session.getAttribute("usuario"));
		dispatcher = request.getRequestDispatcher("/views/User-list.jsp");
		dispatcher.forward(request, response);
	}

	
	private void retrieve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("usuario");
		List<Direccion> direccionList = DireccionDAO.findDireccionByUserId(user.getId());

		request.setAttribute("direccionList", direccionList);

		request.getRequestDispatcher(AppConstants.HOME_PAGE).forward(request, response);		
	}
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		String id = request.getParameter("id");
		Direccion direccion = new Direccion();
		direccion.setDireccion_personal(request.getParameter("direccionpersonal1"));
		direccion.setDireccion_personal2(request.getParameter("direccionpersonal2"));
		direccion.setUser((user));
		
		//if (request.getParameter("done") != null && request.getParameter("done").equals("on")) {
				//direccion.setDone(true);
		//}
		direccion.setUser((User)request.getSession().getAttribute(AppConstants.SESSION_USER));

		if (id != null && !id.isEmpty()) {
			// update
			direccion.setId(Long.valueOf(id));
			DireccionDAO.update(direccion);
		} else {
			// create
			DireccionDAO.create(direccion);

		}
		retrieve(request, response);
		
	}

}
