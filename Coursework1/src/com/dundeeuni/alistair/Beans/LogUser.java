package com.dundeeuni.alistair.Beans;

public class LogUser {
    String username = "Alistair";
    String password = "Admin01";
   
    boolean loggedIn = false;
   
    public LogUser()
    {
       
    }
   
   public boolean isLoggedIn()
   {
       return loggedIn;
   }
  
  
   public String getUsername()
    {
      return username;
    }
  
   public void setUsername(String user)
   {
     username = user;
   }
  
    public  String getPassword()
    {
      return password;
    }
  
   public void setPassword(String p)
   {
     password = p;
   }
   
   public void LogIn(String Username, String Password)
   {
	   if(Username == null)
		  return;
	   if(Password == null)
		   return;
	   else if(Username.equals(username)){
		   if(Password.equals(password))
			   loggedIn = true;}
   }
   
   public void LogOut()
   {
	   if(loggedIn == true)
	  loggedIn = false;
   }
}