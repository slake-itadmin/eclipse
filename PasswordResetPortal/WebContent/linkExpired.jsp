<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="icon" href="Icon/circle.png" type="image/png" />
<meta charset="ISO-8859-1">
<link href="https://fonts.googleapis.com/css2?family=Orbitron:wght@800&display=swap" rel="stylesheet">
<title>Link Expired</title>
<style>
body {
	background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);
	background-size: 400% 400%;
	animation: gradient 15s ease infinite;
}

@keyframes gradient {
	0% {
		background-position: 0% 50%;
	}
	50% {
		background-position: 100% 50%;
	}
	100% {
		background-position: 0% 50%;
	}
}

.expired {
	width: 600px;
	height: 150px;
	position: absolute;
	left: 50%;
	top: 45%;
	transform: translate(-50%, -50%);
	color: #fff;
	font-family: 'Orbitron', sans-serif;
	font-size:30px;
}
</style>
</head>
<body>

<div class="expired">
	<h1 style="text-align:center">This link<br>has expired.</h1>
</div>
</body>
</html>