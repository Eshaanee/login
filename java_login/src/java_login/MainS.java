package java_login;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.Scanner;



/**
 * Servlet implementation class MainS
 */
@WebServlet("/MainS")
public class MainS extends javax.servlet.http.HttpServlet implements 
javax.servlet.Servlet
 {
	private static final long serialVersionUID = 1L;
       
   
    public MainS() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");  
		System.out.println("enter name");
		//Scanner s= new Scanner(System.in);
		String name=request.getParameter("name");  
		//String name=s.nextLine();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con= DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/myfirstdatabase?user=root&password=root");
			Statement stmt=con.createStatement();
			try {
				stmt.execute("CREATE TABLE IF NOT EXISTS simple( name char(30))");
				//		+ "password varchar(30),"
					//	+ "userId integer(10)");
				
			}catch(Exception e) {
				
			}
			String values = "Insert into simple values(\'" + name + "\')";
			if(name != null)
				  stmt.execute(values);
					ResultSet rs = stmt.executeQuery("Select * from simple");
				while ( rs.next())
				  System.out.println(rs.getString(1));

		}catch(Exception e) {
			System.out.println(e);
			System.exit(0);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
