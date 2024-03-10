package hotelManagementSystem;

import java.sql.*;

public class ConnectionClass2 {
	
	Connection con;
	Statement stm;
	String root;
	String password;
	ConnectionClass2(String s1,String s2){
		root=s1;
		password=s2;
	}
	ConnectionClass2(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// modified for dummy //
			con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem",root,password);
			//--------------------------------------//
//			con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","Pranay@267");
			stm = con.createStatement();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		

	}

}
