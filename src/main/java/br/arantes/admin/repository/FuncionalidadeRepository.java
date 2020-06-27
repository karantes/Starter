package br.arantes.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMethod;

import br.arantes.admin.entity.Funcionalidade;

@Repository
public interface FuncionalidadeRepository extends JpaRepository<Funcionalidade, Integer> {

	Funcionalidade findByValueAndMethod(String string, RequestMethod requestMethod);

}
