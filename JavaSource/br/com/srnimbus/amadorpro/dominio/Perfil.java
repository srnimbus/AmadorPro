package br.com.srnimbus.amadorpro.dominio;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PERFIL")
@SequenceGenerator(name = "TB_PERFIL_ID_PERFIL_seq", sequenceName = "TB_PERFIL_ID_PERFIL_seq", allocationSize = 1)
public class Perfil {

	// "TB_PERFIL","ID_PERFIL"
	// "TB_PERFIL","DESC_PERFIL"

	private int id;
	private String descricao;
	private Set<Menu> menus;

	@Id
	@Column(name = "ID_PERFIL")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_PERFIL_ID_PERFIL_seq")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "DESC_PERFIL")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@JoinTable(name = "TB_MENU", joinColumns = { @JoinColumn(name = "ID_PERFIL", unique = true) }, inverseJoinColumns = { @JoinColumn(name = "ID_PERFIL") })
	@ManyToMany(fetch = FetchType.EAGER)
	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

}
