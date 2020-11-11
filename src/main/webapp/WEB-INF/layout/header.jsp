<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="pt_br" scope="session" />
<c:set var="usuarioLogado" value="${pageContext.request.session.getAttribute('usuarioLogado')}" scope="session" />

<nav
	class="header-navbar navbar-expand-md navbar navbar-with-menu navbar-static-top navbar-dark bg-gradient-x-grey-blue navbar-border navbar-brand-center">
	<div class="navbar-wrapper">
		<div class="navbar-header">
			<ul class="nav navbar-nav flex-row">
				<li class="nav-item mobile-menu d-md-none mr-auto"><a class="nav-link nav-menu-main menu-toggle hidden-xs" href="#"><i
						class="feather icon-menu font-large-1"></i></a></li>
				<li class="nav-item"><a class="navbar-brand" href='<spring:url value="/home"/>'><img class="brand-logo" alt="stack admin logo"
						src="${pageContext.request.contextPath}/resources/stack-admin/app-assets/images/logo/stack-logo-light.png">
						<h2 class="brand-text">Starter</h2> </a></li>
				<li class="nav-item d-md-none"><a class="nav-link open-navbar-container" data-toggle="collapse" data-target="#navbar-mobile"><i
						class="fa fa-ellipsis-v"></i></a></li>
			</ul>
		</div>
		<div class="navbar-container content">
			<div class="collapse navbar-collapse" id="navbar-mobile">
				<ul class="nav navbar-nav mr-auto float-left">
					<li class="nav-item d-none d-md-block"><a class="nav-link nav-menu-main menu-toggle hidden-xs" href="#"><i
							class="feather icon-menu"></i></a></li>
					<li class="dropdown nav-item mega-dropdown d-none d-lg-block"><a class="dropdown-toggle nav-link" href="#" data-toggle="dropdown">Mega</a>
						<ul class="mega-dropdown-menu dropdown-menu row p-1">
							<li class="col-md-4 bg-mega p-2">
								<h3 class="text-white mb-1 font-weight-bold">Mega Menu Sidebar</h3>
								<p class="text-white line-height-2">O Lorem Ipsum é um texto modelo da indústria tipográfica e de impressão. O Lorem Ipsum tem vindo
									a ser o texto padrão usado por estas indústrias desde o ano de 1500, quando uma misturou os caracteres de um texto para criar um
									espécime de livro...</p>
								<button class="btn btn-outline-white">Ler mais</button>
							</li>
							<li class="col-md-5 px-2">
								<h6 class="font-weight-bold font-medium-2 ml-1">Apps</h6>
								<ul class="row mt-2">
									<li class="col-6 col-xl-4"><a class="text-center mb-2 mb-xl-3" href="#" target="_blank"><i
											class="feather icon-mail font-large-1 mr-0"></i>
											<p class="font-medium-2 mt-25 mb-0">Email</p> </a></li>
									<li class="col-6 col-xl-4"><a class="text-center mb-2 mb-xl-3" href="#" target="_blank"><i
											class="feather icon-message-square font-large-1 mr-0"></i>
											<p class="font-medium-2 mt-25 mb-0">Chat</p> </a></li>
									<li class="col-6 col-xl-4"><a class="text-center mb-2 mb-xl-3 mt-75 mt-xl-0" href="#" target="_blank"><i
											class="feather icon-check-square font-large-1 mr-0"></i>
											<p class="font-medium-2 mt-25 mb-0">Todo</p> </a></li>
									<li class="col-6 col-xl-4"><a class="text-center mb-2 mt-75 mt-xl-0" href="#" target="_blank"><i
											class="feather icon-file-plus font-large-1 mr-0"></i>
											<p class="font-medium-2 mt-25 mb-50">Kanban</p> </a></li>
									<li class="col-6 col-xl-4"><a class="text-center mb-2 mt-75 mt-xl-0" href="#" target="_blank"><i
											class="feather icon-users font-large-1 mr-0"></i>
											<p class="font-medium-2 mt-25 mb-50">Contacts</p> </a></li>
									<li class="col-6 col-xl-4"><a class="text-center mb-2 mt-75 mt-xl-0" href="#" target="_blank"><i
											class="feather icon-printer font-large-1 mr-0"></i>
											<p class="font-medium-2 mt-25 mb-50">Invoice</p> </a></li>
								</ul>
							</li>
							<li class="col-md-3">
								<h6 class="font-weight-bold font-medium-2">Components</h6>
								<ul class="row mt-1 mt-xl-2">
									<li class="col-12 col-xl-6 pl-0">
										<ul class="mega-component-list">
											<li class="mega-component-item"><a class="mb-1 mb-xl-2" href="#" target="_blank">Alert</a></li>
											<li class="mega-component-item"><a class="mb-1 mb-xl-2" href="#" target="_blank">Callout</a></li>
											<li class="mega-component-item"><a class="mb-1 mb-xl-2" href="#" target="_blank">Buttons</a></li>
											<li class="mega-component-item"><a class="mb-1 mb-xl-2" href="#" target="_blank">Carousel</a></li>
										</ul>
									</li>
									<li class="col-12 col-xl-6 pl-0">
										<ul class="mega-component-list">
											<li class="mega-component-item"><a class="mb-1 mb-xl-2" href="#" target="_blank">Drop Down</a></li>
											<li class="mega-component-item"><a class="mb-1 mb-xl-2" href="#" target="_blank">List Group</a></li>
											<li class="mega-component-item"><a class="mb-1 mb-xl-2" href="#" target="_blank">Modals</a></li>
											<li class="mega-component-item"><a class="mb-1 mb-xl-2" href="#" target="_blank">Pagination</a></li>
										</ul>
									</li>
								</ul>
							</li>
						</ul></li>
					<li class="nav-item d-none d-md-block"><a class="nav-link nav-link-expand" href="#"><i class="ficon feather icon-maximize"></i></a></li>
				</ul>
				<ul class="nav navbar-nav float-right">
					<li class="dropdown dropdown-user nav-item"><a class="dropdown-toggle nav-link dropdown-user-link" href="#" data-toggle="dropdown">
							<div class="avatar avatar-online">
								<img src="${pageContext.request.contextPath}/resources/images/default-user.png" alt="avatar"><i></i>
							</div> <span class="user-name">${usuarioLogado.name }</span>
					</a>
						<div class="dropdown-menu dropdown-menu-right">
							<a class="dropdown-item" href="user-profile"><i class="feather icon-user"></i> Editar Perfil</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href='<spring:url value="/logout" />'><i class="feather icon-power"></i> Logout</a>
						</div></li>
				</ul>
			</div>
		</div>
	</div>
</nav>

