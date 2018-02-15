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
<title>Moyennes Formulaires</title>

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
				<h3>Moyenne des formulaires de satisfaction</h3>
				
				
					<table class="table table-bordered">
						<tr>
							<th class="active">Voyage</th>
							<th class="active">Logement</th>
							<th class="active">Nourriture</th>
							<th class="active">Transport</th>
							<th class="active">Aspect du site internet</th>
							<th class="active">Facilité d'utilisation</th>
							<th class="active">Interlocuteurs</th>

						</tr>

						<c:forEach var="n" items="${moyenneList}">

							<tr>
								<td>${n.voyage}/5</td>
								<td>${n.logement}/5</td>
								<td>${n.nourriture}/5</td>

								<td>${n.transport}/5</td>
								<td>${n.siteAspect}/5</td>
								<td>${n.siteUtil}/5</td>
								<td>${n.agent}/5</td>

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