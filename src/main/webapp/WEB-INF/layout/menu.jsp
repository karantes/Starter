<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="header-navbar navbar-expand-sm navbar navbar-horizontal navbar-fixed navbar-light navbar-without-dd-arrow navbar-shadow menu-border"
	role="navigation" data-menu="menu-wrapper">
	<div class="navbar-container main-menu-content" data-menu="menu-container">
		<ul class="nav navbar-nav" id="main-menu-navigation" data-menu="menu-navigation">
			<c:if test="${usuarioLogado.hasMenu('ADMIN')}">
				<li class="dropdown nav-item" data-menu="dropdown"><a class="dropdown-toggle nav-link" href="#" data-toggle="dropdown"><i
						class="feather icon-settings"></i><span>Admin</span></a>
					<ul class="dropdown-menu">
						<c:if test="${usuarioLogado.hasFuncionalidade('/funcionalidades')}">
							<li data-menu=""><a class="dropdown-item" href='<spring:url value="/funcionalidades.html"/>' data-toggle="dropdown">Funcionalidades</a></li>
						</c:if>
						<c:if test="${usuarioLogado.hasFuncionalidade('/menus')}">
							<li data-menu=""><a class="dropdown-item" href='<spring:url value="/menus.html"/>' data-toggle="dropdown">Menus</a></li>
						</c:if>
						<c:if test="${usuarioLogado.hasFuncionalidade('/roles')}">
							<li data-menu=""><a class="dropdown-item" href='<spring:url value="/roles.html"/>' data-toggle="dropdown">Permissões</a></li>
						</c:if>
						<c:if test="${usuarioLogado.hasFuncionalidade('/users')}">
							<li data-menu=""><a class="dropdown-item" href='<spring:url value="/users.html"/>' data-toggle="dropdown">Usuarios</a></li>
						</c:if>
					</ul></li>
			</c:if>
			<c:if test="${usuarioLogado.hasMenu('TESTE')}">
				<li class="dropdown nav-item" data-menu="dropdown"><a class="dropdown-toggle nav-link" href="#" data-toggle="dropdown"><i
						class="feather icon-settings"></i><span>TESTE</span></a>
					<ul class="dropdown-menu">
						<c:if test="${usuarioLogado.hasFuncionalidade('/teste')}">
							<li data-menu=""><a class="dropdown-item" href='<spring:url value="/teste.html"/>' data-toggle="dropdown">Teste</a></li>
						</c:if>
					</ul></li>
			</c:if>
		</ul>
	</div>
</div>