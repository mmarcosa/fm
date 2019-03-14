package br.com.fm.DAO;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.fm.model.Usuario;

public class UsuarioDAO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
    EntityManager entityManager;

	private DAO<Usuario> dao;

	@PostConstruct //o CDI vai chamar esse método assim que inicializar essa classe
    void init() {
        this.dao = new DAO<Usuario>(entityManager, Usuario.class);
    }

	public Usuario selectById(Integer usuarioId) {
        return this.dao.selectById(usuarioId);
    }

    public void save(Usuario usuario) {
    	this.dao.save(usuario);
    }

    public void update(Usuario usuario) {
    	this.dao.update(usuario);
    }

    public void delete(Usuario usuario) {
    	this.dao.delete(usuario);
    }

    public List<Usuario> selectAll() {
        return this.dao.selectAll();
    }


	
	
	
	
}
