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
	public String showHome(Model model, Principal principal, HttpServletRequest request, Authentication authentication) {
		try {
			if (principal == null)
				return "redirect:/login.html?authenticate=false";
			if (!roleService.isAuthenticated(principal.getName(), new Object() {
			}.getClass().getEnclosingMethod()))
				return "redirect:/error-403.html";

			return "home";
		} catch (Exception e) {
			e.printStackTrace();
			return "error-404";
		}
	}

}
