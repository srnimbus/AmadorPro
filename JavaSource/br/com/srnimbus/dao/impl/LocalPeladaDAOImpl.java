package br.com.srnimbus.dao.impl;

import br.com.srnimbus.dao.ILocalPeladaDAO;
import br.com.srnimbus.dominio.LocalPelada;
import br.com.srnimbus.util.HibernateUtil;

public class LocalPeladaDAOImpl implements ILocalPeladaDAO {

	@Override
	public void insert(LocalPelada localPelada) {
		HibernateUtil.insert(localPelada);

	}

	@Override
	public void update(LocalPelada localPelada) {
		HibernateUtil.update(localPelada);

	}

	@Override
	public void delete(LocalPelada localPelada) {
		HibernateUtil.delete(localPelada);

	}

}
