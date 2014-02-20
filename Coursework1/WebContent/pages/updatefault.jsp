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
<body onLoad="Default()">
<%
if(Log.isLoggedIn()){
    out.println("Hello user " + Log.getUsername() + " <br />");%>
<h3>This is the interface for updating existing entries in the fault table</h3>
<p>Please type data for all fields you wish to update or leave as null to not alter the current data in that field,
once all desired updates are entered hit the submit button, then the link that appears</p>

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
Data.setSummary(request.getParameter("mySummary"));
Data.setDetails(request.getParameter("myDetails"));
Data.setReporter(request.getParameter("myReporter"));
Data.setSection(request.getParameter("mySection"));
Data.setSeverity(request.getParameter("mySeverity"));

out.println("Please click the link below to Update the selected entry or entries <br><br>");
if(request.getParameter("myID") != null){
	Data.setID(request.getParameter("myID"));
	out.println("<a href=\"http://localhost:8080/Coursework1/Update/fault/" + "\">Create Entry</a>");  
}else{out.println("You must provide a id number for the entry you wish to update <br> Make sure it is valid or nothing will happen on the database");}
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
</body>
</html>