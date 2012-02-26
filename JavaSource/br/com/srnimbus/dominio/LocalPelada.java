package br.com.srnimbus.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ID_LOCAL_PELADA")
@SequenceGenerator(name = "TB_LOCAL_PELADA_ID_LOCAL_PELADA_seq", sequenceName = "TB_LOCAL_PELADA_ID_LOCAL_PELADA_seq", allocationSize = 1)
public class LocalPelada {

	//"TB_LOCAL_PELADA","ID_LOCAL_PELADA"
	//"TB_LOCAL_PELADA","DESC_LOCAL"
	//"TB_LOCAL_PELADA","ENDERECO"
	//"TB_LOCAL_PELADA","EMAIL"
	//"TB_LOCAL_PELADA","TELEFONE"

	private int id;
	private String local;
	private String endereco;
	private String email;
	private String telefone;
	
	@Id
	@Column(name = "ID_LOCAL_PELADA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_LOCAL_PELADA_ID_LOCAL_PELADA_seq")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "DESC_LOCAL")
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	@Column(name = "ENDERECO")	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	@Column(name = "EMAIL")	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "TELEFONE")	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

}
