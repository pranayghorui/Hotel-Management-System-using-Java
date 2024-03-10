package hotelManagementSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener {
	JButton back;
	JTable table;
	
	Department(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel l0 = new JLabel("Dept ID");
		l0.setBounds(45,10,100,20);
		add(l0);
		
		JLabel l1 = new JLabel("Department");
		l1.setBounds(240,10,100,20);
		add(l1);
		
		JLabel l2 = new JLabel("Budget");
		l2.setBounds(445,10,100,20);
		add(l2);
		
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		back.setBounds(280,400,120,30);
		add(back);
		
		
		table = new JTable();
		table.setBounds(40,50,600,450);
		add(table);
		
		try {
			ConnectionClass conn = new ConnectionClass();
			ResultSet rs = conn.stm.executeQuery("select * from department;");
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e) {
			/*
			// for dummy demo //
			JOptionPane.showMessageDialog(null,"Database is not Connected / Some Error Occured");
			setVisible(false);
			//-------------------------//
			 * */
			 
			e.printStackTrace();
		}
		
		
		
		setBounds(400,200,700,480);
		setVisible(true);
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Department();
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