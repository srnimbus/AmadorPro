package br.com.srnimbus.amadorpro.dao.impl;

import br.com.srnimbus.amadorpro.dao.IUsuarioDAO;
import br.com.srnimbus.amadorpro.dominio.Usuario;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;
import br.com.srnimbus.amadorpro.util.HibernateUtil;

public class UsuarioDAOImpl implements IUsuarioDAO {

	@Override
	public void insert(Usuario usuario) throws AmadorProDAOException {
		HibernateUtil.insert(usuario);

	}

	@Override
	public void update(Usuario usuario) throws AmadorProDAOException {
		HibernateUtil.update(usuario);

	}

	@Override
	public void delete(Usuario usuario) throws AmadorProDAOException {
		HibernateUtil.delete(usuario);

	}

	@Override
	public Usuario read(Usuario usuario) throws AmadorProDAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findAll(Usuario usuario) throws AmadorProDAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
