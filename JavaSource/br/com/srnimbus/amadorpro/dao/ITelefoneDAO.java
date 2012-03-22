package br.com.srnimbus.amadorpro.dao;

import br.com.srnimbus.amadorpro.dominio.Telefone;

public interface ITelefoneDAO {

	public void insert(Telefone telefone);

	public void update(Telefone telefone);
	
	public void delete(Telefone telefone);
}

