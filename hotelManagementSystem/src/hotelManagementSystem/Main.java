package hotelManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.*;

public class Main extends JFrame implements ActionListener{
	
	Main(){
//		setSize(1166,565); // in video 1366
//		setLocation(100,100);
		setBounds(100,100,1176,665);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/MyFront.jpg")); // front1edit1.jpg
		Image i2 = i1.getImage().getScaledInstance(1166, 565, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1166,565); // location x, location y, length, breadth
		add(image);
		
		JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
		text.setBounds(200,380,1000,90);
//		add(text); 	// hidden behind image
		text.setForeground(Color.YELLOW);
		text.setFont(new Font("serif", Font.PLAIN,45));
		image.add(text);
		
		JButton next = new JButton("Next");
		next.setBounds(1000, 410, 120, 35);
		next.setBackground(Color.DARK_GRAY);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("serif",Font.PLAIN,18));
		// for click event 
		next.addActionListener(this);
		image.add(next);
	        
	    setVisible(true);
		
		while(true){     
	            text.setVisible(false);
	            try{
	               Thread.sleep(500); 
	            }catch(Exception e){
	                e.printStackTrace();                       
	            }  
	            text.setVisible(true);
	            try{
	               Thread.sleep(500); 
	            }catch(Exception e){
	                e.printStackTrace();                       
	            } 
	        }
		
	    }
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// click next close window and open login page
		setVisible(false);
		new Login();
	}
		
	public static void main(String[] args) {
		new Main();
	}

}