package br.com.srnimbus.amadorpro.to;

import java.util.Set;

public class MenuTO extends AbstractTO {

	private String link;
	private PerfilTO perfilTO;
	private String nome;
	private boolean ativo;
	private Set<SubMenuTO> subMenusTO;

	public PerfilTO getPerfilTO() {
		return perfilTO;
	}

	public void setPerfilTO(PerfilTO perfilTO) {
		this.perfilTO = perfilTO;
	}

	public Set<SubMenuTO> getSubMenusTO() {
		return subMenusTO;
	}

	public void setSubmenusTO(Set<SubMenuTO> subMenusTO) {
		this.subMenusTO = subMenusTO;
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
