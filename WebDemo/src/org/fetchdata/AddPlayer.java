package org.fetchdata;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/AddPlayer")
public class AddPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out=response.getWriter();	
		try {
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://@localhost:3306/PlayersDB","root","Swara@27");
			
			
			PreparedStatement ps=conn.prepareStatement("insert into PlayersDB.players values(?,?,?,?,?)");
			ps.setString(1, request.getParameter("ID"));
			ps.setString(2, request.getParameter("NAME"));
			ps.setString(3, request.getParameter("AGE"));
			ps.setString(4, request.getParameter("EMAIL"));
			ps.setString(5, request.getParameter("ADDRESS"));
			
			ps.executeUpdate();
			
			out.println("<html>");
			
			out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">");
			
			out.println("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\" integrity=\"sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI\" crossorigin=\"anonymous\"></script>");
			
			out.println("<body><br><br><br><center>");
			
			out.println("<h1>New Player Added to the Team Successfully</h1>");
			
			
			
			//response.getWriter().print("Player Data Entered Successfully into the Data Base");
			
			out.println("<center> <form action=\"FetchData\" method='post'><br><br> <input type=\"submit\" value=\"View Recently Entered Data\" class=\"btn btn-primary\">");
			
					out.println("</form></center>");
			
			out.println("<center> <form action=\"FetchData.jsp\" method='post'><br><br> <input type=\"submit\" value=\"Back To Home\" class=\"btn btn-primary\">");
					
					out.println("</form></center>");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			response.getWriter().print("Player Data NOT Entered into the Data Base. Something wrong with your Data Entry");
		
			response.getWriter().print("\nIMP NOTE 1:  ID and Age should be entred in Integer format ");
			response.getWriter().print("\nIMP NOTE 2:  NAME and EMAIL and ADDRESS should be in Character format ");
			response.getWriter().print("\nIMP NOTE 3:  There Should NOT be duplicate ID ");
			
			out.println("<center> <form action=\"FetchData.jsp\" method='post'> <input type=\"submit\" value=\"Back To Home\" class=\"btn btn-primary\">");
			
			out.println("</form></center>");
		}
		
		
	}

}
