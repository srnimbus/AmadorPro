package br.com.srnimbus.amadorpro.dao.impl;

import br.com.srnimbus.amadorpro.dao.IPerfilDAO;
import br.com.srnimbus.amadorpro.dominio.Perfil;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;
import br.com.srnimbus.amadorpro.util.HibernateUtil;

public class PerfilDAOImpl implements IPerfilDAO {

	@Override
	public void insert(Perfil perfil) throws AmadorProDAOException {
		HibernateUtil.insert(perfil);

	}

	@Override
	public void update(Perfil perfil) throws AmadorProDAOException {
		HibernateUtil.update(perfil);

	}

	@Override
	public void delete(Perfil perfil) throws AmadorProDAOException {
		HibernateUtil.delete(perfil);

	}

	@Override
	public Perfil read(Perfil perfil) throws AmadorProDAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Perfil findAll(Perfil perfil) throws AmadorProDAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
