<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- ajouter la lib jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- ajouter les balises form de spring mvc -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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
		<!-- Header Client -->
		<%@ include file="/template/headerC.html"%>
	</div>
	<div class="row">
		<div class="col-md-1"></div>

		<div class="col-md-10">
			<div class="panel panel-default">
				<div class="bs-callout bs-callout-color">
					<h3>Bienvenue dans votre Espace Client</h3>
					<h4>Votre e-mail: ${mail}</h4>


					<div class="row">
						<div class="col-sm-6 col-md-4">
							<div class="thumbnail">

								<div class="caption">
									<h3>Votre réservation</h3>
									<p style="text-align: center;">Voir et confirmer votre réservation en attente.</p>
									<h3>

										<button type="button" class="btn btn-primary"
											onclick="location.href = '../reservation/client/liste'">Voir</button>

									</h3>
								</div>
							</div>
						</div>



						<div class="col-sm-6 col-md-4">
							<div class="thumbnail">
								<div class="caption">
									<h3>Votre compte</h3>
									<p style="text-align: center;">Modifier vos informations
										personnelles.</p>
									<h3>
										<button type="button" class="btn btn-primary"
											onclick="location.href = '../../agent/client/ModifLien2'">Voir</button>
									</h3>
								</div>
							</div>
						</div>
						
						<div class="col-sm-6 col-md-4">
							<div class="thumbnail">
								<div class="caption">
									<h3>Déconnexion</h3>
									<p style="text-align: center;">Quitter votre espace client.</p>
									<h3>
										<button type="button" class="btn btn-primary"
											onclick="location.href = '../../deconnexion'">Se déconnecter</button>
									</h3>
								</div>
							</div>
						</div>
					</div>


					<br /> <br /> <br />

					<p style="text-align: center;">
						<em>BoVoyage - Tous droits réservés - 2018</em>
					</p>



				</div>
			</div>
		</div>
	</div>
	<div class="col-md-1"></div>

	</div>
</body>
</html>