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
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/script_navbar.js"/>"></script>
</head>
<body>
	<!-- Header User -->
	<%@ include file="/template/headerC.html"%>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<c:forEach var="v" items="${voyageList}">
		<div class="row">
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="#"> <img src="${v.photo}" alt="voyage1"
						style="width: 400px; height: 300px;">
						<div class="caption">
							<p>${v.continent}</p>
						</div>
					</a>
				</div>
			</div>
	</c:forEach>

</body>




</html>