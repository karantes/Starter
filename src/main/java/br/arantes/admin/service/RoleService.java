package br.arantes.admin.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.arantes.admin.entity.Funcionalidade;
import br.arantes.admin.entity.Menu;
import br.arantes.admin.entity.Role;
import br.arantes.admin.entity.User;
import br.arantes.admin.repository.FuncionalidadeRepository;
import br.arantes.admin.repository.RoleRepository;
import br.arantes.admin.repository.UserRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FuncionalidadeRepository funcionalidadeRepository;

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

	public boolean isAuthenticated(String idLegal, Method method) {
		User user = userRepository.findByIdLegal(idLegal);
		boolean isAuthenticated = false;

		Annotation[] annotations = method.getAnnotations();
		List<Role> roles = roleRepository.findByUser(user);
		for (Annotation annotation : annotations)
			if (annotation instanceof RequestMapping) {
				RequestMapping req = (RequestMapping) annotation;

				RequestMethod requestMethod = null;
				try {
					requestMethod = RequestMethod.valueOf(req.method()[0].name());
				} catch (Exception e) {
				}

				Funcionalidade funcionalidade = funcionalidadeRepository.findByValueAndMethod(req.value()[0], requestMethod);

				for (Role role : roles)
					for (Menu menu : role.getMenus())
						for (Funcionalidade f : menu.getFuncionalidades())
							if (f.equals(funcionalidade)) {
								isAuthenticated = true;
								break;
							}

			}

		return isAuthenticated;
	}
}
