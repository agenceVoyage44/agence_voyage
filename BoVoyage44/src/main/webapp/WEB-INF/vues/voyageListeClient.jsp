<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des voyages</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/script_navbar.js"/>"></script>

</head>
<body>
<div style="height: 90px">
		<%@ include file="/template/headerU.html"%>
	</div>
	


	<h1 style="color: darkred; text-align: center">Liste des
		voyages</h1>

	<table class="table table-bordered">
		<tr>
			<th>Photo</th>
			<th>Continent</th>
			<th>Pays</th>
			<th>Prix de départ</th>
			<th>Remise</th>
			<th>Prix soldé</th>
			<th>Date de départ</th>
			<th>Date de retour</th>
			<th>Nombre de places</th>
			<th>Titre</th>
			<th>Description</th>
		</tr>
		<c:forEach var="v" items="${voyageList }">
			<tr>
				<td><img
					src="${pageContext.request.contextPath}/voyage/photoVoyage?idV=${v.id}"
					height="80px" /></td>
				<td>${v.continent}</td>
				<td>${v.pays}</td>
				<td>${v.prixDepart}</td>
				<td>${v.remise}</td>
				<td>${v.prixSolde}</td>
				<td>${v.dateDepart}</td>
				<td>${v.dateRetour}</td>
				<td>${v.nbPlaces}</td>
				<td>${v.titre}</td>
				<td>${v.description}</td>
			</tr>

		</c:forEach>

	</table>
	<c:forEach var="v" items="${voyageList}">
		<div class="row">
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="#"> <img src="${v.photo}" alt="imageVoyage"
						style="width: 400px; height: 300px;">
						<div class="caption">
							<p>Continent : ${v.continent}<br>
							Description : </p>
							
						</div>
					</a>
				</div>
			</div>
	</c:forEach>

</body>
</html>