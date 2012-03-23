package br.com.srnimbus.amadorpro.business;

import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.to.UsuarioTO;

public interface IUsuarioDelegate {

	public boolean insert(UsuarioTO to) throws AmadorProBusinessException;

	public UsuarioTO update(UsuarioTO to) throws AmadorProBusinessException;

	public boolean delete(UsuarioTO to) throws AmadorProBusinessException;

	public UsuarioTO read(UsuarioTO to) throws AmadorProBusinessException;

	public UsuarioTO findAll(UsuarioTO to) throws AmadorProBusinessException;	
	
}
