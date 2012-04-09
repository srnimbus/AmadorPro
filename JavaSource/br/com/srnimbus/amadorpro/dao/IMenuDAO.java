package br.com.srnimbus.amadorpro.dao;

import java.util.List;

import br.com.srnimbus.amadorpro.dominio.Menu;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;

public interface IMenuDAO {

	public void insert(Menu menu) throws AmadorProDAOException;

	public void update(Menu menu) throws AmadorProDAOException;

	public void delete(Menu menu) throws AmadorProDAOException;

	public Menu read(Menu menu) throws AmadorProDAOException;

	public List<Object> findAll(Menu menu) throws AmadorProDAOException;
}
