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
<style>
       #map {
        height: 200px;
        width: 20%;
       }
       #contentString{
       	height: 10px;
        width: 5px;
       }
    </style>

</head>

<body onload="initialize()">
<h3>My Google Maps Demo</h3>
    <div id="map"></div>
    <script>
      function initMap() {
        var uluru = {lat: 47.2134338, lng: -1.5616846};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 10,
          center: uluru
        });
        //text infos bulle
  	  var contentString = '<div id="content">'+
  	      '<div id="siteNotice">'+
  	      '</div>'+
  	      '<h3 id="firstHeading" class="firstHeading">Agence</h3>'+
  	      '<div id="bodyContent">'+ 
  	      '<p>24 , rue Crebillon ' +
  	      '44000 Nantes '
  	      '</div>'+ '</div>';
  	//affhage de l'info
  	  var infowindow = new google.maps.InfoWindow({
  	    content: contentString
  	  });
  	   var marker = new google.maps.Marker({
           position: uluru,
           map: map
         });
  	//clic de l'info bulle
  	  marker.addListener('click', function() {
  	    infowindow.open(map, marker);
  	  });
  	
     
      }
 
    </script>
    
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBNbERhjSliTotEcKSzVFsXjtfWD-WmSFw&callback=initMap">
    </script>
    <form:form method="POST" action="soumettreAdd" modelAttribute="AssurAjout" cssClass="form-horizontal">
		<div class="form-group">
			<form:label path="nom" class="col-sm-2 control-label">Nom:</form:label>
			<div class="col-sm-5">
				<form:input path="nom" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<form:label path="demande" class="col-sm-2 control-label">Demande</form:label>
			<div class="col-sm-5">
				<form:input path="demande" cssClass="form-control" />
			</div>
		</div>
				
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-success" value="Ajouter"/>
			</div>
		</div>
	

	</form:form>
</body>

</html>