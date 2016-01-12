<%@page import="akenmg.rootsdelivery.dao.DaoAdmin"%>
<%@page import="java.util.*"%>
<%@page import="akenmg.rootsdelivery.model.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Dao Admin</h1>
	
	<h2>Insert</h2>
	<form method="post" action="CreateAdmin">
		<input type="text" name="login" placeholder="login"> 
		<input type="text" name="mdp" placeholder="mdp">
		<input type="submit" value="insert"> 
	</form>
	
	<hr>
	<h2>GetAll</h2>
	<%
		List<Admin> admins = new ArrayList<Admin>();
		admins = DaoAdmin.getAll();
	%>
	<table>
		<tr>
			<th>id</th>
			<th>login</th>
			<th>mdp</th>
			<th>update</th>
			<th>delete</th>
		</tr>
	<%
		for(Admin a : admins){
	%>
		<form method="post" action="UpdateAdmin">
		<tr>
			<td><input type="text" name="id" value="<%= a.getId() %>"> </td>
			<td><input type="text" name="login" value="<%= a.getLogin() %>"> </td>
			<td><input type="text" name="mdp" value="<%= a.getMdp()  %>"> </td>
			<td><input type="submit" value="update"></td>
			<td><a href="DeleteAdmin?id=<%= a.getId() %>">delete</a></td>
		</tr>
		</form>
	<% 
		} 
		if(admins.isEmpty()){
	%> 
	<p>List empty</p>
	<% 
		}
	%>
	</table>
</body>
</html>