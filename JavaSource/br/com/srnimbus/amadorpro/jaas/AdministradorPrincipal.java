package br.com.srnimbus.amadorpro.jaas;

import java.security.Principal;

import br.com.srnimbus.amadorpro.to.LoginTO;

public class AdministradorPrincipal implements Principal {

	private String name;
	private int id;
	
	public AdministradorPrincipal(int id, String name) {
		if (name == null || name.length() == 0) {
			throw new NullPointerException("User group name may not be empty.");
		}
		this.name = name;
	}

	public AdministradorPrincipal(LoginTO loginTO) {
		if (name == null || name.length() == 0) {
			throw new NullPointerException("User group name may not be empty.");
		}
		this.name = name;
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

}
