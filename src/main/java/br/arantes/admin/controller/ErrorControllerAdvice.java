package br.arantes.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControllerAdvice {

	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex, HttpServletRequest httpRequest, Model model) {

		model.addAttribute("errorMsg", ex.getMessage());
		model.addAttribute("url", httpRequest.getRequestURL());
		return "page_error";
	}

}
