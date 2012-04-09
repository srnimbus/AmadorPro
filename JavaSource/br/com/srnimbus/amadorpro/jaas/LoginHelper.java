package br.com.srnimbus.amadorpro.jaas;

import java.util.Date;

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

	public static boolean login(LoginTO to) throws AmadorProException {
		final String MODULE_NAME = AmadorProLoginModule.class.getName();
		// authenticate user
		boolean authenticated = false;
		try {
			LoginContext ctx = new LoginContext(MODULE_NAME, new BundleCallbackHandler(to.getLogin(), to.getSenha()));
			ctx.login();
			authenticated = true;
		} catch (LoginException e) {
			throw new AmadorProException(e);
		} finally {
			try {
				ESAPI.httpUtilities().changeSessionIdentifier(FacesUtil.getRequest());
			} catch (AuthenticationException e) {
				throw new AmadorProException(e);
			}
		}

		return authenticated;

	}

	public static String collectDataLogLogin() {
		StringBuffer retorno = new StringBuffer();
		// TODO Fazer mal-feito para LAB
		// TODO pegar dados para montar log do request + sessao

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

}
