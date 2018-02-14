<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>page de recherche</title>

<!-- ajout lib bootstrap -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />

</head>

<body>


	<h1 style="color: red; text-align: center">Formulaire de recherche</h1>

	<form:form method="POST" action="soumettreGet"
		modelAttribute="hebergSearch" cssClass="form-horizontal">

		<div class="form-group">
			<form:label path="id" cssClass="col-sm-2 control-label">Id</form:label>
			<div class="col-sm-6">
				<form:input cssClass="form-control" path="id" />
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-primary" value="Rechercher" />
			</div>
		</div>
	</form:form>
	<c:if test="${indice==true}">
		<h1 style="color: red; text-align: center">Hebergement recherché</h1>

		<table class="table table-bordered">
			<tr>
				<th style="text-align: center">ID</th>
				<th style="text-align: center">Type</th>
				<th style="text-align: center">Prix</th>
				<th style="text-align: center">ID Formule</th>
			</tr>


			<tr>
				<td style="text-align: center">${hebergement.id}</td>
				<td style="text-align: center">${hebergement.type}</td>
				<td style="text-align: center">${hebergement.prix}</td>
				<td style="text-align: center">${hebergement.formule.id}</td>
			</tr>



		</table>
	</c:if>
	<h1 style="color: red; text-align: center">${message}</h1>

</body>

</html>