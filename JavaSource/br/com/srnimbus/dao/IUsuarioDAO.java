package br.com.srnimbus.dao;

import br.com.srnimbus.dominio.Usuario;

public interface IUsuarioDAO {

	public void insert(Usuario usuario);

	public void update(Usuario usuario);
	
	public void delete(Usuario usuario);
}

