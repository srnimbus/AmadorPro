package br.com.srnimbus.amadorpro.mvc;

import java.lang.reflect.InvocationTargetException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.beanutils.BeanUtils;

import br.com.srnimbus.amadorpro.jaas.Constants;
import br.com.srnimbus.amadorpro.jaas.JAASHelper;
import br.com.srnimbus.amadorpro.to.LoginTO;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {

	private String login;
	private String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String login() throws IllegalAccessException, InvocationTargetException {
		LoginTO to = new LoginTO();
		BeanUtils.copyProperties(to, this);

		boolean isLogged = JAASHelper.login(to);

		if (!isLogged) {
			addMessagePagePanel("Username e/ou Senha Invalidos");
		}

		return isLogged ? Constants.SUCCESS : Constants.ERROR;
	}

	protected void addMessagePagePanel(String msg) {
		FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage(msg));
	}

}
