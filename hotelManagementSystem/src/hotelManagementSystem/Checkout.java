package hotelManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.*;


public class Checkout extends JFrame implements ActionListener {
	
	Choice cCustomer;
	JTextField tfroomno, tfname,tfcheckin;
	JButton tick,checkout,back ;
	JLabel checkouttime,lblroomno,lblname,lblcheckin;
	
	Checkout(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("Check Out");
		text.setFont(new Font("Tahoma", Font.PLAIN,20));
		text.setBounds(100,20,100,30);
		text.setForeground(Color.BLUE);
		add(text);
		
		JLabel lblid = new JLabel("Customer ID");
		lblid.setBounds(30,80,100,30);
		add(lblid);
		
		cCustomer = new Choice();
		cCustomer.setBounds(170,80,130,25);
		add(cCustomer);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
		Image i2=i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		tick = new JButton(i3);
		tick.setBounds(310,80,20,20);
		tick.addActionListener(this);
		add(tick);
		
		lblroomno = new JLabel("Room Number");
		lblroomno.setBounds(30,130,100,20);
		add(lblroomno);
		
		tfroomno = new JTextField();
		tfroomno.setBounds(170,130,130,25);
		add(tfroomno);
		
		lblname = new JLabel("Customer Name");
		lblname.setBounds(30,180,100,20);
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(170,180,130,25);
		add(tfname);
		
		lblcheckin = new JLabel("Check In Time");
		lblcheckin.setBounds(30,230,100,20);
		add(lblcheckin);
		
		tfcheckin = new JTextField();
		tfcheckin.setBounds(170,230,130,25);
		add(tfcheckin);
		
		JLabel lblcheckouttime = new JLabel("Check Out Time");
		lblcheckouttime.setBounds(30,280,100,20);
		add(lblcheckouttime);
		
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :: HH:mm:ss");
		String currentDateTime = dateFormat.format(currentDate);

		checkouttime = new JLabel(""+currentDateTime);
		checkouttime.setBounds(170,280,130,25);
		add(checkouttime);
		
		checkout = new JButton("Check Out");
		checkout.setBackground(Color.BLACK);
		checkout.setForeground(Color.WHITE);
		checkout.setBounds(30,330,120,30);
		checkout.addActionListener(this);
		add(checkout);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(180,330,120,30);
		back.addActionListener(this);
		add(back);
		
		try {
			ConnectionClass conn = new ConnectionClass();
			ResultSet rs= conn.stm.executeQuery("select * from customers;");
//			ResultSet rs= conn.stm.executeQuery("select * from rooms where availability='Occupied';");
			
			while(rs.next()) {
				cCustomer.add(rs.getString("id_number"));
//				tfroomno.setText(rs.getString("roomno"));
//				tfname.setText(rs.getString("cust_name"));
//				tfcheckin.setText(rs.getString("checkintime"));
//				
//				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
		Image img2=img1.getImage().getScaledInstance(420, 280, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		JLabel image = new JLabel(img3);
		image.setBounds(350,60,400,320);
		add(image);
		
		setBounds(300,200,800,450);
		setVisible(true);
	}

	

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub

		int paidAmount = 0;
		 if(ae.getSource()==tick) {
			String id= cCustomer.getSelectedItem();
			String query= "select * from customers where id_number='"+id+"';";

			try {
				//tfroomno, tfname,tfcheckin
				ConnectionClass conn = new ConnectionClass();
				ResultSet rs=conn.stm.executeQuery(query);
				
				while(rs.next()) {
					tfroomno.setText(rs.getString("roomno"));
					tfname.setText(rs.getString("cust_name"));
					tfcheckin.setText(rs.getString("checkintime"));
					paidAmount=Integer.parseInt(rs.getString("deposit"));
				}
				
				
//				ConnectionClass conn2 = new ConnectionClass();
				ResultSet rs2 = conn.stm.executeQuery("select * from rooms where roomno='"+tfroomno.getText()+"';");
//				System.out.println("select * from rooms where roomno='"+tfroomno.getText()+"';");
				
				while(rs2.next()) {					
					String price= rs2.getString("price");
					int due = Integer.parseInt(price)-paidAmount;
					if(due>0) {
						JOptionPane.showMessageDialog(null, "Please Pay the Due Bill Amount");
						setVisible(false);
						new Reception();
					}
				}
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		}
		 else if(ae.getSource()==checkout) {
				String id= cCustomer.getSelectedItem();
				String query1= "delete from customers where id_number='"+id+"';";
				String query2="update rooms set availability='Available' where roomno='"+lblroomno.getText()+"';";
				try {
					ConnectionClass conn = new ConnectionClass();
					conn.stm.executeUpdate(query1);
					conn.stm.executeUpdate(query2);
					
					JOptionPane.showMessageDialog(null, "Check-Out Done");
					
					setVisible(false);
					new Reception();
					
				}
				catch(Exception e) {
					// for dummy demo //
					JOptionPane.showMessageDialog(null,"Database is not Connected / Some Error Occured");
					setVisible(false);
					//-------------------------//
					e.printStackTrace();
				}
			
			}
			else if(ae.getSource()==back){
				setVisible(false);
				new Reception();
			}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Checkout();
	}

}
