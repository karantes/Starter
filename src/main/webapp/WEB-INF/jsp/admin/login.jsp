<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<div class="app-content content">
	<div class="content-wrapper">
		<div class="content-header row"></div>
		<div class="content-body">
			<section class="flexbox-container">
				<div class="col-12 d-flex align-items-center justify-content-center">
					<div class="col-lg-4 col-md-8 col-10 box-shadow-2 p-0">
						<div class="card border-grey border-lighten-3 m-0">
							<div class="card-header border-0">
								<div class="card-title text-center">
									<div class="p-1">
										<img class="brand-logo" src="/resources/stack-admin/app-assets/images/logo/stack-logo.png"
											alt="branding logo">Starter Project
									</div>
								</div>
								<h6
									class="card-subtitle line-on-side text-muted text-center font-small-3 pt-2">
									<span>Easily Using</span>
								</h6>
							</div>
							<div class="card-content">
								<div class="card-body pt-0">
									<form class="form-horizontal" action="#">
										<fieldset class="form-group floating-label-form-group">
											<label for="user-name">Your Username</label> <input
												type="text" class="form-control" id="user-name"
												placeholder="Your Username">
										</fieldset>
										<fieldset class="form-group floating-label-form-group mb-1">
											<label for="user-password">Enter Password</label> <input
												type="password" class="form-control" id="user-password"
												placeholder="Enter Password">
										</fieldset>
										<div class="form-group row">
											<div class="col-sm-6 col-12 text-center text-sm-left">
												<fieldset>
													<input type="checkbox" id="remember-me"
														class="chk-remember"> <label for="remember-me">
														Remember Me</label>
												</fieldset>
											</div>
											<div
												class="col-sm-6 col-12 float-sm-left text-center text-sm-right">
												<a href="#" class="card-link">Forgot
													Password?</a>
											</div>
										</div>
										<button type="submit"
											class="btn btn-outline-primary btn-block">
											<i class="ft-unlock"></i> Login
										</button>
									</form>
								</div>
								<p
									class="card-subtitle line-on-side text-muted text-center font-small-3 mx-2 my-1">
									<span>New User ?</span>
								</p>
								<div class="card-body">
									<a href="#" class="btn btn-outline-danger btn-block"><i
										class="ft-user"></i> Register</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>

		</div>
	</div>
</div>