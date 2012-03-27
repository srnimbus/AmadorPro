package br.com.srnimbus.amadorpro.business;

import java.util.List;

import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.to.LocalPeladaTO;

public interface ILocalPeladaDelegate {

	public boolean insert(LocalPeladaTO to) throws AmadorProBusinessException;

	public LocalPeladaTO update(LocalPeladaTO to) throws AmadorProBusinessException;

	public boolean delete(LocalPeladaTO to) throws AmadorProBusinessException;

	public LocalPeladaTO read(LocalPeladaTO to) throws AmadorProBusinessException;

	public List<LocalPeladaTO> findAll(LocalPeladaTO to) throws AmadorProBusinessException;

}
