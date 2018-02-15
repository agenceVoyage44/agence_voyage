<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page login</title>

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
</head>
<body>

	
	<div class="row" style=" margin-top: 100px">
		<div class="col-md-1"></div>

		<div class="col-md-10">
			<div class="panel panel-default">
				<div class="bs-callout bs-callout-color">
	
	<form class="form-horizontal" method="post"
		action="j_spring_security_check"
		style="margin-left: 200px; margin-top: 100px">
		<div class="form-group has-primary has-feedback">
			<label class="control-label col-sm-3" for="inputGroupSuccess2">E-mail</label>
			<div class="col-sm-3">
				<div class="input-group">
					<span class="input-group-addon">@</span> <input type="text"
						class="form-control" id="idMail" aria-describedby="E-mail"
						name="j_username">
				</div>
				<span aria-hidden="true"></span> <span id="j_username" class="sr-only">(success)</span>
			</div>
		</div>

		<div class="form-group has-primary has-feedback">
			<label class="control-label col-sm-3" for="inputGroupSuccess2">Mot
				de passe</label>
			<div class="col-sm-3">
				<div class="input-group">
					<span class="input-group-addon">?</span> <input type="password"
						class="form-control" id="idMDP" aria-describedby="Mot de passe"
						name="j_password">
				</div>
				<span aria-hidden="true"></span> <span id="idMDP" class="sr-only">(success)</span>
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-8">
				<br />
				<button type="submit" class="btn btn-primary">Connexion</button>

			</div>
		</div>

	</form>

	<c:if test="${not empty msg}">
		<h4 style="text-align: center; color: red">Identifiant ou mot de
			passe incorrect</h4>
	</c:if>
	
	<a href="<c:url value=" /BoVoyage44/agent/client/afficheAdd"/>" >Pas encore incrit ?</a>

				</div>
			</div>
		</div>
		<div class="col-md-1"></div>

	</div>
</body>
</html>