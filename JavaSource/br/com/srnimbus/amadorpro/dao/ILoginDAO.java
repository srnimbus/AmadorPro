package br.com.srnimbus.amadorpro.dao;

import br.com.srnimbus.amadorpro.dominio.Login;

public interface ILoginDAO {

	public void insert(Login login);

	public void update(Login login);
	
	public void delete(Login login);
	
	public String getHashSenha(Login login);
}

