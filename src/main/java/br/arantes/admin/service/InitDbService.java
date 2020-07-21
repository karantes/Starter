package br.arantes.admin.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import br.arantes.admin.entity.Funcionalidade;
import br.arantes.admin.entity.Menu;
import br.arantes.admin.entity.Role;
import br.arantes.admin.entity.User;
import br.arantes.admin.repository.FuncionalidadeRepository;
import br.arantes.admin.repository.MenuRepository;
import br.arantes.admin.repository.RoleRepository;
import br.arantes.admin.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	private FuncionalidadeRepository funcionalidadeRepository;

	@PostConstruct
	public void init() {
		if (userRepository.count() == 0)
			initUsers();

	}

	private void initUsers() {
		List<Funcionalidade> funcionalidades = initFuncionalidades();

		Menu menuAdmin = initMenus(funcionalidades);

		Role adminRole = initRoles(menuAdmin);

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		User kaique = new User();
		kaique.setName("Kaique Arantes Costa");
		kaique.setDtCadastro(LocalDateTime.now());
		kaique.setIdLegal("123456789");
		kaique.setEmail("kaiquearantes@hotmail.com");
		kaique.setEnabled(true);
		kaique.setFirstTimeLogin(true);
		kaique.setPassword(encoder.encode("1234"));
		kaique.setRoles(Arrays.asList(adminRole));

		userRepository.save(kaique);

	}

	private Role initRoles(Menu menuAdmin) {
		Role adminRole;
		adminRole = new Role();
		adminRole.setName("ROLE_ADMIN");
		adminRole.setMenus(Arrays.asList(menuAdmin));
		roleRepository.save(adminRole);

		Role userRole;
		userRole = new Role();
		userRole.setName("ROLE_USER");
		roleRepository.save(userRole);

		return adminRole;
	}

	private Menu initMenus(List<Funcionalidade> funcionalidades) {
		Menu menuAdmin = new Menu();
		menuAdmin.setName("ADMIN");
		menuAdmin.setFuncionalidades(funcionalidades);
		return menuRepository.save(menuAdmin);
	}

	private List<Funcionalidade> initFuncionalidades() {
		List<Funcionalidade> listaFuncionalidades = new ArrayList<>();

		Funcionalidade home = new Funcionalidade();
		home.setMethod(null);
		home.setAtivo(true);
		home.setName("HOME");
		home.setValue("/home");
		listaFuncionalidades.add(funcionalidadeRepository.save(home));

//		FUNCIONALIDADE
		Funcionalidade funcionalidades = new Funcionalidade();
		funcionalidades.setMethod(null);
		funcionalidades.setAtivo(true);
		funcionalidades.setName("FUNCIONALIDADES");
		funcionalidades.setValue("/funcionalidades");
		listaFuncionalidades.add(funcionalidadeRepository.save(funcionalidades));

		Funcionalidade funcionalidadeShowRegister = new Funcionalidade();
		funcionalidadeShowRegister.setMethod(RequestMethod.GET);
		funcionalidadeShowRegister.setAtivo(true);
		funcionalidadeShowRegister.setName("CADASTRAR NOVA FUNCIONALIDADE");
		funcionalidadeShowRegister.setValue("/funcionalidade-register");
		listaFuncionalidades.add(funcionalidadeRepository.save(funcionalidadeShowRegister));

		Funcionalidade funcionalidadeDoRegister = new Funcionalidade();
		funcionalidadeDoRegister.setMethod(RequestMethod.POST);
		funcionalidadeDoRegister.setAtivo(true);
		funcionalidadeDoRegister.setName("SALVAR FUNCIONALIDADE");
		funcionalidadeDoRegister.setValue("/funcionalidade-register");
		listaFuncionalidades.add(funcionalidadeRepository.save(funcionalidadeDoRegister));

		Funcionalidade funcionalidadeUpdate = new Funcionalidade();
		funcionalidadeUpdate.setMethod(null);
		funcionalidadeUpdate.setAtivo(true);
		funcionalidadeUpdate.setName("ATUALIZAR FUNCIONALIDADE");
		funcionalidadeUpdate.setValue("/funcionalidade-update/{id}");
		listaFuncionalidades.add(funcionalidadeRepository.save(funcionalidadeUpdate));

		Funcionalidade funcionalidadeDelete = new Funcionalidade();
		funcionalidadeDelete.setMethod(null);
		funcionalidadeDelete.setAtivo(true);
		funcionalidadeDelete.setName("APAGAR FUNCIONALIDADE");
		funcionalidadeDelete.setValue("/delete-funcionalidade/{id}");
		listaFuncionalidades.add(funcionalidadeRepository.save(funcionalidadeDelete));

//		MENU
		Funcionalidade menus = new Funcionalidade();
		menus.setMethod(null);
		menus.setAtivo(true);
		menus.setName("MENUS");
		menus.setValue("/menus");
		listaFuncionalidades.add(funcionalidadeRepository.save(menus));

		Funcionalidade menuShowRegister = new Funcionalidade();
		menuShowRegister.setMethod(RequestMethod.GET);
		menuShowRegister.setAtivo(true);
		menuShowRegister.setName("CADASTRAR NOVO MENU");
		menuShowRegister.setValue("/menu-register");
		listaFuncionalidades.add(funcionalidadeRepository.save(menuShowRegister));

		Funcionalidade menuDoRegister = new Funcionalidade();
		menuDoRegister.setMethod(RequestMethod.POST);
		menuDoRegister.setAtivo(true);
		menuDoRegister.setName("SALVAR MENU");
		menuDoRegister.setValue("/menu-register");
		listaFuncionalidades.add(funcionalidadeRepository.save(menuDoRegister));

		Funcionalidade menuUpdate = new Funcionalidade();
		menuUpdate.setMethod(null);
		menuUpdate.setAtivo(true);
		menuUpdate.setName("ATUALIZAR MENU");
		menuUpdate.setValue("/menu-update/{id}");
		listaFuncionalidades.add(funcionalidadeRepository.save(menuUpdate));

		Funcionalidade menuDelete = new Funcionalidade();
		menuDelete.setMethod(null);
		menuDelete.setAtivo(true);
		menuDelete.setName("APAGAR MENU");
		menuDelete.setValue("/delete-menu/{id}");
		listaFuncionalidades.add(funcionalidadeRepository.save(menuDelete));

//		ROLE
		Funcionalidade roles = new Funcionalidade();
		roles.setMethod(null);
		roles.setAtivo(true);
		roles.setName("ROLES");
		roles.setValue("/roles");
		listaFuncionalidades.add(funcionalidadeRepository.save(roles));

		Funcionalidade roleShowRegister = new Funcionalidade();
		roleShowRegister.setMethod(RequestMethod.GET);
		roleShowRegister.setAtivo(true);
		roleShowRegister.setName("CADASTRAR NOVA PERMISSÃO");
		roleShowRegister.setValue("/role-register");
		listaFuncionalidades.add(funcionalidadeRepository.save(roleShowRegister));

		Funcionalidade roleDoRegister = new Funcionalidade();
		roleDoRegister.setMethod(RequestMethod.POST);
		roleDoRegister.setAtivo(true);
		roleDoRegister.setName("SALVAR PERMISSÃO");
		roleDoRegister.setValue("/role-register");
		listaFuncionalidades.add(funcionalidadeRepository.save(roleDoRegister));

		Funcionalidade roleUpdate = new Funcionalidade();
		roleUpdate.setMethod(null);
		roleUpdate.setAtivo(true);
		roleUpdate.setName("ATUALIZAR PERMISSÃO");
		roleUpdate.setValue("/role-update/{id}");
		listaFuncionalidades.add(funcionalidadeRepository.save(roleUpdate));

		Funcionalidade roleDelete = new Funcionalidade();
		roleDelete.setMethod(null);
		roleDelete.setAtivo(true);
		roleDelete.setName("APAGAR PERMISSÃO");
		roleDelete.setValue("/delete-role/{id}");
		listaFuncionalidades.add(funcionalidadeRepository.save(roleDelete));

//		USER
		Funcionalidade users = new Funcionalidade();
		users.setMethod(null);
		users.setAtivo(true);
		users.setName("USUÁRIOS");
		users.setValue("/users");
		listaFuncionalidades.add(funcionalidadeRepository.save(users));

		Funcionalidade userShowRegister = new Funcionalidade();
		userShowRegister.setMethod(RequestMethod.GET);
		userShowRegister.setAtivo(true);
		userShowRegister.setName("CADASTRAR NOVO USUÁRIO");
		userShowRegister.setValue("/user-register");
		listaFuncionalidades.add(funcionalidadeRepository.save(userShowRegister));

		Funcionalidade userDoRegister = new Funcionalidade();
		userDoRegister.setMethod(RequestMethod.POST);
		userDoRegister.setAtivo(true);
		userDoRegister.setName("SALVAR USUÁRIO");
		userDoRegister.setValue("/user-register");
		listaFuncionalidades.add(funcionalidadeRepository.save(userDoRegister));

		Funcionalidade userUpdate = new Funcionalidade();
		userUpdate.setMethod(null);
		userUpdate.setAtivo(true);
		userUpdate.setName("ATUALIZAR USUÁRIO");
		userUpdate.setValue("/user-update/{id}");
		listaFuncionalidades.add(funcionalidadeRepository.save(userUpdate));

		return listaFuncionalidades;
	}

}
