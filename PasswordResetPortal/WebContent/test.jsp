<%@ page import="java.util.List"%>
<%@ page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="icon" href="Icon/circle.png" type="image/png" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://fonts.googleapis.com/css2?family=Teko:wght@600&display=swap" rel="stylesheet">
<title>Testing HTML</title>
<style>
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

.user_detail {
	font: 13px/25px "Lucida Grande", Tahoma, Verdana, sans-serif;
	opacity: 1;
	margin-left: auto;
	margin-right: auto;
	padding: 20px 20px 20px;
	height: 510px;
	width: 500px;
	background: white;
	border-radius: 6px;
	-webkit-box-shadow: 0 0 200px rgba(135, 0, 0, 0.5), 0 1px 2px
		rgba(0, 46, 138, 0.3);
	box-shadow: 0 0 200px rgba(63, 63, 63, 0.5), 0 1px 2px
		rgba(135, 0, 0, 0.3);
	z-index: 1000;
	position: relative;
}

.user_detail h1 {
	margin: -20px -20px 21px;
	text-align: center;
	font-size: 25px;
	line-height: 60px;
	font-weight: bold;
	color: #555;
	text-shadow: 0 1px white;
	border-bottom: 1px solid #cfcfcf;
	border-radius: 6px 6px 0 0;
	-webkit-box-shadow: 0 1px whitesmoke;
	box-shadow: 0 1px whitesmoke;
}

.caption, input[type='text'] {
	font-family: 'Teko', sans-serif;
	font-size: 16px;
	text-align: left;
}

input[type='text'] {
	width: 100%;
	/*background: linear-gradient(to top, #ffffff 0%, #ff9999 100%);*/
}

.tablebutton {
	display:block;
	text-align: center;
}

table, th, td {
	border: 1px solid black;
}

@keyframes move_wave {
    0% {
        transform: translateX(0) translateZ(0) scaleY(1)
    }
    50% {
        transform: translateX(-25%) translateZ(0) scaleY(0.55)
    }
    100% {
        transform: translateX(-50%) translateZ(0) scaleY(1)
    }
}

.waveWrapper {
	overflow: hidden;
	position: absolute;
	left: 0;
	right: 0;
	bottom: 0;
	top: 0;
	margin: auto;
}

.waveWrapperInner {
	position: absolute;
	width: 100%;
	overflow: hidden;
	height: 100%;
	bottom: -1px;
	background-image: linear-gradient(to top, #6600ff -60%, #ccffff 100%);
}

.bgTop {
	z-index: 15;
	opacity: 0.5;
}

.bgMiddle {
	z-index: 10;
	opacity: 0.75;
}

.bgBottom {
	z-index: 5;
}

.wave {
	position: absolute;
	left: 0;
	width: 200%;
	height: 100%;
	background-repeat: repeat no-repeat;
	background-position: 0 bottom;
	transform-origin: center bottom;
}

.waveTop {
	background-size: 50% 100px;
}

.waveAnimation .waveTop {
	animation: move-wave 3s;
	-webkit-animation: move-wave 3s;
	-webkit-animation-delay: 1s;
	animation-delay: 1s;
}

.waveMiddle {
	background-size: 50% 120px;
}

.waveAnimation .waveMiddle {
	animation: move_wave 10s linear infinite;
}

.waveBottom {
	background-size: 50% 100px;
}

.waveAnimation .waveBottom {
	animation: move_wave 15s linear infinite;
}
</style>
</head>
<body>
<%
	List<String> userDetails = (List<String>)request.getAttribute("UserDetailResult");
%>


	<div class="outer">
		<div class="middle">
			<div class="user_detail">
				<h1>Active Directory User Details</h1>
				<div class="user_detail_list">
					<table>
						<tr>
							<td style="height:10px" colspan="5"></td>
						</tr>
						<tr>
							<td width="20"></td>
    						<td width="205" class="caption">Full Name</td>
							<td width="15"></td>
							<td width="205" class="caption">
								<input type="text" name="FullName" value="<%=userDetails.get(0)%>" readonly>
							</td>
    						<td width="20"></td>
    					</tr>
						<tr>
							<td width="20"></td>
    						<td width="205" class="caption">Domain Id</td>
							<td width="15"></td>
							<td width="205" class="caption">
								<input type="text" name="DomainId" value="<%=userDetails.get(1)%><%=userDetails.get(2)%>" readonly>
							</td>
    						<td width="20"></td>
    					</tr>
						<tr>
							<td width="20"></td>
    						<td width="205" class="caption">Group Member</td>
							<td width="15"></td>
							<td width="205" class="caption">
								<input type="text" name="GroupMember" value="<%=userDetails.get(3)%>" readonly>
							</td>
    						<td width="20"></td>
    					</tr>
						<tr>
							<td width="20"></td>
    						<td width="205" class="caption">User Workstations</td>
							<td width="15"></td>
							<td width="205" class="caption">
								<input type="text" name="UserWorkstations" value="<%=userDetails.get(4)%>" readonly>
							</td>
    						<td width="20"></td>
    					</tr>
						<tr>
							<td width="20"></td>
    						<td width="205" class="caption">Account Status</td>
							<td width="15"></td>
							<td width="205" class="caption">
								<input type="text" name="AccountStatus" value="<%=userDetails.get(5)%>" readonly>
							</td>
    						<td width="20"></td>
    					</tr>
						<tr>
							<td width="20"></td>
    						<td width="205" class="caption">Account Locked</td>
							<td width="15"></td>
							<td width="205" class="caption">
								<input type="text" name="AccountLocked" value="<%=userDetails.get(6)%>" readonly>
							</td>
    						<td width="20"></td>
    					</tr>
						<tr>
							<td width="20"></td>
    						<td width="205" class="caption">Password Expired</td>
							<td width="15"></td>
							<td width="205" class="caption">
								<input type="text" name="PasswordExpired" value="<%=userDetails.get(7)%>" readonly>
							</td>
    						<td width="20"></td>
    					</tr>
						<tr>
							<td width="20"></td>
    						<td width="205" class="caption">Password Last Set</td>
							<td width="15"></td>
							<td width="205" class="caption">
								<input type="text" name="PasswordLastSet" value="<%=userDetails.get(8)%>" readonly>
							</td>
    						<td width="20"></td>
    					</tr>
						<tr>
							<td width="20"></td>
    						<td width="205" class="caption">Last Login Date</td>
							<td width="15"></td>
							<td width="205" class="caption">
								<input type="text" name="LastLoginDate" value="<%=userDetails.get(9)%>" readonly>
							</td>
    						<td width="20"></td>
    					</tr>
						<tr>
							<td width="20"></td>
    						<td width="205" class="caption">Last Bad Password Attempt</td>
							<td width="15"></td>
							<td width="205" class="caption">
								<input type="text" name="LastBadPasswordAttempt" value="<%=userDetails.get(10)%>" readonly>
							</td>
    						<td width="20"></td>
    					</tr>
						<tr>
							<td width="20"></td>
							<td style="height:60px" width="205" class="tablebutton">
								<form action="UserUnlock" method="post">
								<p class="unlock"><input type="submit" name="unlock_account" value="Unlock Account"></p>
								</form>
							</td>
							<td width="15"></td>
							<td style="height:60px" width="205" class="tablebutton">
								<form action="UserRequestReset" method="post">
								<p class="reset"><input type="submit" name="reset_account" value="Reset Account Password"></p>
								</form>
							</td>
    						<td width="20"></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="waveWrapper waveAnimation">
		<div class="waveWrapperInner bgTop">
			<div class="wave waveTop"
				style="background-image: url(image/wave-top.png)"></div>
		</div>
		<div class="waveWrapperInner bgMiddle">
			<div class="wave waveMiddle"
				style="background-image: url(image/wave-mid.png)"></div>
		</div>
		<div class="waveWrapperInner bgBottom">
			<div class="wave waveBottom"
				style="background-image: url(image/wave-bot.png)"></div>
		</div>
	</div>
	
<%-- Get login email from LoginCheck --%>
<% String email = (String)request.getAttribute("login_email"); %>
        
<%-- Pass user's detail to UserRequestReset.java --%>
<%    
	session.setAttribute("full_name", userDetails.get(0));
	session.setAttribute("domain_name", userDetails.get(1));
	session.setAttribute("domain_id", userDetails.get(2));
	session.setAttribute("login_email", email);
%>	
</body>
</html>