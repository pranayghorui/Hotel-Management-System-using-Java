package hotelManagementSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener{

	JButton add, cancel;
	JTextField tfroomno,tfprice;
	JComboBox bedCombo,availableCombo,cleanCombo;
	
	AddRooms(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		
		// Heading
		JLabel heading = new JLabel("Add Rooms");
		heading.setFont(new Font("Courier", Font.BOLD, 18));
		heading.setBounds(150, 20, 200, 20);
		add(heading);
		
		//Room no
		JLabel lblroomno = new JLabel("Room Number");
		lblroomno.setFont(new Font("Tahoma", Font.PLAIN,16));
		lblroomno.setBounds(60,80,120,30);
		add(lblroomno);
		
		tfroomno = new JTextField();
		tfroomno.setBounds(200,80,150,30);
		add(tfroomno);
		
		// Available
		JLabel lblavailable = new JLabel("Room Available");
		lblavailable.setFont(new Font("Tahoma", Font.PLAIN,16));
		lblavailable.setBounds(60,130,120,30);
		add(lblavailable);
		
		String availableOptions[] = {"Available", "Occupied"};
		availableCombo = new JComboBox(availableOptions);
		availableCombo.setBounds(200,130,150,30);
		availableCombo.setBackground(Color.WHITE);
		add(availableCombo);
		
		// Cleaning
		JLabel lblclean = new JLabel("Cleaning Status");
		lblclean.setFont(new Font("Tahoma", Font.PLAIN,16));
		lblclean.setBounds(60,180,120,30);
		add(lblclean);
		
		String cleanOptions[] = {"Cleaned", "Dingy"};
		cleanCombo = new JComboBox(cleanOptions);
		cleanCombo.setBounds(200,180,150,30);
		cleanCombo.setBackground(Color.WHITE);
		add(cleanCombo);
		
		// Price
		JLabel lblprice= new JLabel("Room Price");
		lblprice.setFont(new Font("Tahoma", Font.PLAIN,16));
		lblprice.setBounds(60,230,120,30);
		add(lblprice);
		
		tfprice = new JTextField();
		tfprice.setBounds(200,230,150,30);
		add(tfprice);
		
		//Room Type
		JLabel lblbed = new JLabel("Room Type");
		lblbed.setFont(new Font("Tahoma", Font.PLAIN,16));
		lblbed.setBounds(60,280,120,30);
		add(lblbed);
		
		String bedOptions[] = {"Single Bed [AC]","Single Bed [Non-AC]", "Double Bed [AC]","Double Bed [Non-AC]"};
		bedCombo = new JComboBox(bedOptions);
		bedCombo.setBounds(200,280,150,30);
		bedCombo.setBackground(Color.WHITE);
		add(bedCombo);
		
		// Add Room button
		add = new JButton("Add Room");
		add.setForeground(Color.ORANGE);
		add.setBackground(Color.BLACK);
		add.setBounds(60,350,130,30);
		add.addActionListener(this);
		add(add);
		// Cancel button
		cancel = new JButton("Cancel");
		cancel.setForeground(Color.BLUE);
		cancel.setBackground(Color.LIGHT_GRAY);
		cancel.setBounds(220,350,130,30);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1 = new 	ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(400,30,400,350);
		add(image);
		
		setBounds(253,180,860,470);
//		setBounds(253,180,860,540);
		setVisible(true);
		try {
			
		}
		catch(Exception e) {
			
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==add) {
			String roomno = tfroomno.getText();
			String availability =(String) availableCombo.getSelectedItem();
			String cleaning_status = (String) cleanCombo.getSelectedItem();
			String room_type =(String) bedCombo.getSelectedItem();
			String price = tfprice.getText();
			
			if(roomno.equals("")) {
				JOptionPane.showMessageDialog(null, "Room Number should not be empty");
				return;
			}
			if(availability.equals("")) {
				JOptionPane.showMessageDialog(null, "No option selected for Room Available");
				return;
			}
			if(cleaning_status.equals("")) {
				JOptionPane.showMessageDialog(null, "Select Cleaning Status");
				return;
			}
			if(room_type.equals("")) {
				JOptionPane.showMessageDialog(null, "Select Room Type");
				return;
			}
			if(price.equals("")) {
				JOptionPane.showMessageDialog(null, "Room Price should not be empty");
				return;
			}
			
			
			try {
				ConnectionClass conn = new ConnectionClass();
				String query ="insert into rooms (roomno, availability,cleaning_status,room_type,price) values ('"+roomno+"','"+availability+"','"+cleaning_status+"','"+room_type+"','"+price+"');";
				// for insert or update info in table-> executeUpdate
				conn.stm.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "New Room Added Successfully");
				// after successful add open dashboard and close window
//				new Dashboard();
				setVisible(false);
				
				// it is recommended to close the connection after use ; 
//				/*
				conn.stm.close();
				conn.con.close();
				if(conn.con.isClosed()) {
					System.out.println("Disconnected");
				}
//				*/
			
			}
			catch(Exception e) {
				e.printStackTrace();
				// for dummy demo //
				JOptionPane.showMessageDialog(null,"Database is not Connected / Some Error Occured");
				setVisible(false);
				//-------------------------//
				JOptionPane.showMessageDialog(null, "Room Number Already Exists");	// this works when database connected
			}
			
		} else {
//			new Dashboard();
			setVisible(false);
		}
	}
	
	
	public static void main(String[] args) {
		new AddRooms();
	}
}
