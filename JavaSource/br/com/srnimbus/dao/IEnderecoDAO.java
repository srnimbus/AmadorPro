package br.com.srnimbus.dao;

import br.com.srnimbus.dominio.Endereco;

public interface IEnderecoDAO {

	public void insert(Endereco endereco);

	public void update(Endereco endereco);
	
	public void delete(Endereco endereco);
}

