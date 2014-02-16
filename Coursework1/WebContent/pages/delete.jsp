<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete entries</title>
</head>
<body>
<h3>This is the interface for deleting an entry from a table in the database</h3>
<p>Please select which table you would like to delete from, type an id for a specific entry, then click the submit button and then the link</p>
<form action="#" name="myTable" id="myTable">
<select name="Tablechoice">
<option>      </option>
<option value='fault'>Fault</option>
<option value='reporter'>Author</option>
<option value='developer'>Developer</option>
<option value='administrator'>Administrator</option>
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
<%  
String myTable = request.getParameter("Tablechoice");
String myName = request.getParameter("myID");
%>
<br>
<b>Click the link below to send to servlet and create entry</b><br><br>
<%out.println("<a href=\"http://localhost:8080/Coursework1/Delete/" + request.getParameter("Tablechoice") + "/" 
        + request.getParameter("myID")+ "\">Submit</a>");  
%>   
<br><br>
<script type="text/javascript">
 function openPage(pageURL)
 {
 window.location.href = pageURL;
 }
</script>
<input type=button value="Back to Home Page" onclick="openPage('http://localhost:8080/Coursework1/index.jsp')">
</body>
</html>