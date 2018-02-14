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
<title>Title</title>
<script type="text/javascript" src="resources/js/jquery-3.2.1.js"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>">
<style type="text/css">
.slideshow {
   width: 1700px;
   height: 200px;
   overflow: hidden;
   border: 3px solid #F2F2F2;
}

.slideshow ul {
    /* 4 images donc 4 x 100% */
   width: 400%;
   height: 200px;
   padding:0; margin:0;
   list-style: none;
}
.slideshow li {
   float: left;
}

.textImg{
position: absolute;}
</style>
<script type="text/javascript">
   $(function(){
      setInterval(function(){
         $(".slideshow ul").animate({marginLeft:-350},800,function(){
            $(this).css({marginLeft:0}).find("li:last").after($(this).find("li:first"));
         })
      }, 3500);
   });
</script>
</head>
<body>

<div class="slideshow">
	<ul>
		<li><a href="${pageContext.request.contextPath}/boVoyage/accueil"><img src="images/voyage1.jpg" alt="" width="350" height="200" /></a></li>
		<li><div id="logo"><img src="images/voyage2.jpg" alt="" width="350" height="200" /><h2 class="texteImg"> TOTO </h2></div></li>
		<li><img src="images/voyage3.jpg" alt="" width="350" height="200" /></li>
		<li><img src="images/voyage4.jpg" alt="" width="350" height="200" /></li>
	</ul>
</div>


</body>
</html>