package br.com.srnimbus.dao.impl;

import br.com.srnimbus.dao.IPerfilDAO;
import br.com.srnimbus.dominio.Perfil;
import br.com.srnimbus.util.HibernateUtil;

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
