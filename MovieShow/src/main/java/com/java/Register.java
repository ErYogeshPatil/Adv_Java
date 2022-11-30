package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/Html");
		PrintWriter Register= response.getWriter();
		String Name=request.getParameter("Uname");
		String Mail=request.getParameter("Umail");
		String Pass=request.getParameter("Upass");
		
		GetterSetter Value =new GetterSetter();
		
		Value.setUname(Name);
		Value.setUmail(Mail);
		Value.setUpass(Pass);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // register driver 
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch12to2","root","Password"); 
            PreparedStatement ps=con.prepareStatement("insert into Registration values(?,?,?)");
            ps.setString(1,Name);
            ps.setString(2,Mail);
            ps.setString(3,Pass);
                    
            int k=ps.executeUpdate();
            if(k>0)
            {
            	response.sendRedirect("/MovieShow/home.html");
            }else
            {
            	Register.print("Registration unsuccessful go to Home page");
            }
            
			
		}catch(Exception e1) {
			System.out.println(e1);
			
		}
	}

}
