<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>How to call Java class, Java Method from JSP Page in eclipse</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/jquery-1.12.4-jquery.min.js" type="text/javascript"></script>
</head>
<body>
	<center>
    	<h3 style="color:green">
        <%
        if(request.getAttribute("SuccessMsg")!=null)
        {
            out.println(request.getAttribute("SuccessMsg")); //get register success message from RegisterController
        }
        %>
        </h3>
            
        <h4><a href="index.jsp">Back</a></h4>
            
    </center>   
            
            
        <br><br><br><br><br><br><br>
        <div class="container">
                
        <h3 align="center"><a href="https://www.onlyxcodes.com/2019/03/call-java-class-from-jsp-page.html" target="_blank">Tutorial</a></h3>
            
        </div>
</body>
</html>