package br.com.srnimbus.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USUARIO")
public class UsuarioDAO {

	//"TB_USUARIO","ID_USUARIO"								
	//"TB_USUARIO","ID_PLANO_PAGAMENTO"								
	//"TB_USUARIO","NOME"								
	//"TB_USUARIO","CPF"								
	//"TB_USUARIO","APELIDO"								
	//"TB_USUARIO","EMAIL"								

	private int id;
	private PlanoPagamentoDAO planoPagamento;
	private String nome;
	private String cpf;
	private String apelido;
	private String email;
	
	@Id
	@GeneratedValue
	@Column(name = "ID_USUARIO")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "ID_PLANO_PAGAMENTO")
	public PlanoPagamentoDAO getPlanoPagamento() {
		return planoPagamento;
	}
	public void setPlanoPagamento(PlanoPagamentoDAO planoPagamento) {
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
