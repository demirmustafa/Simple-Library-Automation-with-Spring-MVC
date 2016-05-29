<%@page import="org.hibernate.validator.constraints.SafeHtml.Tag"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath }/">Library Automation</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			
			
			<a href="${pageContext.request.contextPath }/logout"
				class="navbar-form navbar-right">
				<button class="btn btn-xs btn-danger">Log out</button>
			</a>
			
		</div>
	</div>
	</nav>
	a <br/><p/>
	a <br/><p/>
	<div class="container">
	<p/>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Update</h3>
			</div>
			<div class="panel-body"> <a href="${pageContext.request.contextPath }/admin/users/">Users</a></div>
			<div class="panel-body"><a href="${pageContext.request.contextPath }/admin/books/">Books</a></div>
			<div class="panel-body"><a href="${pageContext.request.contextPath }/admin/authors/">Authors</a></div>
			<div class="panel-body"><a href="${pageContext.request.contextPath }/admin/publishers/">Publishers</a></div>
			<div class="panel-body"><a href="${pageContext.request.contextPath }/admin/categories/">Categories</a></div>
		</div>
	</div>
</body>
</html>