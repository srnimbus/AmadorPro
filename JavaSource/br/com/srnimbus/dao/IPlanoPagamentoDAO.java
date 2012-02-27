package br.com.srnimbus.dao;

import br.com.srnimbus.dominio.PlanoPagamento;

public interface IPlanoPagamentoDAO {

	public void insert(PlanoPagamento planoPagamento);

	public void update(PlanoPagamento planoPagamento);
	
	public void delete(PlanoPagamento planoPagamento);
}

