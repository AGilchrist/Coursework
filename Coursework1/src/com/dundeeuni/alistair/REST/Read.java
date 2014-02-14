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
import com.dundeeuni.alistair.pages.*;
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
if (args.length <4){
	field1 = null;
}else{
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

private void print(ResultSet rs, PrintWriter out) throws SQLException{
	ResultSetMetaData meta = rs.getMetaData();
    int numberofcolumns = meta.getColumnCount();
    while (rs.next()) {
        for (int i = 1; i <= numberofcolumns; i++) {
            if (i > 1) out.print(",\t");
            String Value = rs.getString(i);
            out.print(meta.getColumnName(i) + ":\t" + Value);
            System.out.println(Value);
        }
        out.println("\t");
    }  
out.close();
return;
}

private void fault(PreparedStatement pmst, Connection Conn, String faultid, PrintWriter out ) throws SQLException{
	if(faultid == null){
		PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `fault`");
		try {
			ResultSet rs = pstmt.executeQuery();
			print(rs,out);
			} catch (Exception ex) {
			System.out.println("Cannot do that "+ex);
			return;	
			}
	}else{
	PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `fault` WHERE idfault = ?");
	pstmt.setString(1, faultid);
	try {
		ResultSet rs = pstmt.executeQuery();
		print(rs,out);
		} catch (Exception ex) {
		System.out.println("Cannot do that "+ex);
		return;	
		}
	};
}

private void reporter(PreparedStatement pmst, Connection Conn, String name, PrintWriter out ) throws SQLException{
	if(name == null){
		PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `reporter`");
		try {
			ResultSet rs = pstmt.executeQuery();
			print(rs,out);
			} catch (Exception ex) {
			System.out.println("Cannot do that "+ex);
			return;	
			}
	}else{
	PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `reporter` WHERE name = ?");
	pstmt.setString(1, name);
	try {
		ResultSet rs = pstmt.executeQuery();
		print(rs,out);
		} catch (Exception ex) {
		System.out.println("Cannot do that "+ex);
		return;	
		}
	};
}

private void developer(PreparedStatement pmst, Connection Conn, String name, PrintWriter out ) throws SQLException{
	if(name == null){
		PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `developer`");
		try {
			ResultSet rs = pstmt.executeQuery();
			print(rs,out);
			} catch (Exception ex) {
			System.out.println("Cannot do that "+ex);
			return;	
			}
	}else{
	PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `developer` WHERE name = 'Harry'");
	//pstmt.setString(1, name);
	try {
		ResultSet rs = pstmt.executeQuery();
		print(rs,out);
		} catch (Exception ex) {
		System.out.println("Cannot do that "+ex);
		return;	
		}
	};
}

private void administrator(PreparedStatement pmst, Connection Conn, String name, PrintWriter out ) throws SQLException{
	if(name == null){
		PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `administrator`");
		try {
			ResultSet rs = pstmt.executeQuery();
			print(rs,out);
			} catch (Exception ex) {
			System.out.println("Cannot do that "+ex);
			return;	
			}
	}else{
	PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `administrator` WHERE name = ?");
	pstmt.setString(1, name);
	try {
		ResultSet rs = pstmt.executeQuery();
		print(rs,out);
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