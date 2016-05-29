<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="${pageContext.request.contextPath }/static/css/confirm.css" rel="stylesheet" type="text/css">

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
	<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Please Log In</title>
</head>
<body>

	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<form class="forn-signin"
							action="${pageContext.request.contextPath }/login" method="post">
							<h2 class="form-signin-heading">Please sign in</h2>
							<label for="inputEmail" class="sr-only">Username</label> <input
								type="text" id="inputEmail" class="form-control" name="username"
								placeholder="Username" required autofocus><br/> <label
								for="inputPassword" class="sr-only">Password</label> <input
								name="password" type="password" id="inputPassword"
								class="form-control" placeholder="Password" required>
							<div class="checkbox">
								<br/><label> <input type="checkbox" name="remember_me">
									Remember me
								</label>
							</div>
							<br/>
							<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
								in</button>

							<div class="valid"><%=request.getAttribute("message")%></div>
							<div class="error"><%=request.getAttribute("message2")%></div>

						</form>


					</div>
				</div>
			</div>
		</div>





		<!--  

			<table>

				<tr>
					<td>Username:</td>
					<td><input type="text" name="username">
				</tr>

				<tr>
					<td>Password:</td>
					<td><input type="password" name="password">
				</tr>

				<tr>
					<td>Remember Me:</td>
					<td><input type="checkbox" name="remember_me"
						checked="checked">
				</tr>

				<tr>
					<td />
					<td><input type="submit" value="Login" class="btn btn-primary">
				</tr>

			</table>
			-->


	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


</body>
</html>