<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- ajouter la lib jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- ajouter les balises form de spring mvc -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter une Réservation</title>
<script type="text/javascript" src="resources/js/jquery-3.2.1.js"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>">

</head>
<body>
	<h1 style="text-align: center">Pour effectuer la réseravtion, sélectionnez le nombre de personnes qui effectueront ce voyage</h1>

	<form:form method="POST" action="client/soumettreAdd"
		modelAttribute="resaAdd" cssClass="form-horizontal">
	
		<div class="form-group">
			<form:label path="nbPlaceReservees" class="col-sm-2 control-label">Nombre de places réservées</form:label>
			<div class="col-sm-5">
				<form:input path="nbPlaceReservees" cssClass="form-control" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-success" value="Valider la réservation" />
			</div>
		</div>


	</form:form>
</body>
</html>