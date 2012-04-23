package br.com.srnimbus.amadorpro.jaas;

import java.util.Date;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.AuthenticationException;

import br.com.srnimbus.amadorpro.business.ILogLoginDelegate;
import br.com.srnimbus.amadorpro.business.impl.LogLoginDelegateImpl;
import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.exception.AmadorProException;
import br.com.srnimbus.amadorpro.to.LogLoginTO;
import br.com.srnimbus.amadorpro.to.LoginTO;
import br.com.srnimbus.amadorpro.util.FacesUtil;

public class LoginHelper {

	private LoginHelper() {
	}

	private Subject subject;
	private static LoginHelper instance;
	private LoginTO loginTO;
	

	public static LoginHelper getInstance() {
		if (instance == null) {
			instance = new LoginHelper();
		}
		return instance;
	}

	public static boolean login(LoginTO to) throws AmadorProException {
		final String MODULE_NAME = AmadorProLoginModule.class.getName();
		boolean authenticated = false;
		LoginContext ctx = null;
		try {
			ctx = new LoginContext(MODULE_NAME, new BundleCallbackHandler(to.getLogin(), to.getSenha()));
			ctx.login();
			authenticated = true;
		} catch (LoginException e) {
			throw new AmadorProException(e);
		} finally {
			try {
				if (authenticated)
				ESAPI.httpUtilities().changeSessionIdentifier(FacesUtil.getRequest());
			} catch (AuthenticationException e) {
				throw new AmadorProException(e);
			}
		}

		return authenticated;

	}


	public static String collectDataLogLogin() {
		StringBuffer retorno = new StringBuffer();

		retorno.append("Endereco IP: " + FacesUtil.getRequest().getRemoteHost() + "H ");
		retorno.append("Endereco IP: " + FacesUtil.getRequest().getRemoteAddr() + "A ");
		retorno.append("ID Sessao Gerado: " + FacesUtil.getSession(false).getId() + " ");

		return retorno.toString();
	}

	public static void insertLogLogin(int idLogin, boolean authenticated) throws AmadorProException {
		ILogLoginDelegate delegate = new LogLoginDelegateImpl();
		LogLoginTO to = new LogLoginTO();

		to.setIdLogin(idLogin);
		to.setInfo(LoginHelper.collectDataLogLogin());
		to.setDataHoraLogin(new Date());
		to.setAutenticado(authenticated);

		try {
			delegate.insert(to);
		} catch (AmadorProBusinessException e) {
			throw new AmadorProException(e);
		}

	}

	
	public LoginTO getLoginTO() {
		return loginTO;
	}

	public void setLoginTO(LoginTO loginTO) {
		this.loginTO = loginTO;
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Subject getSubject() {
		return subject;
	}
}
