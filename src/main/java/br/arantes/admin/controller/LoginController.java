package br.arantes.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.arantes.admin.entity.AppConfiguration;
import br.arantes.admin.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/login")
	public String login(Model model) {
		userRepository.findAll().forEach(user -> {
			System.out.println(user.getEmail());
			System.out.println(user.getRoles().get(0).getName());
		});

		model.addAttribute("appName", AppConfiguration.getAppname());
		return "login";
	}

	@RequestMapping("/error-400")
	public String error400(Model model) {
		model.addAttribute("appName", AppConfiguration.getAppname());
		return "error-400";
	}

	@RequestMapping("/error-403")
	public String error403(Model model) {
		model.addAttribute("appName", AppConfiguration.getAppname());
		return "error-403";
	}

	@RequestMapping("/error-404")
	public String error404(Model model) {
		model.addAttribute("appName", AppConfiguration.getAppname());
		return "error-404";
	}

}
