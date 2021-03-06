package br.com.srnimbus.amadorpro.business;

import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.exception.AmadorProException;
import br.com.srnimbus.amadorpro.to.LoginTO;

public interface ILoginDelegate {

	public boolean insert(LoginTO to) throws AmadorProBusinessException;

	public LoginTO update(LoginTO to) throws AmadorProBusinessException;

	public boolean delete(LoginTO to) throws AmadorProBusinessException;

	public LoginTO read(LoginTO to) throws AmadorProBusinessException;

	public LoginTO findAll(LoginTO to) throws AmadorProBusinessException;
	
	public boolean isSenhaValida(LoginTO to) throws AmadorProException;
	
	public LoginTO getLoginTO();
	
}
