package br.com.srnimbus.amadorpro.dao.impl;

import java.util.List;

import br.com.srnimbus.amadorpro.dao.IMenuDAO;
import br.com.srnimbus.amadorpro.dominio.Menu;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;
import br.com.srnimbus.amadorpro.util.HibernateUtil;

public class MenuDAOImpl implements IMenuDAO {

	@Override
	public void insert(Menu menu) throws AmadorProDAOException {
		HibernateUtil.insert(menu);

	}

	@Override
	public void update(Menu menu) throws AmadorProDAOException {
		HibernateUtil.update(menu);

	}

	public Menu read(Menu menu) throws AmadorProDAOException {
		return (Menu) HibernateUtil.loadById(Menu.class, menu.getId());
	}

	public List<Object> findAll(Menu menu) throws AmadorProDAOException {
		return HibernateUtil.findAll(Menu.class.getName());
	}

	@Override
	public void delete(Menu menu) throws AmadorProDAOException {
		HibernateUtil.delete(menu);

	}

}
