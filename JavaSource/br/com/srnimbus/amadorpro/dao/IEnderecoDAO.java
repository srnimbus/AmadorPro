package br.com.srnimbus.amadorpro.dao;

import java.util.List;

import br.com.srnimbus.amadorpro.dominio.Endereco;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;

public interface IEnderecoDAO {

	public void insert(Endereco endereco) throws AmadorProDAOException;

	public void update(Endereco endereco) throws AmadorProDAOException;

	public void delete(Endereco endereco) throws AmadorProDAOException;

	public Endereco read(Endereco endereco) throws AmadorProDAOException;

	public List<Object> findAll(Endereco endereco) throws AmadorProDAOException;
}
