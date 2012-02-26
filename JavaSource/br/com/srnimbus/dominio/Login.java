package br.com.srnimbus.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LOGIN")
@SequenceGenerator(name = "TB_LOGIN_ID_LOGIN_seq", sequenceName = "TB_LOGIN_ID_LOGIN_seq", allocationSize = 1)
public class Login {

	// "TB_LOGIN","ID_LOGIN"
	// "TB_LOGIN","ID_USUARIO"
	// "TB_LOGIN","USUARIO"
	// "TB_LOGIN","SENHA"

	private int id;
	private Usuario usuario;
	private String login;
	private String senha;

	@Id
	@Column(name = "ID_LOGIN")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_LOGIN_ID_LOGIN_seq")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// @Column(name = "ID_USUARIO")
	@JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO", insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
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
