package br.arantes.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.arantes.admin.entity.Menu;
import br.arantes.admin.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	private MenuRepository menuRepository;

	public Menu save(Menu menu) {
		return menuRepository.save(menu);
	}

	public Menu findById(Integer id) {
		return menuRepository.findById(id).orElse(null);
	}

	public List<Menu> findAll() {
		return menuRepository.findAll();
	}

	public void deleteById(Integer id) {
		menuRepository.deleteById(id);
	}
}
