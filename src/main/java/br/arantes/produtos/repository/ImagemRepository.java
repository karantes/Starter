package br.arantes.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.arantes.produtos.entity.Imagem;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Integer> {

}
