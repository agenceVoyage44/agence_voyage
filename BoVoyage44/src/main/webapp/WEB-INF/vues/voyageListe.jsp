<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- ajouter les balises form de spring mvc -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des voyages</title>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/script_navbar.js"/>"></script>

<!-- JS et CSS pour le diapo en haut de page -->
<link rel="stylesheet" href="<c:url value="/resources/css/diapo.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/diapo.js"/>"></script>

</head>
<body>
	<div style="height: 90px">
		<%@ include file="/template/headerA.html"%>
	</div>


	<!-- Galerie Dynamique -->
	<div class="slideshow">
		<ul>
			<c:forEach var="v" items="${voyageList}">
				<c:if test="${v.priorite == true }">
					<li><a
						href="${pageContext.request.contextPath}/voyage/lienDetail?pId=${v.id}">
							<img
							src="${pageContext.request.contextPath}/voyage/photoVoyage?idV=${v.id}"
							alt="" width="450" height="300" />
					</a></li>
				</c:if>
			</c:forEach>
		</ul>
	</div>

	<h1 style="color: darkred; text-align: center">Liste des voyages</h1>

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
		<c:forEach var="v" items="${voyageList}">
			<tr>
				<td><img
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
<c:forEach var="v" items="${voyageList}">
		<div class="row">
			<div class="col-md-4">
				<div class="thumbnail">
					<p>Voyage : ${v.titre}</p>
					<a
						href="${pageContext.request.contextPath}/voyage/lienDetail?pId=${v.id}">
						<img src="${pageContext.request.contextPath}/voyage/photoVoyage?idV=${v.id}" alt="imageVoyage"
						style="width: 400px; height: 300px;">
						<div class="caption">
							<p>
								Continent : ${v.continent}<br> Prix Soldé : ${v.prixSolde}<br>
								Prix : <s>${v.prixDepart}</s><br> Date : du ${v.dateDepart}
								au ${v.dateRetour}<br> Description : ${v.description}<br>
							</p>

						</div>
					</a>
				</div>
			</div>
	</c:forEach>

</body>
</html>