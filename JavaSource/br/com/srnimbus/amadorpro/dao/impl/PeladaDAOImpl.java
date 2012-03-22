package br.com.srnimbus.amadorpro.dao.impl;

import br.com.srnimbus.amadorpro.dao.IPeladaDAO;
import br.com.srnimbus.amadorpro.dominio.Pelada;
import br.com.srnimbus.amadorpro.util.HibernateUtil;

public class PeladaDAOImpl implements IPeladaDAO {

	@Override
	public void insert(Pelada pelada) {
		HibernateUtil.insert(pelada);

	}

	@Override
	public void update(Pelada pelada) {
		HibernateUtil.update(pelada);

	}

	@Override
	public void delete(Pelada pelada) {
		HibernateUtil.delete(pelada);

	}

}
