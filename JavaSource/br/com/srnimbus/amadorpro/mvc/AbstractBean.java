package br.com.srnimbus.amadorpro.mvc;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.mvc.dm.AbstractDataModel;
import br.com.srnimbus.amadorpro.to.AbstractTO;

public abstract class AbstractBean {

	private AbstractDataModel dataModel;

	public AbstractBean() {
		super();
	}

	public abstract void insert(ActionEvent actionEvent) throws IllegalAccessException, InvocationTargetException,
			AmadorProBusinessException;

	public void read(ActionEvent actionEvent) throws AmadorProBusinessException {
	} // como no Swing...

	public abstract void update(ActionEvent actionEvent) throws IllegalAccessException, InvocationTargetException, AmadorProBusinessException;
	
	public abstract void delete(ActionEvent actionEvent) throws IllegalAccessException, InvocationTargetException, AmadorProBusinessException;

	public abstract void findAll(ActionEvent actionEvent) throws AmadorProBusinessException;

	public abstract boolean validateForm();

	protected void addMessagePagePanel(String msg) {
		FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage(msg));
	}
	

	public AbstractDataModel getDataModel() {
		return dataModel;
	}

	public void setDataModel(List<AbstractTO> dataModel) {
		AbstractDataModel dm = new AbstractDataModel(dataModel);
		this.dataModel = dm;
	}

}