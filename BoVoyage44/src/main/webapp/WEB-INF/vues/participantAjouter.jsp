<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Ajout de la taglib spring mvc form -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Ajouter la librairie JSTL -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter Client</title>

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/script_navbar.js"/>"></script>

</head>
<body>


	<div style="height: 90px">
		<%@ include file="/template/headerC.html"%>
	</div>



	<div class="row">
		<div class="col-md-1"></div>

		<div class="col-md-10">
			<div class="panel panel-default">
				<div class="bs-callout bs-callout-color">

					<h3>Ajout d'un Participant</h3>
					<br />
					<form:form method="POST" action="soumettreAddPart"
						modelAttribute="partAjout" cssClass="form-horizontal">

						<div class="form-group">
							<form:label path="civilite" cssClass="col-sm-3 control-label">Civilité</form:label>
							<div class="col-sm-6">
								<form:input path="civilite" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="nom" cssClass="col-sm-3 control-label">Nom</form:label>
							<div class="col-sm-6">
								<form:input path="nom" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="prenom" cssClass="col-sm-3 control-label">Prénom</form:label>
							<div class="col-sm-6">
								<form:input path="prenom" cssClass="form-control" />
							</div>
						</div>



						<div class="form-group">
							<form:label path="dateNaissance"
								cssClass="col-sm-3 control-label">Date de naissance</form:label>
							<div class="col-sm-6">
								<form:input type="date" path="dateNaissance"
									cssClass="form-control" />
							</div>
						</div>


						<div class="form-group">
							<form:label path="tel" cssClass="col-sm-3 control-label">N° de téléphone</form:label>
							<div class="col-sm-6">
								<form:input path="tel" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="numero" cssClass="col-sm-3 control-label">N° de rue</form:label>
							<div class="col-sm-6">
								<form:input path="numero" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="rue" cssClass="col-sm-3 control-label">Nom rue</form:label>
							<div class="col-sm-6">
								<form:input path="rue" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="codePostal" cssClass="col-sm-3 control-label">Code Postal</form:label>
							<div class="col-sm-6">
								<form:input path="codePostal" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="ville" cssClass="col-sm-3 control-label">Ville</form:label>
							<div class="col-sm-6">
								<form:input path="ville" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="pays" cssClass="col-sm-3 control-label">Pays</form:label>
							<div class="col-sm-6">
								<form:input path="pays" cssClass="form-control" />
							</div>
						</div>

						<br />
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-6">
								<input type="submit" class="btn btn-success" value="Ajouter">
							</div>
						</div>
<h1>${message}</h1>
					</form:form>
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