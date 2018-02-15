<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rechercher une Reservation</title>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/script_navbar.js"/>"></script>

</head>
<body>
	<div style="height: 90px">
		<%@ include file="/template/headerC.html"%>
	</div>


	<div class="row">
		<div class="col-md-1"></div>

		<div class="col-md-10">
			<div class="panel panel-default">
				<div class="bs-callout bs-callout-color">
					<h3>Liste de vos réservations</h3>


					<table class="table table-bordered">
						<tr>
							<th>Référence</th>
							<th>Statut</th>
							<th>Date de Réservation</th>
							<th>Prix</th>
							<th>Nombre de places Réservées</th>
							<th>Voyage choisi</th>
							<th>Assurance</th>
							<th>Opération</th>
						</tr>

						<tr>
							<td>${resa.id}</td>
							<td>${resa.statut}</td>
							<td>${resa.dateReservation}</td>
							<td>${resa.prix}</td>
							<td>${resa.nbPlaceReservees}</td>
							<td>${resa.voyage.titre}</td>
							<td>${resa.assurance.type}</td>
							<td>
								<button type="button" class="btn btn-primary"
									onclick="location.href = 'modifierLien?pId=${resa.id}'">Valider
									la réservation</button>
								<button type="button" class="btn btn-danger"
									onclick="location.href = 'supprimeLien/${resa.id}'">Supprimer</button>
							
							</td>

						</tr>
					</table>

				</div>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>

</body>
</html>