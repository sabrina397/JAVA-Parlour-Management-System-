import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class admin implements ActionListener 
{
	//create object of data class
	
	data d = new data();
	
	String aprvuser;
	
	//create JFrameS
	
	private JFrame adm = new JFrame();
	private JFrame remove = new JFrame();
	private JFrame addEmpFrame = new JFrame();
	private JFrame showEmpFrame = new JFrame();
	private JFrame showCustFrame = new JFrame();
	private JFrame aprv = new JFrame();
	private JFrame bookingFrame = new JFrame();
	
	//create JButton
	
	private JButton addEmployee = new JButton("Add Employee");
	private JButton deleteEmployee = new JButton("Delete Employee");
	private JButton showEmployee = new JButton("All Employee");
	private JButton aproveuser = new JButton("Approve Customer");
	private JButton showCustomer = new JButton("All Customer");
	private JButton showBooking = new JButton("Booking Info");
	private JButton changepassword = new JButton("Change Password");
	private JButton back = new JButton("Back");
	private JButton back1 = new JButton("Back");
	private JButton logout = new JButton("Log out");

	private JTextField firstname = new JTextField();
	private JTextField lastname = new JTextField();
	private JTextField email = new JTextField();
	private JTextField mobile = new JTextField();
	private JTextField username = new JTextField();
	
	private Choice year = new Choice();
	private Choice month = new Choice();
	private Choice date = new Choice();
	private Choice bloodGroup = new Choice();
	private Choice gender = new Choice();

	//create JPasswordFields
	 
	private JPasswordField password = new JPasswordField();
	private JPasswordField rpassword = new JPasswordField();
	
	//create JLabels
	
	private JLabel fname = new JLabel("First name");
	private JLabel lname = new JLabel("Email");
	private JLabel uname = new JLabel("User name");
	private JLabel lastnameLabel = new JLabel("Last Name");
	private JLabel mobileLabel = new JLabel("Mobile");
	private JLabel pass = new JLabel("Password");
	private JLabel rpass = new JLabel("Retype Password");
	private JLabel genderLabel = new JLabel("Gender");
	private JLabel dobLabel = new JLabel("DOB");
	private JLabel bloodGroupLabel = new JLabel("Blood Group");

	//create List
	
	private List user = new List(2, false);
	private List users = new List(2, false);
	
	//create JLabel
	
	private JLabel unaproved = new JLabel("Unaproved user");
	private JLabel userlist = new JLabel("User List");
	private JLabel welcome = new JLabel("Hello   Admin!");
	
	//create JButtons
	
	private JButton aprove = new JButton("Aprove");
	private JButton addEmpButton = new JButton("Add");
	private JButton backEmpButton = new JButton("Back");
	private JButton backEmpButton2 = new JButton("Back");
	private JButton backEmpButton3 = new JButton("Back");
	private JButton viewBookingBackButton = new JButton("Back");

	//private JButton home = new JButton("Home");
	private JButton remov = new JButton("Remove");
	private String[] months = new String[] { "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct",
			"nov", "dec" };

	//Constructor
	
	admin()
	{
		//Setup JFrames
		
		gender.add("Male");
		gender.add("Female");
		bloodGroup.add("A+");
		bloodGroup.add("B+");
		bloodGroup.add("O+");
		bloodGroup.add("O-");
		bloodGroup.add("AB+");
		bloodGroup.add("AB-");
		
		for (int i = 1970; i < 2005; i++)
		{
			year.add(Integer.toString(i));
		}
		for (int i = 0; i < 12; i++)
		{
			month.add(months[i]);
		}
		for (int i = 1; i < 32; i++)
		{
			date.add(Integer.toString(i));
		}
		
		adm.setVisible(true);
		adm.setLayout(null);
		adm.setSize(1150, 800);
		adm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		adm.add(addEmployee);
		adm.add(deleteEmployee);
		adm.add(showEmployee);
		adm.add(aproveuser);
		adm.add(showCustomer);
		adm.add(showBooking);
		adm.add(changepassword);
		adm.add(logout);
		adm.add(welcome);
		
		aprv.setLayout(null);
		addEmpFrame.setLayout(null);
		showEmpFrame.setLayout(null);
		showCustFrame.setLayout(null);
		remove.setLayout(null);
		
		aprv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		remove.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addEmpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		showEmpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		showCustFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		bookingFrame.add(viewBookingBackButton);
		aprv.setSize(400, 400);
		addEmpFrame.setSize(800, 800);
		showEmpFrame.setSize(800, 800);
		showCustFrame.setSize(800, 800);
		remove.setSize(400, 400);
		
		//Add components to JFrames
		
		aprv.add(unaproved);
		aprv.add(back);
		aprv.add(user);
		aprv.add(aprove);
		remove.add(userlist);
		remove.add(users);
		remove.add(remov);
		remove.add(back1);
		
		welcome.setBounds(410, 200, 500, 60);
		welcome.setFont(new Font("Serif", Font.BOLD, 50));
		addEmployee.setBounds(20, 350, 120, 30);
		deleteEmployee.setBounds(145, 350, 140, 30);
		showEmployee.setBounds(290, 350, 120, 30);
		aproveuser.setBounds(415, 350, 140, 30);
		showCustomer.setBounds(560, 350, 120, 30);
		showBooking.setBounds(685, 350, 120, 30);
		changepassword.setBounds(810, 350, 150, 30);
		logout.setBounds(965, 350, 110, 30);
		unaproved.setBounds(20, 20, 130, 30);
		userlist.setBounds(20, 20, 130, 30);
		back.setBounds(200, 20, 100, 20);
		back1.setBounds(200, 20, 100, 20);
		user.setBounds(20, 60, 100, 150);
		users.setBounds(20, 60, 100, 150);
		aprove.setBounds(50, 230, 100, 20);
		remov.setBounds(50, 230, 100, 20);
		
		//Add JButtons to ActionListener
		
		viewBookingBackButton.addActionListener(this);
		aproveuser.addActionListener(this);
		addEmpButton.addActionListener(this);
		backEmpButton.addActionListener(this);
		backEmpButton2.addActionListener(this);
		backEmpButton3.addActionListener(this);
		deleteEmployee.addActionListener(this);
		addEmployee.addActionListener(this);
		showEmployee.addActionListener(this);
		showCustomer.addActionListener(this);
		showBooking.addActionListener(this);
		remov.addActionListener(this);
		aprove.addActionListener(this);
		changepassword.addActionListener(this);
		back.addActionListener(this);
		back1.addActionListener(this);
		logout.addActionListener(this);
		
		// add employee

		addEmpFrame.add(firstname);
		addEmpFrame.add(fname);
		addEmpFrame.add(email);
		addEmpFrame.add(lname);
		addEmpFrame.add(mobile);
		addEmpFrame.add(mobileLabel);
		addEmpFrame.add(username);
		addEmpFrame.add(uname);
		addEmpFrame.add(lastnameLabel);
		addEmpFrame.add(lastname);
		addEmpFrame.add(password);
		addEmpFrame.add(rpassword);
		addEmpFrame.add(pass);
		addEmpFrame.add(rpass);
		addEmpFrame.add(gender);
		addEmpFrame.add(genderLabel);
		addEmpFrame.add(bloodGroupLabel);
		addEmpFrame.add(dobLabel);
		addEmpFrame.add(bloodGroup);
		addEmpFrame.add(date);
		addEmpFrame.add(month);
		addEmpFrame.add(year);
		addEmpFrame.add(addEmpButton);
		addEmpFrame.add(backEmpButton);

		showEmpFrame.add(backEmpButton2);
		showCustFrame.add(backEmpButton3);
		
		fname.setBounds(20, 20, 150, 30);
		genderLabel.setBounds(20, 60, 150, 30);
		mobileLabel.setBounds(20, 100, 150, 30);
		lname.setBounds(20, 140, 150, 30);
		uname.setBounds(20, 180, 150, 30);
		pass.setBounds(20, 220, 150, 30);
		rpass.setBounds(20, 260, 150, 30);
		bloodGroupLabel.setBounds(20, 300, 150, 30);
		dobLabel.setBounds(20, 340, 150, 30);
		lastnameLabel.setBounds(370, 20, 150, 30);
		firstname.setBounds(185, 20, 150, 30);
		gender.setBounds(185, 60, 150, 30);
		mobile.setBounds(185, 100, 150, 30);
		email.setBounds(185, 140, 150, 30);
		lastname.setBounds(515, 20, 150, 30);
		username.setBounds(185, 180, 150, 30);
		password.setBounds(185, 220, 150, 30);
		rpassword.setBounds(185, 260, 150, 30);
		bloodGroup.setBounds(185, 300, 150, 30);
		date.setBounds(185, 340, 50, 30);
		month.setBounds(240, 340, 50, 30);
		year.setBounds(295, 340, 50, 30);
		addEmpButton.setBounds(200, 400, 100, 20);
		backEmpButton.setBounds(0, 0, 100, 20);
		backEmpButton2.setBounds(0, 0, 100, 20);
		backEmpButton3.setBounds(0, 0, 100, 20);
		viewBookingBackButton.setBounds(0, 0, 100, 20);

		String[] col = { "Firstname", "Lastname", "Username", "Gender", "Email", "Mobile" };
		String[][] data = d.getEmployeeList();
		String[][] cdata = d.getCustomerList();
		JTable employeeTable = new JTable(data, col);
		JTable customerTable = new JTable(cdata, col);
		showEmpFrame.add(employeeTable);
		employeeTable.setBounds(200, 100, 500, 500);
		showCustFrame.add(customerTable);
		customerTable.setBounds(200, 100, 500, 500);
		
		String[] col3 = { "uname", "Stylist", "Service", "Code" };
		String[][] data3 = d.getBookingList();
		JTable bookingTable = new JTable(data3, col3);
		bookingFrame.setLayout(null);
		bookingFrame.add(bookingTable);

		bookingFrame.setSize(800, 800);
		bookingTable.setBounds(100, 100, 400, 200);
		bookingTable.setSize(400,200);
	}

	public void aproving()
	{
		//Set aprv JFrame visible
		
		aprv.setVisible(true);
		
		//Call list method
		
		list();
	}

	public void removing()
	{
		//Set aprv JFrame visible
		
		remove.setVisible(true);
		
		//Call lists method
		
		lists();
	}

	public void list()
	{
		int count = d.unaprovedusercounter();
		String[] lst = new String[count];
		lst = d.unaproveduser();
		int sz = lst.length;
		for (int k = 0; k < sz; k++) 
		{
			//Add elements to user list
			
			user.add(lst[k]);
		}
	}

	public void lists() 
	{
		int count = d.aprovedusercounter();
		String[] ls = new String[count];
		ls = d.aproveduser();
		int sz = ls.length;
		for (int k = 0; k < sz; k++) 
		{
			//Add elements to users list
			 
			users.add(ls[k]);
		}
	}

	//overriding actionPerformed() method
	 
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == showEmployee)
		{
			adm.setVisible(false);
			showEmpFrame.setVisible(true);
		} 
		else if (e.getSource() == showBooking)
		{
			adm.setVisible(false);
			bookingFrame.setVisible(true);
		} 
		else if (e.getSource() == showCustomer)
		{
			adm.setVisible(false);
			showCustFrame.setVisible(true);
		}
		else if (e.getSource() == aproveuser) 
		{
			adm.setVisible(false);
			aproving();
		}
		else if (e.getSource() == backEmpButton || e.getSource() == backEmpButton2 || e.getSource() == backEmpButton3
				|| e.getSource() == viewBookingBackButton) 
		{
			addEmpFrame.setVisible(false);
			showEmpFrame.setVisible(false);
			showCustFrame.setVisible(false);
			bookingFrame.setVisible(false);
			admin a = new admin();
		}
		else if (e.getSource() == addEmployee) 
		{
			adm.setVisible(false);
			addEmpFrame.setVisible(true);
		}
		else if (e.getSource() == deleteEmployee) 
		{
			adm.setVisible(false);
			removing();
		}
		else if (e.getSource() == addEmpButton)
		{
			int check = 0;
			String pas = new String(password.getPassword());
			String genderValue = gender.getItem(gender.getSelectedIndex());
			System.out.print(genderValue);
			String rpas = new String(rpassword.getPassword());
			String fn = firstname.getText();
			String em = email.getText();
			String un = username.getText();
			String mb = mobile.getText();
			String lastnameValue = lastname.getText();
			String dobValue = date.getItem(date.getSelectedIndex()) + "/" + month.getItem(month.getSelectedIndex())
					+ "/" + year.getItem(year.getSelectedIndex());
			String bloodGroupValue = bloodGroup.getItem(bloodGroup.getSelectedIndex());
			if (fn.equals("") || em.equals("") || un.equals("") || lastnameValue.equals("") || mb.equals("")) 
			{
				JOptionPane.showMessageDialog(addEmpFrame, "Fill empty fields");
			}
			else
			{
				if (pas.equals(rpas))
				{
					String user = username.getText();
					boolean exist = d.checkuser(user);
					if (exist ) 
					{
						JOptionPane.showMessageDialog(addEmpFrame, "Username already used");
					} 
					else
					{
						JOptionPane.showMessageDialog(addEmpFrame, "Employee added Successfully");
						String sql = "INSERT INTO user_info  VALUES (null,'" + fn + "','" + lastnameValue + "','" + un
								+ "','" + pas + "','" + genderValue + "','5','" + em + "','" + mb + "','"
								+ bloodGroupValue + "','" + dobValue + "')";
						d.query(sql);
					}
				}
				else
					JOptionPane.showMessageDialog(addEmpFrame, "Password doesnt match");
			}
		} 
		else if (e.getSource() == aprove) 
		{
			int i[];
			i = user.getSelectedIndexes();
			for (int j = 0; j < i.length; j++)
				aprvuser = user.getItem(i[j]);
			d.aproveuser(aprvuser);
			JOptionPane.showMessageDialog(aprv, aprvuser + " has been approved");
			user.removeAll();
			list();
		} 
		else if (e.getSource() == remov) 
		{
			int i[];
			i = users.getSelectedIndexes();
			for (int j = 0; j < i.length; j++)
				aprvuser = users.getItem(i[j]);
			d.removeuser(aprvuser);
			JOptionPane.showMessageDialog(remove, aprvuser + " has been removed");
			users.removeAll();
			lists();
		} 
		else if (e.getSource() == changepassword)
		{
			adm.setVisible(false);
			changepassword c = new changepassword("admin");
		}
		else if (e.getSource() == back) 
		{
			aprv.setVisible(false);
			admin a = new admin();
		}
		else if (e.getSource() == back1)
		{
			remove.setVisible(false);
			admin a = new admin();
		} 
		else if (e.getSource() == logout)
		{
			adm.setVisible(false);
			signin s = new signin();
		}
	}
}