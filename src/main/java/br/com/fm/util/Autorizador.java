package br.com.fm.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.fm.model.UsuarioLogin;

public class Autorizador implements PhaseListener{

	private static final long serialVersionUID = 1L;

	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		String nomePagina = context.getViewRoot().getViewId();
		System.out.println(nomePagina);
		if("/login.xhtml".equals(nomePagina)) {
			return; //O return significa que não iremos fazer nada e que o código continuará normalmente com as fases seguintes.
		}
		
		UsuarioLogin usuarioLogado = (UsuarioLogin) context.getExternalContext().getSessionMap().get("usuarioLogado");
		
		if(usuarioLogado != null) {
			return;
		}
		
		NavigationHandler handler = context.getApplication().getNavigationHandler();
		handler.handleNavigation(context, null, "/login?faces-redirect=true");
		context.renderResponse();
		
	}

	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
	
}
