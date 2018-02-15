<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/script_navbar.js"/>"></script>

<!-- JS et CSS pour le diapo en haut de page -->
<link rel="stylesheet" href="<c:url value="/resources/css/diapo.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/diapo.js"/>"></script>

</head>
<body>
<body>
	<div style="height: 90px">
		<%@ include file="/template/headerU.html"%>
	</div>

	<!-- Galerie Dynamique -->
	<div class="slideshow">
		<ul>
			<c:forEach var="v" items="${voyageListContinent}">
				<c:if test="${v.priorite == true }">
					<li><a
						href="${pageContext.request.contextPath}/voyage/lienDetail?pId=${v.id}">
							<img
							src="${pageContext.request.contextPath}/voyage/photoVoyage?idV=${v.id}"
							alt="" width="450" height="300" />
					</a></li>
				</c:if>
			</c:forEach>
		</ul>
	</div>

	<h1 style="color: darkred; text-align: center">Liste des voyages
		par Continent</h1>


	<c:forEach var="v" items="${voyageListContinent}">
		<div class="row">
			<div class="col-md-4">
				<div class="thumbnail">
					<p>Voyage : ${v.titre}</p>
					<a
						href="${pageContext.request.contextPath}/voyage/lienDetail?pId=${v.id}">
						<img src="${pageContext.request.contextPath}/voyage/photoVoyage?idV=${v.id}" alt="imageVoyage"
						style="width: 400px; height: 300px;">
						<div class="caption">
							<p>
								Continent : ${v.continent}<br> Prix Soldé : ${v.prixSolde}<br>
								Prix : <s>${v.prixDepart}</s>
								<br> Date : du <fmt:formatDate value="${v.dateDepart}" pattern="dd-MM-yyyy " />
								  
								au <fmt:formatDate value="${v.dateRetour}" pattern="dd-MM-yyyy " /><br> Description : ${v.description}<br>
							</p>

						</div>
					</a>
				</div>
			</div>
	</c:forEach>

</body>
</html>