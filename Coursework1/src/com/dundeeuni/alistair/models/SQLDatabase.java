package com.dundeeuni.alistair.models;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;

public class SQLDatabase {
	 public SQLDatabase(){}

//Create functionality
	 
public void createfault(PreparedStatement pstmt, Connection Conn, String summary, String details, String author, String section, String severity, PrintWriter out ) throws SQLException{
		 pstmt = Conn.prepareStatement("INSERT INTO `fault`(summary,details,author_idauthor, section_idsection, severity) VALUES (?, ?, ?, ?, ?)");
		 pstmt.setString(1, summary);
		 pstmt.setString(2, details);
		 pstmt.setString(3, author);
		 pstmt.setString(4, section);
		 pstmt.setString(5, severity);
		 try {
		 pstmt.executeUpdate();
		 } catch (Exception ex) {
		 System.out.println("Cannot do that "+ex);
		 return;	
		 }
		 out.print("Success");
		 }

public void createreporter(PreparedStatement pstmt, Connection Conn, String name, String email, PrintWriter out )throws SQLException{
		 pstmt = Conn.prepareStatement("INSERT INTO `author`(name, email) VALUES (?, ?)");
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

public void createdeveloper(PreparedStatement pstmt, Connection Conn, String name, String email, PrintWriter out )throws SQLException{
		 pstmt = Conn.prepareStatement("INSERT INTO `developer`(name, email) VALUES (?, ?)");
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

public void createadministrator(PreparedStatement pstmt, Connection Conn, String name, String email, PrintWriter out )throws SQLException{
		 pstmt = Conn.prepareStatement("INSERT INTO `administrator`(name, email) VALUES (?, ?)");
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






//Read Functionality
	
public void readfault(PreparedStatement pstmt, Connection Conn, HttpServletResponse response, String faultid, PrintWriter out ) throws SQLException, InterruptedException, IOException{
	if(faultid.equals("null")){
		pstmt = Conn.prepareStatement("SELECT * FROM `fault`");
		try {
			ResultSet rs = pstmt.executeQuery();
			print(rs, out);
			TimeUnit.SECONDS.sleep(5);
		    response.sendRedirect("http://ac32007.cloudapp.net:8080/130025328Coursework1/index.jsp");
		} catch (Exception ex) {
			System.out.println("Cannot do that "+ex);
			return;	
		}
	}else{
		pstmt = Conn.prepareStatement("SELECT * FROM `fault` WHERE idfault = ?");
		pstmt.setString(1, faultid);
	try {
		ResultSet rs = pstmt.executeQuery();
		print(rs,out);
		TimeUnit.SECONDS.sleep(5);
	    response.sendRedirect("http://ac32007.cloudapp.net:8080/130025328Coursework1/index.jsp");
	} catch (Exception ex) {
		System.out.println("Cannot do that "+ex);
	return;	
		}
	}
}

public void readreporter(PreparedStatement pstmt, Connection Conn, HttpServletResponse response, String authorid, PrintWriter out ) throws SQLException{
	if(authorid.equals("null")){
		pstmt = Conn.prepareStatement("SELECT * FROM `author`");
		try {
			ResultSet rs = pstmt.executeQuery();
			print(rs,out);
		} catch (Exception ex) {
			System.out.println("Cannot do that "+ex);
		return;	
		}
	}else{
		pstmt = Conn.prepareStatement("SELECT * FROM `author` WHERE idauthor = ?");
		pstmt.setString(1, authorid);
		try {
		ResultSet rs = pstmt.executeQuery();
		print(rs,out);
		} catch (Exception ex) {
			System.out.println("Cannot do that "+ex);
		return;	
		}
	}
}

public void readdeveloper(PreparedStatement pstmt, Connection Conn, HttpServletResponse response, String developerid, PrintWriter out ) throws SQLException{
	if(developerid.equals("null")){
		pstmt = Conn.prepareStatement("SELECT * FROM `developer`");
		try {
			ResultSet rs = pstmt.executeQuery();
			print(rs,out);
		} catch (Exception ex) {
			System.out.println("Cannot do that "+ex);
		return;	
		}
	}else{
		pstmt = Conn.prepareStatement("SELECT * FROM `developer` WHERE iddeveloper = ?");
		pstmt.setString(1, developerid);
		try {
			ResultSet rs = pstmt.executeQuery();
			print(rs,out);
		} catch (Exception ex) {
			System.out.println("Cannot do that "+ex);
		return;	
		}
	}
}

public void readadministrator(PreparedStatement pstmt, Connection Conn, HttpServletResponse response, String administratorid, PrintWriter out ) throws SQLException{
	if(administratorid.equals("null")){
		pstmt = Conn.prepareStatement("SELECT * FROM `administrator`");
		try {
			ResultSet rs = pstmt.executeQuery();
			print(rs,out);
		} catch (Exception ex) {
			System.out.println("Cannot do that "+ex);
		return;	
		}
	}else{
		pstmt = Conn.prepareStatement("SELECT * FROM `administrator` WHERE idadministrator = ?");
		pstmt.setString(1, administratorid);
		try {
			ResultSet rs = pstmt.executeQuery();
			print(rs,out);
		} catch (Exception ex) {
			System.out.println("Cannot do that "+ex);
		return;	
		}
	}
}



//Update functionality


public void updatefault(PreparedStatement pstmt, Connection Conn, String oldid, String summary, String details, String author, String section, String severity, PrintWriter out ) throws SQLException{
	int id = Integer.parseInt(oldid);
	if(!summary.equals("")){
		try{
			pstmt = Conn.prepareStatement("UPDATE `fault` SET summary = ? WHERE idfault = ?");
			pstmt.setString(1, summary);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that summary "+ex);
			return;	
			} 
		}
	
	if(!details.equals("")){
		try{
			pstmt = Conn.prepareStatement("UPDATE `fault` SET details = ? WHERE idfault = ?");
			pstmt.setString(1, details);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that details "+ex);
			return;	
			} 
		}
	
	if(!author.equals("")){
		int aint = Integer.parseInt(author);
			try{
			pstmt = Conn.prepareStatement("UPDATE `fault` SET author_idauthor = ? WHERE idfault = ?");
			pstmt.setInt(1, aint);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that author "+ex);
			return;	
			} 
		}
	
	if(!section.equals("")){
		try{
			int sectionint = Integer.parseInt(section);
			pstmt = Conn.prepareStatement("UPDATE `fault` SET section_idsection = (?) WHERE idfault = ?");
			pstmt.setInt(1, sectionint);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that section "+ex);
			return;	
			} 
		}
	
	if(!severity.equals("")){
		try{
			int severityint = Integer.parseInt(severity);
			pstmt = Conn.prepareStatement("UPDATE `fault` SET severity = ? WHERE idfault = ?");
			pstmt.setInt(1, severityint);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that severity "+ex);
			return;	
			} 
		}
}

public void updatereporter(PreparedStatement pstmt, Connection Conn, String oldid, String name, String email, PrintWriter out )throws SQLException{
	int id = Integer.parseInt(oldid);
	if(!name.equals("")){
		try{
			pstmt = Conn.prepareStatement("UPDATE `author` SET name = ? WHERE idauthor = ?");
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that name "+ex);
			return;	
			} 
		}

	if(!email.equals("")){
		try{
			pstmt = Conn.prepareStatement("UPDATE `author` SET email = ? WHERE idauthor = ?");
			pstmt.setString(1, email);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that email "+ex);
			return;	
			}
		}
}

public void updatedeveloper(PreparedStatement pstmt, Connection Conn, String oldid, String name, String email, PrintWriter out )throws SQLException{
	int id = Integer.parseInt(oldid);
	if(!name.equals("")){
		try{
			pstmt = Conn.prepareStatement("UPDATE `developer` SET name = ? WHERE iddeveloper = ?");
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that name "+ex);
			return;	
			} 
		}
	
	if(!email.equals("")){
		try{
			pstmt = Conn.prepareStatement("UPDATE `developer` SET email = ? WHERE iddeveloper = ?");
			pstmt.setString(1, email);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that email "+ex);
			return;	
			} 
		}
}

public void updateadministrator(PreparedStatement pstmt, Connection Conn, String oldid, String name, String email, PrintWriter out )throws SQLException{
	int id = Integer.parseInt(oldid);
	if(!name.equals("")){
		try{
			pstmt = Conn.prepareStatement("UPDATE `administrator` SET name = ? WHERE idadministrator = ?");
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that name "+ex);
			return;	
			} 
		}
	
	if(!email.equals("")){
		try{
			pstmt = Conn.prepareStatement("UPDATE `administrator` SET email = ? WHERE idadministrator = ?");
			pstmt.setString(1, email);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that email "+ex);
			return;	
			} 
		}
}




//Delete functionality


public void deletefault(PreparedStatement pstmt, Connection Conn, String id, PrintWriter out ) throws SQLException{
	pstmt = Conn.prepareStatement("DELETE FROM `fault` WHERE idfault = ?");
	pstmt.setString(1, id);
	try {
		pstmt.executeUpdate();
	} catch (Exception ex) {
		System.out.println("Cannot do that "+ex);
	return;	
	}
}

public void deletereporter(PreparedStatement pstmt, Connection Conn, String id, PrintWriter out )throws SQLException{
	pstmt = Conn.prepareStatement("DELETE FROM `author` WHERE idauthor = ?");
	pstmt.setString(1, id);
	try {
		pstmt.executeUpdate();
	} catch (Exception ex) {
		System.out.println("Cannot do that "+ex);
	return;	
	}
}

public void deletedeveloper(PreparedStatement pstmt, Connection Conn, String id, PrintWriter out )throws SQLException{
	pstmt = Conn.prepareStatement("DELETE FROM `developer` WHERE iddeveloper = ?");
	pstmt.setString(1, id);
	try {
		pstmt.executeUpdate();
	} catch (Exception ex) {
		System.out.println("Cannot do that "+ex);
	return;	
	}
}

public void deleteadministrator(PreparedStatement pstmt, Connection Conn, String id, PrintWriter out )throws SQLException{
	pstmt = Conn.prepareStatement("DELETE FROM `administrator` WHERE idadministrator = ?");
	pstmt.setString(1, id);
	try {
		pstmt.executeUpdate();
	} catch (Exception ex) {
		System.out.println("Cannot do that "+ex);
	return;	
	}
}
	

private void print(ResultSet rs, PrintWriter out) throws SQLException, InterruptedException{
		ResultSetMetaData meta = rs.getMetaData();
	    int numberofcolumns = meta.getColumnCount();
	    while (rs.next()) {
	        for (int i = 1; i <= numberofcolumns; i++) {
	            if (i > 1) out.print(",    ");
	            String Value = rs.getString(i);
	            out.print(meta.getColumnName(i) + ": " + Value);
	          }

	    }  
	out.close();
	return;
	}
}
