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


@WebServlet("/Payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/Html");
		PrintWriter Register= response.getWriter();
		String Mail=request.getParameter("Mail");
		String CardNo=request.getParameter("CardNo");
		String MobileNo=request.getParameter("MobileNo");
		
		GetterSetter Value =new GetterSetter();
		
		Value.setUmail(Mail);
		Value.setUname(CardNo);
		Value.setUpass(MobileNo);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // register driver 
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch12to2","root","Password"); 
            PreparedStatement ps=con.prepareStatement("insert into Payment values(?,?,?)");
            ps.setString(1,Mail);
            ps.setString(2,CardNo);
            ps.setString(3,MobileNo);
                    
            int k=ps.executeUpdate();
            if(k>0)
            {
            	response.sendRedirect("/MovieShow/done.html");
            }else
            {
            	Register.print("Registration unsuccessful");
            }
            
			
		}catch(Exception e1) {
			System.out.println(e1);
			
		}
	}
}
