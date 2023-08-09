<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<link rel="stylesheet" href="resource/assets/css/style4.css">
	<title>Add Course</title>
</head>

<body>
	<section>
		<div class="form-box">
			<div class="form-value">
				<form action="addcourse" method="post">
					<h2>Add Course</h2>
					<div class="inputbox">
						<input type="text" name="cid" required>
						<label for="">Course Id</label>
					</div>
					<div class="inputbox">
						<input type="text" name="cname" required>
						<label for="">Course Name</label>
					</div><div class="inputbox">
						<input type="text" name="dur_months" required>
						<label for="">Course Duration</label>
					</div>
					<div class="inputbox">
						<ion-icon name="lock-closed-outline"></ion-icon>
						<input type="text" name="fees" required>
						<label for="">Fee</label>
					</div>
					
					<input class="login" type="submit" value="Add">
					</form>

					
			</div>
		</div>
	</section>
	<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>

</html>