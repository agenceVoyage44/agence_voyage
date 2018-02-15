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
<title>Title</title>
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



	<div class="row">
		<div class="col-md-1"></div>

		<div class="col-md-10">
			<div class="panel panel-default">
				<div class="bs-callout bs-callout-color">
					<h3>Formulaire de modif Assurance</h3>

					<form:form method="POST" action="soumettreUpdate"
						modelAttribute="AssurModif" cssClass="form-horizontal">
						<div class="form-group">
							<form:label path="id" class="col-sm-3 control-label">ID</form:label>
							<div class="col-sm-6">
								<form:input path="id" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<form:label path="type" class="col-sm-3 control-label">Type</form:label>
							<div class="col-sm-6">
								<form:input path="type" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<form:label path="prix" class="col-sm-3 control-label">Prix</form:label>
							<div class="col-sm-6">
								<form:input path="prix" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-6">
								<input type="submit" class="btn btn-success" value="Modifier" />
							</div>
						</div>
					</form:form>

					<br />

					<button type="button" class="btn btn-primary"
						onclick="location.href = 'liste'">Retour</button>
					<br />
				</div>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>
</body>
</html>