<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BoVoyage - Agent</title>

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

	<div style="height: 90px">
		<%@ include file="/template/headerA.html"%>
	</div>
	<div class="panel panel-default">
		<div class="bs-callout bs-callout-color">
			<h3 style="color: #48494c; text-align: center">Liste des
				Voitures</h3>


			<a href="afficheAdd">Ajouter</a> <br />

			<table class="table table-bordered">
				<tr>
					<th>Id</th>
					<th>Loueur</th>
					<th>Modèle</th>
					<th>Nombre de places</th>
					<th>Photo</th>

					<th>Opértations</th>
				</tr>
				<c:forEach var="v" items="${vListe}">
					<tr>
						<th>${v.id}</th>
						<th>${v.loueur}</th>
						<th>${v.modele}</th>
						<th>${v.nbPlaces}</th>
						<th></th>
						<th><a href="updateLien">Modifier</a> | <a
							href="deleteLien/${v.id}">Supprimer</a></th>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>




</body>
</html>