package br.com.srnimbus.dao.impl;

import br.com.srnimbus.dao.ILoginDAO;
import br.com.srnimbus.dominio.Login;
import br.com.srnimbus.util.HibernateUtil;

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

}
