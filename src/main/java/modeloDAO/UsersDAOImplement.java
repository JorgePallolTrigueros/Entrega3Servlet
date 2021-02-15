package modeloDAO;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.TypedQuery;
import util.JPAUtil;


import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import javax.persistence.Query;

import entities.User;






public class UsersDAOImplement implements UsersDAO {

	EntityManager manager;
	private static EntityManagerFactory emf;
	private static EntityManager em;
	static {
		emf = Persistence.createEntityManagerFactory("entregam3");
		em = emf.createEntityManager();
	}
	
	private String sql;
	private Query query;
	private EntityTransaction tx;
	
	public UsersDAOImplement() {
		tx = em.getTransaction();
	}



	
	@Override
	public User findById(String user) {
		// TODO Auto-generated method stub
		return em.find(User.class, user);
	}

	
	
	@Override
		public User autenticar(String usuario, String password) {
			sql = "select u from User u where u.first_name = :usu and u.password = :pwd";
			try
			{
			query = em.createQuery(sql);
			query.setParameter("usu", usuario);
			query.setParameter("pwd", password);
			
			
			return (User) query.getSingleResult();
			}
			catch(javax.persistence.NoResultException e) {
				return null;
			}
			catch(Exception e) {
				System.out.println("error capturado");
				e.printStackTrace();
				return null;
			}
		}
	
		
		
		
	

	@Override
	public int insert(User user) {
		tx.begin();
		try {
		em.persist(user);
		tx.commit();
		return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}



	
	
	
	
	
	
	
	
	

	@Override
	public List<User> get() {
			try {
				manager = JPAUtil.getEntityManager();
				TypedQuery<User> namedQuery = manager.createNamedQuery("User.findAll", User.class);
				List<User> results = namedQuery.getResultList();
				manager.close();
				return results;
			}catch(Exception e) {
				e.printStackTrace();
			}
			return new ArrayList<User>();
	}



	
	
	
	
	

	@Override
	public User get(Long id) {
		User User = null;
		try {
			manager = JPAUtil.getEntityManager();
			User = manager.find(User.class, id);
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return User;
	}




	@Override
	public boolean save(User user) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			manager.persist(user); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}




	@Override
	public boolean delete(Long id) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			User User = manager.find(User.class, id);
			if (User != null) {
				manager.remove(User);
				manager.getTransaction().commit(); 
				flag = true;
			}
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}




	@Override
	public boolean update(User user) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			manager.merge(user); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}




	@Override
	public boolean view(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	}

	
	
	
	
	
	
	
	
	

	
	
	
	
	
