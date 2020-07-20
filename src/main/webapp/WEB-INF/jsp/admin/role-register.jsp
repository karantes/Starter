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
				<h3 class="content-header-title mb-0">Cadastro de Permissão</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href='<spring:url value="/home.html"/>'>Home</a></li>
							<li class="breadcrumb-item"><a href='<spring:url value="/roles.html"/>'>Permissões</a></li>
							<li class="breadcrumb-item">Cadastro</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<div class="content-body">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title">Permissão</h4>
				</div>
				<div class="card-content">
					<div class="card-body">
						<form:form modelAttribute="role" action="${pageContext.request.contextPath}/role-register.html" method="post" id="formRole">
							<div class="row">
								<form:hidden path="id" />
								<div class="col-md-3">
									<div class="form-group">
										<label>Nome:</label> <br>
										<form:input type="text" path="name" class="form-control" required="required" />
									</div>
								</div>

								<c:set value="0" var="i" />
								<c:forEach items="${menus }" var="menu">
									<div class="col-md-12">
										<br>
									</div>
									<div style="width: 100%; height: 20px; border-bottom: 1px solid black; text-align: left;">
										<span style="font-size: 20px; background-color: white; padding: 0 10px;"> <input type="checkbox" class="${menu.name }"
											id="menuId" name="menuId" value="${menu.id }" ${role.hasMenu(menu.name) ? 'checked="checked"' : '' } /> Menu ${menu.name }
										</span>
									</div>
									<div class="col-md-12">
										<br>
									</div>
									<c:set value="0" var="j" />
									<c:forEach items="${menu.funcionalidades }" var="funcionalidade">
										<div class="col-md-4">
											<fieldset>
												<form:hidden path="menus[${i}].funcionalidades[${j }].id" />
												<form:hidden path="menus[${i}].funcionalidades[${j }].name" />
												<form:hidden path="menus[${i}].funcionalidades[${j }].value" />
												<form:hidden path="menus[${i}].funcionalidades[${j }].method" />
												<form:checkbox path="menus[${i}].funcionalidades[${j }].ativo" value="${funcionalidade.ativo }"
													onclick="$(this).val($(this).prop('checked'))" chequed="${funcionalidade.ativo }" />${funcionalidade.name } 
											</fieldset>
										</div>
										<c:set value="${j + 1 }" var="j" />
									</c:forEach>
									<c:set value="${i + 1 }" var="i" />
								</c:forEach>

								<div class="col-md-12">
									<br>
									<button class="btn btn-block block-element btn-primary" style="width: auto;">${menu.id == null ?
								'Cadastrar' : 'Atualizar' }</button>
								</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
