package br.com.srnimbus.amadorpro.dao.impl;

import br.com.srnimbus.amadorpro.dao.ILocalPeladaDAO;
import br.com.srnimbus.amadorpro.dominio.LocalPelada;
import br.com.srnimbus.amadorpro.util.HibernateUtil;

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
