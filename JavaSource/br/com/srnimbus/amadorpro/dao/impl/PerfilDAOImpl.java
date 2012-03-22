package br.com.srnimbus.amadorpro.dao.impl;

import br.com.srnimbus.amadorpro.dao.IPerfilDAO;
import br.com.srnimbus.amadorpro.dominio.Perfil;
import br.com.srnimbus.amadorpro.util.HibernateUtil;

public class PerfilDAOImpl implements IPerfilDAO {

	@Override
	public void insert(Perfil perfil) {
		HibernateUtil.insert(perfil);

	}

	@Override
	public void update(Perfil perfil) {
		HibernateUtil.update(perfil);

	}

	@Override
	public void delete(Perfil perfil) {
		HibernateUtil.delete(perfil);

	}

}
