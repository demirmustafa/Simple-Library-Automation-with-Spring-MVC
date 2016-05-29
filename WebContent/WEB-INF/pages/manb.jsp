<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<link
	href="${pageContext.request.contextPath }/static/css/bootstrap-combobox.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Books</title>


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
				action="${pageContext.request.contextPath }/admin/">


				<button type="submit" class="btn btn-primary">Admin</button>
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
		<h1>All Books</h1>
	</div>




	<div class="row">
		<div class="col-md-6">

			<div class="form-inline">

				<div class="form-group">


					<table class="table table-striped" id="allUsers">

						<thead>
							<th>Id</th>
							<th>Book</th>
							<th>Author</th>
							<th>Publisher</th>
							<th>Category</th>
							<th>Action</th>
						</thead>
						<tbody>

							<c:forEach var="book" items="${books}">
								<tr>
									<form
										action="${pageContext.request.contextPath }/admin/deletebook/"
										method="post">
										<td><input type="text" class="form-control" name="id"
											readonly="readonly" value="${book.id }" style="width: 50px;"></td>

										<td><input type="text" class="form-control" name="name"
											value="${book.name }" style="width: 130px;"></td>
										<td><input type="text" class="form-control"
											name="author_name"
											value="${book.author.name } ${book.author.surname }"
											style="width: 130px;"></td>

										<td><input type="text" class="form-control"
											name="author_name" value="${book.publisher.publisher_name }"
											style="width: 130px;"></td>
										<td><input type="text" class="form-control"
											name="author_surname" value="${book.category.category_name }"
											style="width: 130px;"></td>

										<!-- 	<td><input type="text" class="form-control input-normal"
								name="surname" value="${book.author }" style="width: 130px;"></td>

							<td><input type="email" class="form-control" name="email"
								value="${book.publisher }" style="width: 130px;"></td>

							<td><input type="text" class="form-control" name="username"
								value="${book.category }" style="width: 130px;"></td>
								
								 -->
									<td> <button type="submit" class="btn btn-xs btn-danger">Delete</button>
									</form>
								</tr>



							</c:forEach>

						</tbody>


					</table>
				</div>
			</div>
		</div>



		<div class="col-md-6">
			<div class="form-group">
				<div class="row">
					<div class="col-md-12">
						<div class="row">
							<div class="col-md-4 col-md-offset-3">
								<form class="forn-signin"
									action="${pageContext.request.contextPath}/addnewbook/"
									method="post">
									<h2 class="forn-signin-heading">Add New Book</h2>
									<label for="inputEmail" class="sr-only">Book Name</label> <input
										style="width: 170px;" type="text" id="inputEmail"
										class="form-control" name="book_name" placeholder="Book"
										required autofocus>
									<p />
									<p />
									<select name="author" style="width: 170px;"> <
										<c:forEach var="author" items="${authors }">
											<option value="${author.id }">${author.name }
												${author.surname }</option>
										</c:forEach>

									</select>
									<p />
									<select name="publisher" style="width: 170px;">
										<c:forEach var="publisher" items="${publishers }">
											<option value="${publisher.id }">${publisher.publisher_name }</option>
										</c:forEach>
									</select>
									<p />
									<select name="category" style="width: 170px;">
										<c:forEach var="category" items="${categories }">
											<option value="${category.id }">${category.category_name }</option>
										</c:forEach>
									</select>
									<p />
									<input class="btn btn-info" type="submit" value="Add">
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<p />










	<p />


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script type="text/javascript"
		href="${pageContext.request.contextPath }/static/script/combo.js"></script>
	<script type="text/javascript">
		//<![CDATA[
		$(document).ready(function() {
			$('.combobox').combobox()
		});
		//]]>
	</script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
</body>
</html>