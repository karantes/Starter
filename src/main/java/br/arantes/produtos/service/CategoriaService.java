package br.arantes.produtos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.arantes.produtos.entity.Categoria;
import br.arantes.produtos.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;

	public void save(Categoria categoria) {
		categoriaRepository.save(categoria);
	}

	public Categoria findOne(Integer id) {
		return categoriaRepository.findById(id).get();
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public void delete(Integer id) {
		categoriaRepository.deleteById(id);
	}

	public void delete(Categoria categoria) {
		categoriaRepository.delete(categoria);
	}
}
