<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Profile</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/static/css/confirm.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	my profile
	<br /> p
	<p />
	<h3>My Profile</h3>
	<p />




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
				action="${pageContext.request.contextPath }/search/" method="post">
				<div class="form-group">
					<input type="text" name="title" placeholder="Search"
						class="form-control">
				</div>

				<button type="submit" class="btn btn-success">Search</button>
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

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<form class="forn-signin"
							action="${pageContext.request.contextPath }/update" method="post">
							<h2 class="forn-signin-heading">Your Account Details</h2>
							<c:forEach var="user" items="${user}">
								<label for="inputEmail" class="sr-only">Name</label>
								<input type="text" id="inputEmail" class="form-control"
									name="name" value="${user.name }">
								<label for="inputEmail" class="sr-only">Surname</label>
								<input type="text" id="inputEmail" class="form-control"
									name="surname" value="${user.surname }">
								<label for="inputEmail" class="sr-only">Username</label>
								<input type="text" id="inputEmail" class="form-control"
									name="username" value="${user.username}">
								<label for="inputEmail" class="sr-only">Email</label>
								<input type="text" id="inputEmail" class="form-control"
									name="email" value="${user.email }">
								<label for="inputPassword" class="sr-only">Password</label>
								<input name="password" type="password" id="inputPassword"
									value="${user.password }" class="form-control"
									placeholder="Password" required> <p> </p>
									<label>Your Debt: </label>
								<label><%=request.getAttribute("debt") %></label>
							</c:forEach>
							<p class="valid"><%=request.getAttribute("message")%></p>
							<input class="btn btn-warning" type="submit" value="Update">
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>

	<h3>My Books</h3>
	<div class="row">


		<div class="col-md-6">

			<div class="form-inline">

				<div class="form-group">


					<table class="table table-striped" id="allUsers">

						<thead>
							<th></th>
							<th>Book</th>
							<th>Author</th>
							<th>Publisher</th>
							<th>Category</th>
							<th>Status</th>

							<th>Action</th>
						</thead>
						<tbody>




							<c:forEach var="book" items="${books}">





								<tr>
									<form
										action="${pageContext.request.contextPath }/user/restitute/"
										method="post">
										<td><input type="hidden" class="form-control"
											name="book_id" readonly="readonly" value="${book.id }"
											style="width: 50px;"></td>

										<td><input type="text" class="form-control"
											name="book_name" readonly="readonly" value="${book.name }"
											style="width: 130px;"></td>
										<td><input type="text" class="form-control"
											name="author_name" readonly="readonly"
											value="${book.author.name } ${book.author.surname }"
											style="width: 130px;"></td>

										<td><input type="text" class="form-control"
											name="book_publisher" readonly="readonly"
											value="${book.publisher.publisher_name }"
											style="width: 130px;"></td>
										<td><input type="text" class="form-control"
											readonly="readonly" name="book_category"
											value="${book.category.category_name }" style="width: 130px;"></td>
										<td><input type="text" class="form-control"
											readonly="readonly" name="book_status"
											value="${book.status }" style="width: 130px;"></td> <input
											id="bookStatus" type="hidden" value="${book.status }">


										<!-- 	<td><input type="text" class="form-control input-normal"
								name="surname" value="${book.author }" style="width: 130px;"></td>

							<td><input type="email" class="form-control" name="email"
								value="${book.publisher }" style="width: 130px;"></td>

							<td><input type="text" class="form-control" name="username"
								value="${book.category }" style="width: 130px;"></td>
								
								 -->
										<td>

											<button type="submit" class="btn btn-xs btn-primary">Restitute</button>
										</td>

									</form>

								</tr>

								</div>

							</c:forEach>


						</tbody>


					</table>
				</div>
			</div>

		</div>
		<p>
		<h5>
			<strong>Restitute Date</strong>
		</h5>
		
		<p> </p>
		<p> </p>
		<div class="col-md-6">

			<div class="form-group">

				<c:forEach items="${res }" var="res">

					<p>
						<label>${res.book.name}</label> <label>${res.restituteDate }</label>
					</p>
					<p></p>


				</c:forEach>

			</div>
		</div>
	</div>






	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
</body>
</html>