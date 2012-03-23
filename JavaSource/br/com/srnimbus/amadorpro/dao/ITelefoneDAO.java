package br.com.srnimbus.amadorpro.dao;

import br.com.srnimbus.amadorpro.dominio.Telefone;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;

public interface ITelefoneDAO {

	public void insert(Telefone telefone) throws AmadorProDAOException;

	public void update(Telefone telefone) throws AmadorProDAOException;

	public void delete(Telefone telefone) throws AmadorProDAOException;

	public Telefone read(Telefone telefone) throws AmadorProDAOException;

	public Telefone findAll(Telefone telefone) throws AmadorProDAOException;
}
