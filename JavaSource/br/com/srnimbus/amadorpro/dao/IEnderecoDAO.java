package br.com.srnimbus.amadorpro.dao;

import br.com.srnimbus.amadorpro.dominio.Endereco;

public interface IEnderecoDAO {

	public void insert(Endereco endereco);

	public void update(Endereco endereco);
	
	public void delete(Endereco endereco);
}

