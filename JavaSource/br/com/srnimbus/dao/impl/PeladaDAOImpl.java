package br.com.srnimbus.dao.impl;

import br.com.srnimbus.dao.IPeladaDAO;
import br.com.srnimbus.dominio.Pelada;
import br.com.srnimbus.util.HibernateUtil;

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
