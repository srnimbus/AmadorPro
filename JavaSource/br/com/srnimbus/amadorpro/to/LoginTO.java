package br.com.srnimbus.amadorpro.to;

import java.util.List;

public class LoginTO {

	private int id;
	private UsuarioTO usuarioTO; // MUDAR PARA O TO
	private String login;
	private String senha;
	private List<PerfilTO> perfisTO;

	public List<PerfilTO> getPerfisTO() {
		return perfisTO;
	}

	public void setPerfisTO(List<PerfilTO> perfisTO) {
		this.perfisTO = perfisTO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UsuarioTO getUsuarioTO() {
		return usuarioTO;
	}

	public void setUsuarioTO(UsuarioTO usuarioTO) {
		this.usuarioTO = usuarioTO;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
