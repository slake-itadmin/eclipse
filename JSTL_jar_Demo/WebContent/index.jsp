<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL jar Demo</title>
</head>
<body>

	<h1>JSTL Test</h1>
	<c:forEach var="i" begin="1" end="5" step="1">
		<c:out value="${i}" />
		<br />
	</c:forEach>

</body>
</html>