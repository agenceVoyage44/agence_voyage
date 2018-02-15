<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulaire de recherche</title>
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
					<h3>Formulaire de recherche de voyage</h3>

					<form:form method="POST" action="soumettreGet"
						modelAttribute="voyageRecherche" cssClass="form-horizontal">

						<div class="form-group">
							<form:label path="id" cssClass="col-sm-3 control-label">Id</form:label>
							<div class="col-sm-6">
								<form:input path="id" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-6">
								<input type="submit" class="btn btn-success" value="Rechercher" />
							</div>
						</div>

					</form:form>

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
						<tr>
							<td>${voyage.id}</td>
							<td>${voyage.continent}</td>
							<td>${voyage.pays}</td>
							<td>${voyage.prixDepart}</td>
							<td>${voyage.remise}</td>
							<td>${voyage.prixSolde}</td>
							<td>${voyage.dateDepart}</td>
							<td>${voyage.dateRetour}</td>
							<td><img src="${pageContext.request.contextPath}/voyage/photoVoyage?idV=${voyage.id}" height="80px"/></td>
							<td>${voyage.nbPlaces}</td>
							<td>${voyage.dispo}</td>
							<td>${voyage.titre}</td>
							<td>${voyage.description}</td>
							<td>${voyage.priorite}</td>
						</tr>

					</table>
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