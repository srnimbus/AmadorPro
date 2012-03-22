package br.com.srnimbus.amadorpro.dao.impl;

import br.com.srnimbus.amadorpro.dao.IPlanoPagamentoDAO;
import br.com.srnimbus.amadorpro.dominio.PlanoPagamento;
import br.com.srnimbus.amadorpro.util.HibernateUtil;

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
