<%@ page contentType="text/html;charset=ISO-8859-1"%>
<%@ page language = "java" %>
<%@ page session= "true" %>
<%@ page import = "java.util.*" %>
<%
      String token = request.getParameter("t");
      String ans = JwtService.parseToken(token);
%>

<HTML>
<HEAD>
<TITLE>TestPCSupport</TITLE>

</HEAD>
<BODY >

<%=ans%>

</BODY>
</HTML>