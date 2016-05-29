<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<link
	href="${pageContext.request.contextPath }/static/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">


<link href="${pageContext.request.contextPath }/static/css/confirm.css"
	rel="stylesheet" type="text/css">

<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/script/jquery.js"></script>

<script type="text/javascript">
	function onLoad() {
		$("#inputPassword").keyup(checkPasswordsMatch);
		$("#inputPasswordConfirm").keyup(checkPasswordsMatch);

	}

	function checkPasswordsMatch() {
		var password = $("#inputPassword").val();
		var confirmPassword = $("#inputPasswordConfirm").val();

		if (password.length > 3 || confirmPassword.length > 3) {

			if (password == confirmPassword) {
				$("#passwordStatus").text("Passwords match");
				$("#passwordStatus").addClass("valid");
				$("#passwordStatus").removeClass("error");
			}

			else {
				$("#passwordStatus").text("Passwords don't match");
				$("#passwordStatus").addClass("error");
				$("#passwordStatus").removeClass("valid");
				return;
			}

		}
	}

	$(document).ready(onLoad);
</script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<form class="forn-signin" id="idForCheckingPasswords"
							action="${pageContext.request.contextPath }/register"
							method="post">
							<h2 class="form-signin-heading">Please sign up</h2>
							<label for="inputEmail" class="sr-only">Name</label> <input
								type="text" id="inputEmail" class="form-control" name="name"
								placeholder="Name" required autofocus> <br/><label
								for="inputEmail" class="sr-only">Surname</label><input
								type="text" id="inputEmail" class="form-control" name="surname"
								placeholder="Surname" required autofocus><br/> <label
								for="inputEmail" class="sr-only">Email</label> <input
								type="email" id="inputEmail" class="form-control" name="email"
								placeholder="Email" required autofocus> <br/><label
								for="inputEmail" class="sr-only">Username</label> <input
								type="text" id="inputEmail" class="form-control" name="username"
								placeholder="Username" required autofocus><br/> <label
								for="inputPassword" class="sr-only">Password</label> <input
								type="password" id="inputPassword" class="form-control"
								name="password" placeholder="Password" required autofocus>
							<br/><label for="inputPasswordConfirm" class="sr-only">Confirm
								Password</label> <input type="password" id="inputPasswordConfirm"
								class="form-control" name="confirmPassword"
								placeholder="Confirm Password" required autofocus><br/>


							<!--  
		<input
			type="text" id="inputEmail" class="form-control" name="username"
			placeholder="Username" required autofocus> <label
			for="inputPassword" class="sr-only">Password</label> <input
			name="password" type="password" id="inputPassword"
			class="form-control" placeholder="Password" required>
			
			-->

							<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
								up</button>

							<div id="passwordStatus" />
							<br />
							<div class="error"><%=request.getAttribute("message")%></div>


						</form>
					</div>
				</div>
			</div>
		</div>


	</div>















	<!--  
<form action="${pageContext.request.contextPath }/register" method="post">

	<table>
		
		<tr>
			<td>Name: </td>
			<td> <input type="text" name="name"></td>
		</tr>
		
		<tr>
			<td>Surname: </td>
			<td> <input type="text" name="surname"></td>
		</tr>
		
		
		
		<tr>
			<td>Email: </td>
			<td> <input type="text" name="email"></td>
		</tr>
		
		<tr>
			<td>Username: </td>
			<td> <input type="text" name="username"></td>
		</tr>
		
		<tr>
			<td>Password: </td>
			<td> <input type="password" name="password"></td>
		</tr>
		
		
		<tr>
			<td/>
			<td> <input type="submit" value="Sign Up!"></td>
		</tr>
	
	</table>



</form>

-->


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>