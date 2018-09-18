package br.arantes.produtos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.arantes.produtos.entity.Imagem;
import br.arantes.produtos.repository.ImagemRepository;

@Service
public class ImagemService {

	@Autowired
	private ImagemRepository imagemRepository;

	public void save(Imagem imagem) {
		imagemRepository.save(imagem);
	}

	public Imagem findOne(Integer id) {
		return imagemRepository.findById(id).get();
	}

	public List<Imagem> findAll() {
		return imagemRepository.findAll();
	}

	public void delete(Integer id) {
		imagemRepository.deleteById(id);
	}

	public void delete(Imagem imagem) {
		imagemRepository.delete(imagem);
	}
}
