package br.com.srnimbus.dao;

import br.com.srnimbus.dominio.Telefone;

public interface ITelefoneDAO {

	public void insert(Telefone telefone);

	public void update(Telefone telefone);
	
	public void delete(Telefone telefone);
}

