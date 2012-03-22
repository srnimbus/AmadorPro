package br.com.srnimbus.amadorpro.dao.impl;

import br.com.srnimbus.amadorpro.dao.IUsuarioDAO;
import br.com.srnimbus.amadorpro.dominio.Usuario;
import br.com.srnimbus.amadorpro.util.HibernateUtil;

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
