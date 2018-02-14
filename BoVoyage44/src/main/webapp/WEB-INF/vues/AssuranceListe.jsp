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

	<h1 style="text-align: center">Liste des Assurances</h1>


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
				<td style="text-align: center"><a
					href="${pageContext.request.contextPath}/agent/assurance/supprimeLien/${a.id}">Supprimer</a>
					| <a
					href="${pageContext.request.contextPath}/agent/assurance/modifieLien?pId=${a.id}">Modifier</a></td>
			</tr>
		</c:forEach>

	</table>



</body>
</html>