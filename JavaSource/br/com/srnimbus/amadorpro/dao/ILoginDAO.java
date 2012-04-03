package br.com.srnimbus.amadorpro.dao;

import br.com.srnimbus.amadorpro.dominio.Login;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;

public interface ILoginDAO {

	public void insert(Login login) throws AmadorProDAOException;

	public void update(Login login) throws AmadorProDAOException;
	
	public void delete(Login login) throws AmadorProDAOException;
	
	public String getHashSenha(Login login) throws AmadorProDAOException;
}

