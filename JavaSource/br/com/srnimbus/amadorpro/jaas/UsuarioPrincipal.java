package br.com.srnimbus.amadorpro.jaas;

import java.security.Principal;

import br.com.srnimbus.amadorpro.to.LoginTO;

public class UsuarioPrincipal implements Principal {

	private String name;
	private int id;
	
	public UsuarioPrincipal(int id, String name) {
		if (name == null || name.length() == 0) {
			throw new NullPointerException("User group name may not be empty.");
		}
		this.name = name;
	}

	public UsuarioPrincipal(LoginTO loginTO) {
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
		if (!(obj instanceof UsuarioPrincipal)) {
			return false;
		}
		UsuarioPrincipal other = (UsuarioPrincipal) obj;
		return getName().equals(other.getName());
	}

	public int hashCode() {
		return getName().hashCode();
	}

}
