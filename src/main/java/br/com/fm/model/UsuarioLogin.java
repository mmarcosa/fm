package br.com.fm.model;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "usuariologin")
public class UsuarioLogin implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    private Integer id;
    private String email;
    private String senha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
