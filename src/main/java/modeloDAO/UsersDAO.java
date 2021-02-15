package modeloDAO;

import java.util.List;

import entities.User;


public interface UsersDAO {
	List<User> get();
	User get(Long id);
	boolean save(User user);
	boolean delete(Long id);
	boolean update(User user);
	public User findById(String user);		//Login
	public User autenticar(String usuario, String password);
	public int insert(User user);			//Insertar
	
	
	boolean view(Long id);
}
