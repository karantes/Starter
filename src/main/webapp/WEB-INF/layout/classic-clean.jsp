<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:importAttribute name="javascripts" />
<tiles:importAttribute name="stylesheets" />
<!DOCTYPE html>

<html class="loading" lang="en" data-textdirection="ltr">
	<head>
	 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
	    <meta name="description" content="Starter project with modern responsive bootstrap 4 admin template with unlimited possibilities.">
	    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app, erp">
	    <meta name="author" content="KAIQUE ARANTES">
	    <title>Starter Project</title>
	    <link rel="apple-touch-icon" href="/resources/stack-admin/app-assets/images/ico/apple-icon-120.png">
	    <link rel="shortcut icon" type="image/x-icon" href="/resources/stack-admin/app-assets/images/ico/favicon.ico">
	    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">

		<c:forEach var="css" items="${stylesheets}">
		<link href="<c:url value="${css}"/>" rel="stylesheet">
		</c:forEach>
	</head>
  	<body class="vertical-layout vertical-menu-modern 1-column   blank-page blank-page" data-open="click" data-menu="vertical-menu-modern" data-col="1-column">
	
		<tiles:insertAttribute name="body" />

		<c:forEach var="script" items="${javascripts}">
		<script src="<c:url value="${script}"/>"></script>
		</c:forEach>
	</body>
</html>