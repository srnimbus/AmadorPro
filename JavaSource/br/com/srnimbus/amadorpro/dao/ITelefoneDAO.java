package br.com.srnimbus.amadorpro.dao;

import java.util.List;

import br.com.srnimbus.amadorpro.dominio.Telefone;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;

public interface ITelefoneDAO {

	public void insert(Telefone telefone) throws AmadorProDAOException;

	public void update(Telefone telefone) throws AmadorProDAOException;

	public void delete(Telefone telefone) throws AmadorProDAOException;

	public Telefone read(Telefone telefone) throws AmadorProDAOException;

	public List<Object> findAll(Telefone telefone) throws AmadorProDAOException;
}
