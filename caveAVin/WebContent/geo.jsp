<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDx112FebkN_E_DM6WAvowszRDAaNgg5jg&sensor=true"></script>
	<link rel="stylesheet" href="css/commun.css">
	
	
	<script type="text/javascript">
	$(function(){
		navigator.geolocation.getCurrentPosition(affichagePos);
	});
	
	function affichagePos(position){
		var lat = position.coords.latitude;
		var lon = position.coords.longitude;
//		var alt = position.coords.altitude;
		
//		var chaine = "<p>Latitude : " + lat + "</p>";
//		chaine += "<p>Longitude : " + lon + "</p>";
//		chaine += "<p>Altitude : " + alt + "</p>";
		
//		$("#maposition").html(chaine);
		
		lat = 46.474575;
		lon = -0.556954;
		
		var latlng = new google.maps.LatLng(lat, lon);
		var myOptions = {
			zoom : 14,
			center : latlng,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		
//		var map = new google.maps.Map(document.getElementById("map"), myOptions);
		var map = new google.maps.Map($("#map").get(0), myOptions);
		
		var marker = new google.maps.Marker({
			position : latlng,
			map : map,
			title : "Ma position"
		});
		
	}
	</script>

</head>
<body>

	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
		        <a  href="index.jsp" class="navbar-brand active">
		        <span class="glyphicon glyphicon-baby-formula"></span> 
		        <span class="glyphicon glyphicon-baby-formula"></span> 
		        </a>
		          <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		          </button>
		    </div>
			<div class="navbar-collapse collapse" id="navbar-main">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<%= request.getContextPath()%>/index.jsp">Accueil</a></li>
					<li><a href="lister">Liste des films</a></li>
					<li><a href="ajouter">Ajouter un film</a></li>
					<li class="active"><a href="#">Qui sommes-nous</a></li>
				</ul>
			</div>
		</div>
	</nav>		
	
	<div class="container">
		<h1 class = "bleu">Nos coordonnées</h1>
		<br>
			<div class="row">
					<div class="col-xs-12 col-sm-4">
						<div class="panel panel-primary">
							<div class="panel-heading clearfix">
								<h3 class="panel-title"><span class="pull-left">Par téléphone</span> <span class="glyphicon glyphicon-phone-alt pull-right"> </span> </h3>
							</div>	
							<div class="panel-body">
								<p>Du lundi au vendredi de 8h00 à 19h00</p>
								<p class="text-info">06.70.34.12.41</p>
							</div>
							<div class="panel-footer">
								<span><small>N'hésitez pas à me contacter</small></span>
							</div>	
						</div>
					</div>

					<div class="col-xs-12 col-sm-4">
						<div class="panel panel-primary">
							<div class="panel-heading clearfix">
								<h3 class="panel-title"><span class="pull-left">Par mail ou courrier</span> <span class="glyphicon glyphicon-envelope pull-right"> </span></h3>
							</div>	
							<div class="panel-body panel-body-info">
								
									<p>HIGELIN Julien<br>
									10 rue Jean de Saint Goard <br>
									79160 ARDIN</p>
									<p><span class="glyphicon glyphicon-phone-alt pull-right"> </span></p>
									<p><a href="mailto:julien.higelin@gmail.com">julien.higelin@gmail.com</a></p>
								
							</div>
						</div>
					</div>

					<div class="col-xs-12 col-sm-4">
						<div class="panel panel-primary">
							<div class="panel-heading clearfix">
								<h3 class="panel-title"><span class="pull-left">Par réseau social</span> <span class="glyphicon glyphicon-link pull-right"> </span></h3>
							</div>

							<div class="panel-body panel-body-info">
							
						
								<div class="col-xs-6 text-center">
								<p></p>
									<p><a target="viadeo" href="http://fr.viadeo.com/fr/profile/julien.higelin"><img src="img/viadeo.png" border="0" alt="Profil Viadeo"/></a></p>
									<p><a target="viadeo" href="http://fr.viadeo.com/fr/profile/julien.higelin">Viadeo</a></p>

								</div>
								<div class="col-xs-6 text-center">
								<p></p>
									<p><a target="in" href="https://www.linkedin.com/in/julien-higelin-967663104/?originalSubdomain=fr" style="text-decoration:none;"><span style="font: 80% Arial,sans-serif; color:#0783B6;"><img src="img/icone-in.png" width="36" height="36" alt="Voir le profil LinkedIn de Sopra Steria" style="vertical-align:middle;" border="0"></span></a></p>
									<p><a target="in" href="https://www.linkedin.com/in/julien-higelin-967663104/?originalSubdomain=fr" >Linked In</a></p>
								</div>
								
							</div><p></p>
						</div>
					</div>

				</div>
			
		<div id="map"></div>
	</div>
	
	<jsp:include page="footer.jsp" />

</body>
</html>