package br.com.fm.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class DAO<T> {
	
	private final Class<T> classe;

	private EntityManager entityManager;
		
	public DAO(EntityManager entityManager, Class<T> classe) {
		this.classe = classe;
		this.entityManager = entityManager;
	}

	public void save(T t) {

		// consegue a entity manager
		EntityManager entityManager = new JPAUtil().getEntityManager();

		// abre transacao
		entityManager.getTransaction().begin();

		// persiste o objeto
		entityManager.persist(t);

		// commita a transacao
		entityManager.getTransaction().commit();

		// fecha a entity manager
		entityManager.close();
	}

	public void delete(T t) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();

		entityManager.remove(entityManager.merge(t));

		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void update(T t) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();

		entityManager.merge(t);

		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public List<T> selectAll() {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = entityManager.createQuery(query).getResultList();

		entityManager.close();
		return lista;
	}

	public T selectById(Integer id) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		T instancia = entityManager.find(classe, id);
		entityManager.close();
		return instancia;
	}

	public int countAll() {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		long result = (Long) entityManager.createQuery("select count(n) from usuario n")
				.getSingleResult();
		entityManager.close();

		return (int) result;
	}

	public List<T> listAllPages(int firstResult, int maxResults) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = entityManager.createQuery(query).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();

		entityManager.close();
		return lista;
	}

	public EntityManager getm() {
		return entityManager;
	}
	public void setEm(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
}
