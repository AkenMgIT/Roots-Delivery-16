
<%@page import="akenmg.rootsdelivery.model.view.ClientView"%>
<%@page import="akenmg.rootsdelivery.model.PlaCom"%>
<%@page import="akenmg.rootsdelivery.model.Commande"%>
<%@page import="akenmg.rootsdelivery.model.view.PlatView"%>
<%@page import="java.util.ArrayList"%>
<%@page import="akenmg.rootsdelivery.model.view.CommandeView"%>
<%@page import="java.util.List"%>
<%
List<CommandeView> commandes = (ArrayList<CommandeView>)request.getAttribute("commandes");
List<PlatView> plats = (ArrayList<PlatView>)request.getAttribute("plats");
CommandeView commande = new CommandeView(
(Commande)request.getSession().getAttribute("commande")
);
List<ClientView> clients = (ArrayList<ClientView>)request.getAttribute("clients");
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

									<title>DashBoard - Table Commandes</title>

									<!-- Bootstrap CSS -->
									<link href="css/bootstrap.min.css" rel="stylesheet">
										<!-- bootstrap theme -->
										<link href="css/bootstrap-theme.css" rel="stylesheet">
											<!--external css-->
											<!-- font icon -->
											<link href="css/elegant-icons-style.css" rel="stylesheet" />
											<link href="css/font-awesome.min.css" rel="stylesheet" />
											<!-- Custom styles -->
											<link href="css/style.css" rel="stylesheet">
												<link href="css/style-responsive.css" rel="stylesheet" />

												<!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
												<!--[if lt IE 9]>
												<script src="js/html5shiv.js"></script>
												<script src="js/respond.min.js"></script>
												<script src="js/lte-ie7.js"></script>
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
													<jsp:include page="_include/bo-side.jsp"></jsp:include>
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
																<li><i class="fa fa-th-list"></i>Commandes</li>
															</ol>
														</div>
													</div>
													<!-- page start-->
													<div class="row">
														<div class="col-lg-6">
															<section class="panel">
																<header class="panel-heading">
																	Formulaire Commande
																</header>
																<div class="panel-body">
																	<form class="form-horizontal " method="post" action="BoCreateCommande">
																		<div class="form-group">
																			<label class="col-sm-2 control-label">Commande</label>
																			<div class="col-sm-10">
																				<table class="table table-striped table-advance table-hover table-bordered">
																					<tbody>
																						<tr>
																							<th>#</th>
																							<th><i class="icon_menu-square_alt2"></i> Produit</th>
																							<th><i class="icon_tag"></i> Quantité</th>
																							<th><i class="icon_currency"></i> Prix</th>
																							<th class="text-center"><i class="icon_cogs"></i> Action</th>
																						</tr>

																						<% if(commande!=null && !commande.getPlacoms().isEmpty()){
																							for(PlaCom p : commande.getPlacoms()){%>
																							<tr>
																								<td></td>
																								<td><%=p.getPlat().getTitre() %></td>
																								<td><%=p.getQuantite() %></td>
																								<td><%=p.getPlat().getPrix() %></td>
																								<td class="text-center">
																									<a class="btn btn-danger" href="EnleverPlatCommande?id=<%=p.getPlat().getId() %>"><i class="icon_minus-06"></i></a>
																								</td>
																							</tr>
																							<%	}
																						}%>

																						<tr class="warning">
																							<td>Total</td>
																							<td colspan="2"></td>
																							<td><%=commande.getPrixTotal() %></td>
																							<td></td>
																						</tr>
																					</tbody>
																				</table>
																				<span class="text-left text-primary">${form.erreurs['commande'] }</span>
																			</div>
																		</div>

																		<div class="form-group">
																			<label class="col-sm-2 control-label">Clients</label>
																			<div class="col-sm-10">
																				<select name="idClient" class="form-control">
																					<% if(clients != null && !clients.isEmpty()){
																						for (ClientView c : clients) {
																							%>
																							<option value="<%=c.getId()%>"><%=c.getNom() + " " + c.getPrenom()%></option>
																							<%
																						}
																					}
																					%>
																				</select>
																			</div>
																		</div>
																		<div class="form-group">
																			<label class="col-sm-2 control-label">Adresse</label>
																			<div class="col-sm-10">
																				<input type="text" class="form-control" name="adresse" placeholder="Adresse de livraison" value="${commandeF.adresse }">
																				<span class="text-left text-primary">${form.erreurs['adresse'] }</span>
																				</div>
																			</div>

																			<div class="form-group">
																				<div class="col-sm-offset-2 col-sm-10">
																					<button type="submit" class="btn btn-primary">Ajouter</button>
																					<a href="ReinitialiserCommande" class="btn btn-default">Reinitialiser</a>
																					<span class="text-left ${empty form.erreurs ? 'text-success' : 'text-danger'}">${form.resultat}</span>
																				</div>
																			</div>

																		</form>
																	</div>
																</section>
															</div>

															<div class="col-lg-6">
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
																				<% if(plats!=null && !plats.isEmpty()){
																					for(PlatView p : plats){%>
																					<tr>
																						<td><%=p.getTitre() %></td>
																						<td><%=p.getPrix() %></td>
																						<td class="text-center">
																							<a class="btn btn-primary" href="AjoutPlatCommande?id=<%= p.getId() %>"><i class="icon_plus"></i></a>
																						</td>
																					</tr>
																					<%	}
																				}%>
																			</tbody>
																		</table>
																	</div>
																</section>
															</div>

														</div>
														<!-- Basic Forms & Horizontal Forms-->


														<div class="row">
															<div class="col-lg-12">
																<section class="panel">
																	<header class="panel-heading">
																		Liste des Commandes
																	</header>

																	<table class="table table-striped table-advance table-hover">
																		<tbody>
																			<tr>
																				<th><i class="icon_id"></i> ID</th>
																				<th><i class="icon_document_alt"></i> Client</th>
																				<th><i class="icon_pin"></i> Adresse</th>
																				<th><i class="icon_clock"></i> Date</th>
																				<th><i class="icon_cogs"></i> Etat</th>
																				<th class="text-center"><i class="icon_cogs"></i> Action</th>
																			</tr>
																			<% if(commandes!=null && !commandes.isEmpty()){
																				for(CommandeView c : commandes){
																				String color = "";
																				if(c.getEtat().equals(Commande.ETAT.ENCOURS)){
																					color="text-warning";
																				}
																				if(c.getEtat().equals(Commande.ETAT.ANNULLEE)){
																					color="text-danger";
																				}
																				if(c.getEtat().equals(Commande.ETAT.PAYEE)){
																					color="text-success";
																				}
																				%>
																				<tr>
																					<td><%=c.getId() %></td>
																					<td><%=c.getClient().getNom() %> <%=c.getClient().getPrenom() %></td>
																					<td><%=c.getAdresse() %></td>
																					<td><%=c.getDate() %></td>
																					<td class="<%=color%>"><%=c.getEtat().toString() %></td>
																					<td class="text-center">
																						<div class="btn-group">
																							<a class="btn btn-primary" href="fiches/Fiche_Commande?id=<%=c.getId() %>">Détails</a>
																							<a class="btn btn-danger" href="BoDeleteCommande?id=<%=c.getId() %>">Supprimer</i></a>
																						</div>
																						<div  class="btn-group">
																							<a class="btn btn-warning" href="BoUpdateCommandeEtat?id=<%=c.getId() %>&etat=encours">En Cours</i></a>
																							<a class="btn btn-success" href="BoUpdateCommandeEtat?id=<%=c.getId() %>&etat=payee">Payée</i></a>
																							<a class="btn btn-danger" href="BoUpdateCommandeEtat?id=<%=c.getId() %>&etat=annulee">Annuler</i></a>
																						</div>
																					</td>
																				</tr>
																				<%	}
																			}%>
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
											<script src="js/jquery.js"></script>
											<script src="js/bootstrap.min.js"></script>
											<!-- nicescroll -->
											<script src="js/jquery.scrollTo.min.js"></script>
											<script src="js/jquery.nicescroll.js" type="text/javascript"></script>
											<!--custome script for all page-->
											<script src="js/scripts.js"></script>


										</body>
									</html>
