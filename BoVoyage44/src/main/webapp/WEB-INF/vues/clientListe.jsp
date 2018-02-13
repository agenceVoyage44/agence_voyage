<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajout de la taglib spring mvc form -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Ajouter la librairie JSTL -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste clients</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />

</head>
<body>

	<h1 >Liste des Clients</h1>

	<div>

		<table class="table table-bordered">
			<tr>
				<th class="active">Id</th>
				<th class="active">Civilité</th>
				<th class="active">Nom Prénom</th>
				<th class="active">Mail</th>
				<th class="active">Adresse</th>
				<th class="active">N° de téléphone</th>
				<th class="active">Date de naissance</th>
				<th class="active">Opérations</th>
			</tr>

			<c:forEach var="c" items="${clientList}">

				<tr>
					<td class="success">${c.id}</td>
					<td class="danger">${c.civilite}</td>
					<td class="info">${c.nom}${c.prenom}</td>

					<td class="warning">${c.mail}</td>
					<td class="success">${c.numero} ${c.rue} ${c.codePostal}
						${c.ville}</td>
					<td class="danger">${c.tel}</td>
					<td class="danger">${c.dateNaissance}</td>

					<td class="active"><a
						href="${pageContext.request.contextPath}/agent/client/supprimLien?pId=${c.id}">Supprimer</a>
						| <a
						href="${pageContext.request.contextPath}/agent/client/ModifLien?pId=${c.id}">Modifier</a></td>


				</tr>


			</c:forEach>

		</table>
	</div>

</body>
</html>