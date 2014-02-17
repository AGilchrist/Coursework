<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.js"></script>
</head>
<body>
<p>Select the action you want to carry out</p>
<form action="#">
<select name="URL" onchange="window.location.href= this.form.URL.options[this.form.URL.selectedIndex].value">
<option>      </option>
<option value="http://localhost:8080/Coursework1/pages/createmenu.jsp">Create</option>
<option value="http://localhost:8080/Coursework1/pages/read.jsp">Read</option>
<option value="http://localhost:8080/Coursework1/pages/updatemenu.jsp">Update</option>
<option value="http://localhost:8080/Coursework1/pages/delete.jsp">Delete</option>
</select>
<p></p>
</form>
</body>
</html>