package br.arantes.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.arantes.admin.entity.Role;
import br.arantes.admin.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByRoles(Role role);

	User findByName(String name);

	User findByIdLegal(String cpf);

	@Query(value = "select u from ADM_USERS u where u.idLegal = ?1")
	User loadUserByUsername(String idLegal);

}
