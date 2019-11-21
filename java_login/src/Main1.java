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
@WebServlet("/Main1")
public class Main1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private static Connection conn;
   
   
    public Main1() {
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
	    
	    Main1 main = new Main1();
	    
	    try {
	    	Class.forName("com.mysql.jdbc.Driver").newInstance();
	    	Connection conn = DriverManager.getConnection(
	    			 "jdbc:mysql://localhost:3306/authDataBase?user=root&password=Manchester@123");
	    	Statement stmt = conn.createStatement();
	    	String sql = "select username,password,usercode from accountinfo where username="+ "'"+ textusername+ "'";
	    	ResultSet result = stmt.executeQuery(sql);
	    	
	    	while(result.next()) {
	    		String username1 = result.getString("username"); System.out.println("username1 is " + username1);
	            String password1 = result.getString("password"); System.out.println("password1 is " + password1);
	    		String usercode1 = result.getString("usercode"); System.out.println("usercode1 is " + usercode1);
	    		
	    		
	    		if(textusername == "" || textpassword == "" || textusercode == "") {
	    	    	if(username1.equals(textusername) && !password1.equals(textpassword) && !usercode1.equals(textusercode)) {
	    	    		String message = "Incorrect Password, Incorrect UserID";
		    	        request.setAttribute("message", message); // This will be available as ${message}
		    	        request.setAttribute("username", username1);
		    	        request.getRequestDispatcher("/WEB-INF/correct username.jsp").forward(request, response);
		    	        return;
	    	    		}
	    	    	
	    	    	if(username1.equals(textusername) && password1.equals(textpassword) && !usercode1.equals(textusercode)) {
	    	    		
	    	    		String message = "Incorrect UserID";
		    	        request.setAttribute("message", message); // This will be available as ${message}
		    	        request.setAttribute("username", username1);
		    	        request.setAttribute("password", password1);
		    	        request.getRequestDispatcher("/WEB-INF/correct username&password.jsp").forward(request, response);
		    	        return;
	    	    		}
                    if(username1.equals(textusername) && usercode1.equals(textusercode) && !password1.equals(textpassword)) {
	    	    		
	    	    		String message = "Incorrect Password";
		    	        request.setAttribute("message", message); // This will be available as ${message}
		    	        request.setAttribute("username", username1);
		    	        request.setAttribute("usercode", usercode1);
		    	        request.getRequestDispatcher("/WEB-INF/correct username&usercode.jsp").forward(request, response);
		    	        return;
	    	    		}
	    	    	
	    	    	if(!username1.equals(textusername) && !password1.equals(textpassword) && !usercode1.equals(textusercode)) {
	    	    	String message = "Incorrect Username, Incorrect Password, Incorrect UserID";
	    	        request.setAttribute("message", message); // This will be available as ${message}
	    	        request.getRequestDispatcher("/WEB-INF/nullresponse.jsp").forward(request, response);
	    	        return;
	    	    }
	    		}
	    		if(username1.equals(textusername) && !password1.equals(textpassword) && !usercode1.equals(textusercode)) {
    	    		String message = "Incorrect Password, Incorrect UserID";
	    	        request.setAttribute("message", message); // This will be available as ${message}
	    	        request.setAttribute("username", username1);
	    	        request.getRequestDispatcher("/WEB-INF/correct username.jsp").forward(request, response);
	    	        return;
    	    		}
	    		if(username1.equals(textusername) && usercode1.equals(textusercode) && !password1.equals(textpassword)) {
    	    		
    	    		String message = "Incorrect Password";
	    	        request.setAttribute("message", message); // This will be available as ${message}
	    	        request.setAttribute("username", username1);
	    	        request.setAttribute("usercode", usercode1);
	    	        request.getRequestDispatcher("/WEB-INF/correct username&usercode.jsp").forward(request, response);
	    	        return;
    	    		}
	    		if(username1.equals(textusername) && password1.equals(textpassword) && !usercode1.equals(textusercode)) {
    	    		
    	    		String message = "Incorrect userid";
	    	        request.setAttribute("message", message); // This will be available as ${message}
	    	        request.setAttribute("username", username1);
	    	        request.setAttribute("password", password1);
	    	        request.getRequestDispatcher("/WEB-INF/correct username&password.jsp").forward(request, response);
	    	        return;
    	    		}
	    		if(username1.equals(textusername) && password1.equals(textpassword) && usercode1.equals(textusercode)) {
	    		String message = "Authentication is Successfull";
	    		request.setAttribute("message", message); // This will be available as ${message}
	 	        request.getRequestDispatcher("/WEB-INF/successful authentication.jsp").forward(request, response);
	 	        return;
	    			
	    		}
	    	}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	       
 }
}
