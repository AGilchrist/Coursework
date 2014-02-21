package com.dundeeuni.alistair.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
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
* Servlet implementation class Fault
*/
@WebServlet(
urlPatterns = {
"/Faults",
"/Fault/*"
},
initParams = {
@WebInitParam(name = "data-source", value = "jdbc/Faultdb")
})
public class Fault extends HttpServlet {
private static final long serialVersionUID = 1L;
private DataSource _ds = null;
       
    /**
* @see HttpServlet#HttpServlet()
*/
    public Fault() {
        super();
        // TODO Auto-generated constructor stub
       
    }
    
    /**
* @see Servlet#init(ServletConfig)
*/
public void init(ServletConfig config) throws ServletException {
// TODO Auto-generated method stub
Dbutils db = new Dbutils();
db.createSchema();
_ds=db.assemble(config);
}

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
//String args[]=Convertors.SplitRequestPath(request);

response.sendRedirect("http://ac32007.cloudapp.net:8080/130025328Coursework1/index.jsp");
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
}

}