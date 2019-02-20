package br.com.fm.facade;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.fm.DAO.CampeonatoDAO;
import br.com.fm.model.Campeonato;

public class CampeonatoFacade implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private CampeonatoDAO dao;
	
	public void save(Campeonato campeonato) {
		dao.save(campeonato);
	}
	
	public void update(Campeonato campeonato) {
		dao.update(campeonato);
	}
	
    public List<Campeonato> selectAll() {
        return this.dao.selectAll();
    }
	
    public void delete(Campeonato campeonato) {
    	dao.delete(campeonato);
    }
    
	public Campeonato selectById(Integer campeonatoId) {
        return this.dao.selectById(campeonatoId);
    }

}