package br.arantes.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.arantes.admin.entity.Role;
import br.arantes.admin.entity.User;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String name);

	@Query(value = "select u.roles from ADM_USERS u where u = ?1")
	List<Role> findByUser(User user);

}
