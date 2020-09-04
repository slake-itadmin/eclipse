<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#emails {
	width: 1000px;
}
</style>
</head>
<body>
<form action="SearchEmail" method="post">
<input type="text" id="emails" name="emails" placeholder="key in all email address"><br><br>
<input type="submit" id="submit" name="submit" value="Submit"><br><br>
<%String email = (String)request.getAttribute("found_email");%>
<%=email%>
</form>
</body>
</html>