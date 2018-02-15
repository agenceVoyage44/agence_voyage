<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

<!-- JS et CSS pour le diapo en haut de page -->
<link rel="stylesheet" href="<c:url value="/resources/css/diapo.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/diapo.js"/>"></script>

</head>
<body>
	<div style="height: 90px">
		<%@ include file="/template/headerU.html"%>
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
									<h1 id="reducDiapo">${v.remise}%de réduction pour ce
										voyage !</h1>
									<h1 id="prixDiapo">${v.prixSolde}euros</h1>
								</figcaption>
							</figure>
					</a></li>
				</c:if>
			</c:forEach>
		</ul>
	</div>

	<form:form method="POST" action="listePays" modelAttribute="voyagePays"
		cssClass="form-horizontal">

		<div class="form-group">
			<form:label path="pays" class="col-sm-2 control-label">Pays</form:label>
			<div class="col-sm-5">
				<form:input path="pays" class="form-control" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-success" value="Rechercher" />
			</div>
		</div>

	</form:form>
	<button type="button" class="btn btn-primary"
						onclick="location.href = '${pageContext.request.contextPath}/voyage/liste'">Retour</button>



	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">


			<h1 style="color: darkred; text-align: center">Liste des voyages</h1>
			<div class="row">
				<c:forEach var="v" items="${voyageList}">

					<div class="col-md-6">
						<div class="thumbnail">
							<p>Voyage : ${v.titre}</p>
							<a
								href="${pageContext.request.contextPath}/voyage/lienDetail?pId=${v.id}">
								<img class="imageAccueil"
								style="width:100%; height: 300px;""
								src="${pageContext.request.contextPath}/voyage/photoVoyage?idV=${v.id}"
								alt="imageVoyage" ">
								<div class="caption">
									<p>
										Continent : ${v.continent}<br> Prix Soldé :
										${v.prixSolde}<br> Prix : <s>${v.prixDepart}</s><br>
										Date : du ${v.dateDepart} au ${v.dateRetour}<br>
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
			</div>
		</div>
		<div class="col-md-1"></div>

	</div>

</body>
</html>