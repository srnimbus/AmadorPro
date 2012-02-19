package br.com.srnimbus.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TELEFONE")
public class TelefoneDAO {

	//"TB_TELEFONE","ID_TELEFONE"								
	//"TB_TELEFONE","PRINCIPAL"								
	//"TB_TELEFONE","DESC_TELEFONE"		
	
	private int id;
	private boolean principal;
	private String telefone;

	@Id
	@GeneratedValue
	@Column(name = "ID_ENDERECO")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "PRINCIPAL")
	public boolean isPrincipal() {
		return principal;
	}
	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}
	
	@Column(name = "DESC_TELEFONE")
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
