<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BoVoyage</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/script_navbar.js"/>"></script>
</head>
<body>

	<!-- Header User -->
	<%@ include file="/template/headerU.html"%>




	<br />
	<br />
	<br />
	<br />

	<h3>
		<a href="${pageContext.request.contextPath}/boVoyage/agent/accueil">Admin
			: aller dans la page agent</a>
	</h3>
	<br />
	<h3>
		<a href="<c:url value="/boVoyage/client/accueil"/>">Client : aller
			dans la page client</a>
	</h3>

</body>
</html>