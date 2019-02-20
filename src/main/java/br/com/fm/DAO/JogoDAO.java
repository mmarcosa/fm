package br.com.fm.DAO;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.fm.model.Jogo;

public class JogoDAO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
    EntityManager entityManager;

	private DAO<Jogo> dao;

	@PostConstruct //o CDI vai chamar esse método assim que inicializar essa classe
    void init() {
        this.dao = new DAO<Jogo>(entityManager, Jogo.class);
    }

	public Jogo selectById(Integer jogoId) {
        return this.dao.selectById(jogoId);
    }

    public void save(Jogo jogo) {
    	this.dao.save(jogo);
    }

    public void update(Jogo jogo) {
    	this.dao.update(jogo);
    }

    public void delete(Jogo jogo) {
    	this.dao.delete(jogo);
    }

    public List<Jogo> selectAll() {
        return this.dao.selectAll();
    }

}