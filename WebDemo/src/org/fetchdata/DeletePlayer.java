package org.fetchdata;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/DeletePlayer")
public class DeletePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out=response.getWriter();	
		try {
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://@localhost:3306/PlayersDB","root","Swara@27");
			
			
			String id = request.getParameter("ID");
			
			
			PreparedStatement ps=conn.prepareStatement("delete from PlayersDB.players where ID=?");
			
			ps.setString(1, id);
			ps.executeUpdate();
			
			out.println("<html>");
			
			out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">");
			
			out.println("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\" integrity=\"sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI\" crossorigin=\"anonymous\"></script>");
			
			out.println("<body><br><br><br><center>");
			
			out.println("<h1>Player Data Deleted Successfully from the Data Base</h1>");
			
			
			//response.getWriter().print("Player Data DELETED Successfully from the Data Base");
			
			out.println("<center> <form action=\"FetchData\" method='post'> <input type=\"submit\" value=\"Verify Deleted Entry\" class=\"btn btn-secondary\">");
			
					out.println("</form></center>");
			
			out.println("<center> <form action=\"FetchData.jsp\" method='post'> <input type=\"submit\" value=\"Back To Home\" class=\"btn btn-secondary\">");
					
					out.println("</form></center>");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			response.getWriter().print("Player Data NOT DELETED from the Data Base. Something wrong with your Data Entry");
		
			out.println("<center> <form action=\"FetchData.jsp\" method='post'> <input type=\"submit\" value=\"Back To Home\" class=\"btn btn-secondary\">");
			
			out.println("</form></center>");
		}
		
		
	}

}
