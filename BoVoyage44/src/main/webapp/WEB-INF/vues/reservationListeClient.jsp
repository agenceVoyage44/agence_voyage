<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rechercher une Reservation</title>
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
		<%@ include file="/template/headerC.html"%>
	</div>


	<div class="row">
		<div class="col-md-1"></div>

		<div class="col-md-10">
			<div class="panel panel-default">
				<div class="bs-callout bs-callout-color">
					<h3>Votre réservation</h3>


					<table class="table table-bordered">
						<tr>
							<th>Référence</th>
							<th>Statut</th>
							<th>Date de Réservation</th>
							<th>Prix</th>
							<th>Nombre de places Réservées</th>
							<th>Voyage choisi</th>
							<th>Assurance</th>
							<th>Opération</th>
						</tr>

						<tr>
							<td>${resa.id}</td>
							<td>${resa.statut}</td>
							<td>${resa.dateReservation}</td>
							<td>${resa.prix}</td>
							<td>${resa.nbPlaceReservees}</td>
							<td>${resa.voyage.titre}</td>
							<td>${resa.assurance.type}</td>
							<td>
								<button type="button" class="btn btn-primary"
									onclick="location.href = 'modifierLien?pId=${resa.id}'">Valider
									la réservation</button>
								<button type="button" class="btn btn-danger"
									onclick="location.href = 'supprimeLien/${resa.id}'">Supprimer</button>
								<br /> <br />
								<form action="https://www.paypal.com/cgi-bin/webscr"
									method="post">
									<input type="hidden" name="cmd" value="_s-xclick"> <input
										type="hidden" name="hosted_button_id" value="ADGE2BBQHZT8J">
									<input type="hidden" name="prix" value="<?php print($prix);?>">
									<input type="hidden" name="page_style" value="PayPal">
									<input type="hidden" name="no_shipping" value="0"> <input
										type="hidden" name="return"
										value="http://www.ton_site/confirm_paiement.php"> <input
										type="hidden" name="cancel_return"
										value="http://www.ton_site.fr/annule_transaction.php">
									<input type="hidden" name="no_note" value="1"> <input
										type="hidden" name="currency_code" value="EUR"> <input
										type="hidden" name="lc" value="FR"> <input
										type="hidden" name="bn" value="PP-BuyNowBF"> <input
										type="image"
										src="https://www.paypalobjects.com/fr_FR/FR/i/btn/btn_buynowCC_LG.gif"
										border="0" name="submit"
										alt="PayPal, le réflexe sécurité pour payer en ligne">
									<img alt="" border="0"
										src="https://www.paypalobjects.com/fr_FR/i/scr/pixel.gif"
										width="1" height="1">
								</form>
							</td>

						</tr>
					</table>

				</div>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>

</body>
</html>