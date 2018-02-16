<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>page Liste Hebergement</title>
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
					<h3>Liste des Hebergements</h3>

					<button type="button" class="btn btn-primary"
						onclick="location.href = 'afficheAdd'">+ Ajouter</button>
					<button type="button" class="btn btn-primary"
						onclick="location.href = 'afficheGet'">Rechercher</button>
					<br /> <br />

					<table class="table table-bordered">
						<tr>
							<th>ID</th>
							<th>Type</th>
							<th>Prix</th>
							<th>ID Formule et son type</th>
							<th>Operations</th>

						</tr>

						<c:forEach var="h" items="${hList}">
							<tr>
								<td>${h.id}</td>
								<td>${h.type}</td>
								<td>${h.prix}euros</td>
								<td>id:${h.formule.id} , type:${h.formule.type}</td>
								<td>
									<button type="button" class="btn btn-primary"
										onclick="location.href = 'modifieLien?pId=${h.id}'">Modifier</button>
									<button type="button" class="btn btn-danger"
										onclick="location.href = 'supprimeLien/${h.id}'">Supprimer</button>
								</td>

							</tr>

						</c:forEach>

					</table>


				</div>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>


</body>

</html>