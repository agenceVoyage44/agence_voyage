<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- ajouter la lib jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- ajouter les balises form de spring mvc -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assurance</title>
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
	<h1 style="text-align: center">Formulaire d'ajout Assurance</h1>

	<form:form method="POST" action="soumettreAdd"
		modelAttribute="AssurAjout" cssClass="form-horizontal">
		<div class="form-group">
			<form:label path="type" class="col-sm-2 control-label">Type</form:label>
			<div class="col-sm-5">
				<form:input path="type" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<form:label path="prix" class="col-sm-2 control-label">Prix</form:label>
			<div class="col-sm-5">
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