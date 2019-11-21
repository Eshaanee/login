package java_login;

import java_login.*;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.undo.StateEdit;




/**
 * Servlet implementation class Main2
 */
@WebServlet("/MainF")
public class MainF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private static Connection conn;
   
   
    public MainF() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String textusername = request.getParameter("username");
        String textpassword = request.getParameter("password");
	    String textusercode = request.getParameter("usercode");
	    
	    if(textusername == "" && textpassword == "" && textusercode == "") {
    		String message = "Error: All fields are empty";
	        request.setAttribute("message", message); // This will be available as ${message}
	        
	        request.getRequestDispatcher("null.jsp").forward(request, response);
	        return;
    		}
	    
	    try {
	    	Class.forName("com.mysql.jdbc.Driver").newInstance();
	    	Connection conn = DriverManager.getConnection(
	    			 "jdbc:mysql://localhost:3306/myfirstdatabase?user=root&password=root");
	    	Statement stmt = conn.createStatement();
	    	String sql = "select username,password,usercode from accountinfo where username="+ "'"+ textusername+ "'";
	    	ResultSet result = stmt.executeQuery(sql);
	    	
	    	while(result.next()) {
	    		String username1 = result.getString("username"); System.out.println("username1 is " + username1);
	            String password1 = result.getString("password"); System.out.println("password1 is " + password1);
	    		String usercode1 = result.getString("usercode"); System.out.println("usercode1 is " + usercode1);
	    		
	    		
	    		if(textusername != "" || textpassword != "" || textusercode != "") {
	    	    	if(username1.equals(textusername) && !password1.equals(textpassword) && !usercode1.equals(textusercode)) {
	    	    		String message = "Login Not successful";
		    	        request.setAttribute("message", message); // This will be available as ${message}
		    	        request.setAttribute("username", username1);
		    	        request.getRequestDispatcher("/c_username.jsp").forward(request, response);
		    	        return;
	    	    		}
	    	    	
	    	    	if(username1.equals(textusername) && password1.equals(textpassword) && !usercode1.equals(textusercode)) {
	    	    		
	    	    		String message = "Error: Login Not successful";
		    	        request.setAttribute("message", message); // This will be available as ${message}
		    	        request.setAttribute("username", username1);
		    	        request.setAttribute("password", password1);
		    	        request.getRequestDispatcher("/correct_username_and_password.jsp").forward(request, response);
		    	        return;
	    	    		}
                    if(username1.equals(textusername) && usercode1.equals(textusercode) && !password1.equals(textpassword)) {
	    	    		
	    	    		String message = "Error:Login Not successful";
		    	        request.setAttribute("message", message); // This will be available as ${message}
		    	        request.setAttribute("username", username1);
		    	        request.setAttribute("usercode", usercode1);
		    	        request.getRequestDispatcher("/c_username_user_id.jsp").forward(request, response);
		    	        return;
	    	    		}
	    	    	
	    		
	    		if(username1.equals(textusername) && !password1.equals(textpassword) && !usercode1.equals(textusercode)) {
    	    		String message = "Error: Login Not successful";
	    	        request.setAttribute("message", message); // This will be available as ${message}
	    	        request.setAttribute("username", username1);
	    	        request.getRequestDispatcher("/c_username.jsp").forward(request, response);
	    	        return;
    	    		}
	    		if(username1.equals(textusername) && usercode1.equals(textusercode) && !password1.equals(textpassword)) {
    	    		
    	    		String message = "Error: Login Not successful";
	    	        request.setAttribute("message", message); // This will be available as ${message}
	    	        request.setAttribute("username", username1);
	    	        request.setAttribute("usercode", usercode1);
	    	        request.getRequestDispatcher("/c_username_user_id.jsp").forward(request, response);
	    	        return;
    	    		}
	    		if(username1.equals(textusername) && password1.equals(textpassword) && !usercode1.equals(textusercode)) {
    	    		
    	    		String message = "Error: Login Not successful";
	    	        request.setAttribute("message", message); // This will be available as ${message}
	    	        request.setAttribute("username", username1);
	    	        request.setAttribute("password", password1);
	    	        request.getRequestDispatcher("/correct_username_and_password.jsp").forward(request, response);
	    	        return;
    	    		}
	    		if(username1.equals(textusername) && password1.equals(textpassword) && usercode1.equals(textusercode)) {
	    		String message = "Authentication is Successfull";
	    		request.setAttribute("message", message); // This will be available as ${message}
	 	        request.getRequestDispatcher("/c_authentication.jsp").forward(request, response);
	 	        return;
	    			
	    		}
	    		}
	    		else{
	    			String message = "Errors: All Credentials cannot be empty";
		    		request.setAttribute("message", message); // This will be available as ${message}
		 	        request.getRequestDispatcher("/null.jsp").forward(request, response);
		 	        return;
	    		}
	    	}
	    	if(result.next() == false) {
	    		String message = "Error: Please enter all fields correctly";
	    		 request.setAttribute("message", message); // This will be available as ${message}	    		 
	    	        request.getRequestDispatcher("everythingincorrect.jsp").forward(request, response);
	    	        return;
	    	}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	       
 }
}
