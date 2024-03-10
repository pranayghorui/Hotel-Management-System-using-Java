package hotelManagementSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener {
	JButton back;
	JTable table;
	
	EmployeeInfo(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		
		
		JLabel l0 = new JLabel("Employee Id");
		l0.setBounds(25,10,70,20);
		add(l0);
		
		JLabel l1 = new JLabel("Name");
		l1.setBounds(125,10,60,20);
		add(l1);
		
		JLabel l2 = new JLabel("Age");
		l2.setBounds(225,10,60,20);
		add(l2);
		
		JLabel l3 = new JLabel("Gender");
		l3.setBounds(325,10,60,20);
		add(l3);
		
		JLabel l4 = new JLabel("Job");
		l4.setBounds(425,10,70,20);
		add(l4);
		
		JLabel l5 = new JLabel("Salary");
		l5.setBounds(525,10,60,20);
		add(l5);
		
		JLabel l6 = new JLabel("Phone");
		l6.setBounds(625,10,60,20);
		add(l6);
		
		JLabel l7 = new JLabel("Email Id");
		l7.setBounds(725,10,60,20);
		add(l7);
		
		JLabel l8 = new JLabel("Aadhar No");
		l8.setBounds(825,10,60,20);
		add(l8);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		back.setBounds(415,400,120,30);
		add(back);
		
		
		table = new JTable();
		table.setBounds(20,40,900,450);
		add(table);
		
		try {
			ConnectionClass conn = new ConnectionClass();
			ResultSet rs = conn.stm.executeQuery("select * from employees;");
			
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
		new EmployeeInfo();
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
