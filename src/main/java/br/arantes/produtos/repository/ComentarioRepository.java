package br.arantes.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.arantes.produtos.entity.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

}
