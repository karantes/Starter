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
						<form:form modelAttribute="user" action="${pageContext.request.contextPath}/user-register" method="post" id="formUser">
							<div class="row">
								<form:hidden path="id" />
								<form:hidden path="password" />
								<form:hidden path="dtCadastro" />
								<form:hidden path="dtAlteracao" />
								<div class="col-md-4">
									<div class="form-group">
										<label>Nome:</label> <br>
										<form:input type="text" path="name" id="name" name="name" class="form-control" required="required" />
									</div>
								</div>

								<div class="col-md-4">
									<div class="form-group">
										<label>CPF/CNPJ:</label> <br>
										<form:input type="number" path="idLegal" id="idLegal" name="idLegal" class="form-control" required="required" />
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
										<label>Senha:</label> <br> <input type="password" id="psWord" name="psWord" class="form-control">
									</div>
								</div>

								<security:authorize access="hasAuthority('ROLE_ADMIN')">

									<div class="col-md-2">
										<div class="form-group">
											<label>Ativo: </label> <br>
											<form:select path="enabled" class="form-control" required="required">
												<form:option value="true">Ativo</form:option>
												<form:option value="false">Inativo</form:option>
											</form:select>
										</div>
									</div>

									<div class="col-md-2">
										<div class="form-group">
											<label>Primeiro Login: </label> <br>
											<form:select path="firstTimeLogin" id="enabled" name="enabled" class="form-control" required="required">
												<form:option value="true">Sim</form:option>
												<form:option value="false">Não</form:option>
											</form:select>
										</div>
									</div>

									<div class="col-md-12"></div>

									<div class="col-md-6">
										<div class="form-group ">
											<label>Permissões:</label> <br>
											<option></option>
											<c:forEach items="${roles }" var="role" varStatus="i">
												<fieldset>
													<input type="checkbox" id="input-${i.index }" name="idRoles" value="${role.id }"
														${user.roles.contains(role) ? 'checked="checked"' : '' }> <label for="input-11">${role.name }</label>
												</fieldset>
											</c:forEach>
										</div>
									</div>

								</security:authorize>

								<security:authorize access="!hasAuthority('ROLE_ADMIN')">
									<form:hidden path="firstTimeLogin" />
									<c:forEach items="${user.roles }" var="role">
										<input type="hidden" id="idRoles" name="idRoles" value="${role.id }" />
									</c:forEach>
									<form:hidden path="enabled" />
								</security:authorize>

								<div class="col-md-12">
									<button class="btn btn-block block-element btn-primary" style="width: auto;">${user.id == null ?
								'Cadastrar' : 'Atualizar' }</button>
								</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
