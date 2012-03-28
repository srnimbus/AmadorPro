package br.com.srnimbus.amadorpro.mvc;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.beanutils.BeanUtils;
import org.primefaces.event.SelectEvent;

import br.com.srnimbus.amadorpro.business.ILocalPeladaDelegate;
import br.com.srnimbus.amadorpro.business.impl.LocalPeladaDelegateImpl;
import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.to.LocalPeladaTO;

@ManagedBean(name = "localPeladaBean")
@SessionScoped
public class LocalPeladaBean extends AbstractBean {
	private int id;
	private String local;
	private String endereco;
	private String email;
	private String telefone;
	private ILocalPeladaDelegate delegate;
	private LocalPeladaTO selecionadoTO;
	
	@Override
	public void insert(ActionEvent actionEvent) throws IllegalAccessException,
			InvocationTargetException, AmadorProBusinessException {
		if (validateForm()){
			LocalPeladaTO to = new LocalPeladaTO();
			BeanUtils.copyProperties(to, this);
			getDelegate().insert(to);
			addMessagePagePanel("Local da pelada inserido com sucesso.");
		}
	}

	@Override
	public void update(ActionEvent actionEvent) throws IllegalAccessException,
			InvocationTargetException, AmadorProBusinessException {
		if (validateForm()) {
			LocalPeladaTO to = new LocalPeladaTO();
			BeanUtils.copyProperties(to, this);
			to.setId(getSelecionadoTO().getId());
			getDelegate().update(to);
			addMessagePagePanel("Local da pelada atualizado com sucesso.");
		}
	}

	@Override
	public void delete(ActionEvent actionEvent) throws IllegalAccessException,
			InvocationTargetException, AmadorProBusinessException {
		if (validateForm()) {
			LocalPeladaTO to = new LocalPeladaTO();
			to.setId(getSelecionadoTO().getId());
			getDelegate().delete(to);
			addMessagePagePanel("Local da pelada atualizado com sucesso.");
		}
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void findAll(ActionEvent actionEvent)
			throws AmadorProBusinessException {
		List listaTO = getDelegate().findAll(new LocalPeladaTO());
		setDataModel(listaTO);
		addMessagePagePanel("Todos os locais de pelada foram carregados com sucesso.");
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

	public LocalPeladaTO getSelecionadoTO() {
		return selecionadoTO;
	}

	public void setSelecionadoTO(LocalPeladaTO selecionadoTO) {
		this.selecionadoTO = selecionadoTO;
	}
	
	private ILocalPeladaDelegate getDelegate() {
		if (delegate == null) {
			delegate = new LocalPeladaDelegateImpl();
		}
		return delegate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

}
