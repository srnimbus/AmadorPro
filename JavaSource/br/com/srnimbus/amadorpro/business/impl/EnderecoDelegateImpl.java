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

public class EnderecoDelegateImpl implements IEnderecoDelegate {

	private IEnderecoDAO dao;

	@Override
	public boolean insert(EnderecoTO to) throws AmadorProBusinessException {

		Endereco modelo = new Endereco();

		try {
			BeanUtils.copyProperties(modelo, to);
			getDAO().insert(modelo);
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
			throw new AmadorProBusinessException(e1);
		} catch (InvocationTargetException e1) {
			throw new AmadorProBusinessException(e1);
		} catch (AmadorProDAOException e) {
			throw new AmadorProBusinessException(e);
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
	public EnderecoTO update(EnderecoTO to) throws AmadorProBusinessException {
		Endereco modelo = new Endereco();
		try {
			BeanUtils.copyProperties(modelo, to);
			getDAO().update(modelo);
		} catch (IllegalAccessException e1) {
			throw new AmadorProBusinessException(e1);
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
			throw new AmadorProBusinessException(e1);
		} catch (AmadorProDAOException e) {
			throw new AmadorProBusinessException(e);
		}
		return null;
	}

	@Override
	public List<EnderecoTO> findAll(EnderecoTO to) throws AmadorProBusinessException {
		Endereco modelo = new Endereco();
		List<EnderecoTO> lista = new ArrayList<EnderecoTO>();
		try {
			BeanUtils.copyProperties(modelo, to);
			for (Object object : getDAO().findAll(modelo)) {
				EnderecoTO tos = new EnderecoTO();
				BeanUtils.copyProperties(tos, object);
				lista.add(tos);
			}
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
			throw new AmadorProBusinessException(e1);
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
			throw new AmadorProBusinessException(e1);
		} catch (AmadorProDAOException e) {
			throw new AmadorProBusinessException(e);
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
