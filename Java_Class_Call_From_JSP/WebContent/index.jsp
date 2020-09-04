<%@page import="com.hamid.MyClass"%>

<%
    if(request.getParameter("btn_check")!=null) //check button click event not null button name is "btn_check"
    { 
        
    	MyClass mc = new MyClass(); //create a java class and this class contain calling return type "check()" function 
        
        String validate=mc.check(); //put "mc" object in "check()" function and recieve string message and store created "validate" variable
        
        if(validate.equals("Java Class Call Successfully")) //check calling "check() function" receive "Java Class Call Successfully" string message and they are match after redirect to "welcome.jsp" page
        {
            request.setAttribute("SuccessMsg",validate); //send successfully message through "SuccessMsg" object
            RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp"); //redirect to welcome.jsp page
            rd.forward(request, response);
        }
    }
%>

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

	<div class="container">
		<h3 align="center"><a href="https://www.onlyxcodes.com/2019/03/call-java-class-from-jsp-page.html" target="_blank">Tutorial</a></h3></br>
               
    	<form method="post" class="form-horizontal">
                    
        	<div class="form-group">
            <div class="col-sm-offset-5 col-sm-9 m-t-15">
            <input type="submit" name="btn_check" class="btn btn-success" value="Check">
            </div>
            </div>
                    
		</form>
            
	</div>

</body>
</html>