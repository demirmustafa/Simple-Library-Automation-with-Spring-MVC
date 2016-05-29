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
<title>Insert title here</title>
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
			<a class="navbar-brand" href="${pageContext.request.contextPath }/">Library
				Automation</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<form class="navbar-form navbar-right"
				action="${pageContext.request.contextPath }/admin/manage/">


				<button type="submit" class="btn btn-success">Manage Users</button>
			</form>


			<div id="navbar" class="navbar-collapse collapse"></div>
			<!--  <c:url var="logoutUrl" value="/logout" />
			<form action="${logoutUrl }" method="post"
				class="navbar-form navbar-right">
				<input type="submit" value="Log out" class="btn btn-xs btn-danger">
			</form>
			
			-->
			<a href="${pageContext.request.contextPath }/logout"
				class="navbar-form navbar-right">
				<button class="btn btn-xs btn-danger">Log out</button>
			</a>



		</div>
		<!--/.navbar-collapse -->
	</div>
	</nav>

	<p />
	a
	<p />
	a
	<p />
	a
	<p />

	<div class="page-header">
		<h1>All Users</h1>
	</div>


	
		
							
					<form class="form-inline" action="${pageContext.request.contextPath }/admin/editusers">

						<div class="form-group">
							<table class="table table-striped" id="allUsers">

								<thead>
									<th>Id</th>
									<th>Name</th>
									<th>Surname</th>
									<th>Email</th>
									<th>Username</th>
									<th>Password</th>
									<th>Action</th>
								</thead>
								<tbody>

									<c:forEach var="user" items="${users}">
										<tr>
											<td><input type="text" class="form-control" name="id"
												placeholder="${user.id }" style="width:50px;" ></td>

											<td><input type="text" class="form-control" name="name"
												placeholder="${user.name }" style="width: 130px;"></td>

											<td><input type="text" class="form-control input-normal"
												name="surname" placeholder="${user.surname }" style="width: 130px;"></td>

											<td><input type="email" class="form-control"
												name="email" placeholder="${user.email }" style="width: 130px;"></td>

											<td><input type="text" class="form-control"
												name="username" placeholder="${user.username }" style="width: 130px;"></td>

											<td><input type="text" class="form-control"
												name="password" placeholder="${user.password }" style="width: 130px;"></td>

											<td><a
												href="${pageContext.request.contextPath}/admin/deleteuser?id=${user.id}"><button
														class="btn btn-xs btn-danger">Delete</button></a> 
														<button type="submit" class="btn btn-xs btn-warning">Edit</button></td>

										</tr>


									</c:forEach>

								</tbody>
							</table>
						</div>
					</form>
				
	

	<p />


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->

</body>
</html>