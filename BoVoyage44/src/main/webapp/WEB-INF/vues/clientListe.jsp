<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- Ajout de la taglib spring mvc form -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Ajouter la librairie JSTL -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste clients</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
	
</head>
<body>

<h1 style="color: dodgerblue; text-align: center">Liste des Clients</h1>
		
		<div style="background-image:url(resources/images/login.jpg)">
		
	<table class="table table-bordered">
		<tr>
			<th class="active">Id</th>
			<th class="active">Référence</th>
			<th class="active">Date de livraison</th>
			<th class="active">Distance</th>
			<th class="active">Poids maximum</th>
			<th class="active">Opérations</th>
		</tr>

		<c:forEach var="c" items="${cargAList}">

			<tr>
				<td class="success">${c.id}</td>
				<td class="danger">${c.reference}</td>
				<td class="info">${c.dateLivraison}</td>

				<td class="warning">${c.distance}</td>
				<td class="success">${c.poidsMax}</td>
				
				<td class="active"><a
					href="${pageContext.request.contextPath}/transport/suprimLienCa?pId=${c.id}">Supprimer</a>
					| <a
					href="${pageContext.request.contextPath}/transport/voirMarchLien?pRef=${c.reference}">Voir Marchandises</a>
				</td>


			</tr>


		</c:forEach>

	</table>
	</div>

</body>
</html>