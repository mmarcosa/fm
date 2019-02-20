package br.com.fm.MB;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fm.facade.TimeFacade;
import br.com.fm.model.Time;
import br.com.fm.TX.Transacional;
import br.com.fm.util.RedirectView;

@Named // anotação do CDI, antes era a anotação do JSF
@ViewScoped // Essa anotação tem o mesmo nome, mas é de outro pacote: javax.faces.view.ViewScoped
public class TimeMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Time time = new Time();

	private Integer timeId;
	
	@Inject
	private FacesContext context;
		
	@Inject
	private TimeFacade timeFacade;
	
	public TimeMB() {

	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Integer getTimeId() {
		return timeId;
	}

	public void setTimeId(Integer timeId) {
		this.timeId = timeId;
	}

	@Transacional
	public RedirectView gravar(){
		System.out.println("Gravando time: " + this.time.getNome());
		if (this.time.getId() == null) {
			timeFacade.save(this.time);
		} else {
			timeFacade.update(this.time);
		}
		this.time = new Time();
		return new RedirectView("time");
	}
	
	public List<Time> getTimes() {
		return timeFacade.selectAll();
	}

	@Transacional
	public void delete(Time time) {
		System.out.println("Removendo time: " + time.getNome());
		timeFacade.delete(time);
	}

	public void select(Time time) {
		System.out.println("Carregando time: " + time.getNome());
		this.time = time;
	}

	public void selectById() {
		this.time = timeFacade.selectById(timeId);
		if (this.time == null) {
			this.time = new Time();
		}
	}
	
}
