package br.com.srnimbus.amadorpro.jaas;

import java.security.Principal;

public class AmadorProPrincipal implements Principal {

	public AmadorProPrincipal(String name) {
		if (name == null || name.length() == 0) {
			throw new NullPointerException("User group name may not be empty.");
		}
		this.name = name;
	}

	private String name;

	@Override
	public String getName() {
		return this.name;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof AmadorProPrincipal)) {
			return false;
		}
		AmadorProPrincipal other = (AmadorProPrincipal) obj;
		return getName().equals(other.getName());
	}

	public int hashCode() {
		return getName().hashCode();
	}

}
