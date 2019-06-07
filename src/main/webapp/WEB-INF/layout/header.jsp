<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="pt_br" scope="session" />

<nav class="header-navbar navbar-expand-md navbar navbar-with-menu navbar-static-top navbar-dark bg-gradient-x-grey-blue navbar-border navbar-brand-center">
	<div class="navbar-wrapper">
		<div class="navbar-header">
			<ul class="nav navbar-nav flex-row">
				<li class="nav-item mobile-menu d-md-none mr-auto"><a class="nav-link nav-menu-main menu-toggle hidden-xs" href="#"><i class="ft-menu font-large-1"></i></a></li>
				<li class="nav-item"><a class="navbar-brand" href='<spring:url value="/home.html"/>'><img class="brand-logo" alt="stack admin logo" src="${pageContext.request.contextPath}/resources/stack-admin/app-assets/images/logo/stack-logo-light.png"
						style="width: 35px; height: 35px;">
						<h2 class="brand-text" style="vertical-align: top;">Starter</h2> </a></li>
				<li class="nav-item d-md-none"><a class="nav-link open-navbar-container" data-toggle="collapse" data-target="#navbar-mobile"><i class="fa fa-ellipsis-v"></i></a></li>
			</ul>
		</div>
		<div class="navbar-container content">
			<div class="collapse navbar-collapse" id="navbar-mobile">
				<ul class="nav navbar-nav mr-auto float-left">
					<li class="nav-item d-none d-md-block"><a class="nav-link nav-menu-main menu-toggle hidden-xs" href="#"><i class="ft-menu"></i></a></li>
					<li class="nav-item d-none d-md-block"><a class="nav-link nav-link-expand" href="#"><i class="ficon ft-maximize"></i></a></li>
				</ul>
				<ul class="nav navbar-nav float-right">
					<li class="dropdown dropdown-user nav-item"><a class="dropdown-toggle nav-link dropdown-user-link" href="#" data-toggle="dropdown"><span class="avatar avatar-online"><img
								src="${pageContext.request.contextPath}/resources/images/default-user.png" alt="avatar"><i></i></span><span class="user-name">${pageContext.request.userPrincipal.name }</span></a>
						<div class="dropdown-menu dropdown-menu-right">
							<a class="dropdown-item" href='<spring:url value="/user-perfil.html" />'><i class="ft-user"></i> Perfil</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href='<spring:url value="/logout.html" />'><i class="ft-power"></i> Logout</a>
						</div></li>
				</ul>
			</div>
		</div>
	</div>
</nav>

<div class="header-navbar navbar-expand-sm navbar navbar-horizontal navbar-fixed navbar-light navbar-without-dd-arrow navbar-shadow menu-border" role="navigation" data-menu="menu-wrapper">
	<div class="navbar-container main-menu-content" data-menu="menu-container">
		<ul class="nav navbar-nav" id="main-menu-navigation" data-menu="menu-navigation">

<%-- 			<security:authorize access="hasAuthority('ROLE_ADMIN')"> --%>
				<li class="dropdown nav-item" data-menu="dropdown"><a class="dropdown-toggle nav-link" href="#" data-toggle="dropdown"><i class="ft-settings"></i><span>Admin</span></a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href='<spring:url value="/users.html"/>'>Usuarios </a></li>
						<li><a class="dropdown-item" href='<spring:url value="/roles.html"/>'>Roles</a></li>
						<li><a class="dropdown-item" href='<spring:url value="/logs.html"/>'>Logs</a></li>
					</ul></li>
<%-- 			</security:authorize> --%>
<%-- 			<security:authorize access="hasAuthority('ROLE_ADMIN')||hasAuthority('ROLE_TRANSPORTADORA')"> --%>
				<li class="dropdown mega-dropdown nav-item" data-menu="megamenu"><a class="dropdown-toggle nav-link" href="#" data-toggle="dropdown"><i class="ft-box"></i><span>Pamcard</span></a>
					<ul class="mega-dropdown-menu dropdown-menu row">
						<li class="col-md-3" data-mega-col="col-md-3">
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a class="dropdown-item" href="#"><i class="ft-edit"></i>Cadastro</a>
											<ul class="mega-menu-sub">
												<li><a class="dropdown-item" href='<spring:url value="/pamcard/incluir-conta.html"/>'>Conta</a></li>
												<li><a class="dropdown-item" href='<spring:url value="/pamcard/inserir-rota.html"/>'>Rota</a></li>
												<li><a class="dropdown-item" href='<spring:url value="/pamcard/remetente-destinatario.html"/>'>Remetente / Destinatário</a></li>
												<li><a class="dropdown-item" href='<spring:url value="/pamcard/incluir-cartao-portador-frete.html"/>'>Incluir Cartão Portador Frete</a></li>
												<li><a class="dropdown-item" href='<spring:url value="/pamcard/favorecido.html"/>'>Favorecido</a></li>
											</ul></li>
									</ul>
								</li>
							</ul>
						</li>
						<li class="col-md-3" data-mega-col="col-md-3">
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a class="dropdown-item" href='<spring:url value="/pamcard/contratos-frete.html"/>'>Contratos de Frete </a></li>
									</ul>
								</li>
							</ul>
						</li>
						<li class="col-md-3" data-mega-col="col-md-3">
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a class="dropdown-item" href="#"><i class="ft-search"></i>Consulta</a>
											<ul class="mega-menu-sub">
												<li><a class="dropdown-item" href='<spring:url value="/pamcard/consultar-cartao.html"/>'>Consultar Cartão</a></li>
												<li><a class="dropdown-item" href='<spring:url value="/pamcard/consultar-rntrc.html"/>'>Consultar RNTRC</a></li>
												<li><a class="dropdown-item" href='<spring:url value="/pamcard/consultar-frota.html"/>'>Consultar Frota</a></li>
												<li><a class="dropdown-item" href='<spring:url value="/pamcard/consultar-conta.html"/>'>Consultar Conta</a></li>
												<li><a class="dropdown-item" href='<spring:url value="/pamcard/roteirizar.html"/>'>Roteirizar</a></li>
											</ul></li>
									</ul>
								</li>
							</ul>
						</li>
						<li class="col-md-3" data-mega-col="col-md-3">
							<ul class="drilldown-menu">
								<li class="menu-list">
									<ul class="mega-menu-sub">
										<li><a class="dropdown-item" href='<spring:url value="/impostos.html"/>'>Impostos </a></li>
									</ul>
								</li>
							</ul>
						</li>
					</ul></li>
<%-- 			</security:authorize> --%>
		</ul>
	</div>
</div>
