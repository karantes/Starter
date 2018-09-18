package br.arantes.produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.arantes.produtos.service.CategoriaService;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping(value = "categorias", method = RequestMethod.GET)
	public String showCategorias(Model model) {	
		model.addAttribute("categorias", categoriaService.findAll());
		return "categorias";
	}
}
