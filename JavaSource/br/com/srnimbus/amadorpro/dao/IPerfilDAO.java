package br.com.srnimbus.amadorpro.dao;

import br.com.srnimbus.amadorpro.dominio.Perfil;

public interface IPerfilDAO {

	public void insert(Perfil perfil);

	public void update(Perfil perfil);
	
	public void delete(Perfil perfil);
}

