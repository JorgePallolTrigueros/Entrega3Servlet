package cread;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Cread {

	public static void main(String[] args) {

		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("entregam3");
		EntityManager manager = managerFactory.createEntityManager();
		
		// Creamos nuevos objetos
		



		

		// Guardar nuevos usuarios (método persist())
		try{
			// Se inicia una transacción
			manager.getTransaction().begin();   
			// Se persisten los objetos

			// Se realiza commit para hacer efectivas las inserciones
			manager.getTransaction().commit();    
		}catch(Exception ex){
			ex.printStackTrace();
			manager.getTransaction().rollback();   
		}finally{
			manager.close();
			managerFactory.close();
		}
	}

}