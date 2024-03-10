package hotelManagementSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class AddDriver extends JFrame implements ActionListener{

	JButton add, cancel;
	JTextField tfname,tfage,tfcompany,tfmodel,tflocation,tfPhNo;
	JComboBox readyCombo,genderCombo;
	
	AddDriver(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		
		// Heading
		JLabel heading = new JLabel("Add Drivers");
		heading.setFont(new Font("Garamond", Font.BOLD, 18));
		heading.setBounds(380, 0, 140, 20);
		add(heading);
		
		//Name
		JLabel lblname = new JLabel("Name");
		lblname.setFont(new Font("Tahoma", Font.PLAIN,16));
		lblname.setBounds(60,30,120,30);
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(200,30,150,30);
		add(tfname);
		
		// Age
		JLabel lblage= new JLabel("Age");
		lblage.setFont(new Font("Tahoma", Font.PLAIN,16));
		lblage.setBounds(60,80,120,30);
		add(lblage);
		
		tfage = new JTextField();
		tfage.setBounds(200,80,150,30);
		add(tfage);
			
		// Gender
		JLabel lblgender = new JLabel("Gender");
		lblgender.setFont(new Font("Tahoma", Font.PLAIN,16));
		lblgender.setBounds(60,130,120,30);
		add(lblgender);
		
		String ageOptions[] = {"Male", "Female"};
		genderCombo = new JComboBox(ageOptions);
		genderCombo.setBounds(200,130,150,30);
		genderCombo.setBackground(Color.WHITE);
		add(genderCombo);
		
		// Car Company
		JLabel lblcompany= new JLabel("Car Company");
		lblcompany.setFont(new Font("Tahoma", Font.PLAIN,16));
		lblcompany.setBounds(60,180,120,30);
		add(lblcompany);
		
		tfcompany = new JTextField();
		tfcompany.setBounds(200,180,150,30);
		add(tfcompany);
		
		//car model
		JLabel lblmodel = new JLabel("Car Model");
		lblmodel.setFont(new Font("Tahoma", Font.PLAIN,16));
		lblmodel.setBounds(60,230,120,30);
		add(lblmodel);
		
		tfmodel = new JTextField();
		tfmodel.setBounds(200,230,150,30);
		add(tfmodel);
		
		//available
		JLabel lblready = new JLabel("Avalability");
		lblready.setFont(new Font("Tahoma", Font.PLAIN,16));
		lblready.setBounds(60,280,120,30);
		add(lblready);
		
		String readyOptions[] = {"Available", "Not Available"};
		readyCombo= new JComboBox(readyOptions);
		readyCombo.setBounds(200,280,150,30);
		readyCombo.setBackground(Color.WHITE);
		add(readyCombo);
		
		//Location
		JLabel lbllocation = new JLabel("Car Location");
		lbllocation.setFont(new Font("Tahoma", Font.PLAIN,16));
		lbllocation.setBounds(60,330,120,30);
		add(lbllocation);
		
		tflocation = new JTextField();
		tflocation.setBounds(200,330,150,30);
		add(tflocation);
		
		// ph no
		JLabel lblPhNo = new JLabel("Contact");
		lblPhNo.setFont(new Font("Tahoma", Font.PLAIN,16));
		lblPhNo.setBounds(60,380,120,30);
		add(lblPhNo);
		
		tfPhNo = new JTextField();
		tfPhNo.setBounds(200,380,150,30);
		add(tfPhNo);
		
		// Add Room button
		add = new JButton("Add Driver");
		add.setForeground(Color.ORANGE);
		add.setBackground(Color.BLACK);
		add.setBounds(400,380,130,30);
		add.addActionListener(this);
		add(add);
		// Cancel button
		cancel = new JButton("Cancel");
		cancel.setForeground(Color.BLUE);
		cancel.setBackground(Color.LIGHT_GRAY);
		cancel.setBounds(670,380,130,30);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1 = new 	ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
		Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
//		image.setBounds(400,52,400,350);
		image.setBounds(400,20,400,350);
		add(image);
		
//		setBounds(253,180,860,540);
		setBounds(253,180,860,540);
		setVisible(true);
		try {
			
		}
		catch(Exception e) {
			
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		/* 	JButton add, cancel;
	JTextField tfname,tfage,tfcompany,tfmodel,tflocation,tfPhNo;
	JComboBox readyCombo,ageCombo;	*/
		if(ae.getSource()==add) {
			String name = tfname.getText();
			String age = tfage.getText();
			String company = tfcompany.getText();
			String model = tfmodel.getText();
			String location = tflocation.getText();
			String available =(String) readyCombo.getSelectedItem();
			String gender = (String) genderCombo.getSelectedItem();
			String contact = tfPhNo.getText();
			
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is not Entered");
				return;
			}
			if(age.equals("")) {
				JOptionPane.showMessageDialog(null, "Age should not be Empty");
				return;
			}
			if(company.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter Car Company");
				return;
			}
			if(model.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter Car Model");
				return;
			}
			if(location.equals("")) {
				JOptionPane.showMessageDialog(null, "Location of Car is not Entered");
				return;
			}
			if(gender.equals("")) {
				JOptionPane.showMessageDialog(null, "Gender is not Select");
				return;
			}
			if(location.equals("")) {
				JOptionPane.showMessageDialog(null, "Location of Car is not Entered");
				return;
			}
			
			
			try {
				ConnectionClass conn = new ConnectionClass();
				String query ="insert into drivers (name,age,company,model,location,available,gender,contact) values ('"+name+"',"+age+",'"+company+"','"+model+"','"+location+"','"+available+"','"+gender+"','"+contact+"');";
				// for insert or update info in table-> executeUpdate
				conn.stm.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Cab Driver Added Successfully");
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
				// for dummy demo //
				JOptionPane.showMessageDialog(null,"Database is not Connected / Some Error Occured");
				setVisible(false);
				//-------------------------//
				e.printStackTrace();
			}
			
		} else {
//			new Dashboard();
			setVisible(false);
		}
	}
	
	
	public static void main(String[] args) {
		new AddDriver();
	}

	
}
