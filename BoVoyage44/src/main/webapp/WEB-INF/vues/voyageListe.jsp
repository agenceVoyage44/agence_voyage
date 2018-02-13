<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des voyages</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>">

</head>
<body>


	<h1 style="color: darkred; text-align: center">Liste des
		voyages</h1>

	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Continent</th>
			<th>Pays</th>
			<th>Prix de d�part</th>
			<th>Remise</th>
			<th>Prix sold�</th>
			<th>Date de d�part</th>
			<th>Date de retour</th>
			<th>Photo</th>
			<th>Nombre de places</th>
			<th>Disponibilit�</th>
			<th>Titre</th>
			<th>Description</th>
			<th>Priorit�</th>
		</tr>
		<c:forEach var="v" items="${voyageList }">
			<tr>
				<td>${v.id}</td>
				<td>${v.continent}</td>
				<td>${v.pays}</td>
				<td>${v.prixDepart}</td>
				<td>${v.remise}</td>
				<td>${v.prixSolde}</td>
				<td>${v.dateDepart}</td>
				<td>${v.dateRetour}</td>
				<td>${v.photo}</td>
				<td>${v.nbPlaces}</td>
				<td>${v.dispo}</td>
				<td>${v.titre}</td>
				<td>${v.description}</td>
				<td>${v.priorite}</td>
			</tr>

		</c:forEach>

	</table>


</body>
</html>