package br.com.srnimbus.amadorpro.business.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import br.com.srnimbus.amadorpro.business.IEnderecoDelegate;
import br.com.srnimbus.amadorpro.dao.IEnderecoDAO;
import br.com.srnimbus.amadorpro.dao.impl.EnderecoDAOImpl;
import br.com.srnimbus.amadorpro.dominio.Endereco;
import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;
import br.com.srnimbus.amadorpro.to.EnderecoTO;

public class MenuDelegateImpl implements IEnderecoDelegate {

	private IEnderecoDAO dao;

	@Override
	public boolean insert(EnderecoTO to) throws AmadorProBusinessException {

		Endereco modelo = new Endereco();

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
	public EnderecoTO read(EnderecoTO to) throws AmadorProBusinessException {
		EnderecoTO retorno = new EnderecoTO();
		return retorno;
	}

	@Override
	public boolean delete(EnderecoTO to) throws AmadorProBusinessException {
		Endereco modelo = new Endereco();
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
	public EnderecoTO update(EnderecoTO to) throws AmadorProBusinessException {
		Endereco modelo = new Endereco();
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
	public List<EnderecoTO> findAll(EnderecoTO to) throws AmadorProBusinessException {
		Endereco modelo = new Endereco();
		try {
			BeanUtils.copyProperties(modelo, to);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		List<EnderecoTO> lista = new ArrayList<EnderecoTO>();

		try {
			for (Object object : getDAO().findAll(modelo)) {
				EnderecoTO tos = new EnderecoTO();
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

	public IEnderecoDAO getDAO() {
		if (dao == null) {
			dao = new EnderecoDAOImpl();
		}
		return dao;
	}
}
