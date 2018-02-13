<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulaire de recherche</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"/>

</head>
<body>

<h1 style="color: darkred ; text-align : center">Formulaire de recherche de voyage</h1>

<form:form method="POST" action="soumettreGet"
		modelAttribute="voyageRecherche" cssClass="form-horizontal">
		
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
	
	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Continent</th>
			<th>Pays</th>
			<th>Prix de départ</th>
			<th>Remise</th>
			<th>Prix soldé</th>
			<th>Date de départ</th>
			<th>Date de retour</th>
			<th>Photo</th>
			<th>Nombre de places</th>
			<th>Disponibilité</th>
			<th>Titre</th>
			<th>Description</th>
			<th>Priorité</th>
		</tr>
			<tr>
				<td>${voyage.id}</td>
				<td>${voyage.continent}</td>
				<td>${voyage.pays}</td>
				<td>${voyage.prixDepart}</td>
				<td>${voyage.remise}</td>
				<td>${voyage.prixSolde}</td>
				<td>${voyage.dateDepart}</td>
				<td>${voyage.dateRetour}</td>
				<td>${voyage.photo}</td>
				<td>${voyage.nbPlaces}</td>
				<td>${voyage.dispo}</td>
				<td>${voyage.titre}</td>
				<td>${voyage.description}</td>
				<td>${voyage.priorite}</td>
			</tr>

	</table>
	
	
</body>
</html>