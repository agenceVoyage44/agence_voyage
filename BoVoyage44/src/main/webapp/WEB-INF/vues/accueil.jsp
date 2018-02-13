<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>page accueil</title>
</head>
<body>

	<h3>
		<a href="${pageContext.request.contextPath}/boVoyage/agent/accueil">Admin
			: aller dans la page agent</a>
	</h3>
<br/>
	<h3>
		<a href="<c:url value="/boVoyage/client/accueil"/>">Client : aller dans la page client</a>
	</h3>

</body>
</html>