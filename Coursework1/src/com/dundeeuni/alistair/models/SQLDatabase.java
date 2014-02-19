package com.dundeeuni.alistair.models;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SQLDatabase {
	 public SQLDatabase(){}
	
public void createfault(PreparedStatement pmst, Connection Conn, String summary, String details, int author, int section, int severity, PrintWriter out ) throws SQLException{
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

public void createreporter(PreparedStatement pmst, Connection Conn, String name, String email, PrintWriter out )throws SQLException{
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

public void createdeveloper(PreparedStatement pmst, Connection Conn, String name, String email, PrintWriter out )throws SQLException{
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

public void createadministrator(PreparedStatement pmst, Connection Conn, String name, String email, PrintWriter out )throws SQLException{
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




	
public void readfault(PreparedStatement pmst, Connection Conn, String faultid, PrintWriter out ) throws SQLException{
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

public void readreporter(PreparedStatement pmst, Connection Conn, String authorid, PrintWriter out ) throws SQLException{
	if(authorid == null){
		PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `author`");
		try {
			ResultSet rs = pstmt.executeQuery();
			print(rs,out);
		} catch (Exception ex) {
			System.out.println("Cannot do that "+ex);
		return;	
		}
	}else{
		PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `author` WHERE idauthor = ?");
		pstmt.setString(1, authorid);
		try {
		ResultSet rs = pstmt.executeQuery();
		print(rs,out);
		} catch (Exception ex) {
			System.out.println("Cannot do that "+ex);
		return;	
		}
	};
}

public void readdeveloper(PreparedStatement pmst, Connection Conn, String developerid, PrintWriter out ) throws SQLException{
	if(developerid == null){
		PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `developer`");
		try {
			ResultSet rs = pstmt.executeQuery();
			print(rs,out);
		} catch (Exception ex) {
			System.out.println("Cannot do that "+ex);
		return;	
		}
	}else{
		PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `developer` WHERE iddeveloper = ?");
		pstmt.setString(1, developerid);
		try {
			ResultSet rs = pstmt.executeQuery();
			print(rs,out);
		} catch (Exception ex) {
			System.out.println("Cannot do that "+ex);
		return;	
		}
	};
}

public void readadministrator(PreparedStatement pmst, Connection Conn, String administratorid, PrintWriter out ) throws SQLException{
	if(administratorid == null){
		PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `administrator`");
		try {
			ResultSet rs = pstmt.executeQuery();
			print(rs,out);
		} catch (Exception ex) {
			System.out.println("Cannot do that "+ex);
		return;	
		}
	}else{
		PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM `administrator` WHERE idadministrator = ?");
		pstmt.setString(1, administratorid);
		try {
			ResultSet rs = pstmt.executeQuery();
			print(rs,out);
		} catch (Exception ex) {
			System.out.println("Cannot do that "+ex);
		return;	
		}
	};
}




public void updatefault(PreparedStatement pmst, Connection Conn, String oldid, String summary, String details, String author, String section, String severity, PrintWriter out ) throws SQLException{
	int id = Integer.parseInt(oldid);
	if(summary != null){
		try{
			PreparedStatement pstmt = Conn.prepareStatement("UPDATE `fault` SET summary = ? WHERE idfault = ?");
			pstmt.setString(1, summary);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that summary "+ex);
			return;	
			} 
		}
	
	if(details != null){
		try{
			PreparedStatement pstmt = Conn.prepareStatement("UPDATE `fault` SET details = ? WHERE idfault = ?");
			pstmt.setString(1, details);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that details "+ex);
			return;	
			} 
		}
	
	if(author != null){
		int aint = Integer.parseInt(author);
			try{
			PreparedStatement pstmt = Conn.prepareStatement("UPDATE `fault` SET author_idauthor = ? WHERE idfault = ?");
			pstmt.setInt(1, aint);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that author "+ex);
			return;	
			} 
		}
	
	if(section != null){
		try{
			int sectionint = Integer.parseInt(section);
			PreparedStatement pstmt = Conn.prepareStatement("UPDATE `fault` SET section_idsection = (?) WHERE idfault = ?");
			pstmt.setInt(1, sectionint);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that section "+ex);
			return;	
			} 
		}
	
	if(severity != null){
		try{
			int severityint = Integer.parseInt(severity);
			PreparedStatement pstmt = Conn.prepareStatement("UPDATE `fault` SET severity = ? WHERE idfault = ?");
			pstmt.setInt(1, severityint);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that severity "+ex);
			return;	
			} 
		}
}

public void updatereporter(PreparedStatement pmst, Connection Conn, String oldid, String name, String email, PrintWriter out )throws SQLException{
	int id = Integer.parseInt(oldid);
	if(name != null){
		try{
			PreparedStatement pstmt = Conn.prepareStatement("UPDATE `author` SET name = ? WHERE idauthor = ?");
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that name "+ex);
			return;	
			} 
		}

	if(email != null){
		try{
			PreparedStatement pstmt = Conn.prepareStatement("UPDATE `author` SET email = ? WHERE idauthor = ?");
			pstmt.setString(1, email);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that email "+ex);
			return;	
			}
		}
}

public void updatedeveloper(PreparedStatement pmst, Connection Conn, String oldid, String name, String email, PrintWriter out )throws SQLException{
	int id = Integer.parseInt(oldid);
	if(name != null){
		try{
			PreparedStatement pstmt = Conn.prepareStatement("UPDATE `developer` SET name = ? WHERE iddeveloper = ?");
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that name "+ex);
			return;	
			} 
		}
	
	if(email != null){
		try{
			PreparedStatement pstmt = Conn.prepareStatement("UPDATE `developer` SET email = ? WHERE iddeveloper = ?");
			pstmt.setString(1, email);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that email "+ex);
			return;	
			} 
		}
}

public void updateadministrator(PreparedStatement pmst, Connection Conn, String oldid, String name, String email, PrintWriter out )throws SQLException{
	int id = Integer.parseInt(oldid);
	if(name != null){
		try{
			PreparedStatement pstmt = Conn.prepareStatement("UPDATE `administrator` SET name = ? WHERE idadministrator = ?");
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that name "+ex);
			return;	
			} 
		}
	
	if(email != null){
		try{
			PreparedStatement pstmt = Conn.prepareStatement("UPDATE `administrator` SET email = ? WHERE idadministrator = ?");
			pstmt.setString(1, email);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();} catch (Exception ex) {
			System.out.println("Cannot do that email "+ex);
			return;	
			} 
		}
}




public void deletefault(PreparedStatement pmst, Connection Conn, String id, PrintWriter out ) throws SQLException{
	PreparedStatement pstmt = Conn.prepareStatement("DELETE FROM `fault` WHERE idfault = ?");
	pstmt.setString(1, id);
	try {
		pstmt.executeUpdate();
	} catch (Exception ex) {
		System.out.println("Cannot do that "+ex);
	return;	
	}
}

public void deletereporter(PreparedStatement pmst, Connection Conn, String id, PrintWriter out )throws SQLException{
	PreparedStatement pstmt = Conn.prepareStatement("DELETE FROM `author` WHERE idauthor = ?");
	pstmt.setString(1, id);
	try {
		pstmt.executeUpdate();
	} catch (Exception ex) {
		System.out.println("Cannot do that "+ex);
	return;	
	}
}

public void deletedeveloper(PreparedStatement pmst, Connection Conn, String id, PrintWriter out )throws SQLException{
	PreparedStatement pstmt = Conn.prepareStatement("DELETE FROM `developer` WHERE iddeveloper = ?");
	pstmt.setString(1, id);
	try {
		pstmt.executeUpdate();
	} catch (Exception ex) {
		System.out.println("Cannot do that "+ex);
	return;	
	}
}

public void deleteadministrator(PreparedStatement pmst, Connection Conn, String id, PrintWriter out )throws SQLException{
	PreparedStatement pstmt = Conn.prepareStatement("DELETE FROM `administrator` WHERE idadministrator = ?");
	pstmt.setString(1, id);
	try {
		pstmt.executeUpdate();
	} catch (Exception ex) {
		System.out.println("Cannot do that "+ex);
	return;	
	}
}
	

private void print(ResultSet rs, PrintWriter out) throws SQLException{
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