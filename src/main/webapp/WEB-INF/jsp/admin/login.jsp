<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="page-header clear-filter">
	<div class="page-header-image"
		style="background-image: url(/resources/images/food-1932466_1920.jpg)"></div>
	<div class="content">
		<div class="container">
			<div class="card card-login card-plain">
				<form action="/login" method="POST">
					<div class="card-header text-center">
						<div class="logo-container">
							<img src="/resources/plugins/nowUIKit/img/now-logo.png" alt="">
						</div>
					</div>
					<div class="card-body">
						<div class="input-group no-border input-lg">
							<div class="input-group-prepend">
								<span class="input-group-text"> <i
									class="now-ui-icons ui-1_email-85"></i>
								</span>
							</div>
							<input type="text" class="form-control" name="username"
								id="username" placeholder="Email..." required="required"
								autocomplete="off">
						</div>
						<div class="input-group no-border input-lg">
							<div class="input-group-prepend">
								<span class="input-group-text"> <i
									class="now-ui-icons objects_key-25"></i>
								</span>
							</div>
							<input type="password" placeholder="Senha..." name="password"
								id="password" class="form-control" required="required"
								autocomplete="off" />
						</div>
					</div>
					<div class="card-footer text-center">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" class="form-control" />
						<button type="submit"
							class="btn btn-primary btn-round btn-lg btn-block">
							Login</button>
					</div>
					<div class="pull-left">
						<h6>
							<a href="#" class="link">Criar Conta</a>
						</h6>
					</div>
					<div class="pull-right">
						<h6>
							<a href="#" class="link">Precisa de Ajuda?</a>
						</h6>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>