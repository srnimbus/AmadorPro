package br.com.srnimbus.amadorpro.mvc;

import java.lang.reflect.InvocationTargetException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.beanutils.BeanUtils;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.AuthenticationException;

import br.com.srnimbus.amadorpro.exception.AmadorProException;
import br.com.srnimbus.amadorpro.jaas.Constants;
import br.com.srnimbus.amadorpro.jaas.LoginHelper;
import br.com.srnimbus.amadorpro.to.LoginTO;
import br.com.srnimbus.amadorpro.util.FacesUtil;

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

	public String login() throws AmadorProException {
		LoginTO to = new LoginTO();
		try {
			BeanUtils.copyProperties(to, this);
		} catch (IllegalAccessException e) {
			throw new AmadorProException(e);
		} catch (InvocationTargetException e) {
			throw new AmadorProException(e);
		}
		boolean isLogged = LoginHelper.login(to);
		if (!isLogged) {
			addMessagePagePanel("Username e/ou Senha Invalidos");
		} else {
			try {
				// troca o identificador de sessao
				//Logger log = ESAPI.getLogger(this.getClass());
				ESAPI.httpUtilities().changeSessionIdentifier(FacesUtil.getRequest());
				System.out.println("depois " + FacesUtil.getRequest().getSession(false).getId());
			} catch (AuthenticationException e) {
				throw new AmadorProException(e);
			}
		}
		return isLogged ? Constants.SUCCESS : Constants.ERROR;
	}

	protected void addMessagePagePanel(String msg) {
		FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage(msg));
	}

}
