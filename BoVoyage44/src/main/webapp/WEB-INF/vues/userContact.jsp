<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Ajout de la taglib spring mvc form -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulaire de contact</title>

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
		<%@ include file="/template/headerU.html"%>
	</div>

	<div class="panel panel-default">
		<div class="bs-callout bs-callout-color">
			<h3 style="color: #48494c; text-align: center">Demande
				d'informations</h3>

			<form:form method="POST" action="soumettreEnvoi"
				modelAttribute="user" cssClass="form-horizontal">


				<div class="form-group">
					<form:label path="nom" class="col-sm-2 control-label">Nom</form:label>
					<div class="col-sm-6">
						<form:input path="nom" cssClass="form-control" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="prenom" class="col-sm-2 control-label">Prénom</form:label>
					<div class="col-sm-6">
						<form:input path="prenom" cssClass="form-control" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="mail" class="col-sm-2 control-label">Mail</form:label>
					<div class="col-sm-6">
						<form:input path="mail" cssClass="form-control" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="rue" class="col-sm-2 control-label">Votre message (veuillez renseigner vos coordonnées pour que nous puissions vous répondre) :</form:label>
					<form:textarea class="form-control" rows="5" path="rue"></form:textarea>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" class="btn btn-success" value="Envoyer" />
					</div>
				</div>

			</form:form>

			<p style="color: red; text-align: center">${message}</p>

		</div>
	</div>
</body>
</html>