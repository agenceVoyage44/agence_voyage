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
<td>Pays
</td>

				${voyage.pays}
				</tr>
				<tr>
				${voyage.prixDepart}
				</tr>
				<tr>
				${voyage.remise}
				</tr>
				<tr>
				${voyage.prixSolde}
				</tr>
				<tr>
				${voyage.dateDepart}
				</tr>
				<tr>
				${voyage.dateRetour}
				</tr>
				<tr>
				${voyage.nbPlaces}
				</tr>
				<tr>
				${voyage.dispo}
				</tr>
				<tr>
				${voyage.description}
				</tr>
				<tr>
				${voyage.priorite}
				</tr>
				
				</table>

</body>
</html>