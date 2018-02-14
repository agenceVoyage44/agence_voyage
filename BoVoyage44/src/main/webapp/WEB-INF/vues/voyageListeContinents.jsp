<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/script_navbar.js"/>"></script>
</head>
<body>
<body>
	<div style="height: 90px">
		<%@ include file="/template/headerA.html"%>
	</div>

	<h1 style="color: darkred; text-align: center">Liste des voyages
		par Continent</h1>

	<table class="table table-bordered">
		<tr>
			<th>Photo</th>
			<th>ID</th>
			<th>Continent</th>
			<th>Pays</th>
			<th>Prix de départ</th>
			<th>Remise</th>
			<th>Prix soldé</th>
			<th>Date de départ</th>
			<th>Date de retour</th>
			<th>Nombre de places</th>
			<th>Disponibilité</th>
			<th>Titre</th>
			<th>Description</th>
			<th>Priorité</th>
			<th>Opérations</th>
		</tr>
		<c:forEach var="v" items="${voyageListContinent}">
			<tr>
				<td>${v.photo}<img
					src="${pageContext.request.contextPath}/voyage/photoVoyage?idV=${v.id}"
					height="80px" /></td>
				<td>${v.id}</td>
				<td>${v.continent}</td>
				<td>${v.pays}</td>
				<td>${v.prixDepart}</td>
				<td>${v.remise}</td>
				<td>${v.prixSolde}</td>
				<td>${v.dateDepart}</td>
				<td>${v.dateRetour}</td>
				<td>${v.nbPlaces}</td>
				<td>${v.dispo}</td>
				<td><a
					href="${pageContext.request.contextPath}/voyage/lienDetail?pId=${v.id}">${v.titre}</a></td>
				<td>${v.description}</td>
				<td>${v.priorite}</td>
				<td><a
					href="${pageContext.request.contextPath}/voyage/agent/modifierButton?pId=${v.id}">Modifier</a>
					| <a
					href="${pageContext.request.contextPath}/voyage/agent/supprimerButton/${v.id}">Supprimer</a>
				</td>
			</tr>

		</c:forEach>

	</table>


</body>
</html>