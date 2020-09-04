<%@ page import="java.util.List"%>
<%@ page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="Icon/circle.png" type="image/png" />
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Password Reset Portal</title>
<style>
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
<%
	List<String> userDetails = (List<String>)request.getAttribute("UserDetailResult");
%>
	<marquee behavior="scroll" width="100%" direction="left" bgcolor=green behavior="scroll" direction="left" scrollamount="11">
		Welcome	<%=userDetails.get(0)%>!!! &nbsp;&nbsp;HENG ah! ONG ah! HUAT ah!"
	</marquee>
	<div>
	<svg width="600" height="600" viewBox="0 0 120 80" fill="none">
	<rect x="10" y="-8" width="93" height="73" rx="5" fill="white" stroke="#0084F8" stroke-width="0.5"/>
	</svg><svg width="600" height="600" viewBox="0 0 120 80" fill="none">
	<rect x="20" y="-8" width="93" height="73" rx="5" fill="white" stroke="#0084F8" stroke-width="0.5"/>
	</svg>
	<p class="user_detail">&nbsp;User Detail</p>	
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
			<p>: <%=userDetails.get(0)%></p> <!-- Full Name -->
			<p>: <%=userDetails.get(1)%></p> <!-- Domain ID -->
			<p>: <%=userDetails.get(2)%></p> <!-- Group Member -->
			<p>: <%=userDetails.get(3)%></p> <!-- User Workstations -->
			<p>: <%=userDetails.get(4)%></p> <!-- Account Status -->
			<p>: <%=userDetails.get(5)%></p> <!-- Account Locked -->
			<p>: <%=userDetails.get(6)%></p> <!-- Password Expired -->
			<p>: <%=userDetails.get(7)%></p> <!-- Password Last Set -->
			<p>: <%=userDetails.get(8)%></p> <!-- Last Login Date -->
			<p>: <%=userDetails.get(9)%></p> <!-- Last Bad Password Attempt -->
		</div>
		<p class="unlock_account">&nbsp;Unlock/Reset Account</p>
		<div class="unlock_account_container">
		<p class="email_address"><label for="email_address"></label></p><br>
		<form action="UserUnlock" method="post">
		<p class="unlock"><input type="submit" name="unlock_account" value="Unlock Account"></p>
		<p class="unlock_account_result"><label for="unlock_account_result">Result &nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp; <%=request.getAttribute("userUnlockResult")%></label></p>
		</form>
		</div>
		<div class="reset_account_container">
		<p class="reset"><input type="submit" name="reset_password" value="Reset Password"></p>
		<form action="UserReset" method="post">
		<p class="reset"><input type="submit" name="reset_account" value="Reset Account Password"></p>
		<p class="reset_account_result"><label for="reset_account_result">Result &nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp; <%=request.getAttribute("userResetResult")%></label></p>
		</form>
		</div>
	</div>

</body>
</html>