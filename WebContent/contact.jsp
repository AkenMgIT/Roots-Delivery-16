<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  
  <title>Roots-Delivery : Contact</title>
  
  <!-- Bootstrap Core CSS -->
  <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
  
  <!-- Custom Fonts -->
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css" type="text/css">
  
  <!-- Plugin CSS -->
  <link rel="stylesheet" href="css/animate.min.css" type="text/css">
  
  <!-- Custom CSS -->
  <link rel="stylesheet" href="css/creative.css" type="text/css">
  <link rel="stylesheet" href="css/custom.min.css" type="text/css">
  
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
  
</head>

<body id="page-top">
  
  <jsp:include page="_include/front-nav.jsp"></jsp:include>
  
  <header>
    <div class="header-content">
      <div class="header-content-inner">
        <h1>Contact</h1>
        <hr>
        <p>Allures gardait eut noircir diables art son contree maudite ici. Flamboyer tarderait et pu on expliquer succedent etendards. Fille irise pente net jet connu femme laque.</p>
        <a href="#info" class="btn btn-primary btn-xl page-scroll"><i class="fa fa-2x fa-caret-down wow bounceIn text-default" style="visibility: visible; animation-name: bounceIn;"></i></a>
      </div>
    </div>
  </header>
  
  <section id="info">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
          <h2 class="section-heading">Nos informations</h2>
          <hr class="primary">
        </div>
      </div>
    </div>
    
    <div class="container">
      <div class="row">
        <div class="col-lg-4">
          
          <div class="pane">
            <div class="panel-body">
              <address class="text-right">
                <strong>RootsDelivery.</strong><br>
                1355 Market Street, Suite 900<br>
                San Francisco, CA 94103<br>
                <abbr title="Telephone">Tel:</abbr> (+261) xxx-xxx-xxx-xxx
              </address>
              
              <address class="text-right">
                <strong>Email</strong><br>
                <a href="mailto:#">first.last@example.com</a>
              </address>
            </div>
          </div>
          
        </div>
        
        <div class="col-lg-8">
          
          <div class="panel panel-default">
            <div class="panel-body">
              
              <p>Google Map</p>
              <div id="map-container"></div>
            </div>
          </div>
          
        </div>
        
      </div>
    </div>
    
  </section>
  
  <!-- jQuery -->
  <script src="js/jquery.js"></script>
  
  <!-- Bootstrap Core JavaScript -->
  <script src="js/bootstrap.min.js"></script>
  
  <!-- Plugin JavaScript -->
  <script src="js/jquery.easing.min.js"></script>
  <script src="js/jquery.fittext.js"></script>
  <script src="js/wow.min.js"></script>
  
  <!-- Custom Theme JavaScript -->
  <script src="js/creative.js"></script>
  <script src="http://maps.google.com/maps/api/js?sensor=false"></script>
  <script>
  
  function init_map() {
    var var_location = new google.maps.LatLng(-18.912180, 47.521054);
    
    var var_mapoptions = {
      center: var_location,
      zoom: 14
    };
    
    var var_marker = new google.maps.Marker({
      position: var_location,
      map: var_map,
      title:"Venice"});
      
      var var_map = new google.maps.Map(document.getElementById("map-container"),
      var_mapoptions);
      
      var_marker.setMap(var_map);
      
    }
    
    google.maps.event.addDomListener(window, 'load', init_map);
    
    </script>
    
  </body>
</html>