package br.com.fm.facade;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.fm.DAO.UsuarioDAO;
import br.com.fm.model.Usuario;

public class UsuarioFacade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject 
	private UsuarioDAO dao;
	
	public void save(Usuario usuario) {
		dao.save(usuario);
	}
	
	public void update(Usuario usuario) {
		dao.update(usuario);
	}
	
    public List<Usuario> selectAll() {
        return this.dao.selectAll();
    }
	
    public void delete(Usuario usuario) {
    	dao.delete(usuario);
    }
    
	public Usuario selectById(Integer usuarioId) {
        return this.dao.selectById(usuarioId);
    }

}
