<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulaire de modification</title>
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
					<h3>Formulaire de modification de voyage</h3>

					<form:form method="POST" action="soumettreUpdate"
						modelAttribute="voyageModif" cssClass="form-horizontal"
						enctype="multipart/form-data">

						<div class="form-group">
							<form:label path="id" cssClass="col-sm-3 control-label">Id</form:label>
							<div class="col-sm-6">
								<form:input path="id" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="continent" cssClass="col-sm-3 control-label">Continent</form:label>
							<div class="col-sm-6">
								<form:input path="continent" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="pays" cssClass="col-sm-3 control-label">Pays</form:label>
							<div class="col-sm-6">
								<form:input path="pays" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="prixDepart" cssClass="col-sm-3 control-label">Prix de d�part</form:label>
							<div class="col-sm-6">
								<form:input path="prixDepart" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="remise" cssClass="col-sm-3 control-label">Remise</form:label>
							<div class="col-sm-6">
								<form:input path="remise" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="dateDepart" cssClass="col-sm-3 control-label">Date de d�part</form:label>
							<div class="col-sm-6">
								<form:input path="dateDepart" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="dateRetour" cssClass="col-sm-3 control-label">Date de retour</form:label>
							<div class="col-sm-6">
								<form:input path="dateRetour" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="nbPlaces" cssClass="col-sm-3 control-label">Nombre de places disponibles</form:label>
							<div class="col-sm-6">
								<form:input path="nbPlaces" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="description" cssClass="col-sm-3 control-label">Description</form:label>
							<div class="col-sm-6">
								<form:input path="description" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="titre" cssClass="col-sm-3 control-label">Titre</form:label>
							<div class="col-sm-6">
								<form:input path="titre" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="nbPlaces" class="col-sm-3 control-label">Choisissez une priorit�</form:label>
							<div class="col-sm-6">
								<form:label path="priorite">Prioritaire</form:label>
								<form:radiobutton path="priorite" value="true" />

								<form:label path="priorite">Non-Prioritaire</form:label>
								<form:radiobutton path="priorite" value="false" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="nbPlaces" class="col-sm-3 control-label">Choisissez une photo:</form:label>

							<div class="input-field col-sm-6">
								<input type="file" name="file" id="selectedFile"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:label path="formule.id" cssClass="col-sm-3 control-label">ID Formule</form:label>
							<form:select path="formule.id">
								<c:forEach var="f" items="${listeFormules}">
									<form:option value="${f.id}">
										<c:out value="${f.id} ${f.type}"></c:out>
									</form:option>
								</c:forEach>
							</form:select>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-6">
								<input type="submit" class="btn btn-success" value="Modifier" />
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