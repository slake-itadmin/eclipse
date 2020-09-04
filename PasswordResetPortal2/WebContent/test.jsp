<%@ page import="java.util.List"%>
<%@ page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="Icon/circle.png" type="image/png" />
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Password Reset Portal</title>
<style>
body {
	font: 13px/20px "Lucida Grande", Tahoma, Verdana, sans-serif;
	color: #404040;
	background: #092756;
	background: -moz-radial-gradient(0% 100%, ellipse cover, rgba(104, 128, 138, .4)
		10%, rgba(138, 114, 76, 0) 40%),
		-moz-linear-gradient(top, rgba(57, 173, 219, .25) 0%,
		rgba(42, 60, 87, .4) 100%),
		-moz-linear-gradient(-45deg, #670d10 0%, #092756 100%);
	background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104, 128, 138, .4)
		10%, rgba(138, 114, 76, 0) 40%),
		-webkit-linear-gradient(top, rgba(57, 173, 219, .25) 0%,
		rgba(42, 60, 87, .4) 100%),
		-webkit-linear-gradient(-45deg, #670d10 0%, #092756 100%);
	background: -o-radial-gradient(0% 100%, ellipse cover, rgba(104, 128, 138, .4)
		10%, rgba(138, 114, 76, 0) 40%),
		-o-linear-gradient(top, rgba(57, 173, 219, .25) 0%,
		rgba(42, 60, 87, .4) 100%),
		-o-linear-gradient(-45deg, #670d10 0%, #092756 100%);
}

marquee {
	font-size: 20px;
	font-weight: 780;
	color: red;
	background: black;
	font-family: sans-serif;
}

.user_detail_list {
	position: absolute;
	width: 300px;
	height: 100px;
	left: 100px;
	top: 100px;
}

.user_detail_result {
	position: absolute;
	width: 300px;
	height: 100px;
	left: 300px;
	top: 100px;
}

.unlock_account_container p.email_address {
	position: absolute;
	width: 300px;
	height: 34px;
	left: 776px;
	top: 145px;
}

p.user_detail {
	position: absolute;
	width: 152px;
	height: 30px;
	left: 215px;
	top: 50px;
	font-style: normal;
	font-weight: normal;
	font-size: 30px;
	line-height: 27px;
	background: #FFFFFF;
}

p.unlock_account {
	position: absolute;
	width: 285px;
	height: 30px;
	left: 797px;
	top: 50px;
	font-style: normal;
	font-weight: normal;
	font-size: 30px;
	line-height: 27px;
	background: #FFFFFF;
}

.unlock_account_container p.unlock input[type=submit] {
	position: absolute;
	padding: 0 18px;
	width: 100px;
	height: 29px;
	left: 780px;
	top: 170px;
	font-size: 12px;
	font-weight: bold;
	color: #527881;
	text-shadow: 0 1px #e3f1f1;
	background: #cde5ef;
	border: 1px solid;
	border-color: #b4ccce #b3c0c8 #9eb9c2;
	border-radius: 16px;
	outline: 0;
	-webkit-box-sizing: content-box;
	-moz-box-sizing: content-box;
	box-sizing: content-box;
	background-image: -webkit-linear-gradient(top, #edf5f8, #cde5ef);
	background-image: -moz-linear-gradient(top, #edf5f8, #cde5ef);
	background-image: -o-linear-gradient(top, #edf5f8, #cde5ef);
	background-image: linear-gradient(to bottom, #edf5f8, #cde5ef);
	-webkit-box-shadow: inset 0 1px white, 0 1px 2px rgba(0, 0, 0, 0.15);
	box-shadow: inset 0 1px white, 0 1px 2px rgba(0, 0, 0, 0.15);
}

.unlock_account_container p.unlock input[type=submit]:active, .reset_account_container p.reset input[type=submit]:active {
	background: #cde5ef;
	border-color: #9eb9c2 #b3c0c8 #b4ccce;
	-webkit-box-shadow: inset 0 0 3px rgba(0, 0, 0, 0.2);
	box-shadow: inset 0 0 3px rgba(0, 0, 0, 0.2);
}

.unlock_account_container p.unlock_account_result {
	position: absolute;
	width: 300px;
	height: 34px;
	left: 790px;
	top: 200px;
}

.reset_account_container p.reset input[type=submit] {
	position: absolute;
	padding: 0 18px;
	width: 170px;
	height: 29px;
	left: 780px;
	top: 310px;
	font-size: 12px;
	font-weight: bold;
	color: #527881;
	text-shadow: 0 1px #e3f1f1;
	background: #cde5ef;
	border: 1px solid;
	border-color: #b4ccce #b3c0c8 #9eb9c2;
	border-radius: 16px;
	outline: 0;
	-webkit-box-sizing: content-box;
	-moz-box-sizing: content-box;
	box-sizing: content-box;
	background-image: -webkit-linear-gradient(top, #edf5f8, #cde5ef);
	background-image: -moz-linear-gradient(top, #edf5f8, #cde5ef);
	background-image: -o-linear-gradient(top, #edf5f8, #cde5ef);
	background-image: linear-gradient(to bottom, #edf5f8, #cde5ef);
	-webkit-box-shadow: inset 0 1px white, 0 1px 2px rgba(0, 0, 0, 0.15);
	box-shadow: inset 0 1px white, 0 1px 2px rgba(0, 0, 0, 0.15);
}

.reset_account_container p.reset_account_result {
	position: absolute;
	width: 300px;
	height: 34px;
	left: 790px;
	top: 340px;
}
</style>
</head>
<body>
	<marquee behavior="scroll" width="100%" direction="left" bgcolor=green behavior="scroll" direction="left" scrollamount="11">
		Welcome	${UserDetailResult.get(0)}!!! &nbsp;&nbsp;HENG ah! ONG ah! HUAT ah!"
	</marquee>
	<div>
	<svg width="600" height="600" viewBox="0 0 120 80" fill="none">
	<rect x="10" y="-8" width="93" height="73" rx="5" fill="white" stroke="#0084F8" stroke-width="0.5"/>
	</svg>
	<p class="user_detail">&nbsp;User</p>	
		<div class="user_detail_list">
			<p>Full Name</p>
			<p>Domain ID</p>
			<p>Group Member</p>
			<p>User Workstations</p>
			<p>Account Status</p>
			<p>Account Locked</p>
			<p>Password Expired</p>
			<p>Password Last Set</p>
			<p>Last Login Date</p>
			<p>Last Bad Password Attempt</p>
		</div>
		<div class="user_detail_result">
			<p>: ${UserDetailResult.get(0)}</p> <!-- Full Name -->
			<p>: ${UserDetailResult.get(1)}</p> <!-- Domain ID -->
			<p>: ${UserDetailResult.get(2)}</p> <!-- Group Member -->
			<p>: ${UserDetailResult.get(3)}</p> <!-- User Workstations -->
			<p>: ${UserDetailResult.get(4)}</p> <!-- Account Status -->
			<p>: ${UserDetailResult.get(5)}</p> <!-- Account Locked -->
			<p>: ${UserDetailResult.get(6)}</p> <!-- Password Expired -->
			<p>: ${UserDetailResult.get(7)}</p> <!-- Password Last Set -->
			<p>: ${UserDetailResult.get(8)}</p> <!-- Last Login Date -->
			<p>: ${UserDetailResult.get(9)}</p> <!-- Last Bad Password Attempt -->
		</div>
	</div>

</body>
</html>