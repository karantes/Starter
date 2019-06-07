package br.arantes.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.arantes.admin.entity.Role;
import br.arantes.admin.entity.User;
import br.arantes.admin.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findById(id).get();
	}

	public void save(User user) {
		userRepository.save(user);
	}

	public List<User> findByRoles(Role role) {
		return userRepository.findByRoles(role);
	}

	public User findByCpf(String cpf) {
		return userRepository.findByIdLegal(cpf);
	}

	public User loadUserByUsername(String idLegal) {
		User user = userRepository.findByIdLegal(idLegal);
		if (user == null)
			throw new UsernameNotFoundException("Usuario " + idLegal + " não encontrado");
		System.out.println(user.getPassword());
		return user;
	}
}
