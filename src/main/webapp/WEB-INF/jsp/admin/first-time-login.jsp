<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<script type="text/javascript">
	$(function() {
		$('#formLogin').submit(function(event) { 
			if ($('#password').val() != $('#confPassword').val()) {
				swal("Atenção!", "Senhas Diferentes!", "error");
				event.preventDefault();
			} 
		});
	});
</script>

<div class="col-lg-4 col-md-8 col-md-10 box-shadow-2 p-0">

	<div class="card border-grey border-lighten-3 px-1 py-1 m-0">
		<div class="card-header border-0">
			<div class="card-title text-center">
				<a href="${pageContext.request.contextPath}/login"><img src="${pageContext.request.contextPath}/resources/images/Chronos Vertical.png" style="width: 150px; height: 150px;" alt="branding logo"></a>
				<h6 class="card-subtitle line-on-side text-muted text-center font-small-3 pt-2">
					<span>Atualização de senha</span>
				</h6>
			</div>
		</div>

		<div class="card-content">
			<div class="card-body">
				<form class="form-horizontal" action='<spring:url value="/first-time-login"/>' id="formLogin" method="post" novalidate>
					<input type="hidden" name="id" id="id" value="${user.id}">

					<fieldset class="form-group position-relative has-icon-left">
						<input type="password" class="form-control" id="password" name="password" placeholder="Senha" required>
						<div class="form-control-position">
							<i class="fa fa-key"></i>
						</div>
					</fieldset>
					<fieldset class="form-group position-relative has-icon-left">
						<input type="password" class="form-control" id="confPassword" name="confPassword" placeholder="Confirm. Senha" required>
						<div class="form-control-position">
							<i class="fa fa-key"></i>
						</div>
					</fieldset>
					<button type="submit" class="btn btn-outline-primary btn-block">Enviar</button>
				</form>
			</div>
		</div>
	</div>
</div>