<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<div class="app-content content">
	<div class="content-wrapper">
		<div class="content-header row"></div>
		<div class="content-body">
			<section class="flexbox-container">
			<div class="col-12 d-flex align-items-center justify-content-center">
				<div class="col-md-4 col-10 p-0">
					<div class="card-header bg-transparent border-0">
						<h2 class="error-code text-center mb-2">403</h2>
						<h3 class="text-uppercase text-center">ACCESS DENIED/FORBIDDEN</h3>
					</div>
					<div class="card-content">
						<div class="row py-2">
							<div class="col-12 col-sm-12 col-md-12 mb-1">
								<a href='javascript:history.back()' class="btn btn-primary btn-block"><i class="ft-home"></i> Home</a>
							</div>
						</div>
					</div>
					<div class="card-footer bg-transparent">
						<div class="row">
							<p class="text-muted text-center col-12 py-1">
								© <span class="year"></span> </a>Coded by <a href="#">KAIQUE ARANTES</a>
							</p>
							<div class="col-12 text-center">
								<a href="https://www.linkedin.com/in/kaique-arantes/" target="_blank" class="btn btn-social-icon mr-1 mb-1 btn-outline-linkedin"><span
									class="fa fa-linkedin font-medium-4"></span></a> <a href="https://github.com/karantes/Starter" target="_blank"
									class="btn btn-social-icon mr-1 mb-1 btn-outline-github"><span class="fa fa-github font-medium-4"></span></a>
							</div>
						</div>
					</div>
				</div>
			</div>
			</section>
		</div>
	</div>
</div>
