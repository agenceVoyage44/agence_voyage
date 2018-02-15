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
<title>Formulaire de satisfaction</title>

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/script_navbar.js"/>"></script>

</head>
<body>

	<h1>Formulaire de satisfaction</h1>
	<br />
	<form:form method="POST" action="soumettreAdd"
		modelAttribute="noteAjout" cssClass="form-horizontal"
		style="margin-left:600px">

		<div class="form-group">
			<form:label path="voyage" cssClass="col-sm-2 control-label">Note voyage sur 5</form:label>
			<div class="col-sm-3">
				<form:input path="voyage" cssClass="form-control" />
			</div>
		</div>

		<div class="form-group">
			<form:label path="logement" cssClass="col-sm-2 control-label">Veuillez noter votre logement (/5)</form:label>
			<div class="col-sm-3">
				<form:input path="logement" cssClass="form-control" />
			</div>
		</div>

		<div class="form-group">
			<form:label path="transport" cssClass="col-sm-2 control-label">Notez les transports utilisés pendant votre voyage (/5)</form:label>
			<div class="col-sm-3">
				<form:input path="transport" cssClass="form-control" />
			</div>
		</div>

		<div class="form-group">
			<form:label path="nourriture" cssClass="col-sm-2 control-label">Comment jugez vous vos repas? (/5)</form:label>
			<div class="col-sm-3">
				<form:input path="nourriture" cssClass="form-control" />
			</div>
		</div>

		<div class="form-group">
			<form:label path="agent" cssClass="col-sm-2 control-label">Interaction avec nos agents (/5)</form:label>
			<div class="col-sm-3">
				<form:input path="agent" cssClass="form-control" />
			</div>
		</div>

		<div class="form-group">
			<form:label path="siteAspect" cssClass="col-sm-2 control-label">Aspect de notre site (/5)</form:label>
			<div class="col-sm-3">
				<form:input path="siteAspect" cssClass="form-control" />
			</div>
		</div>


		<div class="form-group">
			<form:label path="siteUtil" cssClass="col-sm-2 control-label">Facilité d'utilisation de notre site internet (/5)</form:label>
			<div class="col-sm-3">
				<form:input path="siteUtil" cssClass="form-control" />
			</div>
		</div>


		<div class="form-group">
					<form:label path="comm" class="col-sm-2 control-label">Commentaires</form:label>
					<form:textarea class="form-control" rows="5" path="comm"></form:textarea>
				</div>

		<br />
		<div class="col-sm-offset-3 col-sm-10" style="margin-left: 300px">
			<input type="submit" class="btn btn-info" value="Envoyer">
		</div>

	</form:form>


</body>
</html>