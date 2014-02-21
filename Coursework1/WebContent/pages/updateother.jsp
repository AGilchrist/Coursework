<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="Log" class="com.dundeeuni.alistair.Beans.LogUser" scope="session" />
<jsp:setProperty name="Log" property="*" /> 
<jsp:useBean id="Data" class="com.dundeeuni.alistair.Beans.Data" scope="session" />
<jsp:setProperty name="Data" property="*" /> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update an entry</title>
</head>
<body>
<%
if(Log.isLoggedIn()){
    out.println("Hello user " + Log.getUsername() + " <br />");%>
<h3>This is the interface for updating entries in the author, developer or administrator table</h3>
<p>Please select which table you want to make a update the entries in and fill out the two text boxes to update
the details or leave blank for that field to be ignored, when done hit the submit button, then the link</p>
<form action="#" name="myTable" id="myTable">
<select name="Tablechoice">
<option>      </option>
<option value='reporter'>Author</option>
<option value='developer'>Developer</option>
<option value='admin'>Administrator</option>
</select>
<br/>
<br/>
<form name="updateother" method="post" action="updateother.jsp">
ID of entry:
<input type="text" name="myID" id="myID" value="">
<br/>
<br/>
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
Data.setName(request.getParameter("myName"));
Data.setEmail(request.getParameter("myemail"));
out.println("Please click the link below to Update the selected entry or entries <br><br>");
if(request.getParameter("myID") != null){
	Data.setID(request.getParameter("myID"));
	out.println("<a href=\"http://ac32007.cloudapp.net:8080/130025328Coursework1/Update/" + request.getParameter("Tablechoice") + "/" + "\">Update entry</a>"); 
}else{out.println("You must provide a id number for the entry you wish to update <br> Make sure it is valid or nothing will happen on the database");}
%>   
<br><br>
<input type=button value="Back to Home Page" onclick="openPage('http://ac32007.cloudapp.net:8080/130025328Coursework1/index.jsp')">
<br>
<br>
<input type="button" value="Log Out" name="Logout" onclick="openPage('http://ac32007.cloudapp.net:8080/130025328Coursework1/Logout.jsp')"/><%}

else{
	String redirectURL = "http://ac32007.cloudapp.net:8080/130025328Coursework1/index.jsp";
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