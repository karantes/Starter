package br.arantes.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.arantes.admin.entity.Role;
import br.arantes.admin.entity.User;
import br.arantes.admin.repository.UserRepository;

@Service
public class UserService {

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
}
