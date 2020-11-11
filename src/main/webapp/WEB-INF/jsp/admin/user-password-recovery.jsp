<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<div class="app-content content">
	<div class="content-overlay"></div>
	<div class="content-wrapper">
		<div class="content-header row"></div>
		<div class="content-body">
			<section class="row flexbox-container">
			<div class="col-12 d-flex align-items-center justify-content-center">
				<div class="col-lg-4 col-md-8 col-10 box-shadow-2 p-0">
					<div class="card border-grey border-lighten-3 px-1 py-1 m-0">
						<div class="card-header border-0">
							<div class="card-title text-center">
								<a href="${pageContext.request.contextPath}/login"><img
									src="${pageContext.request.contextPath}/resources/stack-admin/app-assets/images/logo/stack-logo-dark.png" alt="branding logo"> </a>
							</div>
						</div>
						<div class="card-content">
							<p class="card-subtitle line-on-side text-muted text-center font-small-3 mx-2 my-1">
								<span>Recuperação de senha</span>
							</p>
							<div class="card-body">
								<form class="form-horizontal" action='<spring:url value="/user-password-recovery"/>' method="post">
									<fieldset class="form-group position-relative has-icon-left">
										<input type="number" step="1" class="form-control" id="idLegal" name="idLegal" placeholder="CPF/CNPJ" required="required">
										<div class="form-control-position">
											<i class="fa fa-user"></i>
										</div>
									</fieldset>
									<div class="form-group row">
										<div class="col-sm-6 col-12 text-center text-sm-left pr-0"></div>
									</div>
									<button type="submit" class="btn btn-outline-primary btn-block">
										<i class="feather icon-mail"></i> Enviar
									</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			</section>
		</div>
	</div>
</div>