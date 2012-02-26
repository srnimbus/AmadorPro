package br.com.srnimbus.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USUARIO")
@SequenceGenerator(name = "TB_USUARIO_ID_USUARIO_seq", sequenceName = "TB_USUARIO_ID_USUARIO_seq", allocationSize = 1)
public class Usuario {

	// "TB_USUARIO","ID_USUARIO"
	// "TB_USUARIO","ID_PLANO_PAGAMENTO"
	// "TB_USUARIO","NOME"
	// "TB_USUARIO","CPF"
	// "TB_USUARIO","APELIDO"
	// "TB_USUARIO","EMAIL"

	private int id;
	private PlanoPagamento planoPagamento;
	private String nome;
	private String cpf;
	private String apelido;
	private String email;

	@Id
	@Column(name = "ID_USUARIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_USUARIO_ID_USUARIO_seq")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// @Column(name = "ID_PLANO_PAGAMENTO")
	@JoinColumn(name = "ID_PLANO_PAGAMENTO", referencedColumnName = "ID_PLANO_PAGAMENTO", insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	public PlanoPagamento getPlanoPagamento() {
		return planoPagamento;
	}

	public void setPlanoPagamento(PlanoPagamento planoPagamento) {
		this.planoPagamento = planoPagamento;
	}

	@Column(name = "NOME")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "CPF")
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name = "APELIDO")
	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
