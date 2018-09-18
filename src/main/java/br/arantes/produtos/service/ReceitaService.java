package br.arantes.produtos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.arantes.produtos.entity.Receita;
import br.arantes.produtos.repository.ReceitaRepository;

@Service
public class ReceitaService {

	@Autowired
	private ReceitaRepository receitaRepository;

	public void save(Receita receita) {
		receitaRepository.save(receita);
	}

	public Receita findOne(Integer id) {
		return receitaRepository.findById(id).get();
	}

	public List<Receita> findAll() {
		return receitaRepository.findAll();
	}

	public void delete(Integer id) {
		receitaRepository.deleteById(id);
	}

	public void delete(Receita receita) {
		receitaRepository.delete(receita);
	}
}
