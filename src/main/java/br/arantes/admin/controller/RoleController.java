package br.arantes.admin.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.arantes.admin.service.RoleService;

@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "roles")
	public String showRoles(Model model, Principal principal) {
		try {
//			if (principal == null)
//				return "redirect:/login.html?authenticate=false";

			model.addAttribute("roles", roleService.findAll());
			return "roles";

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/error-403.html";
		}
	}
}
