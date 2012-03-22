package br.com.srnimbus.amadorpro.dao;

import br.com.srnimbus.amadorpro.dominio.PlanoPagamento;

public interface IPlanoPagamentoDAO {

	public void insert(PlanoPagamento planoPagamento);

	public void update(PlanoPagamento planoPagamento);
	
	public void delete(PlanoPagamento planoPagamento);
}
