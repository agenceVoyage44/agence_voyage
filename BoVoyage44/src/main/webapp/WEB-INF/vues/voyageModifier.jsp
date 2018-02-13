<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulaire de modification</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"/>

</head>
<body>

<h1 style="color: darkred ; text-align : center">Formulaire de modification de voyage</h1>

<form:form method="POST" action="soumettreUpdate"
		modelAttribute="voyageModif" cssClass="form-horizontal">
		
		<div class="form-group">
			<form:label path="id" cssClass="col-sm-2 control-label">Id</form:label>
			<div class="col-sm-5">
				<form:input path="id" cssClass="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="continent" cssClass="col-sm-2 control-label">Continent</form:label>
			<div class="col-sm-5">
				<form:input path="continent" cssClass="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="pays" cssClass="col-sm-2 control-label">Pays</form:label>
			<div class="col-sm-5">
				<form:input path="pays" cssClass="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="prixDepart" cssClass="col-sm-2 control-label">Prix de départ</form:label>
			<div class="col-sm-5">
				<form:input path="prixDepart" cssClass="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="remise" cssClass="col-sm-2 control-label">Remise</form:label>
			<div class="col-sm-5">
				<form:input path="remise" cssClass="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="prixSolde" cssClass="col-sm-2 control-label">Prix soldé</form:label>
			<div class="col-sm-5">
				<form:input path="prixSolde" cssClass="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="dateDepart" cssClass="col-sm-2 control-label">Date de départ</form:label>
			<div class="col-sm-5">
				<form:input path="dateDepart" cssClass="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="dateRetour" cssClass="col-sm-2 control-label">Date de retour</form:label>
			<div class="col-sm-5">
				<form:input path="dateRetour" cssClass="form-control" />
			</div>
		</div>
		
		<!-- PHOTO IMAGE A VOIR -->
		
		<div class="form-group">
			<form:label path="nbPlaces" cssClass="col-sm-2 control-label">Nombre de places disponibles</form:label>
			<div class="col-sm-5">
				<form:input path="nbPlaces" cssClass="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="description" cssClass="col-sm-2 control-label">Description</form:label>
			<div class="col-sm-5">
				<form:input path="description" cssClass="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="titre" cssClass="col-sm-2 control-label">Titre</form:label>
			<div class="col-sm-5">
				<form:input path="titre" cssClass="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="priorite">Prioritaire</form:label>
			<form:radiobutton  path="priorite" value="true" />
           
        	<form:label path="priorite">Non-Prioritaire</form:label>
			<form:radiobutton  path="priorite" value="false" />
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-success" value="Modifier" />
			</div>
		</div>
		
	</form:form>
</body>
</html>