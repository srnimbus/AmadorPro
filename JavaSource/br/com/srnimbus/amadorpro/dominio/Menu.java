package br.com.srnimbus.amadorpro.dominio;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_MENU")
@SequenceGenerator(name = "TB_MENU_ID_MENU_seq", sequenceName = "TB_MENU_ID_MENU_seq", allocationSize = 1)
public class Menu {

	// TB_MENU.ATIVO
	// TB_MENU.ID_MENU_PAI
	// TB_MENU.LINK
	// TB_MENU.ID_PERFIL
	// TB_MENU.ID_MENU
	// TB_MENU.DESC_MENU

	private int id;
	private Set<SubMenu> subMenus;
	private String link;
	private int idPerfil;
	private String nome;
	private boolean ativo;

	@Id
	@Column(name = "ID_MENU")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_MENU_ID_MENU_seq")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JoinColumn(name = "ID_MENU", insertable = false, updatable = false, nullable = true)
	@OneToMany(fetch = FetchType.EAGER)
	public Set<SubMenu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(Set<SubMenu> subMenus) {
		this.subMenus = subMenus;
	}

	@Column(name = "LINK")
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name = "DESC_MENU")
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
	
	@Column(name = "ID_PERFIL")
	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}


	
}
