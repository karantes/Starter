<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tiles:importAttribute name="jsVendors" ignore="true" />
<tiles:importAttribute name="jsPageVendors" ignore="true" />
<tiles:importAttribute name="jsTheme" ignore="true" />
<tiles:importAttribute name="jsPage" ignore="true" />

<tiles:importAttribute name="cssVendors" ignore="true" />
<tiles:importAttribute name="cssTheme" ignore="true" />
<tiles:importAttribute name="cssPage" ignore="true" />
<tiles:importAttribute name="cssCustom" ignore="true" />


<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<!-- BEGIN: Head-->

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="author" content="KAIQUE ARANTES COSTA">
<title>Starter Project - <tiles:insertAttribute name="title" /></title>
<link rel="apple-touch-icon" href="/resources/stack-admin/app-assets/images/ico/apple-icon-120.png">
<link rel="shortcut icon" type="image/x-icon" href="/resources/stack-admin/app-assets/images/ico/favicon.ico">
<link href="/resources/stack-admin/src/css/googleapis.css" rel="stylesheet">

<!-- BEGIN: Vendor CSS-->
<c:forEach var="css" items="${cssVendors}">
	<link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
</c:forEach>
<!-- END: Vendor CSS-->

<!-- BEGIN: Theme CSS-->
<c:forEach var="css" items="${cssTheme}">
	<link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
</c:forEach>
<!-- END: Theme CSS-->

<!-- BEGIN: Page CSS-->
<c:forEach var="css" items="${cssPage}">
	<link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
</c:forEach>
<!-- END: Page CSS-->

<!-- BEGIN: Custom CSS-->
<c:forEach var="css" items="${cssCustom}">
	<link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
</c:forEach>
<!-- END: Custom CSS-->

</head>
<!-- END: Head-->

<!-- BEGIN: Body-->
<body class="horizontal-layout horizontal-menu 1-column blank-page blank-page" data-open="hover" data-menu="horizontal-menu" data-col="1-column"
	style="background-image : url('${pageContext.request.contextPath}/resources/stack-admin/app-assets/images/backgrounds/bg-2.jpg'); background-repeat: no-repeat; background-size : 100% 100%">
	<!-- BEGIN: Content-->
	<tiles:insertAttribute name="body" />
	<!-- END: Content-->


	<!-- BEGIN: Vendor JS-->
	<c:forEach var="script" items="${jsVendors}">
		<script src="<c:url value="${script}"/>"></script>
	</c:forEach>
	<!-- BEGIN Vendor JS-->

	<!-- BEGIN: Page Vendor JS-->
	<c:forEach var="script" items="${jsPageVendors}">
		<script src="<c:url value="${script}"/>"></script>
	</c:forEach>
	<!-- END: Page Vendor JS-->

	<!-- BEGIN: Theme JS-->
	<c:forEach var="script" items="${jsTheme}">
		<script src="<c:url value="${script}"/>"></script>
	</c:forEach>
	<!-- END: Theme JS-->

	<!-- BEGIN: Page JS-->
	<c:forEach var="script" items="${jsPage}">
		<script src="<c:url value="${script}"/>"></script>
	</c:forEach>
	<!-- END: Page JS-->

</body>
<!-- END: Body-->