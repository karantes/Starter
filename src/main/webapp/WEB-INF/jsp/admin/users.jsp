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
				<h3 class="content-header-title mb-0">Usuários</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href='<spring:url value="/home"/>'>Home</a></li>
							<li class="breadcrumb-item">Usuários</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<div class="content-body">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title">Lista de Usuários</h4>
					<br> <a href='<spring:url value="/user-register"/>' style="width: auto;">
						<button class="btn btn-primary">Novo Usuário</button>
					</a> <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
					<div class="heading-elements">
						<ul class="list-inline mb-0">
							<li><a data-action="collapse"><i class="feather icon-minus"></i></a></li>
							<li><a data-action="reload"><i class="feather icon-rotate-cw"></i></a></li>
							<li><a data-action="expand"><i class="feather icon-maximize"></i></a></li>
							<li><a data-action="close"><i class="feather icon-x"></i></a></li>
						</ul>
					</div>
				</div>
				<div class="card-content collapse show">
					<div class="card-body card-dashboard">
						<table class="table table-striped table-bordered dataex-html5-export dataex-res-configuration" style="width: 100%">
							<thead>
								<tr>
									<th>ID</th>
									<th>Nome</th>
									<th>CPF/CNPJ</th>
									<th>Email</th>
									<th>Permissões</th>
									<th>Ações</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${users }" var="user">
									<tr>
										<td>${user.id }</td>
										<td>${user.name }</td>
										<td>${user.idLegal }</td>
										<td>${user.email }</td>
										<td>${user.roles }</td>
										<td style="font-size: 150%;"><a href='<spring:url value="/user-update/${user.id }"/>'> <i class="fa fa-edit"
												title="Editar"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
