<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page login</title>
</head>
<body>

	<form action="j_spring_security_check" method="post">
		Identifiant: <input type="text" name="j_username" /> <br /> Mot de
		passe: <input type="text" name="j_password" /> <br /> <input
			type="submit" value="Se Connecter" />

	</form>
	<c:if test="${not empty msg}">
		<h4 style="text-align: center; color: red">L'identifiant ou mot
			de passe éronné</h4>

	</c:if>

</body>
</html>