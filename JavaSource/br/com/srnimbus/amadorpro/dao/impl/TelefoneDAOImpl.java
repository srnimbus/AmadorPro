package br.com.srnimbus.amadorpro.dao.impl;

import br.com.srnimbus.amadorpro.dao.ITelefoneDAO;
import br.com.srnimbus.amadorpro.dominio.Telefone;
import br.com.srnimbus.amadorpro.util.HibernateUtil;

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
