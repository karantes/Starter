<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">
	$(document).ready(function() {
		$('#roles').DataTable();
	});
</script>

<div class="page-header">
	<div class="page-header-image"
		style="background-image: url(/resources/images/food-1932466_1920.jpg)"></div>
	<div class="bd-content container">
		<div class="card card-plain">
			<div class="card-header">
				<h2 class="card-titlet style=" style="text-align: left;">Roles</h2>
			</div>
			<div class="card-content collapse show">
				<div class="card-body card-dashboard">
					<table id="roles"
						class="table table-striped table-bordered dt-responsive nowrap">
						<thead>
							<tr>

								<th>ID</th>
								<th>Nome</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${roles}" var="role">
								<tr>
									<td>${role.id }</td>
									<td>${role.name }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>