package br.com.srnimbus.amadorpro.to;


public class UsuarioTO {

	private int id;
	private PlanoPagamentoTO planoPagamentoTO; //MUDAR PARA O TO
	private String nome;
	private String cpf;
	private String apelido;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PlanoPagamentoTO getPlanoPagamentoTO() {
		return planoPagamentoTO;
	}

	public void setPlanoPagamentoTO(PlanoPagamentoTO planoPagamentoTO) {
		this.planoPagamentoTO = planoPagamentoTO;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
