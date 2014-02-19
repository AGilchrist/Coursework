<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="Log" class="com.dundeeuni.alistair.Beans.LogUser" scope="session" />
<jsp:setProperty name="Log" property="*" /> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create an entry</title>
</head>
<body>
<%
if(Log.isLoggedIn()){
    out.println("Hello user " + Log.getUsername() + " <br />");%>
<h3>This is the interface for creating a new entry in the author, developer or administrator table</h3>
<p>Please select which table you want to make a new entry in and fill out the two text boxes before hitting the submit button, then the link</p>
<form action="#" name="myTable" id="myTable">
<select name="Tablechoice">
<option>      </option>
<option value='reporter'>Author</option>
<option value='developer'>Developer</option>
<option value='admin'>Administrator</option>
</select>
<br/>
<br/>
<form name="createother" method="post" action="createother.jsp">
Name of new entry:
<input type="text" name="myName" id="myName" value="">
<br/>
<br/>
Email address:
<input type="text" name="myemail" id="myemail" value="">
<br/>
<br/>
<input type="Submit" value="Click to Submit">
</form>
</form>
<%  
String myTable = request.getParameter("Tablechoice");
String myName = request.getParameter("myName");
String myemail = request.getParameter("myemail");
out.println("Please click the link below to create the entry <br><br>");
if(myName != null){
	if(myemail != null){
		out.println("<a href=\"http://localhost:8080/Coursework1/Create/" + request.getParameter("Tablechoice") + "/" 
        + request.getParameter("myName") + "/" + request.getParameter("myemail") + "\">Create Entry</a>"); 
	}else{out.println("You must fill in all fields to create an entry <br>");}
}else{out.println("You must fill in all fields to create an entry <br>");}
%>   
<br>
<br>
<input type=button value="Back to Home Page" onclick="openPage('http://localhost:8080/Coursework1/index.jsp')">
<br>
<br>
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