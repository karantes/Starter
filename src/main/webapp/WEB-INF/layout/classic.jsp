<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:importAttribute name="javascripts" />
<tiles:importAttribute name="stylesheets" />



<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="author" content="Kaique Arantes; David Evangelista">
<title>Starter - <tiles:insertAttribute name="title" /></title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/stack-admin/app-assets/images/ico/favicon.ico">
<link href="<c:url value="/resources/stack-admin/fonts.googleapis.css"/>" rel="stylesheet">


<c:forEach var="css" items="${stylesheets}">
	<link href="<c:url value="${css}"/>" rel="stylesheet">
</c:forEach>

</head>
<body class="horizontal-layout horizontal-menu horizontal-menu-padding 2-columns" data-open="click" data-menu="horizontal-menu" data-col="2-columns">
	<tiles:insertAttribute name="header" />

	<c:forEach var="script" items="${javascripts}">
		<script src="<c:url value="${script}"/>"></script>
	</c:forEach>
	<div class="app-content content center-layout">
		<div class="content-wrapper">
			<div class="content-header row"></div>
			<div class="content-body">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-12">
						<tiles:insertAttribute name="body" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<tiles:insertAttribute name="footer" />
</body>
</html>