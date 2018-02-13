<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulaire de suppression</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"/>

</head>
<body>

<h1 style="color: darkred ; text-align : center">Formulaire d'ajout de voyage</h1>

<form:form method="POST" action="soumettreDelete"
		modelAttribute="voyageSupprim" cssClass="form-horizontal">
		
		<div class="form-group">
			<form:label path="id" cssClass="col-sm-2 control-label">Id</form:label>
			<div class="col-sm-5">
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