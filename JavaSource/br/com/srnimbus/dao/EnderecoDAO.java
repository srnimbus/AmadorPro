package br.com.srnimbus.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ENDERECO")
@SequenceGenerator(name = "TB_ENDERECO_ID_ENDERECO_seq", sequenceName = "TB_ENDERECO_ID_ENDERECO_seq", allocationSize = 1)
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
	@Column(name = "ID_ENDERECO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_ENDERECO_ID_ENDERECO_seq")
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
