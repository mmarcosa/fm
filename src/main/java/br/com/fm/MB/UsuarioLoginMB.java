package br.com.fm.MB;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fm.TX.Transacional;
import br.com.fm.facade.UsuarioLoginFacade;
import br.com.fm.model.UsuarioLogin;
import br.com.fm.util.RedirectView;

@Named // anotação do CDI, antes era a anotação do JSF
@ViewScoped // Essa anotação tem o mesmo nome, mas é de outro pacote: javax.faces.view.ViewScoped
public class UsuarioLoginMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private UsuarioLogin usuarioLogin = new UsuarioLogin();
	
	private Integer usuarioId;
	
	@Inject
	private FacesContext context;
		
	@Inject
	private UsuarioLoginFacade usuarioLoginFacade;
			
	public UsuarioLoginMB() {

	}
		
	public UsuarioLogin getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(UsuarioLogin usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Transacional
	public RedirectView gravar(){
		System.out.println("Gravando usuario: " + this.usuarioLogin.getEmail());
		if (this.usuarioLogin.getId() == null) {
			usuarioLoginFacade.save(this.usuarioLogin);
		} else {
			usuarioLoginFacade.update(this.usuarioLogin);
		}
		this.usuarioLogin = new UsuarioLogin();
		return new RedirectView("usuario");
	}
	
	public List<UsuarioLogin> getUsuarios() {
		return usuarioLoginFacade.selectAll();
	}

	@Transacional
	public void delete(UsuarioLogin usuarioLogin) {
		System.out.println("Removendo jogo: " + usuarioLogin.getEmail());
		usuarioLoginFacade.delete(usuarioLogin);
	}

	public void select(UsuarioLogin usuarioLogin) {
		System.out.println("Carregando usuario adm: " + usuarioLogin.getEmail());
		this.usuarioLogin = usuarioLogin;
	}

	public void selectById() {
		this.usuarioLogin = usuarioLoginFacade.selectById(usuarioId);
		if (this.usuarioLogin == null) {
			this.usuarioLogin = new UsuarioLogin();
		}
	}

}
