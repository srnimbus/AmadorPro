package br.com.srnimbus.amadorpro.business;

import java.util.List;

import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.to.TelefoneTO;

public interface ITelefoneDelegate {

	public boolean insert(TelefoneTO to) throws AmadorProBusinessException;

	public TelefoneTO update(TelefoneTO to) throws AmadorProBusinessException;

	public boolean delete(TelefoneTO to) throws AmadorProBusinessException;

	public TelefoneTO read(TelefoneTO to) throws AmadorProBusinessException;

	public List<TelefoneTO> findAll(TelefoneTO to) throws AmadorProBusinessException;	
	
}
