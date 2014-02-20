package com.dundeeuni.alistair.REST;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.dundeeuni.alistair.Beans.Data;
import com.dundeeuni.alistair.lib.*;
import com.dundeeuni.alistair.models.SQLDatabase;

/**
* Servlet implementation class Math
*/
@WebServlet(
urlPatterns = {
"/Update/*"
},
initParams = {
@WebInitParam(name = "data-source", value = "jdbc/Faultdb")
})
public class Update extends HttpServlet {
private static final long serialVersionUID = 1L;
private HashMap CommandsMap = new HashMap();
private DataSource _ds = null;

/**
* @see HttpServlet#HttpServlet()
*/
    public Update() {
        super();
        // TODO Auto-generated constructor stub
   
        // TODO Auto-generated constructor stub
        CommandsMap.put("fault",1);
        CommandsMap.put("reporter",2);
        CommandsMap.put("developer",3);
        CommandsMap.put("admin",4);
    }

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
Dbutils db = new Dbutils();
_ds=db.assemble(config);
}
    
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PreparedStatement pmst = null;
Connection Conn;
PreparedStatement pstmt = null;
SQLDatabase SQL = new SQLDatabase();
Data data = new Data();

String ID;
String Summary;
String Details;
String Name;
String Email;
String Reporter;
String Section;
String Severity;

try {
Conn = _ds.getConnection();
Convertors ut = new Convertors();
String args[]=ut.SplitRequestPath(request);
response.setContentType("text/html");
PrintWriter out = null;
out =	new PrintWriter(response.getOutputStream());

if (args.length >4){
error("Too many arguments",out);
return;
}
int command;
try{
command =(Integer)CommandsMap.get(args[2]);
}catch(Exception et){
error("You cannot create entries for a table that doesn't exist",out);
return;
}
System.out.println("Command"+command);
try{
ID = data.getID();
}catch(Exception et){
error("Bad numbers in calc",out);
return;	
}
switch (command){
case 1: {
		Summary = data.getSummary();
		Details = data.getDetails();
		Reporter = data.getReporter();
		Section = data.getSection();
		Severity = data.getSeverity();
		SQL.updatefault(pmst, Conn, ID, Summary, Details, Reporter, Section, Severity, out);}
break;
case 2: {
	Name = data.getName();
	Email = data.getEmail();
	SQL.updatereporter(pmst, Conn, ID, Name, Email, out);}
break;
case 3: {
	Name = data.getName();
	Email = data.getEmail();
	SQL.updatedeveloper(pmst, Conn, ID, Name, Email, out);}
break;
case 4: {
	Name = data.getName();
	Email = data.getEmail();
	SQL.updateadministrator(pmst, Conn, ID, Name, Email, out);}
break;
default: error("No such table",out);
}
Conn.close();
}
catch (Exception et) {
return;
}
response.sendRedirect("http://localhost:8080/Coursework1/index.jsp");
}

private void error(String mess, PrintWriter out){
out.println("<h1>You have a an error in your input</h1>");
out.println("<h2>"+mess+"</h2>");
out.close();
return;
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
}

}