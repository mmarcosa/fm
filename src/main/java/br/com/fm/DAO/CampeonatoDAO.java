package br.com.fm.DAO;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.fm.model.Campeonato;

public class CampeonatoDAO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
    EntityManager entityManager;

	private DAO<Campeonato> dao;

	@PostConstruct //o CDI vai chamar esse método assim que inicializar essa classe
    void init() {
        this.dao = new DAO<Campeonato>(entityManager, Campeonato.class);
    }

	public Campeonato selectById(Integer campeonatoId) {
        return this.dao.selectById(campeonatoId);
    }

    public void save(Campeonato campeonato) {
    	this.dao.save(campeonato);
    }

    public void update(Campeonato campeonato) {
    	this.dao.update(campeonato);
    }

    public void delete(Campeonato campeonato) {
    	this.dao.delete(campeonato);
    }

    public List<Campeonato> selectAll() {
        return this.dao.selectAll();
    }

}