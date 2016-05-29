<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Library Automation</title>

<!-- Bootstrap -->

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
	
	<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	
	<link href="${pageContext.request.contextPath }/static/css/main.css" rel="stylesheet" type="text/css">

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/6.1.7/css/bootstrap-slider.min.css"
	rel="stylesheet" type="text/css">
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
			<form class="navbar-form navbar-right" action="${pageContext.request.contextPath }/search/" method="post">
				<div class="form-group">
					
					<input name="title" type="text" placeholder=Search class="form-control">
				</div>

				<button type="submit" class="btn btn-success">Search</button>
				<sec:authorize access="!isAuthenticated()">
					<a href="${pageContext.request.contextPath }/loginpage"
						class="btn btn-primary">Sign In</a>

				</sec:authorize>

				<!-- PROFILE BUTTON ON NAVBAR (ONLY VISIBLE TO SIGNED IN)  -->

				<sec:authorize access="hasRole('ROLE_USER')">
					<a href="${pageContext.request.contextPath }/profile"
						class="btn btn-primary">My Profile</a>
				</sec:authorize>
				
				<sec:authorize access="hasRole('ROLE_USER')">
					<a href="${pageContext.request.contextPath }/upload/"
						class="btn btn-info">Upload</a>
				</sec:authorize>

				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<a href="${pageContext.request.contextPath }/admin"
						class="btn btn-primary">Admin</a>
				</sec:authorize>


			</form>

			<!-- LOGOUT BUTTON ON NAVBAR (ONLY VISIBLE TO SIGNED IN)  -->


			<div id="navbar" class="navbar-collapse collapse"></div>
			<c:url var="logoutUrl" value="/logout" />
			<sec:authorize access="isAuthenticated()">
				<form action="${logoutUrl }" method="post"
					class="navbar-form navbar-right">
					<input type="submit" value="Log out" class="btn btn-xs btn-danger">
				</form>
			</sec:authorize>

			<!-- REGISTER BUTTON ON NAVBAR (NOT VISIBLE TO SIGNED IN) -->

			<sec:authorize access="!isAuthenticated()">
				<form action="${pageContext.request.contextPath }/registerpage"
					method="post" class="navbar-form navbar-right">
					<input type="submit" value="Sign Up" class="btn btn-xs btn-danger">
				</form>
			</sec:authorize>


		</div>
		<!--/.navbar-collapse -->
	</div>
	</nav>






	<!--  

	<sec:authorize access="!isAuthenticated()">
		<a href="${pageContext.request.contextPath }/loginpage">Login</a>
		<p />
		
		<a href="${pageContext.request.contextPath }/registerpage">Register</a>
		<p />
 
	</sec:authorize>

	<sec:authorize access="hasRole('ROLE_USER')">
		<a href="${pageContext.request.contextPath }/profile">My Profile</a>
		<p />
	</sec:authorize>

	<c:url var="logoutUrl" value="/logout" />
	<sec:authorize access="isAuthenticated()">
		<form action="${logoutUrl }" method="post">
			<input type="submit" value="Log out">
		</form>
	</sec:authorize>
	
	-->


	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-14">
			
				<div id="my-slider" class="carousel slide" data-ride="carousel">
				
					<!-- indicators dot nav -->
					
					<ol class="carousel-indicators">
						<li data-target="#my-slider" data-slide-to="0"/>
						<li data-target="#my-slider" data-slide-to="1"/>
						<li data-target="#my-slider" data-slide-to="2"/>
					</ol>
					
					<div class="carousel-inner" role="listbox">
						
						<div class="item active">
							<img alt="library" src="${pageContext.request.contextPath }/static/images/image1.jpg">
							<div class="carousel-caption">
								<h1>Library Automation</h1>
							</div>
						</div>
						
						<div class="item">
							<img alt="library" src="${pageContext.request.contextPath }/static/images/image2.jpg">
							<div class="carousel-caption">
								<h1>Library Automation</h1>
							</div>
						</div>
						
						<div class="item">
							<img alt="library" src="${pageContext.request.contextPath }/static/images/image3.jpg">
							<div class="carousel-caption">
								<h1>Library Automation</h1>
							</div>
						</div>
						
						<a class="left carousel-control" href="#my-slider" role="button" data-slide="prev">
							<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a>
						
						<a class="right carousel-control" href="#my-slider" role="button" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a>
					
					</div>
				
				
				</div>
			
			</div>
		</div>
	</div>






	<div class="container-fluid">
		<!-- 
		<div class="row">
			<div class="col-lg-12">
				<h1>Full Slider by Start Bootstrap</h1>
				<p>
					The background images for the slider are set directly in the HTML
					using inline CSS. The rest of the styles for this template are
					contained within the
					<code>full-slider.css</code>
					file.
				</p>
			</div>
		</div>
		 -->

		<hr/>

		<!-- Footer -->
		<footer class="col-lg-14">
		<div class="row">
			<div class="footer-background">
				<p class="footer-text-color">Copyright &copy; Library Automation 2016</p>
				<p class="footer-text-color">info: info@libraryautomation.com</p>
			</div>
		</div>
		<!-- /.row --> </footer>

	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/static/script/jquery.js"></script>

	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/6.1.7/bootstrap-slider.min.js"></script>

</body>
</html>