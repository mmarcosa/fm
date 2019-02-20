package br.com.fm.facade;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.fm.DAO.UsuarioLoginDao;
import br.com.fm.model.UsuarioLogin;

public class UsuarioLoginFacade implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private UsuarioLoginDao dao;
	
	public void save(UsuarioLogin usuarioLogin) {
		dao.save(usuarioLogin);
	}
	
	public void update(UsuarioLogin usuarioLogin) {
		dao.update(usuarioLogin);
	}
	
    public List<UsuarioLogin> selectAll() {
        return this.dao.selectAll();
    }
	
    public void delete(UsuarioLogin usuarioLogin) {
    	dao.delete(usuarioLogin);
    }
    
	public UsuarioLogin selectById(Integer usuarioLoginId) {
        return this.dao.selectById(usuarioLoginId);
    }
	
	public boolean exists(UsuarioLogin usuarioLogin) {
		return dao.exists(usuarioLogin);
	}
	
}
