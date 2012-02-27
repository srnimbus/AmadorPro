package br.com.srnimbus.dao;

import br.com.srnimbus.dominio.Login;

public interface ILoginDAO {

	public void insert(Login login);

	public void update(Login login);
	
	public void delete(Login login);
	
	
}

