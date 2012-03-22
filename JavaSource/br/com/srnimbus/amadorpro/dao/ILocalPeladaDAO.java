package br.com.srnimbus.amadorpro.dao;

import br.com.srnimbus.amadorpro.dominio.LocalPelada;

public interface ILocalPeladaDAO {

	public void insert(LocalPelada localPelada);

	public void update(LocalPelada localPelada);
	
	public void delete(LocalPelada localPelada);
}

