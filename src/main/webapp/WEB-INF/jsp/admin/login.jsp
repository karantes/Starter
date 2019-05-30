<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<div class="app-content content">
	<div class="content-wrapper">
		<div class="content-header row"></div>
		<div class="content-body">
			<section class="flexbox-container">
				<div class="col-12 d-flex align-items-center justify-content-center">
					<div class="col-lg-4 col-md-8 col-10 box-shadow-2 p-0">
						<div class="card border-grey border-lighten-3 m-0">
							<div class="card-header border-0">
								<div class="card-title text-center">
									<div class="p-1">
										<img class="brand-logo" src="/resources/stack-admin/app-assets/images/logo/stack-logo.png" alt="branding logo">Starter Project
									</div>
								</div>
								<h6 class="card-subtitle line-on-side text-muted text-center font-small-3 pt-2">
									<span>Facil Acesso</span>
								</h6>
							</div>
							<div class="card-content">
								<div class="card-body pt-0">
									<form class="form-horizontal" action="#">
										<fieldset class="form-group floating-label-form-group">
											<input type="text" class="form-control" id="username" name="username" placeholder="Usuário">
										</fieldset>
										<fieldset class="form-group floating-label-form-group mb-1">
											<input type="password" class="form-control" id="password" name="password" placeholder="Senha">
										</fieldset>
										<div class="form-group row pull-right">
											<div class="col-sm-12 col-12">
												<a href="#" class="card-link">Esqueceu a senha?</a>
											</div>
										</div>
										<button type="submit" class="btn btn-outline-primary btn-block">
											<i class="ft-unlock"></i> Entrar
										</button>
									</form>
								</div>
								<p class="card-subtitle line-on-side text-muted text-center font-small-3 mx-2 my-1">
									<span>Novo aqui ?</span>
								</p>
								<div class="card-body">
									<a href="#" class="btn btn-outline-danger btn-block"><i class="ft-user"></i> Registrar</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>

		</div>
	</div>
</div>