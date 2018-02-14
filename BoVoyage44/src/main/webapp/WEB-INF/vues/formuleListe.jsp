<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib de JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste Formules</title>
<script type="text/javascript" src="resources/js/jquery-3.2.1.js"></script>

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />

<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/script_navbar.js"/>"></script>
</head>
<body>
	<%@ include file="/template/headerA.html"%>
	<br/>
	<br/>
	<br/>
	<h1 style="text-align: center">Liste des cargaisons</h1>

	<table class="table table-bordered">

		<tr>
			<th>ID</th>
			<th>Type</th>
			<th>Prix</th>
			<th>Operations</th>
		</tr>
		<c:forEach var="f" items="${formulesList}">
			<tr>
				<td>${f.id}</td>
				<td>${f.type}</td>
				<td>${f.prix}</td>
				<td><a
					href="${pageContext.request.contextPath}/agent/formulaire/supprimeLien/${f.id}">Supprimer</a>
					| <a
					href="${pageContext.request.contextPath}/agent/formulaire/modifieLien?pId=${f.id}">Modifier</a></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>