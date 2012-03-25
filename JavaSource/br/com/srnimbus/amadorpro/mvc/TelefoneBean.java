package br.com.srnimbus.amadorpro.mvc;

import java.lang.reflect.InvocationTargetException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;

@ManagedBean(name = "telefoneBean")
@RequestScoped
public class TelefoneBean extends AbstractBean {

	private int id;
	private boolean principal;
	private String telefone;

	@Override
	public void insert(ActionEvent actionEvent) throws IllegalAccessException, InvocationTargetException,
			AmadorProBusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ActionEvent actionEvent) throws IllegalAccessException, InvocationTargetException,
			AmadorProBusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ActionEvent actionEvent) throws IllegalAccessException, InvocationTargetException,
			AmadorProBusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void findAll(ActionEvent actionEvent) throws AmadorProBusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean validateForm() {
		// TODO Auto-generated method stub
		return false;
	}

	// getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isPrincipal() {
		return principal;
	}

	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
