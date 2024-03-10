package hotelManagementSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Reception extends JFrame implements ActionListener {

	JButton logout,searchroom,pickup,roomstatus,update,checkout,customerInfo,newCustomer,rooms,department,allEmployees,managerInfo;
	Reception(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		newCustomer = new JButton("New Customer");
		newCustomer.setBounds(25,20,200,30);
		newCustomer.setBackground(Color.BLACK);
		newCustomer.setForeground(Color.WHITE);
		newCustomer.addActionListener(this);
		add(newCustomer);
		
		rooms = new JButton("Rooms");
		rooms.setBounds(25,60,200,30);
		rooms.setBackground(Color.BLACK);
		rooms.setForeground(Color.WHITE);
		rooms.addActionListener(this);
		add(rooms);
		
		department = new JButton("Department");
		department.setBounds(25,100,200,30);
		department.setBackground(Color.BLACK);
		department.setForeground(Color.WHITE);
		department.addActionListener(this);
		add(department);
		
		allEmployees = new JButton("All Employees");
		allEmployees.setBounds(25,140,200,30);
		allEmployees.setBackground(Color.BLACK);
		allEmployees.setForeground(Color.WHITE);
		allEmployees.addActionListener(this);		
		add(allEmployees);
		
		managerInfo = new JButton("Manager Info");
		
		managerInfo.setBackground(Color.BLACK);
		managerInfo.setBounds(25,180,200,30);
		managerInfo.setForeground(Color.WHITE);
		managerInfo.addActionListener(this);
		add(managerInfo);
		
		customerInfo = new JButton("Customer Info");		
		customerInfo.setBounds(25,220,200,30);
		customerInfo.setBackground(Color.BLACK);
		customerInfo.setForeground(Color.WHITE);
		customerInfo.addActionListener(this);	
		add(customerInfo);
		
		
		
		checkout = new JButton("Check Out");
		checkout.setBounds(25,260,200,30);
		checkout.setBackground(Color.BLACK);
		checkout.setForeground(Color.WHITE);
		checkout.addActionListener(this);	
		add(checkout);
		
		update = new JButton("Update Billing Status");
		update.setBounds(25,300,200,30);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.addActionListener(this);	
		add(update);
		
		roomstatus = new JButton("Update Room Status");
		roomstatus.setBounds(25,340,200,30);
		roomstatus.setBackground(Color.BLACK);
		roomstatus.setForeground(Color.WHITE);
		roomstatus.addActionListener(this);	
		add(roomstatus);
		
		pickup = new JButton("Pick-Up Service");
		pickup.setBounds(25,380,200,30);
		pickup.setBackground(Color.BLACK);
		pickup.setForeground(Color.WHITE);
		pickup.addActionListener(this);	
		add(pickup);
		
		searchroom = new JButton("Search Room");
		searchroom.setBounds(25,420,200,30);
		searchroom.setBackground(Color.BLACK);
		searchroom.setForeground(Color.WHITE);
		searchroom.addActionListener(this);	
		add(searchroom);
		
		logout = new JButton("Log Out");
		logout.setBounds(25,460,200,30);
		logout.setBackground(Color.BLACK);
		logout.setForeground(Color.RED);
		logout.addActionListener(this);	
		add(logout);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(250,20,500,470);
		add(image);

		
		
		setBounds(283,180,800,550);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Reception();
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==newCustomer) {
			setVisible(false);
			new AddCustomer();
		}
		else if(ae.getSource()==rooms) {
			setVisible(false);
			new Room();
		}
		else if(ae.getSource()==department) {
			setVisible(false);
			new Department();
		}
		
		else if(ae.getSource()==allEmployees) {
			setVisible(false);
			new EmployeeInfo();
		}
		
		else if(ae.getSource()==managerInfo) {
			setVisible(false);
			new ManagerInfo();
		}
		
		else if(ae.getSource()==searchroom) {
			setVisible(false);
			new SearchRoom();
		}
		
		else if(ae.getSource()==customerInfo) {
			setVisible(false);
			new CustomerInfo();
		}
		
		else if(ae.getSource()==update) {
			setVisible(false);
			new UpdateStatus();
		}
		
		else if(ae.getSource()==roomstatus) {
			setVisible(false);
			new UpdateRoomStatus();
		}
		
		else if(ae.getSource()==pickup) {
			setVisible(false);
			new PickupService();
		}
		else if(ae.getSource()==logout) {
			setVisible(false);
			System.exit(0);
		}
	}

}
