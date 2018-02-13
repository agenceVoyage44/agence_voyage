<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib de JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Ajout de la taglib Spring MVC form -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier une formule</title>
<link rel="stylesheet"
	href="<c:url value="/ressources/css/bootstrap.css" />" />
</head>
<body>

	<h1>Modification d'une cargaison routière</h1>
	<br />

	<form:form method="POST" action="soumettreAdd"
		modelAttribute="formuleAjout" cssClass="form-horizontal">

		<div class="form-group">
			<form:label path="id" cssClass="col-sm-2 control-label">ID</form:label>
			<div class="col-sm-4">
				<form:input path="id" cssClass="form-control" />
			</div>
		</div>

		<div class="form-group">
			<form:label path="type" cssClass="col-sm-2 control-label">Type</form:label>
			<div class="col-sm-4">
				<form:input path="type" cssClass="form-control" />
			</div>
		</div>

		<div class="form-group">
			<form:label path="prix" cssClass="col-sm-2 control-label">Prix</form:label>
			<div class="col-sm-4">
				<form:input path="prix" cssClass="form-control" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-success" value="Ajouter" />
			</div>
		</div>
	</form:form>

</body>
</html>