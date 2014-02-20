package com.dundeeuni.alistair.Beans;

public class Data {
	static private String ID, Summary, Details, Name, Email, Reporter, Section, Severity;
	boolean database = false;
	
	public Data(){
		
	}
	
	public void setID(String id){
		ID = id;
	}
	
	public void setSummary(String summary){
		Summary = summary;
	}
	
	public void setDetails(String details){
		Details = details;
	}
	
	public void setReporter(String reporter){
		Reporter = reporter;
	}
	
	public void setSection(String section){
		Section = section;
	}
	
	public void setSeverity(String severity){
		Severity = severity;
	}
	
	public void setName(String name){
		Name = name;
	}
	
	public void setEmail(String email){
		Email = email;
	}
	
	public void setDatabase(Boolean state){
		database = state;
	}
	
	
	public String getID(){
		return ID;
	}
	
	public String getSummary(){
		return Summary;
	}
	
	public String getDetails(){
		return Details;
	}
	
	public String getReporter(){
		return Reporter;
	}
	
	public String getSection(){
		return Section;
	}
	
	public String getSeverity(){
		return Severity;
	}
	
	public String getName(){
		return Name;
	}
	
	public String getEmail(){
		return Email;
	}
	
	public Boolean getDatabase(){
		return database;
	}
	
	public void Reset(){
		ID = "";
		Summary = "";
		Details = "";
		Reporter = "";
		Section = "";
		Severity = "";
		Name = "";
		Email = "";
	}
}
