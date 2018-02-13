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

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
	
</head>
<body>

<h1 style="color: dodgerblue; text-align: center">Formulaire de suppression</h1>
<br/>
	<form:form method="POST" action="soumettreSupprClient"
		modelAttribute="clientSuppr" cssClass="form-horizontal" style="margin-left:600px">

		<div class="form-group">
			<form:label path="clientSuppr" cssClass="col-sm-2 control-label">Id Client</form:label>
			<div class="col-sm-3">
				<form:input path="clientSuppr" cssClass="form-control" />
			</div>
		</div>

		
<br/>
		<div class="col-sm-offset-2 col-sm-10" style="margin-left:300px">
			<input type="submit" class="btn btn-info" value="Supprimer">
		</div>

	</form:form>


</body>
</html>