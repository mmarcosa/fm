package br.com.fm.facade;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.fm.DAO.JogoDAO;
import br.com.fm.model.Jogo;

public class JogoFacade implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private JogoDAO dao;
	
	public void save(Jogo jogo) {
		dao.save(jogo);
	}
	
	public void update(Jogo jogo) {
		dao.update(jogo);
	}
	
    public List<Jogo> selectAll() {
        return this.dao.selectAll();
    }
	
    public void delete(Jogo jogo) {
    	dao.delete(jogo);
    }
    
	public Jogo selectById(Integer jogoId) {
        return this.dao.selectById(jogoId);
    }

}