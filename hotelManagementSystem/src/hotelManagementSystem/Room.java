package hotelManagementSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener {
	JButton back;
	JTable table;
	Room(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
		Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(610,10,300,300);
		add(image);
		
		JLabel l0 = new JLabel("Serial No");
		l0.setBounds(10,10,60,20);
		add(l0);
		
		JLabel l1 = new JLabel("Room No");
		l1.setBounds(87,10,60,20);
		add(l1);
		
		JLabel l2 = new JLabel("Available");
		l2.setBounds(170,10,60,20);
		add(l2);
		
		JLabel l3 = new JLabel("Condition");
		l3.setBounds(255,10,60,20);
		add(l3);
		
		JLabel l4 = new JLabel("Room Type");
		l4.setBounds(337,10,70,20);
		add(l4);
		
		JLabel l5 = new JLabel("Price");
		l5.setBounds(420,10,60,20);
		add(l5);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		back.setBounds(700,400,120,30);
		add(back);
		
		
		table = new JTable();
		table.setBounds(0,40,600,600);
		add(table);
		
		try {
			ConnectionClass conn = new ConnectionClass();
			ResultSet rs = conn.stm.executeQuery("select * from rooms;");
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e) {
			/*
			 // for dummy demo //
				JOptionPane.showMessageDialog(null,"Database is not Connected / Some Error Occured");
				setVisible(false);
				//-------------------------// 
			 
			 */
			e.printStackTrace();
		}
		
		
		
		setBounds(300,200,950,500);
		setVisible(true);
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Room();
	}



	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
//		if(ae.getSource()==back) {
			setVisible(false);
			new Reception();
//		}
	}

}
