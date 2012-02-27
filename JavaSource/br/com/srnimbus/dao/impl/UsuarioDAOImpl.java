package br.com.srnimbus.dao.impl;

import br.com.srnimbus.dao.IUsuarioDAO;
import br.com.srnimbus.dominio.Usuario;
import br.com.srnimbus.util.HibernateUtil;

public class UsuarioDAOImpl implements IUsuarioDAO {

	@Override
	public void insert(Usuario usuario) {
		HibernateUtil.insert(usuario);

	}

	@Override
	public void update(Usuario usuario) {
		HibernateUtil.update(usuario);

	}

	@Override
	public void delete(Usuario usuario) {
		HibernateUtil.delete(usuario);

	}

}
