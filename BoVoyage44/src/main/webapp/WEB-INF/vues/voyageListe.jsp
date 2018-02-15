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
							<figure>
								<img
									src="${pageContext.request.contextPath}/voyage/photoVoyage?idV=${v.id}"
									alt="" width="450" height="300" />
								<figcaption>
								<h1 id="titreDiapo">${v.titre}</h1>
								<h1 id="reducDiapo">${v.remise}% de r�duction pour ce voyage !</h1>
								<h1 id="prixDiapo">${v.prixSolde} euros</h1>
								</figcaption>
							</figure>
					</a></li>
				</c:if>
			</c:forEach>
		</ul>
	</div>

	<div></div>

	<h1 style="color: darkred; text-align: center">Liste des voyages</h1>

	<c:forEach var="v" items="${voyageList}">
		<div class="row">
			<div class="col-md-6">
				<div class="thumbnail">
					<p>Voyage : ${v.titre}</p>
					<a
						href="${pageContext.request.contextPath}/voyage/lienDetail?pId=${v.id}">
						<img class="imageAccueil" style="max-width: 400px; height: auto;"
						src="${pageContext.request.contextPath}/voyage/photoVoyage?idV=${v.id}"
						alt="imageVoyage" style="width: 400px; height: 300px;">
						<div class="caption">
							<p>
								Continent : ${v.continent}<br> Prix Sold� : ${v.prixSolde}<br>
								Prix : <s>${v.prixDepart}</s><br> Date : du ${v.dateDepart}
								au ${v.dateRetour}<br> Description : ${v.description}<br>
							</p>
						</div>
					</a>
					<button type="button" class="btn btn-primary"
						onclick="location.href = '${pageContext.request.contextPath}/voyage/agent/modifierButton?pId=${v.id}'">Modifier</button>
					<button type="button" class="btn btn-danger"
						onclick="location.href = '${pageContext.request.contextPath}/voyage/agent/supprimerButton/${v.id}'">Supprimer</button>
				</div>
			</div>
	</c:forEach>

</body>
</html>