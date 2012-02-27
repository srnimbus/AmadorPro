package br.com.srnimbus.dao.impl;

import br.com.srnimbus.dao.IPlanoPagamentoDAO;
import br.com.srnimbus.dominio.PlanoPagamento;
import br.com.srnimbus.util.HibernateUtil;

public class PlanoPagamentoDAOImpl implements IPlanoPagamentoDAO {

	@Override
	public void insert(PlanoPagamento planoPagamento) {
		HibernateUtil.insert(planoPagamento);

	}

	@Override
	public void update(PlanoPagamento planoPagamento) {
		HibernateUtil.update(planoPagamento);

	}

	@Override
	public void delete(PlanoPagamento planoPagamento) {
		HibernateUtil.delete(planoPagamento);

	}

}
