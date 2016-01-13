<%@page import="akenmg.rootsdelivery.dao.*"%>
<%@page import="akenmg.rootsdelivery.model.Admin"%>
<%@page import="java.util.ArrayList"%>
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
	<h1>Login</h1>
	
	<h2>Form</h2>
	<form method="post" action="Login">
		<input type="text" name="login" placeholder="login"> 
		<input type="text" name="mdp" placeholder="mdp">
		<input type="submit" value="insert"> 
	</form>
	
	<p>${message}</p>
	
	<% if(request.getSession().getAttribute("user") != null){ Admin admin = (Admin)request.getSession().getAttribute("user"); %>
	<p>Vous etes connecté : <% out.println(admin.getLogin()); %> : <a href="Logout"> deconnexion </a></p>
	<%}else{%>
	<p>Vous n'etes pas connecté  </p>
	<%} %>
</body>
</html>