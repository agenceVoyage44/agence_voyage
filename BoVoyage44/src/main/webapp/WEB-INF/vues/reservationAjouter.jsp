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
<title>Ajouter une Réservation</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/script_navbar.js"/>"></script>

</head>
<body>
	<!-- Header User -->
	<%@ include file="/template/headerU.html"%>

<br><br><br><br><br>
<div class="row" style="margin-right: 200px;margin-left: 150px;">
		<div class="col-md-1"></div>

		<div class="col-md-10">
			<div class="panel panel-default">
				<div class="bs-callout bs-callout-color">
	<h1 style="text-align: center">Effectuez votre réservation</h1>
	<br>
	<form:form method="POST" action="soumettreAdd" modelAttribute="resaAdd" cssClass="form-horizontal" style="margin-left: 150px;">

		<div class="form-group" >
			<form:label path="voyage.id" class="col-sm-2 control-label">Voyage choisi</form:label>
			<div class="col-sm-5">
				<form:input path="voyage.id" cssClass="form-control" />
			</div>
		</div>


		<div class="form-group">
			<form:label path="nbPlaceReservees" class="col-sm-2 control-label">Nombre de places réservées</form:label>
			<div class="col-sm-5">
				<form:input path="nbPlaceReservees" cssClass="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="assurance.id" cssClass="col-sm-2 control-label">Assurance</form:label>
			<form:select path="assurance.id">
				<c:forEach var="a" items="${listeAssurance}">
					<form:option value="${a.id}">
						<c:out value="${a.type} ${a.prix}"></c:out>
					</form:option>
				</c:forEach>
			</form:select>
		</div>



		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-success"
					value="Valider la réservation" />
			</div>
		</div>


	</form:form>
	
	
	
					</div>
			</div>
		</div>
		<div class="col-md-1"></div>

	</div>
</body>
</html>