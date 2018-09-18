<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body class="hold-transition login-page">
	<div class="page-header clear-filter">
		<div class="page-header-image"
			style="background-image: url(/resources/images/coffee-1399799_1920.jpg)"></div>
		<div class="content">
			<div class="container">
				<div class="col-md-4 ml-auto mr-auto">
					<div class="card card-login card-plain">
						<p class="login-box-msg">
							<b>A página requisitada não existe. Verifique o endereço e
								tente novamente.</b>
						</p>
						<a href='<spring:url value="/login.html"></spring:url>'><button
								class="btn btn-primary btn-round btn-lg btn-block">
								Pagina Inicial</button></a>
					</div>
				</div>
			</div>
		</div>
	</div>