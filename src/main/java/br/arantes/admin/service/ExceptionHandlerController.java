package br.arantes.admin.service;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(Exception.class)
	public ModelAndView trataExceptionGenerica(Exception exception) {
		System.out.println("Erro genérico acontecendo");
		exception.printStackTrace();

		ModelAndView modelAndView = new ModelAndView("error-404");
		modelAndView.addObject("exception", exception);

		return modelAndView;
	}
}
