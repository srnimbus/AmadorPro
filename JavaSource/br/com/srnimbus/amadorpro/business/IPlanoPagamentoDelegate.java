package br.com.srnimbus.amadorpro.business;

import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.to.PlanoPagamentoTO;

public interface IPlanoPagamentoDelegate {

	public boolean insert(PlanoPagamentoTO to) throws AmadorProBusinessException;

	public PlanoPagamentoTO update(PlanoPagamentoTO to) throws AmadorProBusinessException;

	public boolean delete(PlanoPagamentoTO to) throws AmadorProBusinessException;

	public PlanoPagamentoTO read(PlanoPagamentoTO to) throws AmadorProBusinessException;

	public PlanoPagamentoTO findAll(PlanoPagamentoTO to) throws AmadorProBusinessException;
	
}
