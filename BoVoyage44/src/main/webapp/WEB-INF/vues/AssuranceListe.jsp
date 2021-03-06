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


	<div class="row">
		<div class="col-md-1"></div>

		<div class="col-md-10">
			<div class="panel panel-default">
				<div class="bs-callout bs-callout-color">
					<h3>Liste des assurances</h3>

					<button type="button" class="btn btn-primary"
						onclick="location.href = 'afficheAdd'">+ Ajouter</button>
					<br /> <br />
					<table class="table table-bordered">
						<tr>
							<th>Id</th>
							<th>Type</th>
							<th>Prix</th>
							<th>Operations</th>
						</tr>

						<c:forEach var="a" items="${ListeAssurance}">
							<tr>
								<td>${a.id}</td>
								<td>${a.type}</td>
								<td>${a.prix}</td>
								<td>
									<button type="button" class="btn btn-primary"
										onclick="location.href = 'modifieLien?pId=${a.id}'">Modifier</button>
									<button type="button" class="btn btn-danger"
										onclick="location.href = 'supprimeLien/${a.id}'">Supprimer</button>
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