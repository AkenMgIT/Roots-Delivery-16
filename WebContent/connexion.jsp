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
  
  <title>Roots-Delivery: Connexion</title>
  
  <!-- Bootstrap Core CSS -->
  <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
  
  <!-- Custom Fonts -->
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css" type="text/css">
  
  <!-- Plugin CSS -->
  <link rel="stylesheet" href="css/animate.min.css" type="text/css">
  
  <!-- Custom CSS -->
  <link rel="stylesheet" href="css/creative.css" type="text/css">
  <link rel="stylesheet" href="css/custom.css" type="text/css">
  
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
        <div class="row">
          <!-- COLONNE DE GAUCHE -->
          <div class="col-lg-6">
            <div class="panel">
              <div class="panel-body">
                <legend>Connexion</legend>
                <form class="form-horizontal" method="post" action="Connexion-Input">
                  
                  <div class="form-group">
                    <div class="col-sm-12">
                      <input type="text" class="form-control" placeholder="Email" name="email">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-12">
                      <input type="password" class="form-control" placeholder="Mot de passe" name="mdp">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-12">
                      <button type="submit" class="btn btn-primary">Connexion</button>
                    </div>
                  </div>
                  
                </form>
              </div>
            </div>
          </div>
          
          <!-- COLONNE DE DROITE -->
          <div class="col-lg-6">
            <div class="panel">
              <div class="panel-body">
                <legend>Inscription</legend>
                <form class="form-horizontal" method="post" action="">
                  
                  <div class="form-group">
                    <div class="col-sm-12">
                      <input type="text" class="form-control" placeholder="Votre nom">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-12">
                      <input type="text" class="form-control" placeholder="Votre prénom">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-12">
                      <input type="text" class="form-control" placeholder="Votre numero de telephone">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-12">
                      <input type="email" class="form-control" placeholder="Votre email*">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-12">
                      <input type="text"  class="form-control" placeholder="votre mot de passe*">
                      <span class="help-block text-left"><small>le mot de passe doit être superieur à 6 characteres.</small></span>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-12">
                      <button type="submit" class="btn btn-primary">S'inscrire</button>
                    </div>
                  </div>
                  
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </header>
  
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
  
</body>
</html>