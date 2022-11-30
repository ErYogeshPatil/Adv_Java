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


@WebServlet("/Order")
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter Register= response.getWriter();
		String B_id=request.getParameter("B_id");

		GetterSetter Value =new GetterSetter();
		
		Value.setB_Id(B_id);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // register driver 
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch12to2","root","Yogesh@1996"); 
            PreparedStatement ps=con.prepareStatement("DELETE FROM Ticket_Booking where B_id=?");
            ps.setString(1,B_id);
            
            int k=ps.executeUpdate();
            if(k>0)
            {
            	response.sendRedirect("/MovieShow/Order.html");
            }else
            {
            	Register.print("Faild to delete");
            }
 	
		}catch(Exception e1) {
			System.out.println(e1);
			
		}
	}

}
