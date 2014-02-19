<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="Log" class="com.dundeeuni.alistair.Beans.LogUser" scope="session" />
<jsp:setProperty name="Log" property="*" /> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a fault</title>
</head>
<body>
<%
if(Log.isLoggedIn()){
    out.println("Hello user " + Log.getUsername() + " <br />");%>
<h3>This is the interface for creating a new entry in the fault table</h3>
<p>Please type data for all fields of the entry before hitting the submit button, then the link that appears</p>

<form name="createfault" method="post" action="createfault.jsp">
Summary of fault:
<input type="text" name="mySummary" id="mySummary" value="">
<br/><br/>
Details of fault:
<input type="text" name="myDetails" id="myDetails" value="">
<br/><br/>
Reporter of fault:
<input type="text" name="myReporter" id="myReporter" value="">
<br/><br/>
Section the fault was found in:
<input type="text" name="mySection" id="mySection" value="">
<br/><br/>
Severity of fault:
<input type="text" name="mySeverity" id="mySeverity" value="">
<br/><br/>
<input type="Submit" value="Update details for Servlet">
<br/><br/>
</form>
<%  
String mySummary = request.getParameter("mySummary");
String myDetails = request.getParameter("myDetails");
String myReporter = request.getParameter("myReporter");
String mySection = request.getParameter("mySection");
String mySeverity = request.getParameter("mySeverity");
out.println("Please click the link below to create the entry <br><br>");
if(mySummary != null){
	if(myDetails != null){
		if(myReporter != null){
			if(mySection != null){
				if(mySeverity != null){
					out.println("<a href=\"http://localhost:8080/Coursework1/Create/fault/" 
					        + request.getParameter("mySummary") + "/" + request.getParameter("myDetails") + "/" + request.getParameter("myReporter") + "/"
					        + request.getParameter("mySection") + "/" + request.getParameter("mySeverity") + "\">Create Entry</a>"); 
				}else{out.println("You must fill in all fields to create an entry <br>");}
			}else{out.println("You must fill in all fields to create an entry <br>");}
		}else{out.println("You must fill in all fields to create an entry <br>");}
	}else{out.println("You must fill in all fields to create an entry <br>");}
}else{out.println("You must fill in all fields to create an entry <br>");}
%>   
<br><br>
<input type=button value="Back to Home Page" onclick="openPage('http://localhost:8080/Coursework1/index.jsp')">
<br><br>
<input type="button" value="Log Out" name="Logout" onclick="openPage('http://localhost:8080/Coursework1/Logout.jsp')"/><%}
else{
	out.println("Please Log in to access features <br />");%>
	<br>
    <input type="button" value="Log In" name="Login" onclick="openPage('http://localhost:8080/Coursework1/Login.jsp')"/><%}
%>
<script type="text/javascript">
 function openPage(pageURL)
 {
 window.location.href = pageURL;
 }
</script>
</body>
</html>