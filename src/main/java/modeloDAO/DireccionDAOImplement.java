package modeloDAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import entities.Direccion;
import entities.User;
import util.JPAUtil;
import javax.persistence.TypedQuery;





public class DireccionDAOImplement implements DireccionDAO {
	//Comparar direccion usuario id 
	private static final String FIND_BY_USERID = "SELECT d FROM Direccion d WHERE d.user.id = :usuario_id";
	public DireccionDAOImplement() {
	}
	
	EntityManager manager;

	public void closeEntityManager() {
		manager.close();
	}

	public void openEntityManager() {
		manager = JPAUtil.getEntityManager();
	}
	
	
	
	
	
	@Override
	public Direccion findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Direccion> findAll() {
		openEntityManager();
		TypedQuery<Direccion> namedQuery = manager.createNamedQuery("Direccion.findAll", Direccion.class);
		List<Direccion> todos = namedQuery.getResultList();
		closeEntityManager();
		return todos;
	}

	
	@Override
	public List<Direccion> findDireccionByUserId(Long Id) {
		manager = JPAUtil.getEntityManager();
		TypedQuery<Direccion> query = manager.createQuery(FIND_BY_USERID, Direccion.class);
		query.setParameter("usuario_id", Id);
		List<Direccion> results = query.getResultList();
		manager.close();
		return results;
	}

	
	
	
	@Override
	public Direccion create(Direccion direccion) {
		if (direccion == null || direccion.getId() != null) {
			return direccion;
		}
		openEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(direccion);
			manager.getTransaction().commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
		}
		closeEntityManager();
		return direccion;
	}

	
	
	
	
	@Override
	public Direccion update(Direccion direccion) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Direccion> get() {
		try {
			manager = JPAUtil.getEntityManager();
			TypedQuery<Direccion> namedQuery = manager.createNamedQuery("Direccion.findAll", Direccion.class);
			List<Direccion> results = namedQuery.getResultList();
			manager.close();
			return results;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Direccion>();
	}

	
	
	@Override
	public Direccion get(Long usuario_id) {
		Direccion Direccion = null;
		try {
			manager = JPAUtil.getEntityManager();
			Direccion = manager.find(Direccion.class, usuario_id);
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Direccion;
	}

	
	
	
	@Override
	public boolean delete(Long id) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			Direccion direccion = manager.find(Direccion.class, id);
			if (direccion != null) {
				manager.remove(direccion);
				manager.getTransaction().commit(); 
				flag = true;
			}
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
