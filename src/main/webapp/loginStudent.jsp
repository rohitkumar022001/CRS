<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<link rel="stylesheet" href="resource/assets/css/style1.css">
	<title>Student Login</title>
</head>

<body>
	<section>
		<div class="form-box">
			<div class="form-value">
				<form action="loginStudent" method="post">
					<h2>Login</h2>
					<div class="inputbox">
						<input type="text" name="user_name" required>
						<label for="">Username</label>
					</div>
					<div class="inputbox">
						<input type="text" name="sid" required>
						<label for="">Student Id</label>
					</div>
					<div class="inputbox">
						<ion-icon name="lock-closed-outline"></ion-icon>
						<input type="text" name="password" required>
						<label for="">Password</label>
					</div>
					
					<input class="login" type="submit" value="Log in">
					</form>

					<!--<form action="Register" method="post">-->
					<div class="register">
						<p>Don't have a account / <a href="registerStudent.jsp">Register</a></p>
					</div>
				</form>
			</div>
		</div>
	</section>
	<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>

</html>