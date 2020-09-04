<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Cipher Data</h2>
Sending 'data1' : <a href='decipher-data.jsp?param=<%=com.itcuties.samples.CipherHelper.cipher("01234678", "data1")%>'>...decipher-data.jsp?param=data1(encrypted)</a><br/>
Sending 'data2' : <a href='decipher-data.jsp?param=<%=com.itcuties.samples.CipherHelper.cipher("01234678", "data2")%>'>...decipher-data.jsp?param=data2(encrypted)</a><br/>
Sending 'data3' : <a href='decipher-data.jsp?param=<%=com.itcuties.samples.CipherHelper.cipher("01234678", "data3")%>'>...decipher-data.jsp?param=data3(encrypted)</a><br/>
</body>
</html>