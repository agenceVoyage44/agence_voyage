<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BoVoyage</title>


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
		<%@ include file="/template/headerC.html"%>
	</div>

	<div class="row">
		<div class="col-md-1"></div>

		<div class="col-md-10">
			<div class="panel panel-default">
				<div class="bs-callout bs-callout-color">
					<h3>Souhaitez vous ajouter un autre particpant ?</h3>
					<br /> <a
						href="${pageContext.request.contextPath}/boVoyage/reservation/client/afficherAddPart">Oui</a>
					<a
						href="${pageContext.request.contextPath}/boVoyage/client/accueil">Non</a>

				</div>
			</div>
		</div>
		<div class="col-md-1"></div>

	</div>

</body>
</html>