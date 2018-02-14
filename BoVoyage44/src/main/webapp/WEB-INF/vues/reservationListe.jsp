<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rechercher une Reservation</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />

</head>
<body>

	<h1 style="color: darkred; text-align: center">Liste des
		réservations</h1>


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
		</tr>
		<c:forEach var="reservation" items="${resaListe}">
			<tr>
				<td>${reservation.id}</td>
				<td>${reservation.statut}</td>
				<td>${reservation.dateReservation}</td>
				<td>${reservation.prix}</td>
				<td>${reservation.nbPlaceReservees}</td>
				<td>${reservation.voyage.titre}</td>
				
			</tr>
		</c:forEach>
	</table>


</body>
</html>