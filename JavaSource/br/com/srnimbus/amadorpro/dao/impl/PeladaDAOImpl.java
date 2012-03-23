package br.com.srnimbus.amadorpro.dao.impl;

import br.com.srnimbus.amadorpro.dao.IPeladaDAO;
import br.com.srnimbus.amadorpro.dominio.Pelada;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;
import br.com.srnimbus.amadorpro.util.HibernateUtil;

public class PeladaDAOImpl implements IPeladaDAO {

	@Override
	public void insert(Pelada pelada) throws AmadorProDAOException {
		HibernateUtil.insert(pelada);

	}

	@Override
	public void update(Pelada pelada) throws AmadorProDAOException {
		HibernateUtil.update(pelada);

	}

	@Override
	public void delete(Pelada pelada) throws AmadorProDAOException {
		HibernateUtil.delete(pelada);

	}

	@Override
	public Pelada read(Pelada pelada) throws AmadorProDAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pelada findAll(Pelada pelada) throws AmadorProDAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
