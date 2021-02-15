package modeloDAO;

import java.util.List;

import entities.Direccion;
import entities.User;

public interface DireccionDAO {
	List<Direccion> get();
	
	Direccion get(Long id);
	
	public Direccion findById(Long id);
	
	public List<Direccion> findAll();
	
	public List<Direccion> findDireccionByUserId(Long Id);
	
	public Direccion create(Direccion direccion);
	
	public Direccion update(Direccion direccion);
		
	boolean delete(Long id);
	
	
}
