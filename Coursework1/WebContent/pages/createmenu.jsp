<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>This is the create menu</h3>
<p>Please select the type of entry to create</p>
<form action="#">
<select name="URL" onchange="window.location.href= this.form.URL.options[this.form.URL.selectedIndex].value">
<option>      </option>
<option value="http://localhost:8080/Coursework1/pages/createfault.jsp">A fault</option>
<option value="http://localhost:8080/Coursework1/pages/createother.jsp">An author, developer or administrator</option>
</select>
<p></p>
</form>
<input type=button value="Back to Home Page" onCLick="history.back()">
</body>
</html>