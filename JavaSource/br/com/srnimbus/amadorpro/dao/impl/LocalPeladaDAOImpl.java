package br.com.srnimbus.amadorpro.dao.impl;

import br.com.srnimbus.amadorpro.dao.ILocalPeladaDAO;
import br.com.srnimbus.amadorpro.dominio.LocalPelada;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;
import br.com.srnimbus.amadorpro.util.HibernateUtil;

public class LocalPeladaDAOImpl implements ILocalPeladaDAO {

	@Override
	public void insert(LocalPelada localPelada) throws AmadorProDAOException {
		HibernateUtil.insert(localPelada);

	}

	@Override
	public void update(LocalPelada localPelada) throws AmadorProDAOException {
		HibernateUtil.update(localPelada);

	}

	@Override
	public void delete(LocalPelada localPelada) throws AmadorProDAOException {
		HibernateUtil.delete(localPelada);

	}

	@Override
	public LocalPelada read(LocalPelada localPelada) throws AmadorProDAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalPelada findAll(LocalPelada localPelada) throws AmadorProDAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
