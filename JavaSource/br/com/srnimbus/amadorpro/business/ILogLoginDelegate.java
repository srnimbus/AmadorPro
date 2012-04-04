package br.com.srnimbus.amadorpro.business;

import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.to.LogLoginTO;

public interface ILogLoginDelegate {

	public boolean insert(LogLoginTO to) throws AmadorProBusinessException;

}
