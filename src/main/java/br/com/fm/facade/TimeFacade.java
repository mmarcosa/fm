package br.com.fm.facade;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.fm.DAO.TimeDAO;
import br.com.fm.model.Time;



public class TimeFacade implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private TimeDAO dao;
	
	public void save(Time time) {
		dao.save(time);
	}
	
	public void update(Time time) {
		dao.update(time);
	}
	
    public List<Time> selectAll() {
        return this.dao.selectAll();
    }
	
    public void delete(Time time) {
    	dao.delete(time);
    }
    
	public Time selectById(Integer timeId) {
        return this.dao.selectById(timeId);
    }
}
