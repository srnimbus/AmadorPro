package br.com.srnimbus.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LOGIN")
public class LoginDAO {

	//"TB_LOGIN","ID_LOGIN"								
	//"TB_LOGIN","ID_USUARIO"								
	//"TB_LOGIN","USUARIO"								
	//"TB_LOGIN","SENHA"								
						
	private int id;
	private UsuarioDAO usuario;
	private String login;
	private String senha;
	
	@Id
	@GeneratedValue
	@Column(name = "ID_LOGIN")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "ID_USUARIO")
	public UsuarioDAO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDAO usuario) {
		this.usuario = usuario;
	}
	
	@Column(name = "USUARIO")
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	@Column(name = "SENHA")
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	
}
