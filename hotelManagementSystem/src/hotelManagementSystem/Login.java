package hotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
	JTextField username;
	JPasswordField password;
	JButton login,cancel;
	
    Login(){
       getContentPane().setBackground(Color.WHITE);
       // Frame components create
       setLayout(null);
       JLabel user = new JLabel("username");
       user.setBounds(40,20,100,30);
       add(user);
       
       username = new JTextField();
       username.setBounds(150,20,150,30);
       add(username);
       
       password = new JPasswordField();
       password.setBounds(150,70,150,30);
       add(password);
       
       login= new JButton("Login");
       login.setBounds(40,150,120,30);
       login.setBackground(Color.BLUE);
       login.setForeground(Color.WHITE);
       login.addActionListener(this);
       add(login);
       
       cancel= new JButton("Cancel");
       cancel.setBounds(180,150,120,30);
       cancel.setBackground(Color.BLUE);
       cancel.setForeground(Color.WHITE);
       cancel.addActionListener(this);
       add(cancel);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
       Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(350,10,200,200);
       add(image);
       
       
       JLabel pass = new JLabel("password");
       pass.setBounds(40,70,100,30);
       add(pass);
       
       
       setBounds(500,200,600,300); 
       setVisible(true);
    }
    
	@Override
    public void actionPerformed(ActionEvent ae) {
    	if(ae.getSource()==login) {
    		// login button click => get value from textfield
    		String user = username.getText();
    		@SuppressWarnings("deprecation")
			String pass = password.getText();
    		// check database for existing values or not
    		
    		// modified for dummy//
    		/* dummy check with out interacting with database*/
    		if(user.equals("admin") && pass.equals("admin")) {
    			new Dashboard();
    		}
    		else {
				JOptionPane.showMessageDialog(null,"Invalid username or password");
			}
    		//---------------------------//
    		
    		/*
    		try {
    			ConnectionClass loginCon = new ConnectionClass();
    			
    			String query = "select * from login where username = '"+user+"' and password = '"+pass+"'";
    			ResultSet rs = loginCon.stm.executeQuery(query);
    		
    			if(rs.next()) {
    				// rs.next()==true [when database finds query data] and close window=> open dashboard (logged in)
    				setVisible(false);
    				new Dashboard();
    				
    			} else {
    				JOptionPane.showMessageDialog(null,"Invalid username or password");
    			}
    		}

    		catch(Exception e) {
    			e.printStackTrace();
    		}
		*/
    	}
    	else if(ae.getSource() == cancel) {
    		setVisible(false);
    	}
    	
    }

    public static void main(String[]args){
        new Login();
    }


}
