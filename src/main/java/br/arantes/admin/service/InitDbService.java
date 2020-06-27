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
		kaique.setRoles(Arrays.asList(roleRepository.save(adminRole)));

		userRepository.save(kaique);

	}

	private Role initRoles(Menu menuAdmin) {
		Role adminRole;
		adminRole = new Role();
		adminRole.setName("ROLE_ADMIN");
		adminRole.setMenus(Arrays.asList(menuRepository.save(menuAdmin)));
		return adminRole;
	}

	private Menu initMenus(List<Funcionalidade> funcionalidades) {
		Menu menuAdmin = new Menu();
		menuAdmin.setName("ADMIN");
		menuAdmin.setFuncionalidades(funcionalidades);
		return menuAdmin;
	}

	private List<Funcionalidade> initFuncionalidades() {
		List<Funcionalidade> listaFuncionalidades = new ArrayList<>();

		Funcionalidade home = new Funcionalidade();
		home.setMethod(null);
		home.setName("HOME");
		home.setValue("/home");
		listaFuncionalidades.add(funcionalidadeRepository.save(home));

		Funcionalidade roles = new Funcionalidade();
		roles.setMethod(null);
		roles.setName("PERMISSÕES");
		roles.setValue("/roles");
		listaFuncionalidades.add(funcionalidadeRepository.save(roles));

		Funcionalidade funcionalidades = new Funcionalidade();
		funcionalidades.setMethod(null);
		funcionalidades.setName("FUNCIONALIDADES");
		funcionalidades.setValue("/funcionalidades");
		listaFuncionalidades.add(funcionalidadeRepository.save(funcionalidades));

		Funcionalidade funcionalidadeShowRegister = new Funcionalidade();
		funcionalidadeShowRegister.setMethod(RequestMethod.GET);
		funcionalidadeShowRegister.setName("CADASTRAR NOVA FUNCIONALIDADE");
		funcionalidadeShowRegister.setValue("/funcionalidade-register");
		listaFuncionalidades.add(funcionalidadeRepository.save(funcionalidadeShowRegister));

		Funcionalidade funcionalidadeDoRegister = new Funcionalidade();
		funcionalidadeDoRegister.setMethod(RequestMethod.POST);
		funcionalidadeDoRegister.setName("SALVAR FUNCIONALIDADE");
		funcionalidadeDoRegister.setValue("/funcionalidade-register");
		listaFuncionalidades.add(funcionalidadeRepository.save(funcionalidadeDoRegister));

		Funcionalidade funcionalidadeUpdate = new Funcionalidade();
		funcionalidadeUpdate.setMethod(null);
		funcionalidadeUpdate.setName("ATUALIZAR FUNCIONALIDADE");
		funcionalidadeUpdate.setValue("/funcionalidade-update/{id}");
		listaFuncionalidades.add(funcionalidadeRepository.save(funcionalidadeUpdate));

		return listaFuncionalidades;
	}

}
