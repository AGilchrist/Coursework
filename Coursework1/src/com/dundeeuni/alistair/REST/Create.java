package com.dundeeuni.alistair.REST;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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

import com.dundeeuni.alistair.lib.*;
/**
* Servlet implementation class Math
*/
@WebServlet(
urlPatterns = {
"/Create/*"
},
initParams = {
@WebInitParam(name = "data-source", value = "jdbc/Faultdb")
})
public class Create extends HttpServlet {
private static final long serialVersionUID = 1L;
private HashMap CommandsMap = new HashMap();
private DataSource _ds = null;

/**
* @see HttpServlet#HttpServlet()
*/
    public Create() {
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
String faultSummary;
String faultDetails;
String faultReporter;
String faultSection;
String faultSeverity;
int Reporterint;
int Sectionint;
int Severityint;

try {
Conn = _ds.getConnection();
Convertors ut = new Convertors();
String args[]=ut.SplitRequestPath(request);
response.setContentType("text/html");
PrintWriter out=null;
out =	new PrintWriter(response.getOutputStream());

if (args.length <5){
error("Warning too few args",out);
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
faultSummary = args[3];
faultDetails = args[4];
}catch(Exception et){
error("Bad numbers in calc",out);
return;	
}
switch (command){
case 1: {
	if (args.length <6){
		error("Warning too few args for this command",out);
		return;
		}else{
			faultReporter = args[5];
			faultSection = args[6];
			faultSeverity = args[6];
			Reporterint = Integer.parseInt(faultReporter);
			Sectionint = Integer.parseInt(faultSection);
			Severityint = Integer.parseInt(faultSection);
			fault(pmst, Conn, faultSummary, faultDetails, Reporterint, Sectionint, Severityint, out);}
		}
break;
case 2: reporter(pmst, Conn, faultSummary, faultDetails, out);
break;
case 3: developer(pmst, Conn, faultSummary, faultDetails, out);
break;
case 4: administrator(pmst, Conn, faultSummary, faultDetails, out);
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
out.println("<h1>You have an error in your input</h1>");
out.println("<h2>"+mess+"</h2>");
out.close();
return;
}

private void fault(PreparedStatement pmst, Connection Conn, String summary, String details, int author, int section, int severity, PrintWriter out ) throws SQLException{
	PreparedStatement pstmt = Conn.prepareStatement("INSERT INTO `fault`(summary,details,author_idauthor, section_idsection, severity) VALUES (?, ?, ?, ?, ?)");
	pstmt.setString(1, summary);
	pstmt.setString(2, details);
	pstmt.setInt(3, author);
	pstmt.setInt(4, section);
	pstmt.setInt(5, severity);
	try {
		pstmt.executeUpdate();
		} catch (Exception ex) {
		System.out.println("Cannot do that "+ex);
		return;	
		}
	out.print("Success");
}

private void reporter(PreparedStatement pmst, Connection Conn, String name, String email, PrintWriter out )throws SQLException{
	PreparedStatement pstmt = Conn.prepareStatement("INSERT INTO `author`(name, email) VALUES (?, ?)");
	pstmt.setString(1, name);
	pstmt.setString(2, email);
	try {
		pstmt.executeUpdate();
		} catch (Exception ex) {
		System.out.println("Cannot do that "+ex);
		return;	
		}
	out.print("Success");
}

private void developer(PreparedStatement pmst, Connection Conn, String name, String email, PrintWriter out )throws SQLException{
	PreparedStatement pstmt = Conn.prepareStatement("INSERT INTO `developer`(name, email) VALUES (?, ?)");
	pstmt.setString(1, name);
	pstmt.setString(2, email);
	try {
		pstmt.executeUpdate();
		} catch (Exception ex) {
		System.out.println("Cannot do that "+ex);
		return;	
		}
	out.print("Success");
}

private void administrator(PreparedStatement pmst, Connection Conn, String name, String email, PrintWriter out )throws SQLException{
	PreparedStatement pstmt = Conn.prepareStatement("INSERT INTO `administrator`(name, email) VALUES (?, ?)");
	pstmt.setString(1, name);
	pstmt.setString(2, email);
	try {
		pstmt.executeUpdate();
		} catch (Exception ex) {
		System.out.println("Cannot do that "+ex);
		return;	
		}
	out.print("Success");
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
}

}