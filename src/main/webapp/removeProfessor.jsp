<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<link rel="stylesheet" href="resource/assets/css/style1.css">
	<title>Admin Login</title>
</head>

<body>
	<section>
		<div class="form-box">
			<div class="form-value">
				<form action="removeProf" method="post">
					<h2>Remove Professor</h2>
					<div class="inputbox">
						<input type="text" name="pid" required>
						<label for="">Enter Professor Id</label>
					</div>
					<input class="login" type="submit" value="Remove">
					</form>

			</div>
		</div>
	</section>
	<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>

</html>