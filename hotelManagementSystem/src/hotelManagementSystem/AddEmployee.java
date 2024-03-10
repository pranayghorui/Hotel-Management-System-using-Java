package hotelManagementSystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener {

	JTextField tfname,tfage ,tfsalary,tfphone,tfemail,tfaadhar;
	JRadioButton rbmale,rbfemale;
	JButton submit,cancel;
	JComboBox<String> cbjob;
	
	AddEmployee(){
		setLayout(null);
		JLabel lblhead = new JLabel("Employee Details");
		lblhead.setBounds(360,0,150,20);
		lblhead.setFont(new Font("Garamond", Font.BOLD,18)); // Futura,Helvetica  ,Garamond ,Courier, Tahoma
		add(lblhead);
		// Name
		JLabel lblname = new JLabel("NAME");
		lblname.setBounds(60,30,120,30);
		lblname.setFont(new Font("Helvetica", Font.PLAIN,16)); // Futura,Helvetica  ,Garamond ,Courier, Tahoma
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(200,30,150,30);
		add(tfname);
		
		// Age
		JLabel lblage = new JLabel("AGE");
		lblage.setBounds(60,80,120,30);
		lblage.setFont(new Font("Helvetica", Font.PLAIN,16)); // Futura,Helvetica  ,Garamond ,Courier, Tahoma
		add(lblage);
		
		tfage = new JTextField();
		tfage.setBounds(200,80,150,30);
		add(tfage);
		
		//Gender
		JLabel lblgender = new JLabel("GENDER");
		lblgender.setBounds(60,130,120,30);
		lblgender.setFont(new Font("Helvetica", Font.PLAIN,16)); // Futura,Helvetica  ,Garamond ,Courier, Tahoma
		add(lblgender);
		
		rbmale = new JRadioButton("Male");
		rbmale.setBounds(200,130,60,30);
		rbmale.setFont(new Font("Courier",Font.PLAIN,14));
		rbmale.setBackground(Color.WHITE);
		add(rbmale);
		
		rbfemale = new JRadioButton("Female");
		rbfemale.setBounds(270,130,80,30);
		rbfemale.setFont(new Font("Courier",Font.PLAIN,14));
		rbfemale.setBackground(Color.WHITE);
		add(rbfemale);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbfemale);
		bg.add(rbmale);
		
		// Job
		JLabel lbljob = new JLabel("JOB");
		lbljob.setBounds(60,180,120,30);
		lbljob.setFont(new Font("Helvetica", Font.PLAIN,16)); // Futura,Helvetica  ,Garamond ,Courier, Tahoma
		add(lbljob);
			// job drop down menu
		String str[] = {"Front Dest Clerk","Porter","Housekeeping","Room Service","Kitchen Staff","Chef","Waiter/Waitress","Manager","Accountant"};
		cbjob = new JComboBox<>(str);  // dropdown
		cbjob.setBounds(200,180,150,30);
		cbjob.setBackground(Color.WHITE);
		add(cbjob);
		
		// salary
		JLabel lblsalary = new JLabel("SALARY");
		lblsalary.setBounds(60,230,120,30);
		lblsalary.setFont(new Font("Helvetica", Font.PLAIN,16)); // Futura,Helvetica  ,Garamond ,Courier, Tahoma
		add(lblsalary);
		
		tfsalary = new JTextField();
		tfsalary.setBounds(200,230,150,30);
		add(tfsalary);
		
		//phone
		JLabel lblphone = new JLabel("PHONE NO");
		lblphone.setBounds(60,280,120,30);
		lblphone.setFont(new Font("Helvetica", Font.PLAIN,16)); // Futura,Helvetica  ,Garamond ,Courier, Tahoma
		add(lblphone);
		
		tfphone = new JTextField();
		tfphone.setBounds(200,280,150,30);
		add(tfphone);
		
		//email
		JLabel lblemail = new JLabel("EMAIL");
		lblemail.setBounds(60,330,120,30);
		lblemail.setFont(new Font("Helvetica", Font.PLAIN,16)); // Futura,Helvetica  ,Garamond ,Courier, Tahoma
		add(lblemail);
		
		tfemail = new JTextField();
		tfemail.setBounds(200,330,150,30);
		add(tfemail);
		
		// AADHAR
		JLabel lblaadhar = new JLabel("AADHAR NO");
		lblaadhar.setBounds(60,380,120,30);
		lblaadhar.setFont(new Font("Helvetica", Font.PLAIN,16)); // Futura,Helvetica  ,Garamond ,Courier, Tahoma
		add(lblaadhar);
		
		tfaadhar = new JTextField();
		tfaadhar.setBounds(200,380,150,30);
		add(tfaadhar);
		
		// submit button
		submit = new JButton("SUBMIT");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.ORANGE);
		submit.setFont(new Font("Courier", Font.BOLD,14)); // Futura,Helvetica  ,Garamond ,Courier, Tahoma
		submit.setBounds(60,441,120,30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setForeground(Color.BLUE);
		cancel.setBackground(Color.LIGHT_GRAY);
		submit.setFont(new Font("Courier", Font.BOLD,14));
		cancel.setBounds(230,441,120,30);
		cancel.addActionListener(this);
		add(cancel);
		//Image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 550, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(370,60,450,370);
		add(image);
		
		
		
		
//		getContentPane().setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setBounds(258,180,860,540);
		setVisible(true);
		
		
		
		
	}
	
//	@override
	public void actionPerformed( ActionEvent ae) {
		if(ae.getSource()==submit) {
			String name= tfname.getText();
			String age= tfage.getText();
			String salary= tfsalary.getText();
			String phone= tfphone.getText();
			String email= tfemail.getText();
			String aadhar= tfaadhar.getText();
			String job = (String)cbjob.getSelectedItem();  // .getSelectedItem(); it returns a object so type cast to string
			String gender=null;
			if(rbmale.isSelected()) {
				gender="Male";
			}else if(rbfemale.isSelected()) {
				gender="Female";
			}
			
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name should not be empty");
				return;
			}
			if(age.equals("")) {
				JOptionPane.showMessageDialog(null, "Age should not be empty");
				return;
			}
			if(salary.equals("")) {
				JOptionPane.showMessageDialog(null, "Salary should not be empty");
				return;
			}
			if(phone.equals("")) {
				JOptionPane.showMessageDialog(null, "Phone should not be empty");
				return;
			}
			if(aadhar.equals("")) {
				JOptionPane.showMessageDialog(null, "Aadhar No. should not be empty");
				return;
			}
			
			if(gender.equals("")) {
				JOptionPane.showMessageDialog(null, "Gender is not selected");
				return;
			}
			
			if(job.equals("")) {
				JOptionPane.showMessageDialog(null, "Job is not selected");
				return;
			}
			
			try {
				ConnectionClass conn =  new ConnectionClass();
				//(name varchar(25), age varchar(10), gender varchar(15), job varchar(30), salary varchar(15), phone varchar(13), email varchar(50), aadhar varchar(12));
				String query ="insert into employees(name,age,gender,job,salary,phone,email,aadhar) values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"');";
				conn.stm.executeUpdate(query); // noly for execution query. nothing is returned, so no ResultSet required.
				
				//popup messege
				JOptionPane.showMessageDialog(null,"Employee Added Successfully");
				/*
				 * want to show employee id
				String empid = "select empid from employees where aadhar ='"+aadhar+"';";
				ResultSet st = conn.stm.executeQuery(empid);
				int id;
				while(st.next()) {
					id = st.getInt("empid");
				}
		*/
				
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
			catch(Exception ee) {
				// for dummy demo //
				JOptionPane.showMessageDialog(null,"Database is not Connected / Some Error Occured");
				setVisible(false);
				//-------------------------//
				ee.printStackTrace();
			}
		}
		else {
//			new Dashboard();
			setVisible(false);
		}
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddEmployee();
	}

}
