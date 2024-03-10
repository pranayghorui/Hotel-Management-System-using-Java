package hotelManagementSystem;
import java.awt.Image;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {
	Dashboard(){
		setBounds(0,0,1366,768); // my pc display resolution => in tutorial there is 1550,1000
		// post setBounds() will not if setLayout != null => default layout is border layout
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1366,768,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1366,768);
		add(image);
		
		JLabel text = new JLabel(" THE ROYAL INNS WELCOMES YOU");
		text.setBounds(305,90,730,50);
		text.setFont(new Font("Tahoma", Font.PLAIN,46));
		text.setForeground(Color.WHITE);
		image.add(text);
		
		JMenuBar mb = new JMenuBar();
		mb.setBounds(0,0,1366,30);
		image.add(mb);
		
		JMenu hotel = new JMenu("Hotel Management");
		hotel.setForeground(Color.DARK_GRAY);
		mb.add(hotel);
		
		JMenuItem reception = new JMenuItem("Reception");
		reception.addActionListener(this);
		hotel.add(reception);
		
		JMenu admin = new JMenu("Admin");
		admin.setForeground(Color.BLUE);
		mb.add(admin);
		
		JMenuItem addemployees = new JMenuItem("Add Employee");
		addemployees.addActionListener(this);
		admin.add(addemployees);
		
		JMenuItem addrooms = new JMenuItem("Add Room");
		addrooms.addActionListener(this);
		admin.add(addrooms);
		
		JMenuItem adddriver = new JMenuItem("Add Driver");
		adddriver.addActionListener(this);
		admin.add(adddriver);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Add Employee")) {
			new AddEmployee();
//			setVisible(false);
		}
		else if(ae.getActionCommand().equals("Add Room")) {
			new AddRooms();
//			setVisible(false);
		}
		else if(ae.getActionCommand().equals("Add Driver")) {
			new AddDriver();
//			setVisible(false);
		}
		else if(ae.getActionCommand().equals("Reception")) {
			new Reception();
//			setVisible(false);
		}
	}
	
	public static void main(String[]args) {
		new Dashboard();
	}
}
