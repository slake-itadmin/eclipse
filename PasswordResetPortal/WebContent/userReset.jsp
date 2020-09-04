<%@ page import="java.util.List"%>
<%@ page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
<link rel="icon" href="Icon/circle.png" type="image/png" />
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<script src="http://code.jquery.com/jquery-1.7.min.js"></script>
<script src="passwordverification.js"></script><title>Change Password Page</title><style>
.outer {
	display: table;
	position: absolute;
	top: 0;
	left: 0;
	height: 100%;
	width: 100%;
}

.middle {
	display: table-cell;
	vertical-align: middle;
}

.reset_password {
    position:relative; 
	margin-left: auto;
	margin-right: auto;
	padding: 20px 20px 20px;
	width: 290px;
	background: white;
	border-radius: 4px;
	-webkit-box-shadow: 0 0 200px rgba(135, 0, 0, 0.5), 0 1px 2px rgba(0, 46, 138, 0.3);
	box-shadow: 0 0 200px rgba(63, 63, 63, 0.5), 0 1px 2px rgba(135, 0, 0, 0.3);
}

.reset_password h1 {
	margin: -20px -20px 21px;
	line-height: 40px;
	font-size: 18px;
	font-weight: bold;
	color: #555;
	text-align: center;
	text-shadow: 0 1px white;
	background: #f3f3f3;
	border-bottom: 1px solid #cfcfcf;
	border-radius: 4px 4px 0 0;
	-webkit-box-shadow: 0 1px whitesmoke;
	box-shadow: 0 1px whitesmoke;
}

.reset_password p {
	margin: 20px 0 0;
}

.reset_password p:first-child {
	margin-top: 0;
}

.reset_password input[type=text], .reset_password input[type=password] {
	width: 278px;
}

input[type=text], input[type=password] {
	margin: 7px;
	padding: 0 10px;
	width: 200px;
	height: 34px;
	color: #003300;
	background: white;
	border: 1px solid;
	border-color: #c4c4c4 #d1d1d1 #d4d4d4;
	border-radius: 2px;
	outline: 5px solid #eff4f7;
	-moz-outline-radius: 3px;
	-webkit-box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.12);
	box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.12);
}

input[type=text]:focus, input[type=password]:focus {
	border-color: #7dc9e2;
	outline-color: #dceefc;
	outline-offset: 0;
}


.reset_password p.submit {
	text-align: center;
}

input[type=submit] {
	padding: 0 18px;
	width: 100px;
	height: 29px;
	font-size: 12px;
	font-weight: bold;
	color: #527881;
	text-shadow: 0 1px #e3f1f1;
	background: #cde5ef;
	border: 1px solid;
	border-color: #b4ccce #b3c0c8 #9eb9c2;
	border-radius: 5px;
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

input[type=submit]:active {
	background: #cde5ef;
	border-color: #9eb9c2 #b3c0c8 #b4ccce;
	-webkit-box-shadow: inset 0 0 3px rgba(0, 0, 0, 0.2);
	box-shadow: inset 0 0 3px rgba(0, 0, 0, 0.2);
}

input {
	font-family: 'Lucida Grande', Tahoma, Verdana, sans-serif;
	font-size: 14px;
}

:-moz-placeholder {
	color: #c9c9c9 !important;
	font-size: 13px;
}

::-webkit-input-placeholder {
	color: #ccc;
	font-size: 13px;
}

:-ms-input-placeholder {
	color: #ccc;
	font-size: 13px;
}

:-moz-placeholder {
	color: #ccc;
	font-size: 13px;
}

#pswd_info_1 {
    position: absolute;
    bottom: -80px;
    bottom: -115px\9; /* IE Specific */
    right: 23px;
    width: 250px;
    padding: 15px;
    background: #fefefe;
    font-size: .875em;
    border-radius: 5px;
    box-shadow: 0 1px 3px #ccc;
    border: 1px solid #ddd;
}

#pswd_info_1 h4 {
    margin:0 0 10px 0;
    padding:0;
    font-weight:normal;
}

#pswd_info_1::before {
    content: "\25B2";
    position:absolute;
    top:-12px;
    left:45%;
    font-size:14px;
    line-height:14px;
    color:#cde5ef;
    text-shadow:none;
    display:block;
}

#pswd_info_1 {
    display:none;
}

.invalid {
    background: url(image/cross.png) no-repeat 0 50%;
    padding-left: 22px;
    line-height: 24px;
    color: #ec3f41;
}

.valid {
    background: url(image/tick.png) no-repeat 0 50%;
    padding-left: 22px;
    line-height: 24px;
    color: #3a7d34;
}
</style>
</head>
<body>
	<%-- Get user email from KeyCheck.java --%>
	<%
		String user_email = (String) request.getAttribute("user_email");
	%>

	<%-- Get domain id from KeyCheck.java --%>
	<%
		String domainId = (String) request.getAttribute("domain_id");
	%>

	<%-- Pass user email and domain id to PasswordCheck.java --%>
	<%
		session.setAttribute("user_email", user_email);
		session.setAttribute("domainId", domainId);
	%>


	<div class="outer">
		<div class="middle">
			<div class="reset_password">
				<h1>Change Password</h1>
				<form action="PasswordCheck" method="post">
					<%-- Get domain id from KeyCheck.java --%>
					<p>
						<input type="text" name="domain_id" value="<%=request.getAttribute("domain_id")%>" readonly><br>
						<input id="new_password" type="password" name="new_password" placeholder="New Password" required oninvalid="this.setCustomValidity('New password cannot be empty')" oninput="this.setCustomValidity('')"/><br> 
						<input id="confirm_password" type="password" name="confirm_password" placeholder="Confirm Password" required oninvalid="this.setCustomValidity('Confirm password cannot be empty')" oninput="this.setCustomValidity('')"/><br> 
					</p>
					<p class="submit">
						<input type="submit" id="change_password" name="change_submit" value="Submit">
					</p>
				</form>
				<p style="color:#e74c3c; font-family:'Lucida Grande', Tahoma, Verdana, sans-serif;"><%=request.getAttribute("userResetPasswordResult") == null ? "" : request.getAttribute("userResetPasswordResult")%></p>
				<p style="color:#2ecc71; font-family:'Lucida Grande', Tahoma, Verdana, sans-serif;"><%=request.getAttribute("userResetPasswordResult_s") == null ? "" : request.getAttribute("userResetPasswordResult_s")%></p>
				<div id="pswd_info_1">
   					<h4>Password must meet the following requirements:</h4>
    				<ul>
     					<li id="letter" class="invalid">At least <strong>one letter</strong></li>
        				<!-- <li id="capital" class="invalid">At least <strong>one capital letter</strong></li> -->
        				<li id="number" class="invalid">At least <strong>one number</strong></li>
        				<li id="symbol" class="invalid">At least <strong>one symbol</strong></li>
        				<li id="length_1" class="invalid">Be at least <strong>6 characters</strong></li>
    				</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>