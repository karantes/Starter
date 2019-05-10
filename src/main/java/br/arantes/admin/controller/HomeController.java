package br.arantes.admin.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = "/home")
	public String showHome(Model model, Principal principal, HttpServletResponse response, HttpServletRequest request) {
		if (principal == null)
			return "redirect:/login.html?authenticate=false";

		return "home";
	}

}
