package br.com.srnimbus.amadorpro.dao;

import java.util.List;

import br.com.srnimbus.amadorpro.dominio.LocalPelada;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;

public interface ILocalPeladaDAO {

	public void insert(LocalPelada localPelada) throws AmadorProDAOException;

	public void update(LocalPelada localPelada) throws AmadorProDAOException;

	public void delete(LocalPelada localPelada) throws AmadorProDAOException;

	public LocalPelada read(LocalPelada localPelada) throws AmadorProDAOException;

	public List<Object> findAll(LocalPelada localPelada) throws AmadorProDAOException;
}
