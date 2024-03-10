package hotelManagementSystem;

import java.sql.*;

public class ConnectionClass {
	
	Connection con;
	Statement stm;
	String username = "myuser"; // here put your Username or root of your database(Here used MySQL)
	String password="mypass";	// here put password of your database(Here used MySQL)
	
	ConnectionClass(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// modified for dummy //
			con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem",username,password);
//			--------------------------------------//
//			con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","Pranay@267");
			stm = con.createStatement();
			System.out.println("okay");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		new ConnectionClass();

	}

}
