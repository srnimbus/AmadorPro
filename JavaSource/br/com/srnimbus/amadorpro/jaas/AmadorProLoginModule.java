package br.com.srnimbus.amadorpro.jaas;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class AmadorProLoginModule implements LoginModule {

	private Subject subject;
	private CallbackHandler callbackHandler;
	private Map sharedState = Collections.<String, Object> emptyMap();
	private Map options = Collections.<String, Object> emptyMap();

	/**
	 * Typically, and definitely with the default Configuration, LoginModules
	 * are created using the default, n o argument constructor . As such,
	 * instead of performing instance initialization in the constructor , th e
	 * initialize() meth od should is used. Th e initialize meth od will be
	 * called before the LoginModule’s oth er meth ods are called. Four
	 * parameters are passed into the meth od:
	 * 
	 * public void initialize(Subject subject, CallbackHandler handler, Map
	 * sharedState, Map options)
	 * 
	 * A LoginModule implantation should store each of these items as private
	 * session state, as the oth er meth ods will need to access them . Each obj
	 * ect passed in is shared between all LoginModules in a LoginModule group ,
	 * so care must be taken n ot to ruin them for th e others, for example,
	 * removing all th e entries from the sharedState Map.
	 * 
	 */

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
		this.subject = subject;
		this.callbackHandler = callbackHandler;
		this.sharedState = sharedState;
		this.options = options;

	}

	/**
	 * Once the LoginModule has been initialized, the login() method is called.
	 * In this method, the LoginModule authenticates the user, but doesn ’t yet
	 * modify the Subject. The login() method implementation typically creates
	 * Callbacks, and passes them to the CallbackHanlder’s handle() method. Once
	 * the credentials are gathered, the login() method is responsible for
	 * verifying the credentials, for example, by comparing a username and
	 * password to those stored in a database.
	 * 
	 */

	private boolean authenticated;
	private String username;
	private String password;

	@Override
	public boolean login() throws LoginException {
		NameCallback nameCB = new NameCallback("Username");
		PasswordCallback passwordCB = new PasswordCallback("Password", false);
		Callback[] callbacks = new Callback[] { nameCB, passwordCB };
		try {
			callbackHandler.handle(callbacks);
		} catch (IOException e) {
			LoginException ex = new LoginException("IOException logging in.");
			ex.initCause(e);
			throw ex;
		} catch (UnsupportedCallbackException e) {
			String className = e.getCallback().getClass().getName();
			LoginException ex = new LoginException(className + " is not a supported Callback.");
			ex.initCause(e);
			throw ex;
		}

		// Authenticate username/password
		username = nameCB.getName();
		password = String.valueOf(passwordCB.getPassword());

		//
		// TODO Aqui eu vou na base de dados e digo se a autenticacao funcionou
		//

		if (username.equals("user") && password.equals("pass")) {
			authenticated = true;
		} else {
			authenticated = false;
		}

		return authenticated;
	}

	/**
	 * If th e Subject has authenticated as required by the LoginModule group ’s
	 * collective control flags, the commit() meth od will be called on each
	 * LoginModule. Th e abort() meth od is called if authentication didn ’t
	 * succeed. For examp le, if there are 3 LoginModules in a LoginModule
	 * group, one required, and two optional, as long as the required
	 * LoginModule returns true from login(), the auth entication process will
	 * call commit()on each LoginModule, regardless of the op tional
	 * LoginModules success.
	 * 
	 */

	private Set<?> principalsAdded;

	@Override
	public boolean commit() throws LoginException {
		//remover os principals.
		
		if (!authenticated) {
			// LOGGER.logp(Level.FINEST, CLASS_NAME, "commit()",
			// "{0} not authenticated.", getUsername());
			return false;
		}
		// set credential
		// DbUsernameCredential cred = new DbUsernameCredential(userId,
		// username);
		// subject.getPublicCredentials().add(cred);
		// lookup user groups, add to Subject
		// Set principals = lookupGroups(username);
		// LOGGER.logp(Level.FINEST, CLASS_NAME, "commit()",
		// "Loaded Principals {0}", principals);
		// subject.getPrincipals().addAll(principals);
		// principalsAdded = new HashSet();
		// principalsAdded.addAll(principals);
		return true;
	}

	/**
	 * Th e abort meth od is called when overall authentication fails. In th e
	 * abort() meth od y ou should cleanup any member fields to remove state,
	 * and prevent malicious code from accessing p otentially sensitive in
	 * formation . If an error occurs, abort() can throw a LoginException.
	 * 
	 */

	@Override
	public boolean abort() throws LoginException {
		username = null;
		password = null;
		authenticated = false;
		return false;
	}

	/**
	 * Th e logout() method is called when the LoginContext’s logout() method is
	 * called. This is usually done much after the login()/commit()/abort()
	 * cycle. A LoginModule’s logout() method should remove any Principals and
	 * credentials it added to the Subject.
	 * 
	 */

	@Override
	public boolean logout() throws LoginException {
		if (principalsAdded != null && !principalsAdded.isEmpty()) {
			subject.getPrincipals().removeAll(principalsAdded);
		}
		return true;
	}

}
