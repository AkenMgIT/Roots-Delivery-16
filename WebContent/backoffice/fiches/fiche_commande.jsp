<%@page import="akenmg.rootsdelivery.model.PlaCom"%>
<%@page import="akenmg.rootsdelivery.model.Commande"%>
<%@page import="akenmg.rootsdelivery.model.view.CommandeView"%>
<%
Commande com = (Commande)request.getAttribute("commande");
CommandeView commandeV = new CommandeView(com);
%>

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

  <title>DashBoard:Fiche Commande</title>

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
    <jsp:include page="bo-side.jsp"></jsp:include>
    <!--sidebar end-->
    <!-- sidebar menu end-->
  </div>
</aside>

<!--main content start-->
<section id="main-content">
  <section class="wrapper">
    <div class="row">
      <div class="col-lg-12">
        <h3 class="page-header"><i class="fa fa-table"></i> Détails Commande</h3>
        <ol class="breadcrumb">
          <li><i class="fa fa-home"></i><a href="#">Home</a></li>
          <li><i class="fa fa-table"></i><a href="../Table_Commandes">Commandes</a></li>
          <li><i class="fa fa-file-text"></i>Fiche</li>
        </ol>
      </div>
    </div>
    <!-- page start-->

    <div class="row">
      <div class="col-lg-offset-2 col-lg-8">

        <section class="panel">

          <header class="panel-heading">
            Détails de la commande
          </header>

          <div class="panel-body">

            <h2>Produits de la commande</h2>
            <table class="table table-striped table-advance table-hover table-bordered">
					<tbody>
						<tr>
							<th>#</th>
							<th><i class="icon_menu-square_alt2"></i> Produit</th>
							<th><i class="icon_tag"></i> Quantité</th>
							<th><i class="icon_currency"></i> Prix</th>
<!-- 							<th class="text-center"><i class="icon_cogs"></i> Action</th> -->
						</tr>

						<%
							if (commandeV != null && !commandeV.getPlacoms().isEmpty()) {
								for (PlaCom p : commandeV.getPlacoms()) {
						%>
						<tr>
							<td></td>
							<td><%=p.getPlat().getTitre()%></td>
							<td><%=p.getQuantite()%></td>
							<td><%=p.getPlat().getPrix()%></td>
<!-- 							<td class="text-center"><a class="btn btn-danger" -->
<%-- 								href="EnleverPlatCommande?id=<%=p.getPlat().getId()%>"><i --%>
<!-- 									class="icon_minus-06"></i></a></td> -->
						</tr>
						<%
							}
							}
						%>

						<tr class="warning">
							<td>Total</td>
							<td colspan="2"></td>
							<td><%=commandeV.getPrixTotal()%></td>
<!-- 							<td></td> -->
						</tr>
					</tbody>
				</table>
            <hr>

            <h2>Informations </h2>
            <table class="table table-advance table-hover table-bordered">
              <tr>
                <td>ID</td>
                <td>${commande.id }  </td>
              </tr>
              <tr>
                <td>Client</td>
                <td>${commande.client.nom } ${commande.client.prenom }</td>
              </tr>
              <tr>
                <td>Adresse</td>
                <td>${commande.adresse }</td>
              </tr>
              <tr>
                <td>Date</td>
                <td>${commande.date }</td>
              </tr>
              <tr>
                <td>Etat</td>
                <td>${commande.etat }</td>
              </tr>
            </table>

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
<script src="../js/jquery.js"></script>
<script src="../js/bootstrap.min.js"></script>
<!-- nicescroll -->
<script src="../js/jquery.scrollTo.min.js"></script>
<script src="../js/jquery.nicescroll.js" type="text/javascript"></script>
<!--custome script for all page-->
<script src="../js/scripts.js"></script>


</body>
</html>