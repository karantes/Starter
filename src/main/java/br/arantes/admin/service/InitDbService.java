package br.arantes.admin.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.arantes.admin.entity.Role;
import br.arantes.admin.entity.User;
import br.arantes.admin.repository.RoleRepository;
import br.arantes.admin.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@PostConstruct
	public void init() {
		if (userRepository.count() == 0)
			usersTest();

	}

	private void usersTest() {
		Role adminRole;
		adminRole = new Role();
		adminRole.setName("ROLE_ADMIN");
		roleRepository.save(adminRole);

		List<Role> rolesAdmin = new ArrayList<Role>();
		rolesAdmin.add(adminRole);

		User admin = new User();
		admin.setName("Kaique Arantes Costa");
		admin.setDtCadastro(Calendar.getInstance());
		admin.setIdLegal("123456789");
		admin.setEmail("kaiquearantes@hotmail.com");
		admin.setEnabled(true);
		admin.setFirstTimeLogin(true);
		admin.setPassword("1234");
		admin.setRoles(rolesAdmin);

		userRepository.save(admin);

	}

}
