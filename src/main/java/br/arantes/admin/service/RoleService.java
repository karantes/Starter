package br.arantes.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.arantes.admin.entity.Role;
import br.arantes.admin.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	public Role findOne(int id) {
		return roleRepository.findById(id).get();
	}

	public void save(Role role) {
		roleRepository.save(role);
	}

	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}

}
