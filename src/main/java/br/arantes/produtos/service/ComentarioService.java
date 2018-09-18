package br.arantes.produtos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.arantes.produtos.entity.Comentario;
import br.arantes.produtos.repository.ComentarioRepository;

@Service
public class ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepository;

	public void save(Comentario comentario) {
		comentarioRepository.save(comentario);
	}

	public Comentario findOne(Integer id) {
		return comentarioRepository.findById(id).get();
	}

	public List<Comentario> findAll() {
		return comentarioRepository.findAll();
	}

	public void delete(Integer id) {
		comentarioRepository.deleteById(id);
	}

	public void delete(Comentario comentario) {
		comentarioRepository.delete(comentario);
	}
}
