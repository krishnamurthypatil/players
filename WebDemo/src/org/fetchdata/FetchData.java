package org.fetchdata;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/FetchData")
public class FetchData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://@localhost:3306/PlayersDB","root","Swara@27");
			PreparedStatement ps=conn.prepareStatement("select * from PlayersDB.players");
			ResultSet rs=ps.executeQuery();
				
			
			out.println("<html>");
			
			out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">");
			
			out.println("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\" integrity=\"sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI\" crossorigin=\"anonymous\"></script>");
			
			out.println("<body><br><br><br><center>");
			
			out.println("<h1>Complete Players List</h1>");
			
			out.println("<table align=\"center\" = \"1\" class=\"table table-striped table-bordered\"><tr><td>ID</td><td>NAME</td><td>AGE</td><td>EMAIL</td><td>ADDRESS</td></tr>");
			
			
			while(rs.next()) {
				
				out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td></tr>");
				
			}
			
			out.println("</table></body></html>");
			
			out.println("<center> <form action=\"FetchData.jsp\" method='post'> <br> <input type=\"submit\" value=\"Back To Home\" class=\"btn btn-primary\">");
			
			out.println("</form></center>");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			response.getWriter().print("NOT able to Display the Players Data.");
		
			
			out.println("<center> <form action=\"FetchData.jsp\" method='post'> <br> <input type=\"submit\" value=\"Back To Home\" class=\"btn btn-primary\">");
			
			out.println("</form></center>");
		}
		
		
	}

}
