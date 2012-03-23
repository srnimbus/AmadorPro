package br.com.srnimbus.amadorpro.dao;

import br.com.srnimbus.amadorpro.dominio.Pelada;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;

public interface IPeladaDAO {

	public void insert(Pelada pelada) throws AmadorProDAOException;;

	public void update(Pelada pelada) throws AmadorProDAOException;;

	public void delete(Pelada pelada) throws AmadorProDAOException;;

	public Pelada read(Pelada pelada) throws AmadorProDAOException;

	public Pelada findAll(Pelada pelada) throws AmadorProDAOException;
}
