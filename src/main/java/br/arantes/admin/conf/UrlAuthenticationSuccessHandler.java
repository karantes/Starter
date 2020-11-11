package br.arantes.admin.conf;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.transaction.annotation.Transactional;

import br.arantes.admin.service.UserService;

public class UrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private UserService userService;

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	@Transactional
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		handle(request, response, authentication);
		clearAuthenticationAttributes(request, authentication);
	}

	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		String targetUrl = determineTargetUrl(authentication);

		if (response.isCommitted())
			return;

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	/**
	 * Builds the target URL according to the logic defined in the main class Javadoc.
	 */
	protected String determineTargetUrl(Authentication authentication) {
		return "/home";
	}

	protected void clearAuthenticationAttributes(HttpServletRequest request, Authentication authentication) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		session.setAttribute("usuarioLogado", userService.findByIdLegal(authentication.getName()));
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
}
