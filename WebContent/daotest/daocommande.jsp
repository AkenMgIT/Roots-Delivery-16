<%@page import="akenmg.rootsdelivery.dao.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="akenmg.rootsdelivery.model.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Dao Commande test</h1>
	
	<h2>Insert</h2>
	<form method="post" action="CreateCommande"> 
		<select name="idClient">
		<% List<Client> clients = DaoClient.getAll(); %>
		<% for(Client c : clients){ %>
			<option value="<%= c.getId() %>"><%=c.getNom() +" "+c.getPrenom() %></option>
		<%} %>
		</select>
		<input type="text" name="adresse" placeholder="adresse">
		<input type="submit" value="Valider Commande">
	</form>
	<p><a href="InitCommande">nouvelle commande</a> : <a href="ResetCommande">reset commande</a></p>
	<%Commande commande = (Commande)request.getSession().getAttribute("commande"); %>
	<%if(commande==null){ %>
		<p>pas de commande en cours</p>
	<%}else{ %>
	
		<p>1 commande en cours</p>
		<h3>Items de la commande</h3>
		<%if(commande.getPlacoms().size()!=0){ %>
		<table>
			<tr>
				<th>Produit</th>
				<th>Qunatité</th>
				<th>Prix</th>
				<th>Enlever</th>
<!-- 				<th>Quantité</th> -->
			</tr>
			<%for(PlaCom p : commande.getPlacoms()){ %>
			<tr>
				<td><%=p.getPlat().getTitre() %></td>
				<td><%=p.getQuantite() %></td>
				<td><%=p.getPlat().getPrix() %></td>
				<td><a href="EnleverPlatCommande?id=<%=p.getPlat().getId() %>">Enlever</a></td>
			</tr>
			<%} %>
		</table>
		<%}else{ %>
		<p>pas de plat dans la commande</p>
		<%} %>
	<%} %>
	
	<hr>
	<h3>Liste plat</h3>
	<%
		List<Plat> plats = new ArrayList<Plat>();
		plats = DaoPlat.getAll();
	%>
	<table>
		<tr>
			<th>Produit</th>
			<th>Prix</th>
			<th>Ajouter</th>
		</tr>
		<%for(Plat p : plats){ %>
		<tr>
			<td><%=p.getTitre() %></td>
			<td><%=p.getPrix() %></td>
			<td><a href="AddPlatCommande?id=<%= p.getId() %>">ajouter</a></td>
		</tr>
		<%} %>
	</table>

<hr>
	<h2>GetAll Commande</h2>
	<%
		List<Commande> commandes = new ArrayList<Commande>();
		commandes = DaoCommande.getAll();
	%>
	<%if(commandes.size()!=0){ %>
	<table border="1">
		<tr>
			<th>id</th>
			<th>client</th>
			<th>adresse</th>
			<th>date</th>
			<th>etat</th>
			<th>detail</th>
			<th>delete</th>
			<th>setAnnulée</th>
			<th>setPayée</th>
			<th>setEnCours</th>
		</tr>
	<%
		for(Commande a : commandes){
	%>
		<tr> 
			<td><%= a.getId() %> </td> 
			<td><%= a.getClient().getId() %></td> 
			<td><%= a.getAdresse()  %> </td> 
			<td><%= a.getDate()  %> </td> 
			<td><%= a.getEtat().toString()  %> </td> 
			<td><a href="PlaComFind?id=<%= a.getId() %>">details</a></td>
			<td><a href="DeleteCommande?id=<%= a.getId() %>">delete</a></td>
			<td><a href="UpdateCommande?id=<%= a.getId() %>&action=<%= Commande.ETAT.ANNULLEE.toString() %>">Annuler</a></td>
			<td><a href="UpdateCommande?id=<%= a.getId() %>&action=<%= Commande.ETAT.PAYEE.toString() %>">Payer</a></td>
			<td><a href="UpdateCommande?id=<%= a.getId() %>&action=<%= Commande.ETAT.ENCOURS.toString() %>">En Cours</a></td>
		</tr>
	<% 
		} 
	%> 
	</table>
	<%}else{ %>
		<p>pas de commande</p>
	<%} %>
	
	<%Commande commandeDetail = (Commande)request.getAttribute("commandeDetail"); %>
	<%if(commandeDetail!=null){ %>
		<h3>Items de la commande</h3>
		<%if(commandeDetail.getPlacoms().size()!=0){ %>
		<table>
			<tr>
				<th>Produit</th>
				<th>Prix</th>
				<th>Quantité</th>
			</tr>
			<%for(PlaCom p : commandeDetail.getPlacoms()){ %>
			<tr>
				<td><%=p.getPlat().getTitre() %></td>
				<td><%=p.getPlat().getPrix() %></td>
				<td><%=p.getQuantite() %></td>
			</tr>
			<%} %>
		</table>
		<%}else{ %>
		<p>pas de plat dans la commande</p>
		<%} %>
	<%} %>
	
<!-- 	<select name="etat"> -->
<!-- 			<option value="ENCOURS">EN COURS</option> -->
<!-- 			<option value="PAYEE">PAYEE</option> -->
<!-- 			<option value="ANNULLEE">ANNULLEE</option> -->
<!-- 		</select> -->
</body>
</html>