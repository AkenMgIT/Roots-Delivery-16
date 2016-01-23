<%@page import="java.util.ArrayList"%>
<%@page import="akenmg.rootsdelivery.model.Plat"%>
<%@page import="java.util.List"%>
<%
	List<Plat> plats = (ArrayList<Plat>)request.getAttribute("plats");
%>
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

  <title>Roots-Delivery: Menu</title>

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
        <h1>Menu</h1>
        <hr>
        <p>Suit dieu de hors jeta cela ca nees. Groupes passent moi aurions peu mal accable. Sons il mere etat en doit mais. Son par vrai mere rang. Qu la venait gamins trotte.</p>
        <a href="#info" class="btn btn-primary btn-xl page-scroll"><i class="fa fa-2x fa-caret-down wow bounceIn text-default" style="visibility: visible; animation-name: bounceIn;"></i></a>
      </div>
    </div>
  </header>

  <section id="info">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
          <h2 class="section-heading"><a href="Commande-Client" class="btn btn-primary btn-xl">Commander Maintenant</a></h2>
          <hr class="primary">
        </div>
      </div>
    </div>

    <div class="container">
      <div class="row">
      
        <div class="col-lg-6">
		<%for(int i=0 ;i <plats.size()/2 ; i++){ %>
          <div class="panel">
            <div class="panel-body">
              <h4><%=plats.get(i).getTitre() %> <span class="pull-right"><%=plats.get(i).getPrix() %> Ar</span></h4>
              <em>Exasperer fillettes tu cuirasses un battirent oh citadelle cependant. Etendards du on gachettes superieur eperonnes.</em>
            </div>
          </div>
        <%} %>

        </div>

        <div class="col-lg-6">

          <%for(int i=plats.size()/2 ; i<plats.size() ; i++){ %>
          <div class="panel">
            <div class="panel-body">
              <h4><%=plats.get(i).getTitre() %> <span class="pull-right"><%=plats.get(i).getPrix() %> Ar</span></h4>
              <em>Grandes fureurs partout si la qu. Maintenant partageait ni te je ah remplirent. Poil ici rien age sans ifs.</em>
            </div>
          </div>
        <%} %>

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

</body>

</html>