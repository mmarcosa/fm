package br.com.fm.facade;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.fm.DAO.ClassificacaoDAO;
import br.com.fm.model.Classificacao;

public class ClassificacaoFacade implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private ClassificacaoDAO dao;
	
	public void save(Classificacao classificacao) {
		dao.save(classificacao);
	}
	
	public void update(Classificacao classificacao) {
		dao.update(classificacao);
	}
	
    public List<Classificacao> selectAll() {
        return this.dao.selectAll();
    }
	
    public void delete(Classificacao classificacao) {
    	dao.delete(classificacao);
    }
    
	public Classificacao selectById(Integer classificacaoId) {
        return this.dao.selectById(classificacaoId);
    }

	public List<Classificacao> byCodCampeonato(String codigoCampeonato) {
        return this.dao.buscaByCodCampeonato(codigoCampeonato);
    }
	
}