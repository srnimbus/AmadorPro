package br.com.srnimbus.amadorpro.jaas.filter;

import java.io.IOException;

import javax.security.auth.Subject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.srnimbus.amadorpro.jaas.Constants;
import br.com.srnimbus.amadorpro.jaas.LoginHelper;

//@WebFilter(urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		Subject subject = LoginHelper.getInstance().getSubject();
		if ((req.getRequestURI().indexOf("login") >= 0) || (subject != null && !subject.getPrincipals().isEmpty())) {
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect(Constants.LOGIN_PAGE);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}