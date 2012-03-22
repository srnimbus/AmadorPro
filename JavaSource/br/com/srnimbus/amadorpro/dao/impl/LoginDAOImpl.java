package br.com.srnimbus.amadorpro.dao.impl;

import br.com.srnimbus.amadorpro.dao.ILoginDAO;
import br.com.srnimbus.amadorpro.dominio.Login;
import br.com.srnimbus.amadorpro.util.HibernateUtil;

public class LoginDAOImpl implements ILoginDAO {

	@Override
	public void insert(Login login) {
		HibernateUtil.insert(login);

	}

	@Override
	public void update(Login login) {
		HibernateUtil.update(login);

	}

	@Override
	public void delete(Login login) {
		HibernateUtil.delete(login);

	}

	public String getHashSenha(Login login) {

		// ajustar no banco para o login ser chave composta
		// Login retorno = (Login) HibernateUtil.load(Login.class,
		// login.getLogin());

		return "";

	}

}
