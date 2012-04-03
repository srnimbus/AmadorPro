package br.com.srnimbus.amadorpro.business.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import br.com.srnimbus.amadorpro.business.ILoginDelegate;
import br.com.srnimbus.amadorpro.dao.ILoginDAO;
import br.com.srnimbus.amadorpro.dao.impl.LoginDAOImpl;
import br.com.srnimbus.amadorpro.dominio.Login;
import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.exception.AmadorProException;
import br.com.srnimbus.amadorpro.to.LoginTO;

public class LoginDelegateImpl implements ILoginDelegate {

	public boolean isSenhaValida(LoginTO to) throws AmadorProException {

		ILoginDAO loginDAO = new LoginDAOImpl();
		Login model = new Login();
		// copia dos objetos
		try {
			BeanUtils.copyProperties(model, to);
			String hashSenha = loginDAO.getHashSenha(model);
			return hashSenha.equals(to.getSenha());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return false;
		
	}

	@Override
	public boolean insert(LoginTO to) throws AmadorProBusinessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LoginTO update(LoginTO to) throws AmadorProBusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(LoginTO to) throws AmadorProBusinessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LoginTO read(LoginTO to) throws AmadorProBusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoginTO findAll(LoginTO to) throws AmadorProBusinessException {
		// TODO Auto-generated method stub
		return null;
	}
}
