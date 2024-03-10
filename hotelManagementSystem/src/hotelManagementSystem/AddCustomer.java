package hotelManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.util.Date;


public class AddCustomer extends JFrame implements ActionListener {

	JComboBox comboid, comboroom;
	JTextField tfnumber, tfname,tfaddress,tfdeposit;
	JRadioButton rbmale, rbfemale;
	Choice croom;
	JLabel checkintime ;
	JButton entry, cancel;
	
	AddCustomer(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("New Customer Form");
		text.setBounds(100,20,300,30);
		text.setFont(new Font("Raleway", Font.PLAIN,20));
		add(text);
		
		JLabel lblid = new JLabel("ID Type");
		lblid.setBounds(35,80,100,20);
		lblid.setFont(new Font("Raleway", Font.PLAIN,15));
		add(lblid);
		
		String options[] = {"AADHAR","PAN Card","Voter ID","Driving Liscence","Passport"};
		comboid =new JComboBox(options);
		comboid.setBounds(200,80,150,25);
		comboid.setBackground(Color.WHITE);
		add(comboid);
		
		
		JLabel lblnumber = new JLabel("ID Number");
		lblnumber.setBounds(35,120,100,20);
		lblnumber.setFont(new Font("Raleway", Font.PLAIN,15));
		add(lblnumber);
		
		tfnumber= new JTextField();
		tfnumber.setBounds(200,120,150,25);
		add(tfnumber);
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(35,160,100,20);
		lblname.setFont(new Font("Raleway", Font.PLAIN,15));
		add(lblname);
		
		tfname= new JTextField();
		tfname.setBounds(200,160,150,25);
		add(tfname);
		//gender
		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(35,200,100,20);
		lblgender.setFont(new Font("Raleway", Font.PLAIN,15));
		add(lblgender);
		
		rbmale = new JRadioButton("Male");
		rbmale.setBackground(Color.WHITE);
		rbmale.setBounds(200,200,60,20);
		add(rbmale);
		
		rbfemale = new JRadioButton("Female");
		rbfemale.setBackground(Color.WHITE);
		rbfemale.setBounds(280,200,70,20);
		add(rbfemale);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbfemale);
		bg.add(rbmale);
		//address
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(35,240,100,20);
		lbladdress.setFont(new Font("Raleway", Font.PLAIN,15));
		add(lbladdress);
		
		tfaddress= new JTextField();
		tfaddress.setBounds(200,240,150,25);
		add(tfaddress);
		
		/*
		// room type
		JLabel lblroomtype = new JLabel("Room Type");
		lblroomtype.setBounds(35,280,100,20);
		lblroomtype.setFont(new Font("Raleway", Font.PLAIN,15));
		add(lblroomtype);
		
		String roomoptions[] = {"Single Bed [AC]","Single Bed [Non-AC]","Double Bed [Non-AC]","Double Bed [AC]"};
		comboroom =new JComboBox(roomoptions);
		comboroom.setBounds(200,280,150,25);
		comboroom.setBackground(Color.WHITE);
		add(comboroom);
		
		String room = (String)comboroom.getSelectedItem(); ;
		*/
		// room no
		JLabel lblallocatedroom = new JLabel("Select Room");
		lblallocatedroom.setBounds(35,280,100,20);
		lblallocatedroom.setFont(new Font("Raleway", Font.PLAIN,15));
		add(lblallocatedroom);
		
		croom = new Choice();
		
		try {
			ConnectionClass conn = new ConnectionClass();
			String query = "select * from rooms where availability ='Available';";
			ResultSet rs = conn.stm.executeQuery(query);
			
			while(rs.next()) {
				croom.add(rs.getString("roomno"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		croom.setBounds(200,280,150,20);
		add(croom);
		
		// check in time
		JLabel lbltime = new JLabel("Check In Time");
		lbltime.setBounds(35,320,100,20);
		lbltime.setFont(new Font("Raleway", Font.PLAIN,15));
		add(lbltime);
		
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :: HH:mm:ss");
		String currentDateTime = dateFormat. format(currentDate);
//		System.out.println(currentDateTime);
		
		checkintime = new JLabel(""+ currentDateTime);
		checkintime.setBounds(200,320,270,20);
		checkintime.setFont(new Font("Raleway", Font.PLAIN,14));
		add(checkintime);
		
		JLabel lbldeposit = new JLabel("Deposit Amonnt");
		lbldeposit.setBounds(35,360,150,20);
		lbldeposit.setFont(new Font("Raleway", Font.PLAIN,15));
		add(lbldeposit);
		
		tfdeposit= new JTextField();
		tfdeposit.setBounds(200,360,150,25);
		add(tfdeposit);
		
		entry = new JButton("Entry");
		entry.setBackground(Color.BLACK);
		entry.setForeground(Color.YELLOW);
		entry.setBounds(50,410,120,30);
		entry.addActionListener(this);
		add(entry);
		
		cancel = new JButton("Back");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(210,410,120,30);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1 = new 	ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
		Image i2=i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
//		image.setBounds(400,52,400,350);
		image.setBounds(400,50,300,400);
		add(image);
		
		
		setBounds(350,200,800,500);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
/*  JComboBox comboid;
	JTextField tfnumber, tfname,tfaddress,tfdeposit;
	JRadioButton rbmale, rbfemale;
	Choice croom;
	JLabel checkintime ;
	JButton entry, cancel;
*/
		if(ae.getSource()==entry) {
			String id = (String)comboid.getSelectedItem();
			String number = tfnumber.getText();
			String name = tfname.getText();
			String address = tfaddress.getText();
			String time = checkintime.getText();
			String room =croom.getSelectedItem();
			String gender=null;
			if(rbmale.isSelected()) {
				gender="Male";
			}else if(rbfemale.isSelected()) {
				gender="Female";
			}
			String deposit = tfdeposit.getText();
			
			if(id.equals("")) {
				JOptionPane.showMessageDialog(null, "ID Type is not Selected");
				return;
			}
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "ID Number should not be Empty");
				return;
			}
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is not entered");
				return;
			}
			if(address.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter Address");
				return;
			}
			if(room.equals("")) {
				JOptionPane.showMessageDialog(null, "Select Room");
				return;
			}
			if(gender.equals("")) {
				JOptionPane.showMessageDialog(null, "Gender is not Select");
				return;
			}
			if(deposit.equals("")) {
				JOptionPane.showMessageDialog(null, "Deposit Amount is not Entered");
				return;
			}
			
			try {
				ConnectionClass conn = new ConnectionClass();
				String query = "insert into customers (id_type,id_number,cust_name,address,checkintime,roomno,gender,deposit) values('"+id+"','"+number+"','"+name+"','"+address+"','"+time+"','"+room+"','"+gender+"','"+deposit+"');";
				String query2="update rooms set availability = '"+"Occupied"+"' where roomno = '"+room+"'";
				conn.stm.executeUpdate(query);
				conn.stm.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null, "New Customer added successfully");
				setVisible(false);
				new Reception();
				
			} catch(Exception e) {
				// for dummy demo //
				JOptionPane.showMessageDialog(null,"Database is not Connected / Some Error Occured");
				setVisible(false);
				//-------------------------//
				e.printStackTrace();
			}
			
			
	
		} else if(ae.getSource()==cancel) {
//			new Dashboard();
			setVisible(false);
			new Reception();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddCustomer();
	}

}
