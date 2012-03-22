package br.com.srnimbus.amadorpro.dao.impl;

import br.com.srnimbus.amadorpro.dao.IEnderecoDAO;
import br.com.srnimbus.amadorpro.dominio.Endereco;
import br.com.srnimbus.amadorpro.util.HibernateUtil;

public class EnderecoDAOImpl implements IEnderecoDAO {

	@Override
	public void insert(Endereco endereco) {
		HibernateUtil.insert(endereco);

	}

	@Override
	public void update(Endereco endereco) {
		HibernateUtil.update(endereco);

	}

	@Override
	public void delete(Endereco endereco) {
		HibernateUtil.delete(endereco);

	}

}
