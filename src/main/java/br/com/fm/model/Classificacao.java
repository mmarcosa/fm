package br.com.fm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "classificacao")
public class Classificacao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
	private Integer id;
	
	@Column(name = "id_time")
	private Integer idTime;
	
	@Column(name = "posicao")
	private Integer posicao;
	
	@Column(name = "jogos")
	private Integer qtdeJogos;
	
	@Column(name = "vitorias")
	private Integer qtdeVitorias;
	
	@Column(name = "saldo_gols")
	private Integer saldoGols;
	
	@Column(name = "pontos")
	private Integer pontos;
	
	@Column(name = "id_campeonato")
	private Integer idCampeonato;
	
	@Column(name = "grupo")
	private Integer grupo;

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

	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	public Integer getQtdeJogos() {
		return qtdeJogos;
	}

	public void setQtdeJogos(Integer qtdeJogos) {
		this.qtdeJogos = qtdeJogos;
	}

	public Integer getQtdeVitorias() {
		return qtdeVitorias;
	}

	public void setQtdeVitorias(Integer qtdeVitorias) {
		this.qtdeVitorias = qtdeVitorias;
	}

	public Integer getSaldoGols() {
		return saldoGols;
	}

	public void setSaldoGols(Integer saldoGols) {
		this.saldoGols = saldoGols;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public Integer getIdCampeonato() {
		return idCampeonato;
	}

	public void setIdCampeonato(Integer idCampeonato) {
		this.idCampeonato = idCampeonato;
	}

	public Integer getGrupo() {
		return grupo;
	}

	public void setGrupo(Integer grupo) {
		this.grupo = grupo;
	}
	
}
