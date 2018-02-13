<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib de JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste Formules</title>
<link rel="stylesheet"
	href="<c:url value="/ressources/css/bootstrap.css" />" />
</head>
<body>

	<h1 style="text-align: center">Liste des cargaisons</h1>

	<table class="table table-bordered">

		<tr>
			<th>ID</th>
			<th>Type</th>
			<th>Prix</th>
		</tr>
		<c:forEach var="f" items="${formulesList}">
			<tr>
				<td>${f.id}</td>
				<td>${f.type}</td>
				<td>${f.prix}</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>