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
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />

</head>
<body>

	<h1>${voyage.titre}</h1>

	${voyage.photo}
	</br>

	<table>
		<tr>
			<td>Pays</td>
			<td>${voyage.pays}</td>
		</tr>
		<tr>
			<td>prix depart</td>
			<td>${voyage.prixDepart}</td>
		</tr>
		<tr>
			<td>remise</td>
			<td>${voyage.remise}</td>
		</tr>
		<tr>
			<td>prix soldé</td>
			<td>${voyage.prixSolde}</td>
		</tr>
		<tr>
			<td>date de depart</td>
			<td>${voyage.dateDepart}</td>
		</tr>
		<tr>
			<td>date de retour</td>
			<td>${voyage.dateRetour}</td>
		</tr>
		<tr>
			<td>nombre de place</td>
			<td>${voyage.nbPlaces}</td>
		</tr>

		<tr>
			<td>description</td>
			<td>${voyage.description}</td>
		</tr>


	</table>

</body>
</html>