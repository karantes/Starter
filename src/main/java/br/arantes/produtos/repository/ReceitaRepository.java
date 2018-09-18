package br.arantes.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.arantes.produtos.entity.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer> {

}
