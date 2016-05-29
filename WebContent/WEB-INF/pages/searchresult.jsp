<%@page import="com.library_automation.classes.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


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
<title>Search Results</title>
<script type="text/javascript">
	function fonksiyon(status,id){
		
		var durum = $("#"+status+"").val();
		if(durum == 'CheckedOut'){
			document.getElementById(""+id).disabled = true; 
			alert("This book already reserved. If you want restitute this book, please visit your profile page.");
		}
		else{
			document.getElementById(""+id).disabled = false;
		}
		
		
	}
	
</script>




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

		<!-- 
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

		<sec:authorize access="isAuthenticated()">

			<a href="${pageContext.request.contextPath }/logout"
				class="navbar-form navbar-right">
				<button class="btn btn-xs btn-danger">Log out</button>
			</a>

		</sec:authorize>



	</div>
	<!--/.navbar-collapse -->
	</div>
	</nav>

	<p />
	a
	<p />
	a
	<p />

	<div class="page-header">
		<h1>All Search Results</h1>
	</div>



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
										action="${pageContext.request.contextPath }/user/${book.status }/"
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
											id="bookStatus_${book.id }" type="hidden" value="${book.status }">

										<!-- 	<td><input type="text" class="form-control input-normal"
								name="surname" value="${book.author }" style="width: 130px;"></td>

							<td><input type="email" class="form-control" name="email"
								value="${book.publisher }" style="width: 130px;"></td>

							<td><input type="text" class="form-control" name="username"
								value="${book.category }" style="width: 130px;"></td>
								
								 -->
								 <c:set var="id" value="${book.id }"></c:set>
								 <c:set var="status" value="${book.status }"></c:set>
								 
								 
									<td><sec:authorize access="isAuthenticated()">

											<button id="${book.id }" onclick="fonksiyon('bookStatus_'+id,id)"  type="submit" class="btn btn-xs btn-primary">${book.status }</button>
										</sec:authorize> <sec:authorize access="!isAuthenticated()">
											<a href="${pageContext.request.contextPath }/loginpage/">
												<button type="button" class="btn btn-xs btn-success">Sign
													In</button>
											</a>
										</sec:authorize></td>
										
										

									</form>






								</tr>

							
							</c:forEach>




						</tbody>


					</table>
				</div>
			</div>

		</div>

		<h3>PDF</h3>

		<div class="col-md-6">

			<c:forEach var="thesis" items="${thesis }">

				<form action="${pageContext.request.contextPath }/showpdf/">

					<input type="hidden" name="thesisName" value="${thesis.name }">
					<input type="submit" class="btn btn-info" readonly="readonly"
						value="${thesis.name }" style="width: 130px;">
				</form>
				<p />

			</c:forEach>

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