<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib de JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Ajout de la taglib Spring MVC form -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supprimer une formule</title>
<link rel="stylesheet"
	href="<c:url value="/ressources/css/bootstrap.css" />" />
</head>
<body>

<h1>Suppression d'une cargaison routière</h1>
	<br />

	<form:form method="POST" action="soumettreDelete"
		modelAttribute="formuleSupprim" cssClass="form-horizontal">

		<div class="form-group">
			<form:label path="id" cssClass="col-sm-2 control-label">ID</form:label>
			<div class="col-sm-4">
				<form:input path="id" cssClass="form-control" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-success" value="Supprimer" />
			</div>
		</div>
	</form:form>

</body>
</html>