package br.arantes.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.arantes.admin.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
