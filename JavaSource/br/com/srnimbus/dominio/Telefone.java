package br.com.srnimbus.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TELEFONE")
@SequenceGenerator(name = "TB_TELEFONE_ID_TELEFONE_seq", sequenceName = "TB_TELEFONE_ID_TELEFONE_seq", allocationSize = 1)
public class Telefone{

	// "TB_TELEFONE","ID_TELEFONE"
	// "TB_TELEFONE","PRINCIPAL"
	// "TB_TELEFONE","DESC_TELEFONE"

	private int id;
	private boolean principal;
	private String telefone;

	@Id
	@Column(name = "ID_TELEFONE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_TELEFONE_ID_TELEFONE_seq")
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
