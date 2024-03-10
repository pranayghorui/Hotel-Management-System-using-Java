package hotelManagementSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {
	JButton back,submit;
	JTable table;
	JComboBox bedtype;
	JCheckBox available,allrooms;

	SearchRoom(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text1 = new JLabel("Search for Room");
		text1.setFont(new Font("Tahoma", Font.PLAIN,20));
		text1.setBounds(400,30,200,30);
		add(text1);
		
		JLabel bed = new JLabel("Room Type");
		bed.setBounds(70,90,100,25);
		add(bed);
		
		bedtype = new JComboBox(new String[] {"Single Bed [AC]","Single Bed [Non-AC]","Double Bed [AC]","Double Bed [Non-AC]","All"});
		bedtype.setBounds(150,90,150,25);
		bedtype.setBackground(Color.WHITE);
		add(bedtype);
		
		available= new JCheckBox("Show Available Only");
		available.setBounds(630,90,150,25);
		available.setBackground(Color.WHITE);
		add(available);
		
//		allrooms= new JCheckBox("All Rooms");
//		allrooms.setBounds(788,90,100,25);
//		allrooms.setBackground(Color.WHITE);
//		add(allrooms);
		
		
		JLabel l0 = new JLabel("Serial No");
		l0.setBounds(5,130,60,20);
		add(l0);
		
		JLabel l1 = new JLabel("Room No");
		l1.setBounds(159,130,60,20);
		add(l1);
		
		JLabel l2 = new JLabel("Available");
		l2.setBounds(317,130,60,20);
		add(l2);
		
		JLabel l3 = new JLabel("Condition");
		l3.setBounds(476,130,60,20);
		add(l3);
		
		JLabel l4 = new JLabel("Room Type");
		l4.setBounds(635,130,70,20);
		add(l4);
		
		JLabel l5 = new JLabel("Price");
		l5.setBounds(793,130,60,20);
		add(l5);
		
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
			String query1 = "select * from rooms;";
			ResultSet rs= conn.stm.executeQuery(query1);
			table.setModel(DbUtils.resultSetToTableModel(rs));	
			conn.stm.close();
			conn.con.close();
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
		if(ae.getSource()==back) {
			setVisible(false);
			new Reception();
		}
		else if(ae.getSource()==submit) {
			try {
				ConnectionClass conn = new ConnectionClass();
				String query1 = "select * from rooms where room_type ='"+(String)bedtype.getSelectedItem()+"';";
				String query2 = "select * from rooms where room_type ='"+(String)bedtype.getSelectedItem()+"' and availability='Available';";
				String query3 = "select * from rooms;";
				String query4 = "select * from rooms where availability='Available';";
				ResultSet rs;
				if(available.isSelected() && bedtype.getSelectedItem()!="All") {
					rs = conn.stm.executeQuery(query2);
				}
				else if(available.isSelected()  && bedtype.getSelectedItem()=="All") {
					rs = conn.stm.executeQuery(query4);
				}
				else if(!available.isSelected() && bedtype.getSelectedItem()!="All" ) {
					rs = conn.stm.executeQuery(query1);
				}
//				else if(!available.isSelected()  && bedtype.getSelectedItem()=="All") {				
//					rs = conn.stm.executeQuery(query3);
//				}
				else  {				
					rs = conn.stm.executeQuery(query3);
				}
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
//				conn.stm.close();
//				conn.con.close();
			}catch(Exception e) {
				// for dummy demo //
				JOptionPane.showMessageDialog(null,"Database is not Connected / Some Error Occured");
				setVisible(false);
				//-------------------------//
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SearchRoom();
		
	}
}
