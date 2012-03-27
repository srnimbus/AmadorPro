package br.com.srnimbus.amadorpro.business.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import br.com.srnimbus.amadorpro.business.ILocalPeladaDelegate;
import br.com.srnimbus.amadorpro.dao.ILocalPeladaDAO;
import br.com.srnimbus.amadorpro.dao.impl.LocalPeladaDAOImpl;
import br.com.srnimbus.amadorpro.dominio.LocalPelada;
import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;
import br.com.srnimbus.amadorpro.to.LocalPeladaTO;

public class LocalPeladaDelegateImpl implements ILocalPeladaDelegate {
	private ILocalPeladaDAO dao;

	@Override
	public boolean insert(LocalPeladaTO to) throws AmadorProBusinessException {
		LocalPelada modelo = new LocalPelada();
		try {
			BeanUtils.copyProperties(modelo, to);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			getDAO().insert(modelo);
		} catch (AmadorProDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public LocalPeladaTO update(LocalPeladaTO to) throws AmadorProBusinessException {
		LocalPelada modelo = new LocalPelada();
		try {
			BeanUtils.copyProperties(modelo, to);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			getDAO().update(modelo);
		} catch (AmadorProDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(LocalPeladaTO to) throws AmadorProBusinessException {
		LocalPelada modelo = new LocalPelada();
		try {
			BeanUtils.copyProperties(modelo, to);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			getDAO().delete(modelo);
		} catch (AmadorProDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public LocalPeladaTO read(LocalPeladaTO to) throws AmadorProBusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocalPeladaTO> findAll(LocalPeladaTO to) throws AmadorProBusinessException {
		LocalPelada modelo = new LocalPelada();
		try {
			BeanUtils.copyProperties(modelo, to);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		List<LocalPeladaTO> lista = new ArrayList<LocalPeladaTO>();

		try {
			for (Object object : getDAO().findAll(modelo)) {
				LocalPeladaTO tos = new LocalPeladaTO();
				BeanUtils.copyProperties(tos, object);
				lista.add(tos);
			}
		} catch (AmadorProDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}

	public ILocalPeladaDAO getDAO() {
		if (dao == null) {
			dao = new LocalPeladaDAOImpl();
		}
		return dao;


	}
}
