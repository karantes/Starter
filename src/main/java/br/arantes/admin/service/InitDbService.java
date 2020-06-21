package br.arantes.admin.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		User kaique = new User();
		kaique.setName("Kaique Arantes Costa");
		kaique.setDtCadastro(LocalDateTime.now());
		kaique.setIdLegal("123456789");
		kaique.setEmail("kaiquearantes@hotmail.com");
		kaique.setEnabled(true);
		kaique.setFirstTimeLogin(true);
		kaique.setPassword(encoder.encode("1234"));
		kaique.setRoles(rolesAdmin);

		userRepository.save(kaique);

	}

}
