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

@WebServlet("/adminLogin")
public class adminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/Html");
		PrintWriter Register= response.getWriter();
		String Name=request.getParameter("Uname");
		String Pass=request.getParameter("Upass");
		
		GetterSetter Value =new GetterSetter();
		
		Value.setUname(Name);
		Value.setUpass(Pass);
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // register driver 
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch12to2","root","password"); 
            PreparedStatement ps=con.prepareStatement("select Name , Password from Admin where Name=? and Password=?");
            ps.setString(1, Name);
            ps.setString(2, Pass);
            
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
            	if(Name.equals(rs.getString(1)) && Pass.equals(rs.getString(2)))
            	{
            		response.sendRedirect("/MovieShow/adminPanel.jsp");
            	}else {
            		response.sendRedirect("/MovieShow/AdminLogin.html");
            	}
            }
			
		}catch(Exception e1) {
			System.out.println(e1);
			
		}
	}

}
