package br.com.srnimbus.dao;

import br.com.srnimbus.dominio.Perfil;

public interface IPerfilDAO {

	public void insert(Perfil perfil);

	public void update(Perfil perfil);
	
	public void delete(Perfil perfil);
}

