package br.com.srnimbus.dao.impl;

import br.com.srnimbus.dao.ITelefoneDAO;
import br.com.srnimbus.dominio.Telefone;
import br.com.srnimbus.util.HibernateUtil;

public class TelefoneDAOImpl implements ITelefoneDAO {

	@Override
	public void insert(Telefone telefone) {
		HibernateUtil.insert(telefone);

	}

	@Override
	public void update(Telefone telefone) {
		HibernateUtil.update(telefone);

	}

	@Override
	public void delete(Telefone telefone) {
		HibernateUtil.delete(telefone);

	}

}
