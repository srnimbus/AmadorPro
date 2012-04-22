package br.com.srnimbus.amadorpro.mvc;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.commons.beanutils.BeanUtils;
import org.primefaces.event.SelectEvent;

import br.com.srnimbus.amadorpro.business.IEnderecoDelegate;
import br.com.srnimbus.amadorpro.business.impl.EnderecoDelegateImpl;
import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.to.EnderecoTO;

@ManagedBean(name = "enderecoBean")
@SessionScoped
public class EnderecoBean extends AbstractBean {

	int id;
	private boolean principal;
	private String endereco;
	private String cep;
	private EnderecoTO selecionadoTO;
	private IEnderecoDelegate delegate;

	@Override
	public void insert(ActionEvent actionEvent) throws IllegalAccessException, InvocationTargetException,
			AmadorProBusinessException {

		if (validateForm()) {
			EnderecoTO to = new EnderecoTO();
			BeanUtils.copyProperties(to, this);
			getDelegate().insert(to);
			addMessagePagePanel("Endereço inserido com sucesso.");
		}
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void findAll(ActionEvent actionEvent) throws AmadorProBusinessException {
		List listaTO = getDelegate().findAll(new EnderecoTO());
		setDataModel(listaTO);
		addMessagePagePanel("Todos os endereços carregados com sucesso.");
	}

	public void update(ActionEvent actionEvent) throws IllegalAccessException, InvocationTargetException,
			AmadorProBusinessException {
		if (validateForm()) {
			EnderecoTO to = new EnderecoTO();
			BeanUtils.copyProperties(to, this);
			to.setId(getSelecionadoTO().getId());
			getDelegate().update(to);
			addMessagePagePanel("Endereço atualizado com sucesso.");
		}

	}

	// <p:ajax event="rowSelect" listener="#{enderecoBean.load}"
	// update=":form:panel"/>
	public void load(SelectEvent selectEvent) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties(this, getSelecionadoTO());
		addMessagePagePanel("Endereço carregado objeto nº " + getSelecionadoTO().getId());
	}

	@Override
	public void delete(ActionEvent actionEvent) throws AmadorProBusinessException {
		if (validateForm()) {
			EnderecoTO to = new EnderecoTO();
			to.setId(getSelecionadoTO().getId());
			getDelegate().delete(to);
			addMessagePagePanel("Endereço atualizado com sucesso.");
		}
	}

	@Override
	public boolean validateForm() {
		
		FacesContext context = FacesContext.getCurrentInstance();
	
		String padraoCEP = "^[0-9]{2}( |[-\\.])?[0-9]{3}( |[-\\.])?[0-9]{3}";
		Pattern mask = Pattern.compile(padraoCEP);

		Matcher matcher = mask.matcher(this.cep);

		if (!matcher.find()) {
			FacesMessage message = new FacesMessage();
			message.setDetail("CEP inválido!");
			message.setSummary("CEP inválido! ");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage("form.cep", message);
			return false;
		} else return true;
	}

	// getters and setters

	public boolean isPrincipal() {
		return principal;
	}

	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

	public String getEndereco() {
		return endereco;
	}

	public EnderecoTO getSelecionadoTO() {
		return selecionadoTO;
	}

	public void setSelecionadoTO(EnderecoTO selecionadoTO) {
		this.selecionadoTO = selecionadoTO;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private IEnderecoDelegate getDelegate() {
		if (delegate == null) {
			delegate = new EnderecoDelegateImpl();
		}
		return delegate;
	}

}
