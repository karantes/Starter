package br.arantes.admin.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.arantes.admin.service.RoleService;

@Controller
public class HomeController {

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/home")
	public String showHome(Model model, Principal principal, HttpServletRequest request, Authentication authentication) throws Exception {
		if (principal == null)
			return "redirect:/login?authenticate=false";
		if (!roleService.isAuthenticated(principal.getName(), new Object() {
		}.getClass().getEnclosingMethod()))
			throw new Exception("Usuario não Autorizado");

		return "home";
	}

}
