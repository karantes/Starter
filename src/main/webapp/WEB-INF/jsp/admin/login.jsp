<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<script>
	window.onload = function(e) {
		<c:if test="${param.error eq true}">
		alertaUsuarioIncorreto();
		</c:if>

		<c:if test="${param.passwordChange eq true}">
		alertaSenhaAlterada();
		</c:if>

		<c:if test="${param.authenticate eq false}">
		alertaFacaLogin();
		</c:if>
	}
</script>

<div class="app-content content">
	<div class="content-overlay"></div>
	<div class="content-wrapper">
		<div class="content-header row"></div>
		<div class="content-body">
			<section class="row flexbox-container">
				<div class="col-12 d-flex align-items-center justify-content-center">
					<div class="col-lg-4 col-md-8 col-10 box-shadow-2 p-0">
						<div class="card border-grey border-lighten-3 px-1 py-1 m-0">
							<div class="card-header border-0">
								<div class="card-title text-center">
									<img src="${pageContext.request.contextPath}/resources/stack-admin/app-assets/images/logo/stack-logo-dark.png" alt="branding logo">
								</div>
							</div>
							<div class="card-content">
								<p class="card-subtitle line-on-side text-muted text-center font-small-3 mx-2 my-1">
									<span>Facil Acesso</span>
								</p>
								<div class="card-body">
									<form class="form-horizontal" action='<spring:url value="/login"/>' method="post" novalidate>
										<fieldset class="form-group position-relative has-icon-left">
											<input type="number" class="form-control" id="username" name="username"
												value="${pageContext.request.session.getAttribute('username')}" placeholder="CPF/CNPJ" required>
											<div class="form-control-position">
												<i class="feather icon-user"></i>
											</div>
										</fieldset>
										<fieldset class="form-group position-relative has-icon-left">
											<input type="password" class="form-control" id="password" name="password"
												value="${pageContext.request.session.getAttribute('password')}" placeholder="Senha" required>
											<div class="form-control-position">
												<a onclick="showPassword()" style="color: #404e67;" href="javascript:void(0);"><i id="iconEye" class="fa fa-eye-slash"></i></a>
											</div>
										</fieldset>
										<div class="form-group row">
											<div class="col-sm-6 col-12 text-center text-sm-left pr-0"></div>
											<div class="col-sm-6 col-12 float-sm-left text-center text-sm-right">
												<a href='<spring:url value="/user-password-recovery.html"/>' class="card-link">Esqueci minha senha</a>
											</div>
										</div>
										<button type="submit" class="btn btn-outline-primary btn-block">
											<i class="feather icon-unlock"></i> Login
										</button>
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" class="form-control" />
									</form>
								</div>
								<p class="card-subtitle line-on-side text-muted text-center font-small-3 mx-2 my-1">
									<span>Novo Aqui ?</span>
								</p>
								<div class="card-body">
									<a href='<spring:url value="/user-register.html"/>' class="btn btn-outline-danger btn-block"><i class="feather icon-user"></i>
										Registrar</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>
</div>