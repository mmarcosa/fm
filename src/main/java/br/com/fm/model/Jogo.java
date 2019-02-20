package br.com.fm.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "jogos")
public class Jogo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
	private Integer id;
	
	@Column(name = "id_time")
	private Integer idTime;
	
	@Column(name = "times")
	private String times;
	
	@Column(name = "data")
	private Calendar data = Calendar.getInstance();
	
	@Column(name = "placar")
	private String placar;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "escudos")
	private String escudos;
	
	@Column(name = "resultado")
	private String resultado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdTime() {
		return idTime;
	}

	public void setIdTime(Integer idTime) {
		this.idTime = idTime;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getPlacar() {
		return placar;
	}

	public void setPlacar(String placar) {
		this.placar = placar;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEscudos() {
		return escudos;
	}

	public void setEscudos(String escudos) {
		this.escudos = escudos;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	public String getResultadoString() {
		String resultado = this.getResultado();
		String aux = "";
		if(resultado == "E") {
			aux = "Empate";
		}
		else if(resultado == "V") {
			aux = "Vitória";
		}
		else if(resultado =="") {
			aux = "";
		}
		else if(resultado =="D"){
			aux = "Derrota";
		}
		
		return aux;
	}
}
