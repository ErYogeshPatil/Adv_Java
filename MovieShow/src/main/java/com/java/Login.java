package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/Html");
		PrintWriter Register= response.getWriter();
		String Name=request.getParameter("Uname");
		String Email=request.getParameter("Umail");
		String Pass=request.getParameter("Upass");
		
		GetterSetter Value =new GetterSetter();
		
		Value.setUname(Name);
		Value.setUmail(Email);
		Value.setUpass(Pass);
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // register driver 
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch12to2","root","Yogesh@1996"); 
            PreparedStatement ps=con.prepareStatement("select Email , Password from Registration where Email=? and Password=?");               
            ps.setString(1, Email);
            ps.setString(2, Pass);
            
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
            	if(Email.equals(rs.getString(1)) && Pass.equals(rs.getString(2)))
            	{
            		
            		response.sendRedirect("/MovieShow/Dashboard.html");
            	}else {
            		response.sendRedirect("http://localhost:8080/MovieShow/Login.html");
            	}
            }else {
            	response.sendRedirect("/MovieShow/Login.html");
            }
			
		}catch(Exception e1) {
			System.out.println(e1);
			
		}
	}

}
