package br.com.srnimbus.business.impl;

import br.com.srnimbus.business.ILoginDelegate;
import br.com.srnimbus.controller.LoginBean;
import br.com.srnimbus.dao.ILoginDAO;
import br.com.srnimbus.dao.impl.LoginDAOImpl;
import br.com.srnimbus.dominio.Login;
import br.com.srnimbus.exception.AmadorProException;

public class LoginDelegateImpl implements ILoginDelegate {

	public boolean isSenhaValida(LoginBean loginBean) throws AmadorProException {

		boolean retorno = true;
		ILoginDAO loginDAO = new LoginDAOImpl();
		// copia dos objetos

		Login loginDominio = new Login();

		loginDominio.setLogin(loginBean.getLogin());
		// loginDominio.setSenha(loginBean.getSenha());

		String hashSenha = loginDAO.getHashSenha(loginDominio);

		if (!loginDominio.getSenha().equals(hashSenha)) {
			throw new AmadorProException("Fudeu");
		}

		return retorno;

		// loginDAO.update(login);
	}
}
