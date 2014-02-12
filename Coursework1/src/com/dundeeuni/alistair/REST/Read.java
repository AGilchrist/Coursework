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
/**
* Servlet implementation class Math
*/
@WebServlet(
urlPatterns = {
"/Read/*"
},
initParams = {
@WebInitParam(name = "data-source", value = "jdbc/Faultdb")
})
public class Read extends HttpServlet {
private static final long serialVersionUID = 1L;
private HashMap CommandsMap = new HashMap();
private DataSource _ds = null;

/**
* @see HttpServlet#HttpServlet()
*/
    public Read() {
        super();
        // TODO Auto-generated constructor stub
   
        // TODO Auto-generated constructor stub
        CommandsMap.put("fault",1);
//        CommandsMap.put("reporter",2);
//        CommandsMap.put("developer",3);
//        CommandsMap.put("administrator",4);
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
try {
Conn = _ds.getConnection();
Convertors ut = new Convertors();
String args[]=ut.SplitRequestPath(request);
response.setContentType("text/html");
PrintWriter out=null;
String summary;
String details;
out =	new PrintWriter(response.getOutputStream());

if (args.length <5){
error("Warning too few args",out);
return;
}
int command;
try{
command =(Integer)CommandsMap.get(args[2]);
}catch(Exception et){
error("No such table",out);
return;
}
System.out.println("Command"+command);
float faultid;
float idauthor;
float idsection;
try{
faultid=Float.parseFloat(args[3]);
summary = args[4];
details = args[5];
idauthor=Float.parseFloat(args[6]);
idsection=Float.parseFloat(args[7]);
}catch(Exception et){
error("Bad numbers in calc",out);
return;	
}
switch (command){
case 1: fault(pmst, Conn, faultid, summary, details, idauthor, idsection, out);
break;
/*case 2: div(x,y,out);
break;
case 3: add(x,y,out);
break;
case 4: sub(x,y,out);
break;*/
default: error("No such table",out);
}
Conn.close();
}
catch (Exception et) {
return;
}
}

private void error(String mess, PrintWriter out){
out.println("<h1>You have a an error in your input</h1>");
out.println("<h2>"+mess+"</h2>");
out.close();
return;
}

private void fault(PreparedStatement pmst, Connection Conn, float faultid, String summary, String details, float idauthor, float idsection, PrintWriter out ){

	String sqlQuery="SELECT * FROM `fault`";
	try {
		pmst = Conn.prepareStatement(sqlQuery);
		pmst.executeUpdate();
		} catch (Exception ex) {
		System.out.println("Can not insert default fault "+ex);
		return;	
		}
}

private void div(float x, float y, PrintWriter out ){

float result=x/y;
out.println("<h1>Result</h1>");
out.println("<h2>"+result+"</h2>");
out.close();
}

private void add(float x, float y, PrintWriter out ){

float result=x+y;
out.println("<h1>Result</h1>");
out.println("<h2>"+result+"</h2>");
out.close();
}
private void sub(float x, float y, PrintWriter out ){

float result=x-y;
out.println("<h1>Result</h1>");
out.println("<h2>"+result+"</h2>");
out.close();
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
}

}