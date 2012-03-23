package br.com.srnimbus.amadorpro.dao.impl;

import br.com.srnimbus.amadorpro.dao.ILoginDAO;
import br.com.srnimbus.amadorpro.dominio.Login;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;
import br.com.srnimbus.amadorpro.util.HibernateUtil;

public class LoginDAOImpl implements ILoginDAO {

	@Override
	public void insert(Login login) throws AmadorProDAOException {
		HibernateUtil.insert(login);

	}

	@Override
	public void update(Login login) throws AmadorProDAOException {
		HibernateUtil.update(login);

	}

	@Override
	public void delete(Login login) throws AmadorProDAOException {
		HibernateUtil.delete(login);

	}

	public String getHashSenha(Login login) throws AmadorProDAOException {

		// ajustar no banco para o login ser chave composta
		// Login retorno = (Login) HibernateUtil.load(Login.class,
		// login.getLogin());

		return "";

	}

}
