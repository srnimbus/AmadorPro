package br.com.srnimbus.amadorpro.dao.impl;

import br.com.srnimbus.amadorpro.dao.ILogLoginDAO;
import br.com.srnimbus.amadorpro.dominio.LogLogin;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;
import br.com.srnimbus.amadorpro.util.HibernateUtil;

public class LogLoginDAOImpl implements ILogLoginDAO {

	@Override
	public void insert(LogLogin logLogin) throws AmadorProDAOException {
		HibernateUtil.insert(logLogin);
	}

}
