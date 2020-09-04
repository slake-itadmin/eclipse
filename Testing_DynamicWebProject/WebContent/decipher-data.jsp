<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>DeCipher Data</h2>

<%
// Read parameter
String param = request.getParameter("param");
%>

received encryptedData: <%=param%><br/>
decrypted data is: <%=com.itcuties.samples.CipherHelper.decipher("012345678", param)%><br/>
<br/>
<br/>
<a href='cipher-data.jsp'>back</a>
</body>
</html>