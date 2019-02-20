package br.com.fm.MB;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fm.TX.Transacional;
import br.com.fm.facade.CampeonatoFacade;
import br.com.fm.model.Campeonato;
import br.com.fm.util.RedirectView;

@Named // anotação do CDI, antes era a anotação do JSF
@ViewScoped // Essa anotação tem o mesmo nome, mas é de outro pacote: javax.faces.view.ViewScoped
public class CampeonatoMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Campeonato campeonato = new Campeonato();
	
	private Integer campeonatoId;
	
	@Inject
	private FacesContext context;
		
	@Inject
	private CampeonatoFacade campeonatoFacade;
	
	public CampeonatoMB() {

	}
	
	public Campeonato getCampeonato() {
		return campeonato;
	}


	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}


	public Integer getCampeonatoId() {
		return campeonatoId;
	}


	public void setCampeonatoId(Integer campeonatoId) {
		this.campeonatoId = campeonatoId;
	}


	@Transacional
	public RedirectView gravar(){
		System.out.println("Gravando campeonato: " + this.campeonato.getNome());
		if (this.campeonato.getId() == null) {
			campeonatoFacade.save(this.campeonato);
		} else {
			campeonatoFacade.update(this.campeonato);
		}
		this.campeonato = new Campeonato();
		return new RedirectView("campeonato");
	}
	
	public List<Campeonato> getCampeonatos() {
		return campeonatoFacade.selectAll();
	}

	@Transacional
	public void delete(Campeonato campeonato) {
		System.out.println("Removendo campeonato: " + campeonato.getNome());
		campeonatoFacade.delete(campeonato);
	}

	public void select(Campeonato campeonato) {
		System.out.println("Carregando campeonato: " + campeonato.getNome());
		this.campeonato = campeonato;
	}

	public void selectById() {
		this.campeonato = campeonatoFacade.selectById(campeonatoId);
		if (this.campeonato == null) {
			this.campeonato = new Campeonato();
		}
	}
		
}
