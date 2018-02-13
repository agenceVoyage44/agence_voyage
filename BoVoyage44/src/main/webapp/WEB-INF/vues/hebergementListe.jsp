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
<!-- ajout lib bootstrap -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />

</head>

<body>

<h1 style="color: red; text-align: center">Liste des Hebergements</h1>

	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Type</th>
			<th>Prix</th>
			<th>ID Formule</th>
			<th>Operations</th>
		</tr>

		<c:forEach var="h" items="${hList}">
			<tr>
				<td>${h.id}</td>
				<td>${h.type}</td>
				<td>${h.prix}</td>
				<td>${h.formule.id}</td>
				<td><a
					href="${pageContext.request.contextPath}/agent/hebergement/supprimeLien/${h.id}">Supprimer</a>
					| <a
					href="${pageContext.request.contextPath}/agent/hebergement/modifieLien?pId=${h.id}">Modifier</a></td>
			</tr>

		</c:forEach>

	</table>




</body>

</html>