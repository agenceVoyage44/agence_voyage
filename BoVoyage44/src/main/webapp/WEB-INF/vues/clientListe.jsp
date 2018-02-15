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
					<h3>Liste des Clients</h3>

					<div>

						<table class="table table-bordered">
							<tr>
								<th>Id</th>
								<th>Civilité</th>
								<th>Nom Prénom</th>
								<th>Mail</th>
								<th>Adresse</th>
								<th>N° de téléphone</th>
								<th>Date de naissance</th>
								<th>Opérations</th>
							</tr>

							<c:forEach var="c" items="${clientList}">

								<tr>
									<td>${c.id}</td>
									<td>${c.civilite}</td>
									<td>${c.nom}${c.prenom}</td>

									<td>${c.mail}</td>
									<td>${c.numero}${c.rue}${c.codePostal}${c.ville}</td>
									<td>${c.tel}</td>
									<td>${c.dateNaissance}</td>

									<td>
										<button type="button" class="btn btn-primary"
											onclick="location.href = 'ModifLien?pId=${c.id}'">Modifier</button>
										<button type="button" class="btn btn-danger"
											onclick="location.href = 'supprimLien?pId=${c.id}'">Supprimer</button>
										<button type="button" class="btn btn-primary"
											onclick="location.href = 'EnvoiFormulaire?pId=${c.id}'">Envoi
											Formulaire de satisfaction</button>
									</td>


								</tr>


							</c:forEach>

						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-1"></div>

	</div>

</body>
</html>