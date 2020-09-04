<%@ page import="java.util.List"%>
<%@ page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check your email</title>
</head>
<body>
<%List<String> resetRequest = (List<String>)request.getAttribute("UserRequestResetResult");%>
<p><%=resetRequest.get(0)%></p>
<p><%=resetRequest.get(1)%></p>
</body>
</html>