<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Page de recherche</title>

<script type="text/javascript" src="resources/js/jquery-3.2.1.js"></script>

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


	<div class="row">
		<div class="col-md-1"></div>

		<div class="col-md-10">
			<div class="panel panel-default">
				<div class="bs-callout bs-callout-color">

					<h3>Formulaire de recherche</h3>

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
						<h3>Hebergement
							recherché</h3>

						<table class="table table-bordered">
							<tr>
								<th style="text-align: center">ID</th>
								<th style="text-align: center">Type</th>
								<th style="text-align: center">Prix</th>
								<th style="text-align: center">ID Formule et son type</th>
							</tr>


							<tr>
								<td style="text-align: center">${hebergement.id}</td>
								<td style="text-align: center">${hebergement.type}</td>
								<td style="text-align: center">${hebergement.prix}euros</td>
								<td style="text-align: center">id:${hebergement.formule.id}
									, type:${hebergement.formule.type}</td>
							</tr>



						</table>
					</c:if>
					<h3 style="color: red;">${message}</h3>

				</div>
			</div>
		</div>
		<div class="col-md-1"></div>

	</div>


</body>

</html>