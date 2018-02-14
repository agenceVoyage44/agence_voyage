<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>page ajout hebergement</title>
<!-- ajout lib bootstrap -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />

</head>

<body>


	<h1 style="color: red; text-align: center">Formulaire d'ajout
		d'hebergement</h1>

	<form:form method="POST" action="soumettreAdd"
		modelAttribute="addHebergement" cssClass="form-horizontal">

		<div class="form-group">
			<form:label path="type" cssClass="col-sm-2 control-label">Type</form:label>
			<div class="col-sm-6">
				<form:input cssClass="form-control" path="type" />
			</div>
		</div>

		<div class="form-group">
			<form:label path="prix" cssClass="col-sm-2 control-label">Prix</form:label>
			<div class="col-sm-6">
				<form:input cssClass="form-control" path="prix" />
			</div>
		</div>
		<div class="form-group">
			<form:label path="formule.id" cssClass="col-sm-2 control-label">ID Formule</form:label>
			<form:select path="formule.id">
				<c:forEach var="f" items="${listeFormules}">
					<form:option value="${f.id}">
						<c:out value="${f.id} ${f.type}"></c:out>
					</form:option>
				</c:forEach>
			</form:select>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-primary" value="ajouter" />
			</div>
		</div>
	</form:form>



</body>

</html>