<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="app-content content" style="background-color: white;">
	<div class="content-overlay"></div>
	<div class="content-wrapper">
		<div class="content-header row"></div>
		<div class="content-body">
			<section class="flexbox-container">
			<div class="col-12 d-flex align-items-center justify-content-center">
				<div class="col-md-6 col-10 p-0">
					<div class="card-header bg-transparent border-0">
						<h1 class="error-code text-center mb-2">
							<b>ERRO</b>
						</h1>
						<h2 class="error-code text-center mb-2">
							<b>${url }</b>
						</h2>
						<h3 class="text-uppercase text-center">${errorMsg }</h3>
					</div>
					<div class="card-content">
						<div class="row py-2">
							<div class="col-12 col-sm-6 col-md-6 mb-1">
								<a href='<spring:url value="/home.html"/>' class="btn btn-primary btn-block"><i class="feather icon-home"></i> Home</a>
							</div>
							<div class="col-12 col-sm-6 col-md-6 mb-1">
								<a href="#" onclick="window.history.back();" class="btn btn-danger btn-block"><i class="feather icon-rewind"></i> Voltar</a>
							</div>
						</div>
					</div>
					<div class="card-footer bg-transparent">
						<div class="row">
							<div class="col-12 text-center">
								<a target="_blank" href="https://facebook.com/kaiquearantes" class="btn btn-social-icon mr-1 mb-1 btn-outline-facebook"><span
									class="fa fa-facebook"> </span></a> <a target="_blank" href="https://twitter.com/_karantes"
									class="btn btn-social-icon mr-1 mb-1 btn-outline-twitter"> <span class="fa fa-twitter"> </span></a> <a target="_blank"
									href="https://linkedin.com/in/kaique-arantes" class="btn btn-social-icon mr-1 mb-1 btn-outline-linkedin"><span
									class="fa fa-linkedin font-medium-4"></span></a> <a target="_blank" href="https://github.com/karantes/"
									class="btn btn-social-icon mr-1 mb-1 btn-outline-github"> <span class="fa fa-github font-medium-4"> </span></a>
							</div>
						</div>
					</div>
				</div>
			</div>
			</section>

		</div>
	</div>
</div>