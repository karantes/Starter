<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="app-content content">
	<div class="content-overlay"></div>
	<div class="content-wrapper">
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-12 mb-2">
				<h3 class="content-header-title mb-0">Cadastro de Usuário</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href='<spring:url value="/home"/>'>Home</a></li>
							<li class="breadcrumb-item"><a href='<spring:url value="/users"/>'>Usuários</a></li>
							<li class="breadcrumb-item">Cadastro</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<div class="content-body">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title">Usuário</h4>
				</div>
				<div class="card-content">
					<div class="card-body">
						<form:form modelAttribute="user" action="${pageContext.request.contextPath}/login-register" method="post" id="formUser">
							<div class="row">
								<form:hidden path="id" />
								<div class="col-md-4">
									<div class="form-group">
										<label>Nome:</label> <br>
										<form:input type="text" path="name" class="form-control" required="required" />
									</div>
								</div>

								<div class="col-md-4">
									<div class="form-group">
										<label>CPF/CNPJ:</label> <br>
										<form:input type="number" path="idLegal" class="form-control" required="required" />
									</div>
								</div>

								<div class="col-md-4">
									<div class="form-group">
										<label>Email:</label> <br>
										<form:input type="email" path="email" class="form-control" required="required" />
									</div>
								</div>

								<div class="col-md-4">
									<div class="form-group">
										<label>Senha:</label> <br>
										<form:input type="password" path="password" class="form-control" required="required" />
									</div>
								</div>

								<div class="col-md-12">
									<button class="btn btn-block block-element btn-primary" style="width: auto;">Cadastrar</button>
								</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
