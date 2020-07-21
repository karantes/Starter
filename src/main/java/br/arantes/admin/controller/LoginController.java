package br.arantes.admin.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.arantes.admin.entity.User;
import br.arantes.admin.service.RoleService;
import br.arantes.admin.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@RequestMapping(value = "/login-register", method = RequestMethod.GET)
	public String showRegister(Model model) {
		model.addAttribute("user", new User());
		return "login-register";
	}

	@RequestMapping(value = "/login-register", method = RequestMethod.POST)
	public String doRegister(Model model, Principal principal, HttpServletRequest request, Authentication authentication, @ModelAttribute User user) throws Exception {

		user.setFirstTimeLogin(false);
		user.setEnabled(true);
		user.setDtCadastro(LocalDateTime.now());
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setRoles(Arrays.asList(roleService.findByName("ROLE_USER")));

		userService.save(user);

		return "redirect:/login.html";

	}

}
