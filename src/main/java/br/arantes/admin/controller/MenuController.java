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
	public String showMenus(Model model, Principal principal, HttpServletRequest request, Authentication authentication) {
		try {
			if (principal == null)
				return "redirect:/login.html?authenticate=false";
			if (!roleService.isAuthenticated(principal.getName(), new Object() {
			}.getClass().getEnclosingMethod()))
				return "redirect:/error-403.html";

			model.addAttribute("menus", menuService.findAll());

			return "menus";
		} catch (Exception e) {
			e.printStackTrace();
			return "error-404";
		}
	}

	@RequestMapping(value = "/menu-register", method = RequestMethod.GET)
	public String showRegister(Model model, Principal principal, HttpServletRequest request, Authentication authentication) {
		try {
			if (principal == null)
				return "redirect:/login.html?authenticate=false";
			if (!roleService.isAuthenticated(principal.getName(), new Object() {
			}.getClass().getEnclosingMethod()))
				return "redirect:/error-403.html";

			model.addAttribute("menu", new Menu());
			model.addAttribute("funcionalidades", funcionalidadeService.findAll());

			return "menu-register";
		} catch (Exception e) {
			e.printStackTrace();
			return "error-404";
		}
	}

	@RequestMapping(value = "/menu-register", method = RequestMethod.POST)
	public String doRegister(Model model, Principal principal, HttpServletRequest request, Authentication authentication, @ModelAttribute Menu menu) {
		try {
			if (principal == null)
				return "redirect:/login.html?authenticate=false";
			if (!roleService.isAuthenticated(principal.getName(), new Object() {
			}.getClass().getEnclosingMethod()))
				return "redirect:/error-403.html";

			menuService.save(menu);

			return "redirect:/menus.html";
		} catch (Exception e) {
			e.printStackTrace();
			return "error-404";
		}
	}

	@RequestMapping(value = "/menu-update/{id}")
	public String showUpdate(Model model, Principal principal, HttpServletRequest request, Authentication authentication, @PathVariable Integer id) {
		try {
			if (principal == null)
				return "redirect:/login.html?authenticate=false";
			if (!roleService.isAuthenticated(principal.getName(), new Object() {
			}.getClass().getEnclosingMethod()))
				return "redirect:/error-403.html";

			model.addAttribute("menu", menuService.findById(id));
			model.addAttribute("funcionalidades", funcionalidadeService.findAll());

			return "menu-register";
		} catch (Exception e) {
			e.printStackTrace();
			return "error-404";
		}
	}

	@RequestMapping(value = "/delete-menu/{id}")
	public String doDelete(Model model, Principal principal, HttpServletRequest request, Authentication authentication, @PathVariable Integer id) {
		try {
			if (principal == null)
				return "redirect:/login.html?authenticate=false";
			if (!roleService.isAuthenticated(principal.getName(), new Object() {
			}.getClass().getEnclosingMethod()))
				return "redirect:/error-403.html";

			menuService.deleteById(id);

			return "redirect:/menus.html";
		} catch (Exception e) {
			e.printStackTrace();
			return "error-404";
		}
	}
}
