package br.com.srnimbus.amadorpro.business;

import java.util.List;

import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.to.EnderecoTO;

public interface IEnderecoDelegate {

	public boolean insert(EnderecoTO to) throws AmadorProBusinessException;

	public EnderecoTO update(EnderecoTO to) throws AmadorProBusinessException;

	public boolean delete(EnderecoTO to) throws AmadorProBusinessException;

	public EnderecoTO read(EnderecoTO to) throws AmadorProBusinessException;

	public List<EnderecoTO> findAll(EnderecoTO to) throws AmadorProBusinessException;
}
