package br.arantes.produtos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.arantes.produtos.entity.Ingrediente;
import br.arantes.produtos.repository.IngredienteRepository;

@Service
public class IngredienteService {

	@Autowired
	private IngredienteRepository ingredienteRepository;

	public void save(Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);
	}

	public Ingrediente findOne(Integer id) {
		return ingredienteRepository.findById(id).get();
	}

	public List<Ingrediente> findAll() {
		return ingredienteRepository.findAll();
	}

	public void delete(Integer id) {
		ingredienteRepository.deleteById(id);
	}

	public void delete(Ingrediente ingrediente) {
		ingredienteRepository.delete(ingrediente);
	}
}
