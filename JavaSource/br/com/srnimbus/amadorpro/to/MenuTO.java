package br.com.srnimbus.amadorpro.to;

import java.util.Set;

public class MenuTO extends AbstractTO {

	private Set<MenuTO> submenusTO;
	private String link;
	private PerfilTO perfilTO;
	private String nome;
	private boolean ativo;

	public PerfilTO getPerfilTO() {
		return perfilTO;
	}

	public void setPerfilTO(PerfilTO perfilTO) {
		this.perfilTO = perfilTO;
	}

	public Set<MenuTO> getSubmenusTO() {
		return submenusTO;
	}

	public void setSubmenusTO(Set<MenuTO> submenusTO) {
		this.submenusTO = submenusTO;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
