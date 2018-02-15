<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des voyages</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/script_navbar.js"/>"></script>

</head>
<body>
<div style="height: 90px">
		<%@ include file="/template/headerU.html"%>
	</div>
	
	<form:form method="POST" action="listePays"
		modelAttribute="voyagePays" cssClass="form-horizontal">

		<div class="form-group">
			<form:label path="pays" class="col-sm-2 control-label">Pays</form:label>
			<div class="col-sm-5">
				<form:input path="pays" class="form-control" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-success" value="Rechercher" />
			</div>
		</div>

	</form:form>


	<h1 style="color: darkred; text-align: center">Liste des
		voyages</h1>

	


	<c:forEach var="v" items="${voyageList}">
		<div class="row">
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="#"> <img src="${v.photo}" alt="imageVoyage"
						style="width: 400px; height: 300px;">
						<div class="caption">
							<p>Continent : ${v.continent}<br>
							Description : </p>
							
						</div>
					</a>
				</div>
			</div>
	</c:forEach>

</body>
</html>