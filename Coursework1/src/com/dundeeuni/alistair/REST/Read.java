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
"/Read",
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
        CommandsMap.put("reporter",2);
        CommandsMap.put("developer",3);
        CommandsMap.put("administrator",4);
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
String field1;

try {
Conn = _ds.getConnection();
Convertors ut = new Convertors();
String args[]=ut.SplitRequestPath(request);
response.setContentType("text/html");
PrintWriter out=null;
out =	new PrintWriter(response.getOutputStream());

int command;
try{
command =(Integer)CommandsMap.get(args[2]);
}catch(Exception et){
error("You cannot create entries for a table that doesn't exist",out);
return;
}
System.out.println("Command"+command);
if (args[3] == null) 
{field1 = null;}
else{
field1 = args[3];}
switch (command){
case 1: fault(pmst, Conn, field1, out);
break;
case 2: reporter(pmst, Conn, field1, out);
break;
case 3: developer(pmst, Conn, field1, out);
break;
case 4: administrator(pmst, Conn, field1, out);
break;
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

private void fault(PreparedStatement pmst, Connection Conn, String faultid, PrintWriter out ) throws SQLException{
	if(faultid == null){
		PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `fault`");
		try {
			pstmt.executeUpdate();
			} catch (Exception ex) {
			System.out.println("Cannot do that "+ex);
			return;	
			}
	}else{
	PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `fault` WHERE idfault = ?");
	try {
		pstmt.setString(1, faultid);
		pstmt.executeUpdate();
		} catch (Exception ex) {
		System.out.println("Cannot do that "+ex);
		return;	
		}
	};
}

private void reporter(PreparedStatement pmst, Connection Conn, String name, PrintWriter out ) throws SQLException{
	if(name == null){
		PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `fault`");
		try {
			pstmt.executeUpdate();
			} catch (Exception ex) {
			System.out.println("Cannot do that "+ex);
			return;	
			}
	}else{
	PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `fault` WHERE idfault = ?");
	try {
		pstmt.setString(1, name);
		pstmt.executeUpdate();
		} catch (Exception ex) {
		System.out.println("Cannot do that "+ex);
		return;	
		}
	};
}

private void developer(PreparedStatement pmst, Connection Conn, String name, PrintWriter out ) throws SQLException{
	if(name == null){
		PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `fault`");
		try {
			pstmt.executeUpdate();
			} catch (Exception ex) {
			System.out.println("Cannot do that "+ex);
			return;	
			}
	}else{
	PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `fault` WHERE idfault = ?");
	try {
		pstmt.setString(1, name);
		pstmt.executeUpdate();
		} catch (Exception ex) {
		System.out.println("Cannot do that "+ex);
		return;	
		}
	};
}

private void administrator(PreparedStatement pmst, Connection Conn, String name, PrintWriter out ) throws SQLException{
	if(name == null){
		PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `fault`");
		try {
			pstmt.executeUpdate();
			} catch (Exception ex) {
			System.out.println("Cannot do that "+ex);
			return;	
			}
	}else{
	PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `fault` WHERE idfault = ?");
	try {
		pstmt.setString(1, name);
		pstmt.executeUpdate();
		} catch (Exception ex) {
		System.out.println("Cannot do that "+ex);
		return;	
		}
	};
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
}

}