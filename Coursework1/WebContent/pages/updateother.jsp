<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update an entry</title>
</head>
<body onLoad="Default()">
<h3>This is the interface for updating entries in the author, developer or administrator table</h3>
<p>Please select which table you want to make a update the entries in and fill out the two text boxes to update
the details or leave as null to no update the current data before hitting the submit button, then the link</p>
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
String myTable = request.getParameter("Tablechoice");
String myID = request.getParameter("myID");
String myName = request.getParameter("myName");
String myemail = request.getParameter("myemail");
%>  
<br>
<b>Click the link below to send to servlet and create entry</b><br><br>
<%out.println("<a href=\"http://localhost:8080/Coursework1/Update/" + request.getParameter("Tablechoice") + "/" 
		 + request.getParameter("myID") + "/" + request.getParameter("myName") + "/" + request.getParameter("myemail") + "\">Submit</a>");  
%>   
<br><br>
<script type="text/javascript">

function openPage(pageURL)
 {
 window.location.href = pageURL;
 }
 
function Default(){
    if(document.myTable.myName.value==""){
        document.myTable.myName.value = null;
    }
    if(document.myTable.myemail.value==""){
        document.myTable.myemail.value = null;
    }
}
</script>
<input type=button value="Back to Home Page" onclick="openPage('http://localhost:8080/Coursework1/index.jsp')">
</body>
</html>