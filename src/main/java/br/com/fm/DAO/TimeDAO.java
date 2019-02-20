package br.com.fm.DAO;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.fm.model.Time;



public class TimeDAO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
    EntityManager entityManager;
	
	private DAO<Time> dao;

	@PostConstruct //o CDI vai chamar esse método assim que inicializar essa classe
    void init() {
        this.dao = new DAO<Time>(entityManager, Time.class);
    }
	
	public Time selectById(Integer timeId) {
        return this.dao.selectById(timeId);
    }

    public void save(Time time) {
    	this.dao.save(time);
    }

    public void update(Time time) {
    	this.dao.update(time);
    }

    public void delete(Time time) {
    	this.dao.delete(time);
    }

    public List<Time> selectAll() {
        return this.dao.selectAll();
    }
}
