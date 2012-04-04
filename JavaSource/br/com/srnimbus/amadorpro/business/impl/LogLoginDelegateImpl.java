package br.com.srnimbus.amadorpro.business.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import br.com.srnimbus.amadorpro.business.ILogLoginDelegate;
import br.com.srnimbus.amadorpro.dao.ILogLoginDAO;
import br.com.srnimbus.amadorpro.dao.impl.LogLoginDAOImpl;
import br.com.srnimbus.amadorpro.dominio.LogLogin;
import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;
import br.com.srnimbus.amadorpro.to.LogLoginTO;

public class LogLoginDelegateImpl implements ILogLoginDelegate {

	ILogLoginDAO dao;

	@Override
	public boolean insert(LogLoginTO to) throws AmadorProBusinessException {
		LogLogin modelo = new LogLogin();

		try {
			BeanUtils.copyProperties(modelo, to);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			getDAO().insert(modelo);
		} catch (AmadorProDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public ILogLoginDAO getDAO() {
		if (dao == null) {
			dao = new LogLoginDAOImpl();
		}
		return dao;
	}
}
