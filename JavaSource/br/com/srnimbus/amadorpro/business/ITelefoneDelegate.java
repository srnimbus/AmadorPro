package br.com.srnimbus.amadorpro.business;

import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.to.TelefoneTO;

public interface ITelefoneDelegate {

	public boolean insert(TelefoneTO to) throws AmadorProBusinessException;

	public TelefoneTO update(TelefoneTO to) throws AmadorProBusinessException;

	public boolean delete(TelefoneTO to) throws AmadorProBusinessException;

	public TelefoneTO read(TelefoneTO to) throws AmadorProBusinessException;

	public TelefoneTO findAll(TelefoneTO to) throws AmadorProBusinessException;	
	
}
