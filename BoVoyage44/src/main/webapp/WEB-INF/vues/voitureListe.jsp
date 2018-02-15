<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BoVoyage - Agent</title>

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
		<%@ include file="/template/headerA.html"%>
	</div>


	<div class="row">
		<div class="col-md-1"></div>

		<div class="col-md-10">
			<div class="panel panel-default">
				<div class="bs-callout bs-callout-color">
					<h3>
						>Liste des Voitures
					</h3>


					<button type="button" class="btn btn-primary"
						onclick="location.href = 'afficheAdd'">+ Ajouter</button>
					<br /> <br />

					<table class="table table-bordered">
						<tr>
							<th>Id</th>
							<th>Loueur</th>
							<th>Modèle</th>
							<th>Nombre de places</th>
							<th>Photo</th>
							<th>Opértations</th>
						</tr>
						<c:forEach var="v" items="${vListe}">
							<tr>
								<td>${v.id}</td>
								<td>${v.loueur}</td>
								<td>${v.modele}</td>
								<td>${v.nbPlaces}</td>
								<td><img
									src="${pageContext.request.contextPath}/agent/Voiture/photoVoiture?idV=${v.id}"
									height="80px" /></td>
								<td>
									<button type="button" class="btn btn-primary"
										onclick="location.href = 'updateLien?pId=${v.id}'">Modifier</button>
									<button type="button" class="btn btn-danger"
										onclick="location.href = 'deleteLien/${v.id}'">Supprimer</button>
								</td>
							</tr>
						</c:forEach>
					</table>

				</div>
			</div>
		</div>
		<div class="col-md-1"></div>

	</div>


</body>
</html>