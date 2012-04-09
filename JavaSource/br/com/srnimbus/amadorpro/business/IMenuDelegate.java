package br.com.srnimbus.amadorpro.business;

import java.util.List;

import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.to.MenuTO;

public interface IMenuDelegate {

	public boolean insert(MenuTO to) throws AmadorProBusinessException;

	public MenuTO update(MenuTO to) throws AmadorProBusinessException;

	public boolean delete(MenuTO to) throws AmadorProBusinessException;

	public MenuTO read(MenuTO to) throws AmadorProBusinessException;

	public List<MenuTO> findAll(MenuTO to) throws AmadorProBusinessException;
}
