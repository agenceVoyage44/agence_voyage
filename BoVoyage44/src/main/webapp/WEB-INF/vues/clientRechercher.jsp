<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!-- Ajouter la librairie JSTL -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Ajout de la taglib spring mvc form -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rechercher client</title>


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>


	<h1 style="color: dodgerblue; text-align: center">Formulaire de
		Recherche</h1>
	<br />
	<form:form method="POST" action="soumettreRechId"
		modelAttribute="clientRech" cssClass="form-horizontal"
		style="margin-left:600px">

		<div class="form-group">
			<form:label path="id" cssClass="col-sm-2 control-label">Id Client</form:label>
			<div class="col-sm-3">
				<form:input path="id" cssClass="form-control" />
			</div>
		</div>


		<br />
		<div class="col-sm-offset-2 col-sm-10" style="margin-left: 300px">
			<input type="submit" class="btn btn-info" value="Afficher">
		</div>

	</form:form>

	<br />
	<br />
	<c:if test="${indice==true}">

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



			<tr>
				<td class="success">${client.id}</td>
				<td class="danger">${client.civilite}</td>
				<td class="info">${client.nom} ${client.prenom}</td>

				<td class="warning">${client.mail}</td>
				<td class="success">${client.numero} ${client.rue}
					${client.codePostal} ${client.ville}</td>
				<td class="danger">${client.tel}</td>
				<td class="danger">${client.dateNaissance}</td>

				<td class="active"><a
					href="${pageContext.request.contextPath}/agent/client/supprimLien?pId=${client.id}">Supprimer</a>
					| <a
					href="${pageContext.request.contextPath}/agent/client/ModifLien?pId=${client.id}">Modifier</a></td>


			</tr>




		</table>
	</c:if>


	<h1 style="color: red; text-align: center">${message}</h1>

</body>
</html>