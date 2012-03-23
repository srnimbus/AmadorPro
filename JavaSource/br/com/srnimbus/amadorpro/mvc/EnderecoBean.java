package br.com.srnimbus.amadorpro.mvc;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.beanutils.BeanUtils;

import br.com.srnimbus.amadorpro.business.IEnderecoDelegate;
import br.com.srnimbus.amadorpro.business.impl.EnderecoDelegateImpl;
import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.to.EnderecoTO;

@ManagedBean(name = "enderecoBean")
@RequestScoped
public class EnderecoBean {

	int id;
	private boolean principal;
	private String endereco;
	private String cep;
	private List<EnderecoTO> lista;

	public boolean insert() throws IllegalAccessException, InvocationTargetException {

		IEnderecoDelegate delegate = new EnderecoDelegateImpl();
		EnderecoTO to = new EnderecoTO();
		BeanUtils.copyProperties(to, this);

		try {
			delegate.insert(to);
		} catch (AmadorProBusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public void read() {

	}

	public boolean delete() {

		return true;
	}

	public List<EnderecoTO> findAll() throws AmadorProBusinessException {
		IEnderecoDelegate delegate = new EnderecoDelegateImpl();

		delegate.findAll(new EnderecoTO());
		return delegate.findAll(new EnderecoTO());
	}

	public boolean validateForm() {

		return true;
	}

	public boolean isPrincipal() {
		return principal;
	}

	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

	public String getEndereco() {
		return endereco;
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

	public List<EnderecoTO> getLista() {
		return lista;
	}

	public void setLista(List<EnderecoTO> lista) {
		this.lista = lista;
	}

}
