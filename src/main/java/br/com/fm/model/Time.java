package br.com.fm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "times")
public class Time implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "alias")
	private String alias;
	
	@Column(name = "mural_ativado")
	private Integer muralAtivado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public Integer getMuralAtivado() {
		return muralAtivado;
	}

	public void setMuralAtivado(Integer muralAtivado) {
		this.muralAtivado = muralAtivado;
	}

	public String getMuralAtivadoString() {
		String muralAtivadoString = "";
		
		if (muralAtivado == null) {
			muralAtivadoString = "";
		}
		else if(muralAtivado == 0){
			muralAtivadoString = "Inativado";
		}
		else if(muralAtivado == 1){
			muralAtivadoString = "Ativado";
		}
		return muralAtivadoString;
	}
	
}
