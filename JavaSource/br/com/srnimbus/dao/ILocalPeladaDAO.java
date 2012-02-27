package br.com.srnimbus.dao;

import br.com.srnimbus.dominio.LocalPelada;

public interface ILocalPeladaDAO {

	public void insert(LocalPelada localPelada);

	public void update(LocalPelada localPelada);
	
	public void delete(LocalPelada localPelada);
}

