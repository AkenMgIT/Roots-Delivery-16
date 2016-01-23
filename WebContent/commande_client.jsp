<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
  <meta name="author" content="GeeksLabs">
  <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
  <link rel="shortcut icon" href="img/favicon.png">
  
  <title>Commande client</title>
  
  <!-- Bootstrap CSS -->
  <link href="backoffice/css/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->
  <link href="backoffice/css/bootstrap-theme.css" rel="stylesheet">
  <!--external css-->
  <!-- font icon -->
  <link href="backoffice/css/elegant-icons-style.css" rel="stylesheet" />
  <link href="backoffice/css/font-awesome.min.css" rel="stylesheet" />
  <!-- Custom styles -->
  <link href="backoffice/css/style.css" rel="stylesheet">
  <link href="backoffice/css/style-responsive.css" rel="stylesheet" />
  
  <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
  <!--[if lt IE 9]>
  <script src="backoffice/js/html5shiv.js"></script>
  <script src="backoffice/js/respond.min.js"></script>
  <script src="backoffice/js/lte-ie7.js"></script>
  <![endif]-->
</head>

<body>
  <!-- container section start -->
  <section id="container" class="">
    <!--header start-->
    <header class="header dark-bg">
      <div class="toggle-nav">
        <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i class="icon_menu"></i></div>
      </div>
      
      <!--logo start-->
      <a href="index.html" class="logo">Roots <span class="lite">Delivery</span></a>
      <!--logo end-->
      
      <div class="top-nav notification-row">
        <!-- notificatoin dropdown start-->
        <ul class="nav pull-right top-menu">
          
          <!-- alert notification start-->
          <!-- user login dropdown start-->
          <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
              <span class="username">Bonjours Variable</span>
              <b class="caret"></b>
            </a>
            <ul class="dropdown-menu extended logout">
              <div class="log-arrow-up"></div>
              <li class="eborder-top">
                <a href="#"><i class="icon_profile"></i>Mon compte</a>
              </li>
              <li>
                <a href="login.html"><i class="icon_key_alt"></i> Déconnexion</a>
              </li>
            </ul>
          </li>
          <!-- user login dropdown end -->
        </ul>
        <!-- notificatoin dropdown end-->
      </div>
    </header>
    <!--header end-->
    
    <!--sidebar start-->
    <jsp:include page="_include/back-nav.jsp"></jsp:include>
    <!--sidebar end-->
<!--main content start-->
<section id="main-content">
  <section class="wrapper">
    <div class="row">
      <div class="col-lg-12">
        <h3 class="page-header"><i class="fa fa-table"></i> Passer une commande</h3>
        <ol class="breadcrumb">
          <li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
          <li><i class="fa fa-user"></i>commandes</li>
        </ol>
      </div>
    </div>
    <!-- page start-->
    <div class="row">
      
      <div class="col-lg-5">
        <section class="panel">
          <header class="panel-heading">
            Liste des produits
          </header>
          <div class="panel-body">
            <table class="table table-striped table-advance table-hover table-bordered">
              <tbody>
                <tr>
                  <th><i class="icon_menu-square_alt2"></i> Produit</th>
                  <th><i class="icon_currency"></i> Prix</th>
                  <th class="text-center"><i class="icon_cogs"></i> Action</th>
                </tr>
                <tr>
                  <td>variable</td>
                  <td>variable</td>
                  <td class="text-center">
                    <a class="btn btn-primary" href="#"><i class="icon_plus"></i></a>
                  </td>
                </tr>
                
              </tbody>
            </table>
          </div>
        </section>
      </div>
      
      <div class="col-lg-7">
        <section class="panel">
          <header class="panel-heading">
            Formulaire Commande
          </header>
          <div class="panel-body">
            <table class="table table-striped table-advance table-hover table-bordered">
              <tbody>
                <tr>
                  <th>#</th>
                  <th><i class="icon_menu-square_alt2"></i> Produit</th>
                  <th><i class="icon_currency"></i> Prix</th>
                  <th><i class="icon_tag"></i> Quantité</th>
                  <th class="text-center"><i class="icon_cogs"></i> Action</th>
                </tr>
                <tr>
                  <td></td>
                  <td>variable</td>
                  <td>variable</td>
                  <td>variable</td>
                  <td class="text-center">
                    <a class="btn btn-danger" href="#"><i class="icon_minus-06"></i></a>
                  </td>
                </tr>
                
                <tr class="warning">
                  <td>Total</td>
                  <td colspan="3"></td>
                  <td>Variable</td>
                </tr>
              </tbody>
            </table>
            <form class="form-horizontal " method="get">
              
              <div class="form-group">
                <label class="col-sm-2 control-label">Adresse</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="Adresse de livraison">
                </div>
              </div>
              
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-primary">Commander</button>
                </div>
              </div>
              
            </form>
          </div>
        </section>
      </div>
      
    </div>
    <!-- Basic Forms & Horizontal Forms-->
    
    <!-- page end-->
  </section>
</section>
<!--main content end-->
</section>
<!-- container section end -->
<!-- javascripts -->
<script src="backoffice/js/jquery.js"></script>
<script src="backoffice/js/bootstrap.min.js"></script>
<!-- nicescroll -->
<script src="backoffice/js/jquery.scrollTo.min.js"></script>
<script src="backoffice/js/jquery.nicescroll.js" type="text/javascript"></script>
<!--custome script for all page-->
<script src="backoffice/js/scripts.js"></script>


</body>
</html>