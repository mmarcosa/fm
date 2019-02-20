package br.com.fm.DAO;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fm.model.UsuarioLogin;


public class UsuarioLoginDao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
    EntityManager em;
	
	private DAO<UsuarioLogin> dao;

	@PostConstruct //o CDI vai chamar esse método assim que inicializar CachorroDao
    void init() {
        this.dao = new DAO<UsuarioLogin>(em, UsuarioLogin.class);
    }
	
	public UsuarioLogin selectById(Integer usuarioLoginId) {
        return this.dao.selectById(usuarioLoginId);
    }

    public void save(UsuarioLogin usuarioLogin) {
    	this.dao.save(usuarioLogin);
    }

    public void update(UsuarioLogin usuarioLogin) {
    	this.dao.update(usuarioLogin);
    }

    public void delete(UsuarioLogin usuarioLogin) {
    	this.dao.delete(usuarioLogin);
    }

    public List<UsuarioLogin> selectAll() {
        return this.dao.selectAll();
    }
	
	public boolean exists(UsuarioLogin usuarioLogin) {
        
		EntityManager em = new JPAUtil().getEntityManager();
        
		TypedQuery<UsuarioLogin> query = em.createQuery("select u from UsuarioLogin u where u.email = :pEmail and u.senha = :pSenha", UsuarioLogin.class);
        
		query.setParameter("pEmail", usuarioLogin.getEmail());
	    query.setParameter("pSenha", usuarioLogin.getSenha());

	    try {
	    	UsuarioLogin resultado = query.getSingleResult();
	    } catch (NoResultException ex) {
	        return false;
	    }

	    em.close();

	    return true;
    }
	
}
