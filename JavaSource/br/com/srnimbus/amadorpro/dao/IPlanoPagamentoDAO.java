package br.com.srnimbus.amadorpro.dao;

import br.com.srnimbus.amadorpro.dominio.PlanoPagamento;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;

public interface IPlanoPagamentoDAO {

	public void insert(PlanoPagamento planoPagamento) throws AmadorProDAOException;

	public void update(PlanoPagamento planoPagamento) throws AmadorProDAOException;

	public void delete(PlanoPagamento planoPagamento) throws AmadorProDAOException;

	public PlanoPagamento read(PlanoPagamento planoPagamento) throws AmadorProDAOException;

	public PlanoPagamento findAll(PlanoPagamento planoPagamento) throws AmadorProDAOException;
}
