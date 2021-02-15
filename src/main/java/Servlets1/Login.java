package Servlets1;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;
import modeloDAO.UsersDAO;
import modeloDAO.UsersDAOImplement;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = null;
		UsersDAO cdao = new UsersDAOImplement();
		switch(request.getParameter("opcion")) {
		case "validar":
			
			
			user = cdao.autenticar(request.getParameter("usuario"), 
										request.getParameter("password"));
			if (user != null) {
				if (user.getTipoUser().equals("normal")) {
					HttpSession misesion = request.getSession();
					misesion.setAttribute("usuario", user);
					misesion.setAttribute("sessionScope", user);
					//Como cambiar
					//request.getRequestDispatcher("/entregam3/UserController").forward(request, response);
					response.sendRedirect("/entregam3/UserController");
	
				}else
					request.getRequestDispatcher("MenuAdministrador.jsp").forward(request, response);
			}else {
				request.setAttribute("mensajeLogin", "usuario o password incorrecto, intentalo de nuevo");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
			break;
		case "registrar":
			user = new User();
			user.setLast_name(request.getParameter("last_name"));
			user.setPassword(request.getParameter("password"));
			user.setAge(Integer.valueOf(request.getParameter("age")));
			user.setFirst_name(request.getParameter("first_name"));
			user.setEmail(request.getParameter("email"));
			user.setMarried(request.getParameter("married"));
			user.setTipoUser("normal");

			
			
			if (cdao.insert(user) == 1) {
				request.setAttribute("mensajeLogin", "User inserado por favor loguese");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				request.setAttribute("mensajeLogin", "usuario ya existe");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			break;
			
		case "registrarBean":
			user = (User) request.getAttribute("miUser");
			user.setTipoUser("normal");

			if (cdao.insert(user) == 1) {
				request.setAttribute("mensajeLogin", "User inserado por favor loguese");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				request.setAttribute("mensajeLogin", "usuario ya existe");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
				
			
			break;
			
		default:
			System.out.println("opcion en Login erronea : " + request.getParameter("opcion"));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
