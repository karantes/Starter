package br.arantes.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import br.arantes.admin.entity.Role;
import br.arantes.admin.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserDetailsService {

	List<User> findByRoles(Role role);

	User findByName(String name);

	User findByIdLegal(String cpf);

}
