<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:importAttribute name="javascripts" />
<tiles:importAttribute name="stylesheets" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Starter</title>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

<c:forEach var="css" items="${stylesheets}">
	<link href="<c:url value="${css}"/>" rel="stylesheet">
</c:forEach>
</head>
<body class="horizontal-layout horizontal-menu 2-columns  " data-open="click" data-menu="horizontal-menu" data-col="2-columns">

	<tiles:insertAttribute name="header" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js" type="text/javascript"></script>
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
	<c:forEach var="script" items="${javascripts}">
		<script src="<c:url value="${script}"/>"></script>
	</c:forEach>
</body>
</html>