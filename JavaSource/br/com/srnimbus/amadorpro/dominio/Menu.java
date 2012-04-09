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
	private Set<Menu> submenus;
	private String link;
	private Perfil perfil;
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

//	@JoinColumn(name = "ID_MENU_1", insertable = true, updatable = true, nullable = true)
//	@OneToMany(fetch = FetchType.EAGER)
	public Set<Menu> getSubmenus() {
		return submenus;
	}

	public void setSubmenus(Set<Menu> submenus) {
		this.submenus = submenus;
	}

	@Column(name = "LINK")
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name = "ID_PERFIL")
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
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

}
