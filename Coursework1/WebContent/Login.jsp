<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="Log" class="com.dundeeuni.alistair.Beans.LogUser" scope="session" />
 <jsp:setProperty name="Log" property="*" /> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<form name="Login" method="post" action="Login.jsp">
Username:
<input type="text" name="myUsername" id="myUsername" value="">
<br/>
<br/>
Password:
<input type="password" name="myPassword" id="myPassword" value="">
<br/>
<br/>
<input type="Submit" value="Log In">
</form>

<%
String myUsername = request.getParameter("myUsername");
String myPassword = request.getParameter("myPassword");
Log.LogIn(myUsername, myPassword);
if(Log.isLoggedIn())
	response.sendRedirect("http://localhost:8080/Coursework1/index.jsp");
%>

<script type="text/javascript">
 function openPage(pageURL)
 {
 window.location.href = pageURL;
 }
 
</script>
</body>
</html>