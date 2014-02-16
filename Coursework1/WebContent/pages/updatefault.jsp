<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update an entry</title>
</head>
<body">
<h3>This is the interface for updating existing entries in the fault table</h3>
<p>Please type data for all fields of the entry before hitting the submit button, then the link</p>

<form name="updatefault" method="post" action="updatefault.jsp">
ID of fault to update:
<input type="text" name="myID" id="myID" value="">
<br/>
<br/>
Summary of fault:
<input type="text" name="mySummary" id="mySummary" value="">
<br/>
<br/>
Details of fault:
<input type="text" name="myDetails" id="myDetails" value="">
<br/>
<br/>
Reporter of fault:
<input type="text" name="myReporter" id="myReporter" value="">
<br/>
<br/>
Section the fault was found in:
<input type="text" name="mySection" id="mySection" value="">
<br/>
<br/>
Severity of fault:
<input type="text" name="mySeverity" id="mySeverity" value="">
<br/>
<br/>
<input type="Submit" value="Update details for Servlet">
<br/>
<br/>
</form>
<%  
String myID = request.getParameter("myID");
String mySummary = request.getParameter("mySummary");
String myDetails = request.getParameter("myDetails");
String myReporter = request.getParameter("myReporter");
String mySection = request.getParameter("mySection");
String mySeverity = request.getParameter("mySeverity");
%>  
<b>Click the link below to send to servlet and create entry</b><br><br>
<%out.println("<a href=\"http://localhost:8080/Coursework1/Update/fault/" 
		+ request.getParameter("myID") + "/" + request.getParameter("mySummary") + "/" + request.getParameter("myDetails") + "/" 
		+ request.getParameter("myReporter") + "/" + request.getParameter("mySection") + "/" + request.getParameter("mySeverity") 
        + "\">Create Entry</a>");  
%>   
<br>
<br>
<script type="text/javascript">
 function openPage(pageURL)
 {
 window.location.href = pageURL;
 }

 function Default(){
     if(document.updatefault.mySummary.value==""){
         document.updatefault.mySummary.value = null;
     }
     if(document.updatefault.myDetails.value==""){
         document.updatefault.myDetails.value = null;
     }
     if(document.updatefault.myReporter.value==""){
         document.updatefault.myReporter.value = null;
     }
     if(document.updatefault.mySection.value==""){
         document.updatefault.mySection.value = null;
     }
     if(document.updatefault.mySeverity.value==""){
         document.updatefault.mySeverity.value = null;
     }
 }
</script>
<input type=button value="Back to Home Page" onclick="openPage('http://localhost:8080/Coursework1/index.jsp')">
</body>
</html>