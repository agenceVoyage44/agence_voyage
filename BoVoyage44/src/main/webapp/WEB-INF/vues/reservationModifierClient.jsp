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
<title>Modifier une R�servation (Client)</title>
<script type="text/javascript" src="resources/js/jquery-3.2.1.js"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/script_navbar.js"/>"></script>

</head>
<body>


	<div style="height: 90px">
		<%@ include file="/template/headerC.html"%>
	</div>




	<div class="row">
		<div class="col-md-1"></div>

		<div class="col-md-10">
			<div class="panel panel-default">
				<div class="bs-callout bs-callout-color">

					<h3>V�rifier votre r�servation</h3>

					<form:form method="POST" action="soumettreUpdate"
						modelAttribute="resaUpdateC" cssClass="form-horizontal">

						<h4>Le prix maximum de votre r�servation actuelle est
							${prixMax} Euros</h4>

						<div class="form-group">
							<form:label path="id" class="col-sm-3 control-label">R�f�rence de la r�servation</form:label>
							<div class="col-sm-6">
								<form:input path="id" cssClass="form-control" />
							</div>
						</div>
						<br />

						<div class="form-group">
							<form:label path="voyage.id" class="col-sm-3 control-label">Voyage choisi</form:label>
							<div class="col-sm-6">
								<form:input path="voyage.id" cssClass="form-control" />
							</div>
						</div>
						<br />
						<div class="form-group">
							<form:label path="assurance.id" cssClass="col-sm-3 control-label">Assurance</form:label>

							<div class="col-sm-6">
								<form:select path="assurance.id">
									<c:forEach var="a" items="${listeAssurance}">
										<form:option value="${a.id}">
											<c:out value="${a.type} ${a.prix}"></c:out>
										</form:option>
									</c:forEach>
								</form:select>
							</div>
						</div>



						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-6">
								<input type="submit" class="btn btn-success"
									value="Valider la r�servation" />
							</div>
						</div>


					</form:form>

					<button type="button" class="btn btn-primary"
						onclick="location.href = 'liste'">Retour</button>
					<br />
				</div>
			</div>
		</div>
		<div class="col-md-1"></div>

	</div>
</body>
</html>