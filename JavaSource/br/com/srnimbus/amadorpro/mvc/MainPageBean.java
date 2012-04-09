package br.com.srnimbus.amadorpro.mvc;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.srnimbus.amadorpro.jaas.Constants;
import br.com.srnimbus.amadorpro.to.LoginTO;
import br.com.srnimbus.amadorpro.to.UsuarioTO;
import br.com.srnimbus.amadorpro.util.FacesUtil;

@ManagedBean(name = "mainPageBean")
@SessionScoped
public class MainPageBean {

	private LoginTO loginTO;
	private UsuarioTO usuarioTO;

	public MainPageBean() {

		loginTO = (LoginTO) FacesUtil.getSession(false).getAttribute(Constants.SESSION_USER);
		if (loginTO != null) {
			usuarioTO = loginTO.getUsuarioTO();
		}

	}

	public LoginTO getLoginTO() {
		return loginTO;
	}

	public void setLoginTO(LoginTO loginTO) {
		this.loginTO = loginTO;
	}

	public UsuarioTO getUsuarioTO() {
		return usuarioTO;
	}

	public void setUsuarioTO(UsuarioTO usuarioTO) {
		this.usuarioTO = usuarioTO;
	}

}
