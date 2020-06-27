package br.arantes.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

	@RequestMapping("/error-400")
	public String error400(Model model) {
		return "error-400";
	}

	@RequestMapping("/error-403")
	public String error403(Model model) {
		return "error-403";
	}

	@RequestMapping("/error-404")
	public String error404(Model model) {
		return "error-404";
	}

}
