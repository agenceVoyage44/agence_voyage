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
					<h3>Formulaire de Recherche</h3>
					<br />
					<form:form method="POST" action="soumettreRechId"
						modelAttribute="clientRech" cssClass="form-horizontal">

						<div class="form-group">
							<form:label path="id" cssClass="col-sm-3 control-label">Id Client</form:label>
							<div class="col-sm-6">
								<form:input path="id" cssClass="form-control" />
							</div>
						</div>


						<br />
						<div class="col-sm-offset-3 col-sm-6" style="margin-left: 300px">
							<input type="submit" class="btn btn-info" value="Afficher">
						</div>

					</form:form>

					<br /> <br />
					<c:if test="${indice==true}">

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



							<tr>
								<td>${client.id}</td>
								<td>${client.civilite}</td>
								<td>${client.nom}${client.prenom}</td>

								<td>${client.mail}</td>
								<td>${client.numero}${client.rue}${client.codePostal}
									${client.ville}</td>
								<td>${client.tel}</td>
								<td>${client.dateNaissance}</td>

								<td>
									<button type="button" class="btn btn-primary"
										onclick="location.href = 'ModifLien?pId=${client.id}'">Modifier</button>
									<button type="button" class="btn btn-danger"
										onclick="location.href = 'supprimLien?pId=${client.id}'">Supprimer</button>
								</td>


							</tr>




						</table>
					</c:if>


					<h4 style="color: red;">${message}</h4>
					<br />
					<button type="button" class="btn btn-primary"
						onclick="location.href = 'liste'">Retour</button>
					<br />
				</div>
			</div>
		</div>
		<div class="col-md-1"></div>

	</div>
</body>
</html>