package br.com.srnimbus.amadorpro.dao;

import br.com.srnimbus.amadorpro.dominio.Usuario;

public interface IUsuarioDAO {

	public void insert(Usuario usuario);

	public void update(Usuario usuario);
	
	public void delete(Usuario usuario);
}

