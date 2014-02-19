package com.dundeeuni.alistair.Beans;

public class Data {
	static private int ID, Reporter, Section, Severity;
	static private String Summary, Details, Name, Email;
	
	public Data(){
		ID = 0;
		Summary = "";
		Details = "";
		Reporter = 0;
		Section = 0;
		Severity = 0;
		Name = "";
		Email = "";
	}
	
	static public void setID(int id){
		ID = id;
	}
	
	static public void setSummary(String summary){
		Summary = summary;
	}
	
	static public void setDetails(String details){
		Details = details;
	}
	
	static public void setReporter(int reporter){
		Reporter = reporter;
	}
	
	static public void setSection(int section){
		Section = section;
	}
	
	static public void setSeverity(int severity){
		Severity = severity;
	}
	
	static public void setName(String name){
		Name = name;
	}
	
	static public void setEmail(String email){
		Email = email;
	}
	
	
	static public int getID(){
		return ID;
	}
	
	static public String getSummary(){
		return Summary;
	}
	
	static public String getDetails(){
		return Details;
	}
	
	static public int getReporter(){
		return Reporter;
	}
	
	static public int getSection(){
		return Section;
	}
	
	static public int getSeverity(){
		return Severity;
	}
	
	static public String getName(){
		return Name;
	}
	
	static public String getEmail(){
		return Email;
	}
	
	static public void Reset(){
		ID = 0;
		Summary = "";
		Details = "";
		Reporter = 0;
		Section = 0;
		Severity = 0;
		Name = "";
		Email = "";
	}
}
