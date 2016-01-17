<%@page import="akenmg.rootsdelivery.dao.DaoPlat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="akenmg.rootsdelivery.model.Plat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Dao Plat test</h1>
	
	<h2>Insert</h2>
	<form method="post" action="CreatePlat"> 
		<input type="text" name="titre" placeholder="titre"> 
		<input type="text" name="description" placeholder="description"> 
		<input type="text" name="prix" placeholder="prix"> 
		<input type="text" name="img" placeholder="img" > 
		<input type="submit" value="insert">  
	</form>
	
	
	
	<hr>
	<h2>GetAll</h2>
	<%
		List<Plat> plats = new ArrayList<Plat>();
		plats = DaoPlat.getAll();
	%>
	<table>
		<tr>
			<th>id</th>
			<th>titre</th>
			<th>description</th>
			<th>prix</th>
			<th>img</th>
		</tr>
	<%
		for(Plat a : plats){
	%>
		<form method="post" action="UpdatePlat">
		<tr> 
			<td><input type="text" name="id" value="<%= a.getId() %>"> </td> 
			<td><input type="text" name="titre" value="<%= a.getTitre() %>"> </td> 
			<td><input type="text" name="description" value="<%= a.getDescription()  %>"> </td> 
			<td><input type="text" name="prix" value="<%= a.getPrix()  %>"> </td> 
			<td><input type="text" name="img" value="<%= a.getImg()  %>"> </td> 
			<td><input type="submit" value="update"></td> 
			<td><a href="DeletePlat?id=<%= a.getId() %>">delete</a></td>
		</tr>
		</form>
	<% 
		} 
	%> 
	</table>
</body>
</html>