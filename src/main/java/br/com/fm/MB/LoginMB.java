package br.com.fm.MB;


import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fm.facade.UsuarioLoginFacade;
import br.com.fm.model.UsuarioLogin;
import br.com.fm.util.RedirectView;

@Named //anota��o do CDI, antes era a anota��o @ManagedBean do JSF
@ViewScoped //Essa anota��o tem o mesmo nome, mas � de outro pacote: javax.faces.view.ViewScoped
public class LoginMB implements Serializable{

	private static final long serialVersionUID = 1L;

	private UsuarioLogin usuarioLogin = new UsuarioLogin();

	@Inject
    FacesContext context;
	
	@Inject
	private UsuarioLoginFacade usuarioLoginFacade;
		
    public UsuarioLogin getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(UsuarioLogin usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

	public RedirectView efetuaLogin() {        
    	System.out.println("Fazendo login do usu�rio " + this.usuarioLogin.getEmail());               	
    	boolean existe = usuarioLoginFacade.exists(this.usuarioLogin);        
        if(existe) {        
        	context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuarioLogin);        	
        	return new RedirectView("campeonato");
        }
        
        context.getExternalContext().getFlash().setKeepMessages(true);
        context.addMessage(null, new FacesMessage("Usu�rio n�o encontrado ou senha inv�lida .."));
        
        return new RedirectView("login");
    }
    
    public RedirectView deslogar() {
		
    	FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().remove("usuarioLogado");

        return new RedirectView("login");
    	
    }

}
