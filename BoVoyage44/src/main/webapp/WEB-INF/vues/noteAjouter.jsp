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

<link rel="shortcut icon" type="image/x-icon"
	href="../../images/logo.ico" />

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />

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
			<form:label path="voyage" cssClass="col-sm-2 control-label">Note voyage</form:label>
			<div class="col-sm-3">
				<form:select path="voyage" class="form-control">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
				</form:select>
			</div>

		</div>


		<div class="form-group">
			<form:label path="logement" cssClass="col-sm-2 control-label">Veuillez noter votre logement</form:label>
			<div class="col-sm-3">
				<form:select path="logement" class="form-control">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
				</form:select>
			</div>
		</div>

		<div class="form-group">
			<form:label path="transport" cssClass="col-sm-2 control-label">Notez les transports utilisés pendant votre voyage</form:label>
			<div class="col-sm-3">
				<form:select path="transport" class="form-control">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
				</form:select>
			</div>
		</div>

		<div class="form-group">
			<form:label path="nourriture" cssClass="col-sm-2 control-label">Comment jugez vous vos repas?</form:label>
			<div class="col-sm-3">
				<form:select path="nourriture" class="form-control">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
				</form:select>
			</div>
		</div>

		<div class="form-group">
			<form:label path="agent" cssClass="col-sm-2 control-label">Interaction avec nos agents</form:label>
			<div class="col-sm-3">
				<form:select path="agent" class="form-control">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
				</form:select>
			</div>
		</div>
		<div class="form-group">
			<form:label path="siteAspect" cssClass="col-sm-2 control-label">Aspect de notre site</form:label>
			<div class="col-sm-3">
				<form:select path="siteAspect" class="form-control">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
				</form:select>
			</div>
		</div>


		<div class="form-group">
			<form:label path="siteUtil" cssClass="col-sm-2 control-label">Facilité d'utilisation de notre site internet</form:label>
			<div class="col-sm-3">
				<form:select path="siteUtil" class="form-control">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
				</form:select>
			</div>
		</div>


		<div class="form-group">
			<form:label path="comm" class="col-sm-2 control-label">Commentaires</form:label>
			<form:textarea class="form-control" rows="5" path="comm"></form:textarea>
		</div>

		<br />
		<div class="col-sm-offset-2 col-sm-4" style="margin-left: 100px">
			<input type="submit" class="btn btn-info" value="Envoyer">
		</div>

	</form:form>


</body>
</html>