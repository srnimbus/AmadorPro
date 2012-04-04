package br.com.srnimbus.amadorpro.jaas;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import br.com.srnimbus.amadorpro.to.LoginTO;

public class JAASHelper {

	public static boolean login(LoginTO to) {
		final String MODULE_NAME = AmadorProLoginModule.class.getName();
		// authenticate user
		boolean authenticated = false;
		try {
			LoginContext ctx = new LoginContext(MODULE_NAME, new BundleCallbackHandler(to.getLogin(), to.getSenha()));
			ctx.login();
			authenticated = true;
		} catch (LoginException e) {
			e.printStackTrace();
		}

		return authenticated;

	}

	public static String collectDataLogLogin() {
		StringBuffer retorno = new StringBuffer();
		// TODO Fazer mal-feito para LAB
		// TODO pegar dados para montar log do request + sessao

		retorno.append("Endereco IP: ");
		retorno.append("ID Sessao Gerado: ");

		return retorno.toString();
	}
	
}
