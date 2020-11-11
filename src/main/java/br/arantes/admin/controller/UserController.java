package br.arantes.admin.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import br.arantes.admin.entity.User;
import br.arantes.admin.service.RoleService;
import br.arantes.admin.service.UserService;
import br.arantes.util.Mail;

@Controller
public class UserController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users")
	public String showRoles(Model model, Principal principal, HttpServletRequest request, Authentication authentication) throws Exception {
		if (principal == null)
			return "redirect:/login?authenticate=false";
		if (!roleService.isAuthenticated(principal.getName(), new Object() {
		}.getClass().getEnclosingMethod()))
			throw new Exception("Usuario não Autorizado");

		model.addAttribute("users", userService.findAll());

		return "users";
	}

	@RequestMapping(value = "/user-register", method = RequestMethod.GET)
	public String showRegister(Model model, Principal principal, HttpServletRequest request, Authentication authentication) throws Exception {
		if (principal == null)
			return "redirect:/login?authenticate=false";
		if (!roleService.isAuthenticated(principal.getName(), new Object() {
		}.getClass().getEnclosingMethod()))
			throw new Exception("Usuario não Autorizado");

		model.addAttribute("user", new User());
		model.addAttribute("roles", roleService.findAll());

		return "user-register";
	}

	@RequestMapping(value = "/user-register", method = RequestMethod.POST)
	public String doRegister(	Model model, Principal principal, HttpServletRequest request, Authentication authentication, @ModelAttribute User user, @RequestParam(required = false) String psWord,
								@RequestParam(required = false) List<Integer> idRoles) throws Exception {
		if (principal == null)
			return "redirect:/login?authenticate=false";
		boolean isAdmin = roleService.isAuthenticated(principal.getName(), new Object() {
		}.getClass().getEnclosingMethod());
		if (!isAdmin && !user.getIdLegal().equals(principal.getName()))
			throw new Exception("Usuario não Autorizado");

		boolean isRegister = user.getId() == null;
		if (isRegister) {
			isRegister = true;
			user.setFirstTimeLogin(true);
			user.setDtCadastro(LocalDateTime.now());
		} else {
			user.setDtAlteracao(LocalDateTime.now());
		}

		if (psWord != null && !psWord.isEmpty()) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(psWord));
		}

		if (idRoles != null)
			user.setRoles(roleService.findByIdIn(idRoles));

		userService.save(user);

		if (isAdmin)
			return "redirect:/users";
		else
			return "redirect:/home";

	}

	@RequestMapping(value = "/user-update/{id}")
	public String showUpdate(Model model, Principal principal, HttpServletRequest request, Authentication authentication, @PathVariable Integer id) throws Exception {
		if (principal == null)
			return "redirect:/login?authenticate=false";
		if (!roleService.isAuthenticated(principal.getName(), new Object() {
		}.getClass().getEnclosingMethod()))
			throw new Exception("Usuario não Autorizado");

		model.addAttribute("user", userService.findById(id));
		model.addAttribute("roles", roleService.findAll());

		return "user-register";
	}

	@RequestMapping(value = "/user-password-recovery", method = RequestMethod.GET)
	public String showPasswordRecovery(Model model, Principal principal, HttpServletRequest request) {

		return "user-password-recovery";
	}

	@RequestMapping(value = "/user-password-recovery", method = RequestMethod.POST)
	public String doPasswordRecovery(Model model, Principal principal, HttpServletRequest request, @RequestParam String idLegal) {
		String token = UUID.randomUUID().toString().toUpperCase().substring(0, 6);

		User user = userService.findByIdLegal(idLegal);
		user.setToken(token);

		userService.save(user);

		new Mail().sendMailPasswordRecovery(user, token);

		return "redirect:/user-has-token?idLegal=" + idLegal;
	}

	@RequestMapping(value = "/user-has-token", method = RequestMethod.GET)
	public String showUserHasToken(Model model, Principal principal, HttpServletRequest request, @RequestParam(defaultValue = "") String idLegal) {
		model.addAttribute("idLegal", idLegal);
		return "user-has-token";
	}

	@RequestMapping(value = "/user-has-token", method = RequestMethod.POST)
	public String doUserHasToken(Model model, Principal principal, HttpServletRequest request, @RequestParam String idLegal, @RequestParam String token, @RequestParam String password) {

		User user = userService.findByIdLegal(idLegal);

		if (!user.getToken().equalsIgnoreCase(token))
			return "redirect:/user-has-token?tokenWrong=true&idLegal=" + idLegal;

		user.setPassword(new BCryptPasswordEncoder().encode(password));
		userService.save(user);

		return "redirect:/login?passwordChange=true";
	}

	@RequestMapping(value = "/first-time-login/{id}", method = RequestMethod.GET)
	public String showFistTimeLogin(Model model, Principal principal, HttpServletRequest request, @PathVariable int id) {
		User user = userService.findById(id);

		if (user.getFirstTimeLogin()) {
			model.addAttribute("user", user);

			return "first-time-login";
		} else {
			return "redirect:/login";
		}

	}

	@RequestMapping(value = "/first-time-login", method = RequestMethod.POST)
	public String doFirstTimeLogin(Model model, Principal principal, HttpServletRequest request, @RequestParam int id, @RequestParam String password) {

		User user = userService.findById(id);

		if (user.getFirstTimeLogin()) {
			user.setPassword(new BCryptPasswordEncoder().encode(password));
			user.setFirstTimeLogin(false);
			userService.save(user);

			return "redirect:/login?passwordChange=true";
		}

		return "redirect:/login";
	}

	@ResponseBody
	@RequestMapping(value = "/ajax/busca-usuario", method = RequestMethod.POST)
	public String findUsers(Principal principal, @RequestParam(required = false) String idLegal, @RequestParam(required = false) String email, HttpServletRequest request) {
		User user = null;
		if (idLegal != null)
			user = userService.findByIdLegal(idLegal);
		else if (email != null)
			user = userService.findByEmail(email);
		return new Gson().toJson(user);
	}

}
