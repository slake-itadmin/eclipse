<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL Demo</title>
</head>
<body>
<c:out value="${students}" /> </br></br>

<c:forEach items="${students}" var="n">
${n.rollno} ${n.name}</br>
</c:forEach>

<c:set var="str" value="Edmund Chiu Pak Ngiu" /></br></br>

Name : ${str}</br>

<c:forEach items="${fn:split(str,' ')}" var="s">
<br>
${s}
</c:forEach>

</br></br>
index : ${fn:indexOf(str,"Pak")}

</br></br>
is there : ${fn:contains(str,"Chiu")}

</br></br>
<c:if test="${fn:contains(str,'Chiu')}">
Last name is Chiu
</c:if>

</body>
</html>