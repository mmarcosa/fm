package br.com.fm.DAO;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("futebolm");

	@Produces //para o CDI saber que esse método produz o EntityManager
	@RequestScoped //javax.enterprise.context.RequestScoped;
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void close(@Disposes EntityManager em) {
		em.close();
	}
}
