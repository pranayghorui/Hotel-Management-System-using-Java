package hotelManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class UpdateStatus extends JFrame implements ActionListener {
	
	Choice cCustomer;
	JTextField tfroom, tfname,tfcheckin,tfpaid,tfpending ;
	JButton check,update,back ;
	
	UpdateStatus(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("Update Status");
		text.setFont(new Font("Tahoma", Font.PLAIN,20));
		text.setBounds(90,20,200,30);
		text.setForeground(Color.BLUE);
		add(text);
		
		JLabel lblid = new JLabel("Customer ID");
		lblid.setBounds(30,80,100,20);
		add(lblid);
		
//		JLabel lblid = new JLabel("Room No");
//		lblid.setBounds(30,80,100,20);
//		add(lblid);
		
		cCustomer = new Choice();
		cCustomer.setBounds(200,80,150,25);
		add(cCustomer);
		
		try {
			ConnectionClass conn = new ConnectionClass();
			ResultSet rs= conn.stm.executeQuery("select * from customers;");
//			ResultSet rs= conn.stm.executeQuery("select * from rooms where availability='Occupied';");
			
			while(rs.next()) {
				cCustomer.add(rs.getString("id_number"));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblroom = new JLabel("Room Number");
		lblroom.setBounds(30,120,100,20);
		add(lblroom);
		
		tfroom = new JTextField();
		tfroom.setBounds(200,120,150,25);
		add(tfroom);
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(30,160,100,20);
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(200,160,150,25);
		add(tfname);
		
		JLabel lblcheckin = new JLabel("Check In Time");
		lblcheckin.setBounds(30,200,100,20);
		add(lblcheckin);
		
		tfcheckin = new JTextField();
		tfcheckin.setBounds(200,200,150,25);
		add(tfcheckin);
		
		JLabel lblpaid = new JLabel("Paid Amount");
		lblpaid.setBounds(30,240,100,20);
		add(lblpaid);
		
		tfpaid = new JTextField();
		tfpaid.setBounds(200,240,150,25);
		add(tfpaid);
		
		JLabel lblpending = new JLabel("Pending");
		lblpending.setBounds(30,280,100,20);
		add(lblpending);
		
		tfpending = new JTextField();
		tfpending.setBounds(200,280,150,25);
		add(tfpending);
		
		check = new JButton("Check");
		check.setBackground(Color.BLACK);
		check.setForeground(Color.WHITE);
		check.setBounds(30,340,100,25);
		check.addActionListener(this);
		add(check);
		
		update = new JButton("Update");
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.setBounds(150,340,100,25);
		update.addActionListener(this);
		add(update);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(270,340,100,25);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(400,50,500,300);
		add(image);
		
		
		
		
		
		
		
		
		setBounds(300,200,980,500);
		setVisible(true);
	}

	

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==check) {
			String id= cCustomer.getSelectedItem();
			String query= "select * from customers where id_number='"+id+"';";
			
			try {
				ConnectionClass conn = new ConnectionClass();
				ResultSet rs=conn.stm.executeQuery(query);
				while(rs.next()) {
					tfroom.setText(rs.getString("roomno"));
					tfname.setText(rs.getString("cust_name"));
					tfcheckin.setText(rs.getString("checkintime"));
					tfpaid.setText(rs.getString("deposit"));				
				}
//				ConnectionClass conn2 = new ConnectionClass();
				ResultSet rs2 = conn.stm.executeQuery("select * from rooms where roomno='"+tfroom.getText()+"';");
				System.out.println("select * from rooms where roomno='"+tfroom.getText()+"';");
				while(rs2.next()) {					
					String price= rs2.getString("price");
					int due = Integer.parseInt(price)-Integer.parseInt(tfpaid.getText());
					tfpending.setText(""+due);
					System.out.println(tfpending.getText());
				}
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		}
		else if(ae.getSource()==update) {
			String number = cCustomer.getSelectedItem();
			String room = tfroom.getText();
			String name = tfname.getText();
			String chekin= tfcheckin.getText();
			String deposit = tfpaid.getText();
			
			try {
				ConnectionClass conn = new ConnectionClass();
				conn.stm.executeUpdate("update customers set roomno='"+room+"',cust_name='"+name+"',deposit='"+deposit+"' where id_number='"+number+"';");
				JOptionPane.showMessageDialog(null, "Data Updated Successfully");
				
				setVisible(false);
				new Reception();
				
			}  catch(Exception e) {
				// for dummy demo //
				JOptionPane.showMessageDialog(null,"Database is not Connected / Some Error Occured");
				setVisible(false);
				//-------------------------//
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
		new UpdateStatus();
	}

}
