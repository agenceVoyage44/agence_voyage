<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Title</title>
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
	
	<br><br><br><br>
	<div class="row">
		<div class="col-md-1"></div>

		<div class="col-md-10">
			<div class="panel panel-default">
				<div class="bs-callout bs-callout-color">
					<h2>${voyage.titre}</h2>
					<center>
						<img
							src="${pageContext.request.contextPath}/voyage/photoVoyage?idV=${voyage.id}"
							height="20%" width="50%" />
					</center>
					<br />
					<div style="text-align: center;">
						<p>
							Pays : ${voyage.pays}<br>							 
							  Prix :${voyage.prixSolde} <br> 
							  Date de depart :	<fmt:formatDate value="${voyage.dateDepart}" pattern="dd-MM-yyyy " />
							<br> Date de retour :<fmt:formatDate value="${voyage.dateRetour}" pattern="dd-MM-yyyy " />
							<br> Nombre de place : ${voyage.nbPlaces}<br>
							Description : ${voyage.description}
						</p>
					<button type="button" class="btn btn-primary"
										onclick="location.href = 
										'<c:url value=" /BoVoyage44/boVoyage/reservation/client/afficherAdd?pID=${voyage.id}"/>'">Réserver</button>
					</div>


				</div>
			</div>
		</div>
		<div class="col-md-1"></div>

	</div>


</body>
</html>