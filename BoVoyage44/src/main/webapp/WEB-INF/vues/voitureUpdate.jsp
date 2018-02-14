<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Ajout de la taglib spring mvc form -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BoVoyage - Agent</title>

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/script_navbar.js"/>"></script>
</head>
<body>


	<div style="height: 90px">
		<%@ include file="/template/headerA.html"%>
	</div>
	<div class="panel panel-default">
		<div class="bs-callout bs-callout-color">
			<h3 style="color: #48494c; text-align: center">Modifier une
				Voiture</h3>

			<form:form method="POST" action="soumettreUpdate"
				modelAttribute="vUpdate" cssClass="form-horizontal"
				enctype="multipart/form-data">

				<div class="form-group">
					<form:label path="id" class="col-sm-2 control-label">Id:</form:label>
					<div class="col-sm-6">
						<form:input path="id" cssClass="form-control" disabled="disabled"/>
					</div>
				</div>
				<div class="form-group">
					<form:label path="loueur" class="col-sm-2 control-label">Loueur:</form:label>
					<div class="col-sm-6">
						<form:input path="loueur" cssClass="form-control" />
					</div>
				</div>
				<div class="form-group">
					<form:label path="modele" class="col-sm-2 control-label">Modèle:</form:label>
					<div class="col-sm-6">
						<form:input path="modele" cssClass="form-control" />
					</div>
				</div>
				<div class="form-group">
					<form:label path="nbPlaces" class="col-sm-2 control-label">Nombre de places:</form:label>
					<div class="col-sm-6">
						<form:input path="nbPlaces" cssClass="form-control" />
					</div>
				</div>
				<div class="form-group">
					<div class="input-field col-sm-6">
						<input type="file" name="file" id="selectedFile"
							class="form-control" />
					</div>
				</div>


				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-6">
						<input type="submit" class="btn btn-success" />
					</div>
				</div>


			</form:form>
			<br /> <a href="liste">Retour</a> <br />
		</div>
	</div>


</body>
</html>