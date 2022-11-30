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

@WebServlet("/MovieBook")
public class MovieBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/Html");
		PrintWriter Register= response.getWriter();
		String B_id=request.getParameter("B_id");
		String Username=request.getParameter("Username");
		String Movie=request.getParameter("Movie");
		String Location=request.getParameter("Location");
		Integer Numseats=Integer.valueOf(request.getParameter("Numseats"));
		String SeatNo=request.getParameter("SeatNo");
		
		GetterSetter Value =new GetterSetter();
		
		Value.setB_Id(B_id);
		Value.setUsername(Username);
		Value.setMovie(Movie);
		Value.setLocation(Location);
		Value.setNumSeats(Numseats);
		Value.setMovie(SeatNo);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // register driver 
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch12to2","root","Yogesh@1996"); 
            PreparedStatement ps=con.prepareStatement("insert into Ticket_Booking values(?,?,?,?,?,?,?)");
            ps.setString(1,B_id);
            ps.setString(2,Username);
            ps.setString(3,Movie);
            ps.setString(4,Location);
            ps.setInt(5,Numseats);
            Integer Total= Numseats*100;
            ps.setInt(6,Total);
            ps.setString(7,SeatNo);
            
            
          //ps.setInt(6,q);
                    
            int k=ps.executeUpdate();
            if(k>0)
            {
            	response.sendRedirect("/MovieShow/Payment.html");
            }else
            {
            	response.sendRedirect("/MovieShow/Dashboard.html");
            }
            
			
		}catch(Exception e1) {
			System.out.println(e1);
			
		}
	}

}
