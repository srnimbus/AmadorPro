package br.com.srnimbus.dao.impl;

import br.com.srnimbus.dao.IEnderecoDAO;
import br.com.srnimbus.dominio.Endereco;
import br.com.srnimbus.util.HibernateUtil;

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
