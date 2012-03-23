package br.com.srnimbus.amadorpro.dao.impl;

import br.com.srnimbus.amadorpro.dao.ITelefoneDAO;
import br.com.srnimbus.amadorpro.dominio.Telefone;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;
import br.com.srnimbus.amadorpro.util.HibernateUtil;

public class TelefoneDAOImpl implements ITelefoneDAO {

	@Override
	public void insert(Telefone telefone) throws AmadorProDAOException {
		HibernateUtil.insert(telefone);

	}

	@Override
	public void update(Telefone telefone) throws AmadorProDAOException {
		HibernateUtil.update(telefone);

	}

	@Override
	public void delete(Telefone telefone) throws AmadorProDAOException {
		HibernateUtil.delete(telefone);

	}

	@Override
	public Telefone read(Telefone telefone) throws AmadorProDAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Telefone findAll(Telefone telefone) throws AmadorProDAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
