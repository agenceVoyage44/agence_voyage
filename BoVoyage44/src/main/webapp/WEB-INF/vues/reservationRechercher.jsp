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
	<h1 style="color: darkred; text-align: center">Formulaire de
		recherche d'une réservation</h1>

	<form:form method="POST" action="soumettreGet" modelAttribute="resaGet"
		cssClass="form-horizontal">

		<div class="form-group">
			<form:label path="id" cssClass="col-sm-2 control-label">Id</form:label>
			<div class="col-sm-5">
				<form:input path="id" cssClass="form-control" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-success" value="Rechercher" />
			</div>
		</div>

	</form:form>

	<c:if test="${indice==true}">
		<h1>Réservation recherchée</h1>
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
			<tr>
				<td>${resaGet.id}</td>
				<td>${resaGet.statut}</td>
				<td>${resaGet.dateReservation}</td>
				<td>${resaGet.prix}</td>
				<td>${resaGet.nbPlaceReservees}</td>
				<td>${resaGet.voyage.titre}</td>

			</tr>

		</table>
	</c:if>

</body>
</html>