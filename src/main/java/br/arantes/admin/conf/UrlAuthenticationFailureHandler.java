package br.arantes.admin.conf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class UrlAuthenticationFailureHandler implements AuthenticationFailureHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

		request.getSession().setAttribute("username", request.getParameter("username"));
		request.getSession().setAttribute("password", request.getParameter("password"));
		if (response.isCommitted())
			return;
		redirectStrategy.sendRedirect(request, response, "/login?error=true");
	}

}
