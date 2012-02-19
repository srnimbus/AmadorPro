package br.com.srnimbus.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PLANO_PAGAMENTO")
public class PlanoPagamentoDAO {

	//"TB_PLANO_PAGAMENTO","ID_PLANO_PAGAMENTO"								
	//"TB_PLANO_PAGAMENTO","DESC_PLANO"								
	//"TB_PLANO_PAGAMENTO","VALOR_PLANO"								

	private int id;
	private String descricao;
	private double valor;
	
	@Id
	@GeneratedValue
	@Column(name = "ID_PLANO_PAGAMENTO")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "DESC_PLANO")
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Column(name = "VALOR_PLANO")
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
