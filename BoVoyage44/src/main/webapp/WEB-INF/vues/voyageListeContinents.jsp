<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
	<div>
		<%@ include file="/template/headerU.html"%>
	</div>

	<c:if test="${voyageListContinent.isEmpty() }">
		<div class="row">
			<div class="col-md-1"></div>

			<div class="col-md-10">
				<div class="panel panel-default">
					<div class="bs-callout bs-callout-color">
					<br/>
					<br/>
						<h1 style="text-align: center"">Oups ! Pas de
							voyage disponible pour le moment pour ce continent...</h1>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>

		</div>
	</c:if>

	<c:if test="${!voyageListContinent.isEmpty() }">


		<!-- Galerie Dynamique -->
		<div class="slideshow">
			<ul>
				<c:forEach var="v" items="${voyageListContinent}">
					<c:if test="${v.priorite == true }">
						<li><a
							href="${pageContext.request.contextPath}/voyage/lienDetail?pId=${v.id}">
								<figure> <img
									src="${pageContext.request.contextPath}/voyage/photoVoyage?idV=${v.id}"
									alt="" width="450" height="300" "/> <figcaption>
								<h1 id="titreDiapo">${v.titre}</h1>
								<h1 id="reducDiapo">${v.remise}%deréductionpour ce voyage !</h1>
								<h1 id="prixDiapo">${v.prixSolde}euros</h1>
								</figcaption> </figure>
						</a></li>
					</c:if>
				</c:forEach>
			</ul>
		</div>

		<div class="row">
			<div class="col-md-12">

				<div class="panel panel-default">
					<div class="bs-callout bs-callout-color">

						<h1 style="color: #0131B4; text-align: center">Liste des
							voyages</h1>
						<div class="row">
							<c:forEach var="v" items="${voyageListContinent}">

								<div class="col-md-6">
									<div id="voyage" class="thumbnail">
										<h1>${v.titre}</h1>
										<a
											href="${pageContext.request.contextPath}/voyage/lienDetail?pId=${v.id}">
											<img class="imageAccueil"
											style="max-width: 100%; height: 300px;"
											"
								src="${pageContext.request.contextPath}/voyage/photoVoyage?idV=${v.id}"
											alt="imageVoyage"">
											<div class="caption">
												<p>
													<b>Prix initial :</b> <s>${v.prixDepart}</s> <br> <b
														style="color: red"> Prix soldé : ${v.prixSolde}</b><br>
													<b>Dates :</b> du
													<fmt:formatDate value="${v.dateDepart}"
														pattern="dd-MM-yyyy " />

													au
													<fmt:formatDate value="${v.dateRetour}"
														pattern="dd-MM-yyyy " />
												</p>

											</div>
										</a>
									</div>
								</div>

							</c:forEach>
						</div>
					</div>

				</div>
			</div>
		</div>
	</c:if>
</body>
</html>