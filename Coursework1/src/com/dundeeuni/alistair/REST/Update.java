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

String Action = "Update";
String ID;
String field1;
String field2;
String Reporter;
String Section;
String Severity;

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
ID = args[3];
field1 = args[4];
	if(field1.equals("null")){field1 = null;}
field2 = args[5];
	if(field2.equals("null")){field2 = null;}
}catch(Exception et){
error("Bad numbers in calc",out);
return;	
}
switch (command){
case 1: {
	if (args.length <9){
		error("Warning too few args for this command",out);
		return;
		}else{
			Reporter = args[6];
				if(Reporter.equals("null")){Reporter = null;}
			Section = args[7];
				if(Section.equals("null")){Section = null;}
			Severity = args[8];
				if(Severity.equals("null")){Severity = null;}
			SQL.fault(pmst, Conn, Action, ID, field1, field2, Reporter, Section, Severity, out);}
		}
break;
case 2: SQL.reporter(pmst, Conn, Action, ID, field1, field2, out);
break;
case 3: SQL.developer(pmst, Conn, Action, ID, field1, field2, out);
break;
case 4: SQL.administrator(pmst, Conn, Action, ID, field1, field2, out);
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

private void developer(PreparedStatement pmst, Connection Conn, String oldid, String name, String email, PrintWriter out )throws SQLException{
	int id = Integer.parseInt(oldid);
	if(name != null){
		try{
	PreparedStatement pstmt = Conn.prepareStatement("UPDATE `developer` SET name = ? WHERE iddeveloper = ?");
	pstmt.setString(1, name);
	pstmt.setInt(2, id);
	pstmt.executeUpdate();} catch (Exception ex) {
		System.out.println("Cannot do that name "+ex);
		return;	
		} }
	
	if(email != null){
		try{
	PreparedStatement pstmt = Conn.prepareStatement("UPDATE `developer` SET email = ? WHERE iddeveloper = ?");
	pstmt.setString(1, email);
	pstmt.setInt(2, id);
	pstmt.executeUpdate();} catch (Exception ex) {
		System.out.println("Cannot do that email "+ex);
		return;	
		} }
}

private void administrator(PreparedStatement pmst, Connection Conn, String oldid, String name, String email, PrintWriter out )throws SQLException{
	int id = Integer.parseInt(oldid);
	if(name != null){
		try{
	PreparedStatement pstmt = Conn.prepareStatement("UPDATE `administrator` SET name = ? WHERE idadministrator = ?");
	pstmt.setString(1, name);
	pstmt.setInt(2, id);
	pstmt.executeUpdate();} catch (Exception ex) {
		System.out.println("Cannot do that name "+ex);
		return;	
		} }
	
	if(email != null){
		try{
	PreparedStatement pstmt = Conn.prepareStatement("UPDATE `administrator` SET email = ? WHERE idadministrator = ?");
	pstmt.setString(1, email);
	pstmt.setInt(2, id);
	pstmt.executeUpdate();} catch (Exception ex) {
		System.out.println("Cannot do that email "+ex);
		return;	
		} }
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
}

}