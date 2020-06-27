package br.arantes.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.arantes.admin.entity.Funcionalidade;
import br.arantes.admin.repository.FuncionalidadeRepository;

@Service
public class FuncionalidadeService {

	@Autowired
	private FuncionalidadeRepository funcionalidadeRepository;

	public List<Funcionalidade> findAll() {
		return funcionalidadeRepository.findAll();
	}

	public Funcionalidade save(Funcionalidade funcionalidade) {
		return funcionalidadeRepository.save(funcionalidade);
	}

	public Funcionalidade findById(Integer id) {
		return funcionalidadeRepository.findById(id).orElse(null);
	}
}
