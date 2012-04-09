package br.com.srnimbus.amadorpro.business.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import br.com.srnimbus.amadorpro.business.IMenuDelegate;
import br.com.srnimbus.amadorpro.dao.IMenuDAO;
import br.com.srnimbus.amadorpro.dao.impl.MenuDAOImpl;
import br.com.srnimbus.amadorpro.dominio.Menu;
import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;
import br.com.srnimbus.amadorpro.to.MenuTO;

public class MenuDelegateImpl implements IMenuDelegate {

	private IMenuDAO dao;

	@Override
	public boolean insert(MenuTO to) throws AmadorProBusinessException {

		Menu modelo = new Menu();

		try {
			BeanUtils.copyProperties(modelo, to);
			getDAO().insert(modelo);
		} catch (IllegalAccessException e1) {
			throw new AmadorProBusinessException(e1);
		} catch (InvocationTargetException e1) {
			throw new AmadorProBusinessException(e1);
		} catch (AmadorProDAOException e) {
			throw new AmadorProBusinessException(e);
		}
		return true;
	}

	@Override
	public MenuTO read(MenuTO to) throws AmadorProBusinessException {
		MenuTO retorno = new MenuTO();
		return retorno;
	}

	@Override
	public boolean delete(MenuTO to) throws AmadorProBusinessException {
		Menu modelo = new Menu();
		try {
			BeanUtils.copyProperties(modelo, to);
			getDAO().delete(modelo);
		} catch (IllegalAccessException e1) {
			throw new AmadorProBusinessException(e1);
		} catch (InvocationTargetException e1) {
			throw new AmadorProBusinessException(e1);
		} catch (AmadorProDAOException e) {
			throw new AmadorProBusinessException(e);
		}
		return true;
	}

	@Override
	public MenuTO update(MenuTO to) throws AmadorProBusinessException {
		Menu modelo = new Menu();
		try {
			BeanUtils.copyProperties(modelo, to);
			getDAO().update(modelo);
		} catch (IllegalAccessException e1) {
			throw new AmadorProBusinessException(e1);
		} catch (InvocationTargetException e1) {
			throw new AmadorProBusinessException(e1);
		} catch (AmadorProDAOException e) {
			throw new AmadorProBusinessException(e);
		}
		return null;
	}

	@Override
	public List<MenuTO> findAll(MenuTO to) throws AmadorProBusinessException {
		Menu modelo = new Menu();
		List<MenuTO> lista = new ArrayList<MenuTO>();
		try {
			BeanUtils.copyProperties(modelo, to);
			for (Object object : getDAO().findAll(modelo)) {
				MenuTO tos = new MenuTO();
				BeanUtils.copyProperties(tos, object);
				lista.add(tos);
			}
		} catch (IllegalAccessException e1) {
			throw new AmadorProBusinessException(e1);
		} catch (InvocationTargetException e1) {
			throw new AmadorProBusinessException(e1);
		} catch (AmadorProDAOException e) {
			throw new AmadorProBusinessException(e);
		}

		return lista;
	}

	public IMenuDAO getDAO() {
		if (dao == null) {
			dao = new MenuDAOImpl();
		}
		return dao;
	}
}
