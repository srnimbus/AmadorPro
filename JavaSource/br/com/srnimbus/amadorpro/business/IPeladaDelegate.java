package br.com.srnimbus.amadorpro.business;

import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.to.PeladaTO;

public interface IPeladaDelegate {

	public boolean insert(PeladaTO to) throws AmadorProBusinessException;

	public PeladaTO update(PeladaTO to) throws AmadorProBusinessException;

	public boolean delete(PeladaTO to) throws AmadorProBusinessException;

	public PeladaTO read(PeladaTO to) throws AmadorProBusinessException;

	public PeladaTO findAll(PeladaTO to) throws AmadorProBusinessException;
	
}
