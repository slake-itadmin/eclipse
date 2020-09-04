<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Encryption & Decryption</title>
<style>
p {
	width: 350px;
}
</style>
</head>
<body>
<form action="Encryption" method="post">
	<input style="width:420px" id="encrypt_string" type="text" name="encrypt_string" placeholder="Encrypt String">
	<input id="encrypt_key" type="text" name="encrypt_key" placeholder="Encrypt Key">
	<input type="submit" id="encrypt_submit" name="encrypt_submit" value="Submit">
	<%String encryptedString = (String)request.getAttribute("encrypted_string"); %>
	<input style="width:420px" type="text" id="encrypted_string" name="encrypted_string" value="<%=encryptedString%>" readonly>
</form>
<form action="Decryption" method="post">
	<input style="width:420px" id="decrypt_string" type="text" name="decrypt_string" placeholder="Decrypt String">
	<input id="decrypt_key" type="text" name="decrypt_key" placeholder="Decrypt Key">
	<input type="submit" id="decrypt_submit" name="decrypt_submit" value="Submit">
	<%String decryptedString = (String)request.getAttribute("decrypt_string"); %>
	<input style="width:420px" type="text" id="decrypted_string" name="decrypted_string" value="<%=decryptedString%>" readonly>
</form>
</body>
</html>