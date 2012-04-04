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
import br.com.srnimbus.amadorpro.to.PlanoPagamentoTO;
import br.com.srnimbus.amadorpro.to.UsuarioTO;

public class LoginDelegateImpl implements ILoginDelegate {

	private LoginTO loginTO;

	public boolean isSenhaValida(LoginTO to) throws AmadorProException {

		ILoginDAO loginDAO = new LoginDAOImpl();
		Login model = new Login();
		// copia dos objetos
		try {
			BeanUtils.copyProperties(model, to);
			Login login = loginDAO.getLogin(model);
			if (login != null)
				setLoginTO(login);
			return login.getSenha().equals(to.getSenha());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return false;

	}

	private void setLoginTO(Login login) {
		loginTO = new LoginTO();
		UsuarioTO usuarioTO = new UsuarioTO();
		PlanoPagamentoTO planoPagamentoTO = new PlanoPagamentoTO();
		try {
			BeanUtils.copyProperties(loginTO, login);
			BeanUtils.copyProperties(usuarioTO, login.getUsuario());
			BeanUtils.copyProperties(planoPagamentoTO, login.getUsuario().getPlanoPagamento());
			usuarioTO.setPlanoPagamentoTO(planoPagamentoTO);
			loginTO.setUsuarioTO(usuarioTO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public LoginTO getLoginTO() {
		return this.loginTO;
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
