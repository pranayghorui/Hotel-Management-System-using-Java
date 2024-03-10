package hotelManagementSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class PickupService extends JFrame implements ActionListener {
	JButton back,submit;
	JTable table;
	Choice cartype;
	JCheckBox available,allrooms;

	PickupService(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text1 = new JLabel("Pickup Service");
		text1.setFont(new Font("Tahoma", Font.PLAIN,20));
		text1.setBounds(400,30,200,30);
		add(text1);
		
		JLabel bed = new JLabel("Car Type");
		bed.setBounds(70,90,100,25);
		add(bed);
		
		cartype=new Choice();
		cartype.setBounds(170,90,200,25);
		add(cartype);
		
		try {
			ConnectionClass conn = new ConnectionClass();
			ResultSet rs= conn.stm.executeQuery("select * from drivers");
			while(rs.next()) {
				cartype.add(rs.getString("model"));
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
//		available= new JCheckBox("Show Available Only");
//		available.setBounds(630,90,150,25);
//		available.setBackground(Color.WHITE);
//		add(available);

		
		
		JLabel l0 = new JLabel("ID No");
		l0.setBounds(2,130,60,20);
		add(l0);
		
		JLabel l1 = new JLabel("Name");
		l1.setBounds(108,130,60,20);
		add(l1);
		
		JLabel l2 = new JLabel("Age");
		l2.setBounds(214,130,60,20);
		add(l2);
		
		JLabel l3 = new JLabel("Car Brand");
		l3.setBounds(318,130,60,20);
		add(l3);
		
		JLabel l4 = new JLabel("Car Model");
		l4.setBounds(424,130,70,20);
		add(l4);
		
		JLabel l5 = new JLabel("Location");
		l5.setBounds(530,130,60,20);
		add(l5);
		
		JLabel l6 = new JLabel("Availability");
		l6.setBounds(635,130,60,20);
		add(l6);
		
		JLabel l7 = new JLabel("Gender");
		l7.setBounds(740,130,60,20);
		add(l7);
		
		JLabel l8 = new JLabel("Contact");
		l8.setBounds(846,130,60,20);
		add(l8);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		submit.setBounds(177,400,120,30);
		add(submit);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		back.setBounds(640,400,120,30);
		add(back);
		
		
		table = new JTable();
		table.setBounds(0,150,950,250);
		add(table);
		
		try {
			ConnectionClass conn = new ConnectionClass();
			String query1 = "select * from drivers;";
			ResultSet rs= conn.stm.executeQuery(query1);
			table.setModel(DbUtils.resultSetToTableModel(rs));	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		setBounds(300,200,950,500);
		setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==submit) {
			try {
				ConnectionClass conn = new ConnectionClass();
				String query1 = "select * from drivers where model ='"+cartype.getSelectedItem()+"';";
				ResultSet rs;
				rs=conn.stm.executeQuery(query1);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			setVisible(false);
			new Reception();
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PickupService();
		
	}
}
