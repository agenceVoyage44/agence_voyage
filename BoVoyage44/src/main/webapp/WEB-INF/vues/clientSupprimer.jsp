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
<title>Supprimer Client</title>

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

	<h1 style="color: dodgerblue; text-align: center">Formulaire de
		suppression</h1>
	<br />
	<form:form method="POST" action="soumettreSupprClient"
		modelAttribute="clientSuppr" cssClass="form-horizontal"
		style="margin-left:600px">

		<div class="form-group">
			<form:label path="id" cssClass="col-sm-2 control-label">Id Client</form:label>
			<div class="col-sm-3">
				<form:input path="id" cssClass="form-control" />
			</div>
		</div>


		<br />
		<div class="col-sm-offset-2 col-sm-10" style="margin-left: 300px">
			<input type="submit" class="btn btn-info" value="Supprimer">
		</div>

	</form:form>


</body>
</html>