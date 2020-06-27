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

import br.arantes.admin.entity.Funcionalidade;
import br.arantes.admin.service.FuncionalidadeService;
import br.arantes.admin.service.RoleService;

@Controller
public class FuncionalidadeController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private FuncionalidadeService funcionalidadeService;

	@RequestMapping(value = "/funcionalidades")
	public String showFuncionalidades(Model model, Principal principal, HttpServletRequest request, Authentication authentication) {
		try {
			if (principal == null)
				return "redirect:/login.html?authenticate=false";
			if (!roleService.isAuthenticated(principal.getName(), new Object() {
			}.getClass().getEnclosingMethod()))
				return "redirect:/error-403.html";

			model.addAttribute("funcionalidades", funcionalidadeService.findAll());

			return "funcionalidades";
		} catch (Exception e) {
			e.printStackTrace();
			return "error-404";
		}
	}

	@RequestMapping(value = "/funcionalidade-register", method = RequestMethod.GET)
	public String showRegister(Model model, Principal principal, HttpServletRequest request, Authentication authentication) {
		try {
			if (principal == null)
				return "redirect:/login.html?authenticate=false";
			if (!roleService.isAuthenticated(principal.getName(), new Object() {
			}.getClass().getEnclosingMethod()))
				return "redirect:/error-403.html";

			model.addAttribute("funcionalidade", new Funcionalidade());
			model.addAttribute("methods", RequestMethod.values());

			return "funcionalidade-register";
		} catch (Exception e) {
			e.printStackTrace();
			return "error-404";
		}
	}

	@RequestMapping(value = "/funcionalidade-register", method = RequestMethod.POST)
	public String doRegister(Model model, Principal principal, HttpServletRequest request, Authentication authentication, @ModelAttribute Funcionalidade funcionalidade) {
		try {
			if (principal == null)
				return "redirect:/login.html?authenticate=false";
			if (!roleService.isAuthenticated(principal.getName(), new Object() {
			}.getClass().getEnclosingMethod()))
				return "redirect:/error-403.html";

			funcionalidadeService.save(funcionalidade);

			return "redirect:/funcionalidades.html";
		} catch (Exception e) {
			e.printStackTrace();
			return "error-404";
		}
	}

	@RequestMapping(value = "/funcionalidade-update/{id}")
	public String showUpdate(Model model, Principal principal, HttpServletRequest request, Authentication authentication, @PathVariable Integer id) {
		try {
			if (principal == null)
				return "redirect:/login.html?authenticate=false";
			if (!roleService.isAuthenticated(principal.getName(), new Object() {
			}.getClass().getEnclosingMethod()))
				return "redirect:/error-403.html";

			model.addAttribute("funcionalidade", funcionalidadeService.findById(id));
			model.addAttribute("methods", RequestMethod.values());

			return "funcionalidade-register";
		} catch (Exception e) {
			e.printStackTrace();
			return "error-404";
		}
	}
}
