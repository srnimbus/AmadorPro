package br.com.srnimbus.amadorpro.dao.impl;

import java.util.List;

import br.com.srnimbus.amadorpro.dao.IEnderecoDAO;
import br.com.srnimbus.amadorpro.dominio.Endereco;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;
import br.com.srnimbus.amadorpro.util.HibernateUtil;

public class EnderecoDAOImpl implements IEnderecoDAO {

	@Override
	public void insert(Endereco endereco) throws AmadorProDAOException {
		HibernateUtil.insert(endereco);

	}

	@Override
	public void update(Endereco endereco) throws AmadorProDAOException {
		HibernateUtil.update(endereco);

	}

	public Endereco read(Endereco endereco) throws AmadorProDAOException {
		return (Endereco) HibernateUtil.loadById(Endereco.class, endereco.getId());
	}

	public List<Object> findAll(Endereco endereco) throws AmadorProDAOException {
		return HibernateUtil.findAll(Endereco.class.getName());
	}

	@Override
	public void delete(Endereco endereco) throws AmadorProDAOException {
		HibernateUtil.delete(endereco);

	}

}
