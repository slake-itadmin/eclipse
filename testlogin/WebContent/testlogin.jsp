<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="login">
		<h1>Password Reset Portal</h1>
		<form method="post" action="LoginCheck">
			<label for="username">User Name:</label>
			<input type="text" name="IDUsername">
			<p>
			<label for="password">Password:</label>
			<input type="password" name="IDPassword"><br>
			<p class="remember_me">
				<label> 
					<input type="checkbox" name="remember_me" id="remember_me"> 
					Remember me on this computer
				</label>
			</p>
			<p class="submit">
				<input type="submit" name="commit" value="login" onclick="remember_me()">
			</p>
		</form>
	</div>
</body>
</html>