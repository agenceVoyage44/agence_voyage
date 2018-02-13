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
<script type="text/javascript" src="resources/js/jquery-3.2.1.js"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>">

</head>



<body>

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
				</tr>
		</c:forEach>

	</table>



</body>
</html>