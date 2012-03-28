package br.com.srnimbus.amadorpro.mvc;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.beanutils.BeanUtils;
import org.primefaces.event.SelectEvent;

import br.com.srnimbus.amadorpro.business.ITelefoneDelegate;
import br.com.srnimbus.amadorpro.business.impl.TelefoneDelegateImpl;
import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.to.TelefoneTO;

@ManagedBean(name = "telefoneBean")
@SessionScoped
public class TelefoneBean extends AbstractBean {

	private int id;
	private boolean principal;
	private String telefone;
	private ITelefoneDelegate delegate;
	private TelefoneTO selecionadoTO;

	public TelefoneTO getSelecionadoTO() {
		return selecionadoTO;
	}

	public void setSelecionadoTO(TelefoneTO selecionadoTO) {
		this.selecionadoTO = selecionadoTO;
	}

	@Override
	public void insert(ActionEvent actionEvent) throws IllegalAccessException, InvocationTargetException,
			AmadorProBusinessException {
		TelefoneTO to = new TelefoneTO();
		BeanUtils.copyProperties(to, this);
		getDelegate().insert(to);
		addMessagePagePanel("Telefone inserido com sucesso.");

	}

	@Override
	public void update(ActionEvent actionEvent) throws IllegalAccessException, InvocationTargetException,
			AmadorProBusinessException {
		if (validateForm()) {
			TelefoneTO to = new TelefoneTO();
			BeanUtils.copyProperties(to, this);
			to.setId(getSelecionadoTO().getId());
			getDelegate().update(to);
			addMessagePagePanel("Telefone atualizado com sucesso.");
		}
	}

	@Override
	public void delete(ActionEvent actionEvent) throws IllegalAccessException, InvocationTargetException,
			AmadorProBusinessException {
		if (validateForm()) {
			TelefoneTO to = new TelefoneTO();
			to.setId(getSelecionadoTO().getId());
			getDelegate().delete(to);
			addMessagePagePanel("Telefone atualizado com sucesso.");
		}
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void findAll(ActionEvent actionEvent) throws AmadorProBusinessException {
		List listaTO = getDelegate().findAll(new TelefoneTO());
		setDataModel(listaTO);
		addMessagePagePanel("Todos os telefones foram carregados com sucesso.");

	}

	//<p:ajax event="rowSelect" listener="#{enderecoBean.load}" update=":form:panel"/>   
	public void load(SelectEvent selectEvent) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties(this, getSelecionadoTO());
		addMessagePagePanel("Endereço carregado objeto nº " + getSelecionadoTO().getId());
	}
	
	@Override
	public boolean validateForm() {
		// TODO Auto-generated method stub
		return true;
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

	private ITelefoneDelegate getDelegate() {
		if (delegate == null) {
			delegate = new TelefoneDelegateImpl();
		}
		return delegate;
	}

}
