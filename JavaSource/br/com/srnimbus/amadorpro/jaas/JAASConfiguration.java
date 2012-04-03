package br.com.srnimbus.amadorpro.jaas;

import java.util.Collections;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.AppConfigurationEntry.LoginModuleControlFlag;
import javax.security.auth.login.Configuration;

public class JAASConfiguration extends Configuration {

	private static JAASConfiguration config;

	public static void init() {
		config = new JAASConfiguration();
		Configuration.setConfiguration(config);
	}

	/**
	o   required –  the  LoginModule must  succeed.  Th at  is, it  must  return  true  from  the 
        login() method.       However,    regardless  of  success,   the  LoginContext continues 
        calling the login()method on the rest of the LoginModules. 
    o   requisite –  the LoginModule must  succeed: it  must return  true from  the  login() 
        method.    Unlike    required  LoginModules, the failure   of a requisite 
        LoginModule prevents th e  login() meth od of th e remaining LoginModules from 
        being called. 
    o   sufficient –  the LoginModule isn ’t  required to succeed. But, if it does succeed, no 
        other  LoginModules  are  called.  Th at  is, once  a  sufficient LoginModule returns 
        true from it ’s login()meth od, n o oth er login()meth ods will be called. 
    o   optional –      success    isn ’t required   for  optional LoginModules. Whether  an 
        optional LoginModule is successful or  fails, the  authentication  still goes down the 
        stack .
	 */
	
	@Override
	public AppConfigurationEntry[] getAppConfigurationEntry(String name) {

		final String loginModuleName = AmadorProLoginModule.class.getName();
		AppConfigurationEntry[] entrys = null;

		if (name.equals(AmadorProLoginModule.class.getName())) {
			AppConfigurationEntry entry = new AppConfigurationEntry(loginModuleName, LoginModuleControlFlag.REQUIRED,
					Collections.<String, Object> emptyMap());
			entrys = new AppConfigurationEntry[] { entry };
		}
		return entrys;
	}

}
