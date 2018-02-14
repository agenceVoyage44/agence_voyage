<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<!-- Ajouter la lib JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>page Liste Hebergement</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/script_navbar.js"/>"></script>

</head>

<body>
	<%@ include file="/template/headerA.html"%>
	<br/>
	<br/>
	<br/>
<h1 style="color: red; text-align: center">Liste des Hebergements</h1>

	<table class="table table-bordered">
		<tr>
			<th style="text-align: center">ID</th>
			<th style="text-align: center">Type</th>
			<th style="text-align: center">Prix</th>
			<th style="text-align: center">ID Formule et son type</th>
			<th style="text-align: center">Operations</th>
		</tr>

		<c:forEach var="h" items="${hList}">
			<tr>
				<td style="text-align: center">${h.id}</td>
				<td style="text-align: center">${h.type}</td>
				<td style="text-align: center">${h.prix} euros</td>
				<td style="text-align: center">id:${h.formule.id} , type:${h.formule.type}</td>
				<td style="text-align: center"><a
					href="${pageContext.request.contextPath}/agent/hebergement/supprimeLien/${h.id}">Supprimer</a>
					| <a
					href="${pageContext.request.contextPath}/agent/hebergement/modifieLien?pId=${h.id}">Modifier</a></td>
			</tr>

		</c:forEach>

	</table>




</body>

</html>