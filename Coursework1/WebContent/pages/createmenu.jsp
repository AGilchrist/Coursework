<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="Log" class="com.dundeeuni.alistair.Beans.LogUser" scope="session" />
<jsp:setProperty name="Log" property="*" /> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(Log.isLoggedIn()){
    out.println("Hello user " + Log.getUsername() + " <br />");%>
<h3>This is the create menu</h3>
<p>Please select the type of entry to create</p>
<form action="#">
<select name="URL" onchange="window.location.href= this.form.URL.options[this.form.URL.selectedIndex].value">
<option>      </option>
<option value="http://ac32007.cloudapp.net:8080/130025328Coursework1/pages/createfault.jsp">A fault</option>
<option value="http://ac32007.cloudapp.net:8080/130025328Coursework1/pages/createother.jsp">An author, developer or administrator</option>
</select>
<br>
<br>
</form>
<input type=button value="Back to Home Page" onclick="openPage('http://ac32007.cloudapp.net:8080/130025328Coursework1/index.jsp')">
<br>
<br>
<input type="button" value="Log Out" name="Logout" onclick="openPage('http://ac32007.cloudapp.net:8080/130025328Coursework1/Logout.jsp')"/><%}

else{
	String redirectURL = "http://ac32007.cloudapp.net:8080/130025328Coursework1/.jsp";
    response.sendRedirect(redirectURL);}
%>
<script type="text/javascript">
 function openPage(pageURL)
 {
 window.location.href = pageURL;
 }
</script>
</body>
</html>