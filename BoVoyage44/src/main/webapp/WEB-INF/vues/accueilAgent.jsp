<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil agent</title>
<link rel="shortcut icon" type="image/x-icon"
	href="../../images/logo.ico" />

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
		<%@ include file="/template/headerA.html"%></div>



	<div class="row">
		<div class="col-md-1"></div>

		<div class="col-md-10">
			<div class="panel panel-default">
				<div class="bs-callout bs-callout-color">
					<h3>Tableau de bord</h3>
					<br /> <br />
					<h4>Moyenne des formulaires de satisfaction</h4>

					<div>

						<table class="table table-bordered">
							<tr>
								<th>Voyage</th>
								<th>Logement</th>
								<th>Nourriture</th>
								<th>Transport</th>
								<th>Aspect du site internet</th>
								<th>Facilité d'utilisation</th>
								<th>Interlocuteurs</th>

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
		</div>
		<div class="col-md-1"></div>

	</div>
</body>
</html>