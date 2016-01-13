<%@page import="akenmg.rootsdelivery.dao.DaoClient"%>
<%@page import="akenmg.rootsdelivery.model.Client"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Dao Client test</h1>
	
	<h2>Insert</h2>
	<form method="post" action="CreateClient">
		<input type="text" name="nom" placeholder="nom"> 
		<input type="text" name="prenom" placeholder="prenom"> 
		<input type="text" name="numero" placeholder="numero"> 
		<input type="text" name="email" placeholder="email"> 
		<input type="text" name="mdp" placeholder="mdp"> 
		<input type="submit" value="insert">  
	</form>
	
	<hr>
	<h2>GetAll</h2>
	<%
		List<Client> clients = new ArrayList<Client>();
		clients = DaoClient.getAll();
	%>
	<table>
		<tr>
			<th>id</th>
			<th>nom</th>
			<th>prenom</th>
			<th>numero</th>
			<th>email</th>
			<th>mdp</th>
		</tr>
	<%
		for(Client a : clients){
	%>
		<form method="post" action="UpdateClient">
		<tr> 
			<td><input type="text" name="id" value="<%= a.getId() %>"> </td> 
			<td><input type="text" name="nom" value="<%= a.getNom() %>"> </td> 
			<td><input type="text" name="prenom" value="<%= a.getPrenom()  %>"> </td> 
			<td><input type="text" name="numero" value="<%= a.getNumero()  %>"> </td> 
			<td><input type="text" name="email" value="<%= a.getEmail()  %>"> </td> 
			<td><input type="text" name="mdp" value="<%= a.getMdp()  %>"> </td>
			<td><input type="submit" value="update"></td> 
			<td><a href="DeleteClient?id=<%= a.getId() %>">delete</a></td>
		</tr>
		</form>
	<% 
		} 
	%> 
	</table>
</body>
</html>