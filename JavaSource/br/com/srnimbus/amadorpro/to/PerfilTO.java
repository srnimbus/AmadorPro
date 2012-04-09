package br.com.srnimbus.amadorpro.to;

import java.util.HashSet;
import java.util.Set;

public class PerfilTO {

	private int id;
	private String descricao;
	private String principal;

	private Set<MenuTO> menusTO;

	public Set<MenuTO> getMenusTO() {
		if (menusTO == null) {
			menusTO = new HashSet<MenuTO>();
		}
		return menusTO;
	}

	public void setMenusTO(Set<MenuTO> menusTO) {
		this.menusTO = menusTO;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
