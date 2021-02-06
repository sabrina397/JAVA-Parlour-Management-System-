import javax.swing.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.awt.*;
import java.util.UUID;

class user implements ActionListener 
{
	data d = new data();
	
	private String username;
	
	private JFrame userfst = new JFrame();
	private JFrame newBookingFrame = new JFrame();
	private JFrame myBookingFrame = new JFrame();
	
	private JButton bookingButton = new JButton("New Booking");
	private JButton myBookingButton = new JButton("My Bookings");
	private JButton changepassword = new JButton("Change Password");
	private JButton logout = new JButton("Log Out");
	
	private Choice serviceNames = new Choice();
	private Choice employeeNames = new Choice();

	private JLabel serviceLabel = new JLabel("Service");
	private JLabel employeeLabel = new JLabel("Stylist");
	private JButton newBookingBackButton = new JButton("Back");
	private JButton myBookingBackButton = new JButton("Back");
	private JButton confirmBookingButton = new JButton("Confirm");

	user(String name)
	{
		username = name;

		JLabel welcome = new JLabel("Welcome   " + username);
		welcome.setFont(new Font("Serif", Font.BOLD, 50));
		
		userfst.setVisible(true);
		userfst.setLayout(null);
		userfst.setSize(700, 600);
		userfst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userfst.add(bookingButton);
		userfst.add(myBookingButton);
		userfst.add(changepassword);
		userfst.add(logout);
		userfst.add(welcome);

		newBookingFrame.setVisible(false);
		newBookingFrame.setLayout(null);
		newBookingFrame.setSize(700, 600);
		newBookingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newBookingFrame.add(serviceLabel);
		newBookingFrame.add(serviceNames);
		newBookingFrame.add(employeeLabel);
		newBookingFrame.add(employeeNames);
		newBookingFrame.add(confirmBookingButton);
		
		String[] employees = d.employees();
		String[] services = d.services();
		for (int i = 0; i < Array.getLength(employees); i++)
		{
			try
			{
				employeeNames.add(employees[i]);
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
		for (int i = 0; i < Array.getLength(services); i++)
		{
			try 
			{
				serviceNames.add(services[i]);
			}
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}

		myBookingFrame.setVisible(false);
		myBookingFrame.setLayout(null);
		myBookingFrame.setSize(900, 600);
		myBookingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myBookingFrame.add(myBookingBackButton);
		String[] col = { "uname", "a", "hh" };
		String[][] data = d.getBookingListByCustomer(username);

		JTable bookingTable = new JTable(data, col);
		myBookingFrame.add(bookingTable);

		bookingTable.setBounds(50, 100, 750, 500);

		welcome.setBounds(210, 200, 500, 60);

		welcome.setFont(new Font("Serif", Font.BOLD, 50));
		bookingButton.setBounds(20, 350, 120, 30);
		myBookingButton.setBounds(145, 350, 140, 30);
		changepassword.setBounds(290, 350, 120, 30);
		logout.setBounds(415, 350, 140, 30);
		newBookingBackButton.setBounds(0, 0, 100, 20);
		serviceLabel.setBounds(50, 100, 90, 20);
		serviceNames.setBounds(155, 100, 120, 20);
		employeeLabel.setBounds(280, 100, 80, 20);
		employeeNames.setBounds(360, 100, 120, 20);
		confirmBookingButton.setBounds(490, 100, 120, 20);
		myBookingFrame.add(myBookingBackButton);
		newBookingFrame.add(newBookingBackButton);
		bookingButton.addActionListener(this);
		confirmBookingButton.addActionListener(this);
		myBookingBackButton.setBounds(0, 0, 100, 20);
		changepassword.addActionListener(this);
		logout.addActionListener(this);
		myBookingButton.addActionListener(this);
		newBookingBackButton.addActionListener(this);
		myBookingBackButton.addActionListener(this);
	}

	//overriding actionPerformed() method
	 
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == bookingButton)
		{
			userfst.setVisible(false);
			newBookingFrame.setVisible(true);
		} 
		else if (e.getSource() == myBookingBackButton)
		{
			myBookingFrame.setVisible(false);
			user u = new user(username);
		}
		else if (e.getSource() == confirmBookingButton)
		{
			String service = serviceNames.getItem(serviceNames.getSelectedIndex());
			String employee = employeeNames.getItem(employeeNames.getSelectedIndex());
			String random = UUID.randomUUID().toString();
			String customer = username;
			String sql = "INSERT INTO bookings VALUES (null,'" + customer + "','" + employee + "','" + service + "',0,'"
					+ random + "')";
			System.out.print(sql);
			JOptionPane.showMessageDialog(newBookingFrame, "Booking confirmed successfully");
			d.query(sql);
		} 
		else if (e.getSource() == newBookingBackButton)
		{
			newBookingFrame.setVisible(false);
			user u = new user(username);
		} 
		else if (e.getSource() == myBookingButton) 
		{
			userfst.setVisible(false);
			myBookingFrame.setVisible(true);
		} 
		else if (e.getSource() == changepassword) 
		{
			userfst.setVisible(false);
			changepassword c = new changepassword(username);
		}
		else if (e.getSource() == logout) 
		{
			userfst.setVisible(false);
			signin s = new signin();
		}
	}
}