import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class signup implements ActionListener
{
	//create object of data class
	
	data d = new data();
	
	//create JFrames
	
	private JFrame registration = new JFrame();
	
	//create JButton
	
	private JButton sup = new JButton("Signup");
	private JButton back = new JButton("Back");

	//create JTextFields
	
	private JTextField firstname = new JTextField();
	private JTextField lastname = new JTextField();
	private JTextField email = new JTextField();
	private JTextField mobile = new JTextField();
	private JTextField username = new JTextField();
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

	signup() 
	{
		//Setup registration JFrame
		
		gender.add("Male");
		gender.add("Female");
		registration.setLayout(null);
		registration.setVisible(true);
		registration.setSize(800,600);
		registration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Add component in registration JFrame
		 
		registration.add(back);
		registration.add(sup);
		registration.add(firstname);
		registration.add(fname);
		registration.add(email);
		registration.add(lname);
		registration.add(mobile);
		registration.add(mobileLabel);
		registration.add(username);
		registration.add(uname);
		registration.add(lastnameLabel);
		registration.add(lastname);
		registration.add(password);
		registration.add(rpassword);
		registration.add(pass);
		registration.add(rpass);
		registration.add(gender);
		registration.add(genderLabel);

		//Set bounds of components
		
		fname.setBounds(20, 20, 150, 30);
		genderLabel.setBounds(20, 60, 150, 30);
		mobileLabel.setBounds(20, 100, 150, 30);
		lname.setBounds(20, 140, 150, 30);
		uname.setBounds(20, 180, 150, 30);
		pass.setBounds(20, 220, 150, 30);
		rpass.setBounds(20, 260, 150, 30);
		lastnameLabel.setBounds(370, 20, 150, 30);
		firstname.setBounds(185, 20, 150, 30);
		gender.setBounds(185, 60, 150, 30);
		mobile.setBounds(185, 100, 150, 30);
		email.setBounds(185, 140, 150, 30);
		lastname.setBounds(515, 20, 150, 30);
		username.setBounds(185, 180, 150, 30);
		password.setBounds(185, 220, 150, 30);
		rpassword.setBounds(185, 260, 150, 30);
		sup.setBounds(170, 330, 100, 60);
		back.setBounds(170, 410, 100, 60);

		//Add buttons to ActionListener
		
		sup.addActionListener(this);
		back.addActionListener(this);
	}

	//overriding actionPerformed() method
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//Action against button
		
		int check = 0;
		if (e.getSource() == sup) 
		{
			String pas = new String(password.getPassword());
			String genderValue = gender.getItem(gender.getSelectedIndex());
			System.out.print(genderValue);
			String rpas = new String(rpassword.getPassword());
			String fn = firstname.getText();
			String em = email.getText();
			String un = username.getText();
			String mb = mobile.getText();
			String lastnameValue = lastname.getText();
			
			if (fn.equals("") || em.equals("") || un.equals("") || lastnameValue.equals("") || mb.equals(""))
			{
				JOptionPane.showMessageDialog(registration, "Fill empty fields");
			}
			else 
			{
				if (pas.equals(rpas))
				{
					String user = username.getText();
					boolean exist = d.checkuser(user);
					if (exist) 
					{
						JOptionPane.showMessageDialog(registration, "Username already used");
					}
					else
					{
						JOptionPane.showMessageDialog(registration, "Registration Successfull");
						String sql = "INSERT INTO user_info VALUES (null,'" + fn + "','" + lastnameValue + "','" + un
								+ "','" + pas + "','" + genderValue + "','0','" + em + "','" + mb + "',' ',' ')";
						d.query(sql);
						registration.setVisible(false);
						start s = new start();
					}
				}
				else
					JOptionPane.showMessageDialog(registration, "Password doesnt match");
			}
		} 
		else if (e.getSource() == back) 
		{
			registration.setVisible(false);
			start s = new start();
		}
	}
}