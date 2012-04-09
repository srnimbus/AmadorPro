package br.com.srnimbus.amadorpro.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_SUBMENU")
@SequenceGenerator(name = "TB_MENU_ID_MENU_seq", sequenceName = "TB_MENU_ID_MENU_seq", allocationSize = 1)
public class SubMenu {

	// TB_SUBMENU.ID_MENU
	// TB_SUBMENU.LINK
	// TB_SUBMENU.ATIVO
	// TB_SUBMENU.ID_SUBMENU
	// TB_SUBMENU.DESC_SUBMENU

	private int id;
	private String link;
	private String nome;
	private int idMenuPai;
	private boolean ativo;

	@Id
	@Column(name = "ID_SUBMENU")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_MENU_ID_MENU_seq")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "LINK")
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name = "DESC_SUBMENU")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "ATIVO")
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Column(name = "ID_MENU")
	public int getIdMenuPai() {
		return idMenuPai;
	}

	public void setIdMenuPai(int idMenuPai) {
		this.idMenuPai = idMenuPai;
	}

}
