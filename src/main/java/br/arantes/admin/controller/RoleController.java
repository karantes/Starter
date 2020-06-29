package br.arantes.admin.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.arantes.admin.entity.Role;
import br.arantes.admin.service.MenuService;
import br.arantes.admin.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "/roles")
	public String showRoles(Model model, Principal principal, HttpServletRequest request, Authentication authentication) throws Exception {
		if (principal == null)
			return "redirect:/login.html?authenticate=false";
		if (!roleService.isAuthenticated(principal.getName(), new Object() {
		}.getClass().getEnclosingMethod()))
			throw new Exception("Usuario não Autorizado");

		model.addAttribute("roles", roleService.findAll());

		return "roles";
	}

	@RequestMapping(value = "/role-register", method = RequestMethod.GET)
	public String showRegister(Model model, Principal principal, HttpServletRequest request, Authentication authentication) throws Exception {
		if (principal == null)
			return "redirect:/login.html?authenticate=false";
		if (!roleService.isAuthenticated(principal.getName(), new Object() {
		}.getClass().getEnclosingMethod()))
			throw new Exception("Usuario não Autorizado");

		model.addAttribute("role", new Role());
		model.addAttribute("menus", menuService.findAll());

		return "menu-register";
	}

	@RequestMapping(value = "/role-register", method = RequestMethod.POST)
	public String doRegister(Model model, Principal principal, HttpServletRequest request, Authentication authentication, @ModelAttribute Role role) throws Exception {
		if (principal == null)
			return "redirect:/login.html?authenticate=false";
		if (!roleService.isAuthenticated(principal.getName(), new Object() {
		}.getClass().getEnclosingMethod()))
			throw new Exception("Usuario não Autorizado");

		roleService.save(role);
		
		roleService.findAll();

		return "redirect:/roles.html";
	}

	@RequestMapping(value = "/role-update/{id}")
	public String showUpdate(Model model, Principal principal, HttpServletRequest request, Authentication authentication, @PathVariable Integer id) throws Exception {
		if (principal == null)
			return "redirect:/login.html?authenticate=false";
		if (!roleService.isAuthenticated(principal.getName(), new Object() {
		}.getClass().getEnclosingMethod()))
			throw new Exception("Usuario não Autorizado");

		model.addAttribute("role", roleService.findById(id));
		model.addAttribute("menus", menuService.findAll());

		return "role-register";
	}

	@RequestMapping(value = "/delete-role/{id}")
	public String doDelete(Model model, Principal principal, HttpServletRequest request, Authentication authentication, @PathVariable Integer id) throws Exception {
		if (principal == null)
			return "redirect:/login.html?authenticate=false";
		if (!roleService.isAuthenticated(principal.getName(), new Object() {
		}.getClass().getEnclosingMethod()))
			throw new Exception("Usuario não Autorizado");

		roleService.deleteById(id);

		return "redirect:/roles.html";
	}
}
