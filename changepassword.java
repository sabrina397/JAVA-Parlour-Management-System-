import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class changepassword implements ActionListener 
{
	data d = new data();
	private String uname;
	private JFrame password = new JFrame();
	private JLabel oldp = new JLabel("Old password");
	private JLabel newp = new JLabel("New Password");
	private JPasswordField oldpassword = new JPasswordField();
	private JPasswordField newpassword = new JPasswordField();
	private JButton update = new JButton("Update");
	private JButton back = new JButton("Back");

	changepassword(String username) 
	{
		uname = username;
		password.setVisible(true);
		password.setLayout(null);
		password.setSize(500, 500);
		password.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		oldp.setBounds(100, 50, 100, 30);
		newp.setBounds(100, 90, 100, 30);
		oldpassword.setBounds(210, 50, 130, 30);
		newpassword.setBounds(210, 90, 130, 30);
		update.setBounds(150, 140, 120, 20);
		back.setBounds(10, 10, 120, 20);
		
		password.add(oldp);
		password.add(oldpassword);
		password.add(newp);
		password.add(newpassword);
		password.add(update);
		password.add(back);
		
		oldpassword.setEchoChar('*');
		newpassword.setEchoChar('*');
		update.addActionListener(this);
		back.addActionListener(this);
	}

	//overriding actionPerformed() method
	 
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == update)
		{
			String psd = new String(oldpassword.getPassword());
			String npsd = new String(newpassword.getPassword());
			if (npsd.equals("")) 
			{
				JOptionPane.showMessageDialog(password, "Give the password");
				return; 
			}
			
			boolean matched = d.checkoldpassword(uname, psd); 
			
			if (matched)
			{
				d.updatepassword(uname, npsd);
				JOptionPane.showMessageDialog(password, "Password changed successfully");
			}
			else
				JOptionPane.showMessageDialog(password, "Wrong Old password");
		} 
		else if (e.getSource() == back)
		{
			password.setVisible(false);
			start s = new start();
			s.back(uname);
		}
	}
}