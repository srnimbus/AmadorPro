package br.com.srnimbus.amadorpro.business.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import br.com.srnimbus.amadorpro.business.ITelefoneDelegate;
import br.com.srnimbus.amadorpro.dao.ITelefoneDAO;
import br.com.srnimbus.amadorpro.dao.impl.TelefoneDAOImpl;
import br.com.srnimbus.amadorpro.dominio.Telefone;
import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;
import br.com.srnimbus.amadorpro.to.TelefoneTO;

public class TelefoneDelegateImpl implements ITelefoneDelegate {
	private ITelefoneDAO dao;

	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public boolean insert(TelefoneTO to) throws AmadorProBusinessException {
		Telefone modelo = new Telefone();

		try {
			logger.info("Tentando inserir telefone");
			//System.out.println("Tentando inserir telefone");
			BeanUtils.copyProperties(modelo, to);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			System.out.println("Exceção insert telefone");
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			System.out.println("Exceção insert telefone");
			e1.printStackTrace();
		}

		try {
			getDAO().insert(modelo);
		} catch (AmadorProDAOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exceção insert DAO telefone");
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public TelefoneTO update(TelefoneTO to) throws AmadorProBusinessException {
		Telefone modelo = new Telefone();
		try {
			BeanUtils.copyProperties(modelo, to);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			System.out.println("Exceção update telefone");
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			System.out.println("Exceção update telefone");
			e1.printStackTrace();
		}

		try {
			getDAO().update(modelo);
		} catch (AmadorProDAOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exceção update DAO telefone");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(TelefoneTO to) throws AmadorProBusinessException {
		Telefone modelo = new Telefone();
		try {
			BeanUtils.copyProperties(modelo, to);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			System.out.println("Exceção delete telefone");
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			System.out.println("Exceção delete telefone");
			e1.printStackTrace();
		}

		try {
			getDAO().delete(modelo);
		} catch (AmadorProDAOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exceção delete DAO telefone");
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public TelefoneTO read(TelefoneTO to) throws AmadorProBusinessException {
		// TODO Auto-generated method stub
		System.out.println("READ ACESSADO");
		return null;
	}

	@Override
	public List<TelefoneTO> findAll(TelefoneTO to) throws AmadorProBusinessException {
		Telefone modelo = new Telefone();
		try {
			BeanUtils.copyProperties(modelo, to);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			System.out.println("Exceção findAll telefone");
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			System.out.println("Exceção findAll telefone");
			e1.printStackTrace();
		}

		List<TelefoneTO> lista = new ArrayList<TelefoneTO>();

		try {
			for (Object object : getDAO().findAll(modelo)) {
				TelefoneTO tos = new TelefoneTO();
				BeanUtils.copyProperties(tos, object);
				lista.add(tos);
			}
		} catch (AmadorProDAOException e) {
			System.out.println("Exceção findAll DAO telefone");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("Exceção copia lista telefone");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			System.out.println("Exceção copia lista telefone");
			e.printStackTrace();
		}

		return lista;
	}

	public ITelefoneDAO getDAO() {
		if (dao == null) {
			dao = new TelefoneDAOImpl();
		}
		return dao;
	}

}
