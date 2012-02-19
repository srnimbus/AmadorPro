package br.com.srnimbus.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ENDERECO")
public class EnderecoDAO {

	// "TB_ENDERECO","ID_ENDERECO"
	// "TB_ENDERECO","PRINCIPAL"
	// "TB_ENDERECO","DESC_ENDERECO"
	// "TB_ENDERECO","CEP"

	private int id;
	private boolean principal;
	private String endereco;
	private String cep;

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

	@Column(name = "DESC_ENDERECO")
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Column(name = "CEP")
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
