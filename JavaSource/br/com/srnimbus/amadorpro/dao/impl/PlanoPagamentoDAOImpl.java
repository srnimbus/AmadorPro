package br.com.srnimbus.amadorpro.dao.impl;

import br.com.srnimbus.amadorpro.dao.IPlanoPagamentoDAO;
import br.com.srnimbus.amadorpro.dominio.PlanoPagamento;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;
import br.com.srnimbus.amadorpro.util.HibernateUtil;

public class PlanoPagamentoDAOImpl implements IPlanoPagamentoDAO {

	@Override
	public void insert(PlanoPagamento planoPagamento) throws AmadorProDAOException {
		HibernateUtil.insert(planoPagamento);

	}

	@Override
	public void update(PlanoPagamento planoPagamento) throws AmadorProDAOException {
		HibernateUtil.update(planoPagamento);

	}

	@Override
	public void delete(PlanoPagamento planoPagamento) throws AmadorProDAOException {
		HibernateUtil.delete(planoPagamento);

	}

	@Override
	public PlanoPagamento read(PlanoPagamento planoPagamento) throws AmadorProDAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlanoPagamento findAll(PlanoPagamento planoPagamento) throws AmadorProDAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
