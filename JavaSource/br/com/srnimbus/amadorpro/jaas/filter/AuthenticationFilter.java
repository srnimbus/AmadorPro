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

@WebFilter(urlPatterns = "/html/*")
public class AuthenticationFilter implements Filter {

	private final String LOGIN_PATTERN = "login";
	private final String INDEX_PATTERN = "index";
	private final String RESOURCE_PATTERN = "javax.faces.resource";

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String context = req.getContextPath();

		String uri = req.getRequestURI();

		boolean contextAuthorizer = uri.indexOf(LOGIN_PATTERN) >= 0
				|| uri.indexOf(RESOURCE_PATTERN) >= 0
				|| uri.indexOf(INDEX_PATTERN) >= 0;

		Subject subject = LoginHelper.getInstance().getSubject();
		if ((contextAuthorizer)
				|| (subject != null && !subject.getPrincipals().isEmpty())) {
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect(context + Constants.LOGIN_PAGE);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}