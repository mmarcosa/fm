package br.com.fm.MB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fm.facade.JogoFacade;
import br.com.fm.facade.TimeFacade;
import br.com.fm.model.Jogo;
import br.com.fm.model.Time;
import br.com.fm.TX.Transacional;
import br.com.fm.enumeracao.TipoResultadoEnum;
import br.com.fm.util.RedirectView;

@Named // anotação do CDI, antes era a anotação do JSF
@ViewScoped // Essa anotação tem o mesmo nome, mas é de outro pacote: javax.faces.view.ViewScoped
public class JogoMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Jogo jogo = new Jogo();	
	private Integer jogoId;	
	private Integer timeId;	
	@Inject	private FacesContext context;
	@Inject private JogoFacade jogoFacade;
	@Inject private TimeFacade timeFacade;
	private List<SelectItem> descricoesTipoResultado;
	private List<Time> times;
	
	@PostConstruct
	public void init() {
		criaTiposResultado();
		criaTimes();
	}
		
	public JogoMB() {

	}
	
	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Integer getJogoId() {
		return jogoId;
	}

	public void setJogoId(Integer jogoId) {
		this.jogoId = jogoId;
	}

	@Transacional
	public RedirectView gravar(){
		System.out.println("Gravando jogo: " + this.jogo.getEscudos());
		if (this.jogo.getId() == null) {
			jogoFacade.save(this.jogo);
		} else {
			jogoFacade.update(this.jogo);
		}
		this.jogo = new Jogo();
		return new RedirectView("jogo");
	}
	
	public List<Jogo> getJogos() {
		return jogoFacade.selectAll();
	}

	@Transacional
	public void delete(Jogo jogo) {
		System.out.println("Removendo jogo: " + jogo.getEscudos());
		jogoFacade.delete(jogo);
	}

	public void select(Jogo jogo) {
		System.out.println("Carregando jogo: " + jogo.getEscudos());
		this.jogo = jogo;
	}

	public void selectById() {
		this.jogo = jogoFacade.selectById(jogoId);
		if (this.jogo == null) {
			this.jogo = new Jogo();
		}
	}
	
	public Integer getTimeId() {
		return timeId;
	}

	public void setTimeId(Integer timeId) {
		this.timeId = timeId;
	}

	public List<SelectItem> getDescricoesTipoResultado() {
		return descricoesTipoResultado;
	}

	public void setDescricoesTipoResultado(List<SelectItem> descricoesTipoResultado) {
		this.descricoesTipoResultado = descricoesTipoResultado;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	private void criaTiposResultado(){
		TipoResultadoEnum[] tipoResultados = TipoResultadoEnum.values();
		descricoesTipoResultado = new ArrayList<>(tipoResultados.length);
		for(TipoResultadoEnum tre : tipoResultados) {
			descricoesTipoResultado.add(new SelectItem(tre.getCodigo(), tre.getDescricao()));
		}
		
	}
	
	private void criaTimes() {
		times = timeFacade.selectAll();
	}
	
	public String getTipoResultado(String codigo) {
		return TipoResultadoEnum.busca(codigo).getDescricao();
	}
	
	
}
