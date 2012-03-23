package br.com.srnimbus.amadorpro.dao;

import br.com.srnimbus.amadorpro.dominio.Usuario;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;

public interface IUsuarioDAO {

	public void insert(Usuario usuario) throws AmadorProDAOException;

	public void update(Usuario usuario) throws AmadorProDAOException;

	public void delete(Usuario usuario) throws AmadorProDAOException;

	public Usuario read(Usuario usuario) throws AmadorProDAOException;

	public Usuario findAll(Usuario usuario) throws AmadorProDAOException;
}
