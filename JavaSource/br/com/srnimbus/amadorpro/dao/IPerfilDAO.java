package br.com.srnimbus.amadorpro.dao;

import br.com.srnimbus.amadorpro.dominio.Perfil;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;

public interface IPerfilDAO {

	public void insert(Perfil perfil) throws AmadorProDAOException;

	public void update(Perfil perfil) throws AmadorProDAOException;

	public void delete(Perfil perfil) throws AmadorProDAOException;

	public Perfil read(Perfil perfil) throws AmadorProDAOException;

	public Perfil findAll(Perfil perfil) throws AmadorProDAOException;
}
