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

import br.arantes.admin.entity.Menu;
import br.arantes.admin.service.FuncionalidadeService;
import br.arantes.admin.service.MenuService;
import br.arantes.admin.service.RoleService;

@Controller
public class MenuController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private FuncionalidadeService funcionalidadeService;

	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "/menus")
	public String showMenus(Model model, Principal principal, HttpServletRequest request, Authentication authentication) throws Exception {
		if (principal == null)
			return "redirect:/login.html?authenticate=false";
		if (!roleService.isAuthenticated(principal.getName(), new Object() {
		}.getClass().getEnclosingMethod()))
			throw new Exception("Usuario não Autorizado");

		model.addAttribute("menus", menuService.findAll());

		return "menus";
	}

	@RequestMapping(value = "/menu-register", method = RequestMethod.GET)
	public String showRegister(Model model, Principal principal, HttpServletRequest request, Authentication authentication) throws Exception {
		if (principal == null)
			return "redirect:/login.html?authenticate=false";
		if (!roleService.isAuthenticated(principal.getName(), new Object() {
		}.getClass().getEnclosingMethod()))
			throw new Exception("Usuario não Autorizado");

		model.addAttribute("menu", new Menu());
		model.addAttribute("funcionalidades", funcionalidadeService.findAll());

		return "menu-register";
	}

	@RequestMapping(value = "/menu-register", method = RequestMethod.POST)
	public String doRegister(Model model, Principal principal, HttpServletRequest request, Authentication authentication, @ModelAttribute Menu menu) throws Exception {
		if (principal == null)
			return "redirect:/login.html?authenticate=false";
		if (!roleService.isAuthenticated(principal.getName(), new Object() {
		}.getClass().getEnclosingMethod()))
			throw new Exception("Usuario não Autorizado");

		menuService.save(menu);

		return "redirect:/menus.html";
	}

	@RequestMapping(value = "/menu-update/{id}")
	public String showUpdate(Model model, Principal principal, HttpServletRequest request, Authentication authentication, @PathVariable Integer id) throws Exception {
		if (principal == null)
			return "redirect:/login.html?authenticate=false";
		if (!roleService.isAuthenticated(principal.getName(), new Object() {
		}.getClass().getEnclosingMethod()))
			throw new Exception("Usuario não Autorizado");

		model.addAttribute("menu", menuService.findById(id));
		model.addAttribute("funcionalidades", funcionalidadeService.findAll());

		return "menu-register";
	}

	@RequestMapping(value = "/delete-menu/{id}")
	public String doDelete(Model model, Principal principal, HttpServletRequest request, Authentication authentication, @PathVariable Integer id) throws Exception {
		if (principal == null)
			return "redirect:/login.html?authenticate=false";
		if (!roleService.isAuthenticated(principal.getName(), new Object() {
		}.getClass().getEnclosingMethod()))
			throw new Exception("Usuario não Autorizado");

		menuService.deleteById(id);

		return "redirect:/menus.html";
	}
}
