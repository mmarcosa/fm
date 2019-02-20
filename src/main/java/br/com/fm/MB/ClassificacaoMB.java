package br.com.fm.MB;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fm.TX.Transacional;
import br.com.fm.facade.CampeonatoFacade;
import br.com.fm.facade.ClassificacaoFacade;
import br.com.fm.facade.TimeFacade;
import br.com.fm.model.Campeonato;
import br.com.fm.model.Classificacao;
import br.com.fm.model.Time;
import br.com.fm.util.RedirectView;

@Named // anotação do CDI, antes era a anotação do JSF
@ViewScoped // Essa anotação tem o mesmo nome, mas é de outro pacote: javax.faces.view.ViewScoped
public class ClassificacaoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Classificacao classificacao = new Classificacao();
	private Integer classificacaoId;
	@Inject	private FacesContext context;
	@Inject	private ClassificacaoFacade classificacaoFacade;
	@Inject private CampeonatoFacade campeonatoFacade;
	@Inject private TimeFacade timeFacade;
	private List<Classificacao> classificacaoCampeonato;
	private List<Campeonato> campeonatos;
	private List<Time> times;
	
	@PostConstruct
	public void init() {
		criaCampeonatos();
		criaTimes();
	}
	
	public ClassificacaoMB() {

	}
	
	public Classificacao getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}

	public Integer getClassificacaoId() {
		return classificacaoId;
	}

	public void setClassificacaoId(Integer classificacaoId) {
		this.classificacaoId = classificacaoId;
	}

	public List<Classificacao> getClassificacaoCampeonato() {
		return classificacaoCampeonato;
	}

	public void setClassificacaoCampeonato(List<Classificacao> classificacaoCampeonato) {
		this.classificacaoCampeonato = classificacaoCampeonato;
	}

	public List<Campeonato> getCampeonatos() {
		return campeonatos;
	}

	public void setCampeonatos(List<Campeonato> campeonatos) {
		this.campeonatos = campeonatos;
	}

	@Transacional
	public RedirectView gravar(){
		System.out.println("Gravando classificacao: " + this.classificacao.getIdTime());
		if (this.classificacao.getId() == null) {
			classificacaoFacade.save(this.classificacao);
		} else {
			classificacaoFacade.update(this.classificacao);
		}
		this.classificacao = new Classificacao();
		return new RedirectView("classificacao");
	}
	
	public List<Classificacao> getClassificacoes() {
		return classificacaoFacade.selectAll();
	}

	@Transacional
	public void delete(Classificacao classificacao) {
		System.out.println("Removendo classificacao: " + classificacao.getIdCampeonato());
		classificacaoFacade.delete(classificacao);
	}

	public void select(Classificacao classificacao) {
		System.out.println("Carregando classificacao: " + classificacao.getIdCampeonato());
		this.classificacao = classificacao;
	}

	public void selectById() {
		this.classificacao = classificacaoFacade.selectById(classificacaoId);
		if (this.classificacao == null) {
			this.classificacao = new Classificacao();
		}
	}
	
	public void getClassificacao(String codigoCampeonato) {
		classificacaoCampeonato = classificacaoFacade.byCodCampeonato(codigoCampeonato);
	}
	
	private void criaCampeonatos() {
		campeonatos = campeonatoFacade.selectAll();
	}
	
	private void criaTimes() {
		times = timeFacade.selectAll();
	}	
	
	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}
	
}
