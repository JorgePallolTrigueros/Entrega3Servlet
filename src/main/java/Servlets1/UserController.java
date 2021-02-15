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

import modeloDAO.DireccionDAOImplement;
import modeloDAO.DireccionDAO;
import modeloDAO.UsersDAO;
import modeloDAO.UsersDAOImplement;
import entities.Direccion;
import entities.User;





@WebServlet("/UserController")
public class UserController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	
	UsersDAO UsersDAO = new UsersDAOImplement();
	DireccionDAO DireccionDAO = new DireccionDAOImplement();
	
	public UserController() {
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listUser(request, response);
				break;
				
			case "EDIT":
				getSingleUser(request, response);
				break;
				
			case "DELETE":
				deleteUser(request, response);
				break;
				
			case "VIEW":
				viewUser(request, response);
				break;			
				
			default:
				listUser(request, response);
				break;
				
		}
		
	}

	private void viewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		
		// Si quisiera usar una lista sería así:
		//List<Direccion> listaDirecciones = DireccionDAO.findDireccionByUserId(Long.parseLong(id));
		//request.setAttribute("direcciones", listaDirecciones);
		
		Direccion theDireccion = DireccionDAO.get(Long.parseLong(id));
		User theUser = UsersDAO.get(Long.parseLong(id));
		
		request.setAttribute("direccion", theDireccion);
		request.setAttribute("user", theUser);
		
		dispatcher = request.getRequestDispatcher("/views/direccion-list.jsp");
		
		dispatcher.forward(request, response);
	}
	
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
	
		if(UsersDAO.delete(Long.parseLong(id))) {
			request.setAttribute("NOTIFICATION", "User Deleted Successfully!");
		}
		
		listUser(request, response);
	}
	
	
	
	
	
	
	

	private void getSingleUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
		User theUser = UsersDAO.get(Long.parseLong(id));
		
		request.setAttribute("user", theUser);
		
		dispatcher = request.getRequestDispatcher("/views/User-form.jsp");
		
		dispatcher.forward(request, response);
	}

	
	
	
	
	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> theList = UsersDAO.get();
		
		request.setAttribute("list", theList);
		HttpSession session = request.getSession();
		request.setAttribute("nombreSession", session.getAttribute("usuario"));
		
		dispatcher = request.getRequestDispatcher("/views/User-list.jsp");
		
		dispatcher.forward(request, response);
	}

	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		User user = new User();
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setAge(Integer.valueOf(request.getParameter("age")));
		user.setFirst_name(request.getParameter("first_name"));
		user.setLast_name(request.getParameter("last_name"));
		user.setTipoUser("normal");
		user.setMarried(request.getParameter("maried"));
		user.setNif(Integer.valueOf(request.getParameter("niff")));
		if(id.isEmpty() || id == null) {
			
			if(UsersDAO.save(user)) {
				request.setAttribute("NOTIFICATION", "Usuario actualizado con Exito!");
			}
		
		}else {
			
			user.setId(Long.parseLong(id));
			if(UsersDAO.update(user)) {
				request.setAttribute("NOTIFICATION", "User Updated Successfully!");
			}
			
		}
		
		listUser(request, response);
	}

}
