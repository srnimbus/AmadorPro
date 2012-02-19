package br.com.srnimbus.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PERFIL")
public class PerfilDAO {
	
	//"TB_PERFIL","ID_PERFIL"								
	//"TB_PERFIL","DESC_PERFIL"								

	private int id;
	private String descricao;
	
	@Id
	@GeneratedValue
	@Column(name = "ID_PERFIL")
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
	
}
