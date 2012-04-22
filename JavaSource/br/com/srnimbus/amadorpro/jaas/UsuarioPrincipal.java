package br.com.srnimbus.amadorpro.jaas;

import java.security.Principal;

import br.com.srnimbus.amadorpro.to.LoginTO;
import br.com.srnimbus.amadorpro.to.PerfilTO;

public class UsuarioPrincipal implements Principal {

	private String name;
	private int id;
	private LoginTO loginTO;
	private PerfilTO perfilTO;
	
	public UsuarioPrincipal(LoginTO loginTO) {
		if (loginTO == null) {
			throw new NullPointerException("Sem dados para montar o principals.");
		}
		this.id = loginTO.getId();
		this.name = loginTO.getLogin();
	}

	public int getId() {
		return id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof AdministradorPrincipal)) {
			return false;
		}
		AdministradorPrincipal other = (AdministradorPrincipal) obj;
		return getName().equals(other.getName());
	}

	public int hashCode() {
		return getName().hashCode();
	}

	public LoginTO getLoginTO() {
		return loginTO;
	}

	public void setLoginTO(LoginTO loginTO) {
		this.loginTO = loginTO;
	}

	public PerfilTO getPerfilTO() {
		return perfilTO;
	}

	public void setPerfilTO(PerfilTO perfilTO) {
		this.perfilTO = perfilTO;
	}


}
