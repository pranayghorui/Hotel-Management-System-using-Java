package hotelManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class UpdateRoomStatus extends JFrame implements ActionListener {
	
	Choice cCustomer;
	JTextField tfroom, tfavailability,tfclean;
	JButton check,update,back ;
	
	UpdateRoomStatus(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("Update Room Status");
		text.setFont(new Font("Tahoma", Font.PLAIN,20));
		text.setBounds(30,20,250,30);
		text.setForeground(Color.BLUE);
		add(text);
		
		JLabel lblid = new JLabel("Customer ID");
		lblid.setBounds(30,80,100,20);
		add(lblid);
		
//		JLabel lblid = new JLabel("Room No");
//		lblid.setBounds(30,80,100,20);
//		add(lblid);
		
		cCustomer = new Choice();
		cCustomer.setBounds(200,80,170,25);
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
		tfroom.setBounds(200,120,170,25);
		add(tfroom);
		
		JLabel lblname = new JLabel("Availability");
		lblname.setBounds(30,160,100,20);
		add(lblname);
		
		tfavailability = new JTextField();
		tfavailability.setBounds(200,160,170,25);
		add(tfavailability);
		
		JLabel lblclean = new JLabel("Cleaning Status");
		lblclean.setBounds(30,200,100,20);
		add(lblclean);
		
		tfclean = new JTextField();
		tfclean.setBounds(200,200,170,25);
		add(tfclean);
		
		check = new JButton("Check");
		check.setBackground(Color.BLACK);
		check.setForeground(Color.WHITE);
		check.setBounds(30,274,100,25);
		check.addActionListener(this);
		add(check);
		
		update = new JButton("Update");
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.setBounds(150,274,100,25);
		update.addActionListener(this);
		add(update);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(270,274,100,25);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
		Image i2=i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400,50,400,250);
		add(image);
		
		
		
		
		
		
		
		
		setBounds(300,200,850,390);
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
				}
//				ConnectionClass conn2 = new ConnectionClass();
				ResultSet rs2 = conn.stm.executeQuery("select * from rooms where roomno='"+tfroom.getText()+"';");
				System.out.println("select * from rooms where roomno='"+tfroom.getText()+"';");
				while(rs2.next()) {					
					tfavailability.setText(rs2.getString("availability"));
					tfclean.setText(rs2.getString("cleaning_status"));
				}
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		}

		else if(ae.getSource()==update) {
			String number = cCustomer.getSelectedItem();
			String room = tfroom.getText();
			String available=tfavailability.getText();
			String clean = tfclean.getText();
			
			try {
				ConnectionClass conn = new ConnectionClass();
				conn.stm.executeUpdate("update rooms set availability='"+available+"',cleaning_status='"+clean+"' where roomno='"+room+"';");
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
		new UpdateRoomStatus();
	}

}
