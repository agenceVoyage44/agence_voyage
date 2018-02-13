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
<script type="text/javascript" src="resources/js/jquery-3.2.1.js"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>">

</head>
<body>

	<h1 style="text-align: center">Formulaire de recherche Par Id</h1>

	<form:form method="POST" action="soumettreGet"
		modelAttribute="MarchRecherche" cssClass="form-horizontal">
		<div class="form-group">
			<form:label path="id class="col-sm-2 control-label">ID </form:label>
			<div class="col-sm-5">
				<form:input path="id" cssClass="form-control" />
			</div>
</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn btn-success" value="Rechercher" />
				</div>
			</div>
	</form:form>

	<table class="table table-bordered">

		<tr>
			<th>Id</th>
			<th>Type</th>
			<th>Prix</th>
			<th>Operations</th>
		</tr>
			
				<tr>
					<td>${assurance.id}</td>
					<td>${assurance.type}</td>
					<td>${assurance.prix}</td>
				</tr>


	</table>


</body>
</html>