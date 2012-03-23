package br.com.srnimbus.amadorpro.business;

import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.to.PerfilTO;

public interface IPerfilDelegate {

	public boolean insert(PerfilTO to) throws AmadorProBusinessException;

	public PerfilTO update(PerfilTO to) throws AmadorProBusinessException;

	public boolean delete(PerfilTO to) throws AmadorProBusinessException;

	public PerfilTO read(PerfilTO to) throws AmadorProBusinessException;

	public PerfilTO findAll(PerfilTO to) throws AmadorProBusinessException;
	
}
