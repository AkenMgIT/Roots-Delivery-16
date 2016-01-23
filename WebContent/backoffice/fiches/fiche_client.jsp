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

  <title>DashBoard:Fiche client</title>

  <!-- Bootstrap CSS -->
  <link href="../css/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->
  <link href="../css/bootstrap-theme.css" rel="stylesheet">
  <!--external css-->
  <!-- font icon -->
  <link href="../css/elegant-icons-style.css" rel="stylesheet" />
  <link href="../css/font-awesome.min.css" rel="stylesheet" />
  <!-- Custom styles -->
  <link href="../css/style.css" rel="stylesheet">
  <link href="../css/style-responsive.css" rel="stylesheet" />

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
  <!--[if lt IE 9]>
  <script src="../js/html5shiv.js"></script>
  <script src="../js/respond.min.js"></script>
  <script src="../js/lte-ie7.js"></script>
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
      <a href="index.html" class="logo">Back <span class="lite">Office</span></a>
      <!--logo end-->

      <div class="top-nav notification-row">
        <!-- notificatoin dropdown start-->
        <ul class="nav pull-right top-menu">

          <!-- alert notification start-->
          <!-- user login dropdown start-->
          <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
              <span class="username">Variable</span>
              <b class="caret"></b>
            </a>
            <ul class="dropdown-menu extended logout">
              <div class="log-arrow-up"></div>
              <li class="eborder-top">
                <a href="#"><i class="icon_profile"></i> Mon compte</a>
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
    <jsp:include page="../_include/bo-side.jsp"></jsp:include>
    <!--sidebar end-->
    <!-- sidebar menu end-->
  </div>
</aside>

<!--main content start-->
<section id="main-content">
  <section class="wrapper">
    <div class="row">
      <div class="col-lg-12">
        <h3 class="page-header"><i class="fa fa-table"></i> Données</h3>
        <ol class="breadcrumb">
          <li><i class="fa fa-home"></i><a href="#">Home</a></li>
          <li><i class="fa fa-table"></i><a href="#">Clients</a></li>
          <li><i class="fa fa-file-text"></i>Fiche</li>
        </ol>
      </div>
    </div>
    <!-- page start-->
    <div class="row">
      <div class="col-lg-offset-3 col-lg-6">
        <section class="panel">
          <header class="panel-heading">
            Fiche Client
          </header>
          <div class="panel-body">
            <form class="form-horizontal " method="get">
              <div class="form-group">
                <label class="col-sm-2 control-label">ID</label>
                <div class="col-sm-10">
                  <input class="form-control" id="disabledInput" type="text" placeholder="N/A" disabled="" value="xxIDxx">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">Nom</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="Nom du client" value="variable">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">Prénom</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="Prénom du client" value="variable">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">Numéro de Telephone</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="ex : +261 03X XX XXX XX" value="variable">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">Adresse email*</label>
                <div class="col-sm-10">
                  <input type="email" class="form-control" placeholder="ex : xxxx.xxxx@xxxx.xx" value="variable">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">Mot de passe*</label>
                <div class="col-sm-10">
                  <input type="text"  class="form-control" placeholder="" value="variable">
                  <span class="help-block">le mot de passe doit être superieur à 3 characteres.</span>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-primary">Modifier</button>
                </div>
              </div>

            </form>
          </div>
        </section>
      </div>
    </div>
    <!-- Basic Forms & Horizontal Forms-->


    <div class="row">
      <div class="col-lg-12">
        <section class="panel">
          <header class="panel-heading">
            Liste des Commandes du client
          </header>

          <table class="table table-striped table-advance table-hover">
            <tbody>
              <tr>
                <th><i class="icon_document_alt"></i> ID</th>
                <th><i class="icon_pin"></i> Adresse</th>
                <th><i class="icon_clock"></i> Date</th>
                <th><i class="icon_question_alt"></i> Etat</th>
                <th class="text-center"><i class="icon_cogs"></i> Action</th>
              </tr>
              <tr>
                <td>variable</td>
                <td>variable</td>
                <td>variable</td>
                <td>variable</td>
                <td class="text-center">
                  <div class="btn-group">
                    <a class="btn btn-primary" href="#">Détails</a>
                    <a class="btn btn-danger" href="#">Supprimer</i></a>
                  </div>
                </td>
              </tr>
            </tbody>
          </table>
        </section>
      </div>
    </div>
    <!-- page end-->
  </section>
</section>
<!--main content end-->
</section>
<!-- container section end -->
<!-- javascripts -->
<script src="../js/jquery.js"></script>
<script src="../js/bootstrap.min.js"></script>
<!-- nicescroll -->
<script src="../js/jquery.scrollTo.min.js"></script>
<script src="../js/jquery.nicescroll.js" type="text/javascript"></script>
<!--custome script for all page-->
<script src="../js/scripts.js"></script>


</body>
</html>