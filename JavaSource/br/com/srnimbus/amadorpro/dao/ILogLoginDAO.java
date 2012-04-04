package br.com.srnimbus.amadorpro.dao;

import br.com.srnimbus.amadorpro.dominio.LogLogin;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;

public interface ILogLoginDAO {

	public void insert(LogLogin logLogin) throws AmadorProDAOException;

}
