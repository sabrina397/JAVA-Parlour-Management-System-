import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class start implements ActionListener 
{
	data d = new data();
	
	//create JFrames
	
	private JFrame first = new JFrame();

	//create JLabel
	 
	private ImageIcon image1 = new ImageIcon(getClass().getResource("welcom.png"));
	private JLabel welcome = new JLabel(image1);

	//create JButtons
	 
	private JButton signup = new JButton("Sign up");
	private JButton signin = new JButton("Log In");

	//Constructor
	
	start()
	{
		//Setup first JFrame
		
		first.setSize(600, 400);
		first.setVisible(true);
		first.setLayout(null);
		first.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Add component to JFrame
		 
		first.add(welcome);
		first.add(signup);
		first.add(signin);
		
		//Set bounds of components
		
		welcome.setBounds(100, 20, 350, 70);
		signin.setBounds(400, 180, 120, 40);
		signup.setBounds(400, 230, 120, 40);

		//Add JButtons to ActionListener
		
		
		signup.addActionListener(this);
		signin.addActionListener(this);
	}

	//overriding actionPerformed() method
	 
	@Override
	public void actionPerformed(ActionEvent e) 
	{ 
		//Actions against JButtons
													 
		if (e.getSource() == signup)
		{
			first.setVisible(false);
			signup s = new signup();
		}

		else if (e.getSource() == signin)
		{
			first.setVisible(false);
			signin s = new signin();
		}

	}

	public void back(String uname)
	{
		first.setVisible(false);
		try 
		{
			String st = d.getuserstatus(uname);
			if (st.equals("2")) 
			{
				admin a = new admin();
			} 
			else if (st.equals("1"))
			{
				user u = new user(uname);
			} 
			else 
			{
				employee e = new employee(uname);
			}
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

	//defining main method
	 
	public static void main(String[] args)
	{
		//Creating object of start class

		start s = new start();
	}
}