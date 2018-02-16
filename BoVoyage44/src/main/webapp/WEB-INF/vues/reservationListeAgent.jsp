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
		<%@ include file="/template/headerA.html"%>
	</div>


	<div class="row">
		<div class="col-md-1"></div>

		<div class="col-md-10">
			<div class="panel panel-default">
				<div class="bs-callout bs-callout-color">
					<h3>Liste des réservations</h3>


					<table class="table table-bordered">
						<tr>
							<th>ID</th>
							<th>Statut</th>
							<th>Date de Réservation</th>
							<th>Prix</th>
							<th>Nombre de places Réservées</th>
							<th>Voayge choisi</th>
							<th>Les participants</th>
							<th>Assurance</th>
							<th>Opérations</th>
						</tr>
						<c:forEach var="reservation" items="${resaListe}">
							<tr>
								<td>${reservation.id}</td>
								<td>${reservation.statut}</td>
								<td>${reservation.dateReservation}</td>
								<td>${reservation.prix}</td>
								<td>${reservation.nbPlaceReservees}</td>
								<td>${reservation.voyage.titre}</td>
								<td><%-- ${reservation.listeParticipants} --%></td>
								<td>${reservation.assurance.type}</td>
								<td><button type="button" class="btn btn-primary"
										onclick="location.href = 'afficherUpdate?pId=${reservation.id}'">Modifier le statut</button></td>
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