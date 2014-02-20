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
<title>Delete entries</title>
</head>
<body>
<%
if(Log.isLoggedIn()){
    out.println("Hello user " + Log.getUsername() + " <br />");%>
<h3>This is the interface for deleting an entry from a table in the database</h3>
<p>Please select which table you would like to delete from, type an id for a specific entry, then click the submit button and then the link</p>
<form action="#" name="myTable" id="myTable">
<select name="Tablechoice">
<option>      </option>
<option value='fault'>Fault</option>
<option value='reporter'>Author</option>
<option value='developer'>Developer</option>
<option value='admin'>Administrator</option>
</select>
<br/>
<br/>
<form name="selectid" method="post" action="read.jsp">
Name of new entry:
<input type="text" name="myID" id="myID" value="">
<br/>
<br/>
<input type="Submit" value="Click to Submit">
</form>
</form>
<br>
<%
Data.setID(request.getParameter("myID"));
out.println("Please click the link below to delete the selected entry <br><br>");
if(request.getParameter("myID") != null){
out.println("<a href=\"http://localhost:8080/Coursework1/Delete/" + request.getParameter("Tablechoice") + "/" + "\">Delete entry</a>");
}else{out.println("You must provide a id number for the entry you wish to delete <br>");}
%>   
<br>
<br>
<input type=button value="Back to Home Page" onclick="openPage('http://localhost:8080/Coursework1/index.jsp')">
<br>
<br>
<input type="button" value="Log Out" name="Logout" onclick="openPage('http://localhost:8080/Coursework1/Logout.jsp')"/><%}

else{
	String redirectURL = "http://localhost:8080/Coursework1/index.jsp";
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