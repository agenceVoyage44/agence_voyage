<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Ajout de la taglib spring mvc form -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulaire de contact</title>

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
		<%@ include file="/template/headerU.html"%>
	</div>
	<div class="row">
		<div class="col-md-1"></div>

		<div class="col-md-10">


			<div class="panel panel-default">
				<div class="bs-callout bs-callout-color">
				
				
				
				
					<div class="row"
						style="background-color: #ffffff; border-radius: 25px; border-style: solid">
						<div class="col-md-4">
							<h2>
								<b>- BoVoyage -</b>
							</h2>
							<br>
							<h4>Adresse : 24 rue Crebillon, 44000 Nantes</h4>
							<br>
							<h4>
								Horaires : <br /> Du Mardi au Samedi : 9h - 19h
							</h4>

						</div>
						<div class="col-md-4">
							<h4>
								Tel : 02 60 60 60 60<br /> Fax : 02 80 80 80 80 <br /> <br />
								Mail: <em>bo.voyage@bv.fr</em>
							</h4>
						</div>
						<div class="col-md-4">
							<img src="../images/agence.jpg"
								style="border-style: solid; border-radius: 25px;" width="398px"/>
						</div>
					</div>





					<h2>Demande d'informations</h2>
					<br>
					<form:form method="POST" action="soumettreEnvoi"
						modelAttribute="user" cssClass="form-horizontal">


						<div class="form-group">
							<form:label path="nom" class="col-sm-3 control-label">Nom</form:label>
							<div class="col-sm-6">
								<form:input path="nom" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="prenom" class="col-sm-3 control-label">Pr�nom</form:label>
							<div class="col-sm-6">
								<form:input path="prenom" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="mail" class="col-sm-3 control-label">Mail</form:label>
							<div class="col-sm-6">
								<form:input path="mail" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="rue" class="col-sm-3 control-label">Votre message (veuillez renseigner vos coordonn�es pour que nous puissions vous r�pondre) :</form:label>
							<div class="col-sm-6">
								<form:textarea class="form-control" rows="5" path="rue"></form:textarea>
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-6">
								<input type="submit" class="btn btn-success" value="Envoyer" />
							</div>
						</div>

					</form:form>

					<p style="color: red; text-align: center">${message}</p>

				</div>
			</div>
		</div>
	</div>
	<div class="col-md-1"></div>



</body>
</html>