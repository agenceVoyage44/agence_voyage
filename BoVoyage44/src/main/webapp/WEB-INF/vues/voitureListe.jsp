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
			<div class="panel panel-default" style="background-color: #f0f0f0">
				<div class="bs-callout bs-callout-color">
					<h3 style="color: #48494c; text-align: center"><b>Liste des
						Voitures</b></h3>


					<button type="button" class="btn btn-primary"
						onclick="location.href = 'afficheAdd'">+ Ajouter</button>
					<br /> <br />
					
					<table class="table table-bordered" style="text-align: center;">
						<tr class="success" >
							<th style="text-align: center;">Id</th>
							<th style="text-align: center;">Loueur</th>
							<th style="text-align: center;">Modèle</th>
							<th style="text-align: center;">Nombre de places</th>
							<th style="text-align: center;">Photo</th>
							<th style="text-align: center;">Opértations</th>
						</tr>
						<c:forEach var="v" items="${vListe}">
							<tr class="active">
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