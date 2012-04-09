package br.com.srnimbus.amadorpro.to;


public class SubMenuTO extends AbstractTO {

	private String link;
	private String nome;
	private int idMenuPai;
	private boolean ativo;

	public int getIdMenuPai() {
		return idMenuPai;
	}

	public void setIdMenuPai(int idMenuPai) {
		this.idMenuPai = idMenuPai;
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
