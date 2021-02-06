import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class data {
	private String q;
	private int l = 0;
	//ekhon ok
	
	
	private String s;
	
	Connection con;
	Statement stmt;

	data() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/beauty", "root", "");
			// here data is database name, root is username and password is ""
			stmt = con.createStatement();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public int aprovedusercounter()
	{
		int i = 0;
		try 
		{
			String sql = "select* from user_info where status =1 ";
			stmt.executeQuery(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				i++;
			}
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		return i;
	}

	public String[][] getEmployeeList()
	{
		int i = 1; 
		int size = 0;
		try 
		{
			String sql1 = "select* from user_info where status=5";
			ResultSet rs1 = stmt.executeQuery(sql1);
			while (rs1.next()) 
			{
				size++;
			}
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		String[][] data = new String[size + 1][6]; 
		try 
		{
			String sql = "select* from user_info where status=5";
			ResultSet rs = stmt.executeQuery(sql);

			data[0][0] = "Firstname";
			data[0][1] = "Lastname";
			data[0][2] = "Username";
			data[0][3] = "Gender";
			data[0][4] = "Email";
			data[0][5] = "Mobile";
		
			while (rs.next()) 
			{
				data[i][0] = rs.getString("firstname");
				data[i][1] = rs.getString("lastname");
				data[i][2] = rs.getString("username");
				data[i][3] = rs.getString("gender");
				data[i][4] = rs.getString("email");
				data[i][5] = rs.getString("mobile");
				i++;
			}
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		return data;
	}

	public String[][] getBookingList()
	{
		int i = 1;
		int size = 0;
		try 
		{
			String sql1 = "select* from bookings";
			ResultSet rs1 = stmt.executeQuery(sql1);
			while (rs1.next()) 
			{
				size++;
			}
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		String[][] data = new String[size + 1][4];
		try
		{
			String sql = "select* from bookings";
			ResultSet rs = stmt.executeQuery(sql);

			data[0][0] = "Customer";
			data[0][1] = "Stylist";
			data[0][2] = "Service";
			data[0][3] = "Code";

			while (rs.next()) 
			{
				data[i][0] = rs.getString("customer_name");
				data[i][1] = rs.getString("employee_name");
				data[i][2] = rs.getString("service_name");
				data[i][3] = rs.getString("code");
				i++;
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return data;
	}

	public String[][] getBookingListByCustomer(String name) 
	{
		int i = 1;
		int size = 0;
		try 
		{
			String sql1 = "select* from bookings where customer_name='" + name + "'";
			ResultSet rs1 = stmt.executeQuery(sql1);
			while (rs1.next()) 
			{
				size++;
			}
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		String[][] data = new String[size + 1][3];
		try 
		{
			String sql = "select* from bookings where customer_name='" + name + "'";
			ResultSet rs = stmt.executeQuery(sql);
		
			data[0][0] = "Stylist";
			data[0][1] = "Service";
			data[0][2] = "Code";

			while (rs.next()) 
			{
				data[i][0] = rs.getString("employee_name");
				data[i][1] = rs.getString("service_name");
				data[i][2] = rs.getString("code");
				i++;
			}
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		return data;
	}

	public String[][] getBookingListByEmployee(String name)
	{
		int i = 1;
		int size = 0;
		try
		{
			String sql1 = "select* from bookings where employee_name='" + name + "'";
			ResultSet rs1 = stmt.executeQuery(sql1);
			while (rs1.next()) 
			{
				size++;
			}
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		String[][] data = new String[size + 1][4];
		try 
		{
			String sql = "select* from bookings where employee_name='" + name + "'";
			ResultSet rs = stmt.executeQuery(sql);
			
			data[0][0] = "Customer";
			data[0][1] = "Stylish";
			data[0][2] = "Service";
			data[0][3] = "Code";

			while (rs.next()) 
			{
				data[i][0] = rs.getString("customer_name");
				data[i][1] = rs.getString("employee_name");
				data[i][2] = rs.getString("service_name");
				data[i][3] = rs.getString("code");
				i++;
			}
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		return data;
	}

	public String[][] getCustomerList()
	{
		int i = 1;
		int size = 0;
		try
		{
			String sql1 = "select* from user_info where status=1";
			ResultSet rs1 = stmt.executeQuery(sql1);
			while (rs1.next()) 
			{
				size++;
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		String[][] data = new String[size + 1][6];
		try
		{
			String sql = "select* from user_info where status=1";
			ResultSet rs = stmt.executeQuery(sql);

			data[0][0] = "Firstname";
			data[0][1] = "Lastname";
			data[0][2] = "Username";
			data[0][3] = "Gender";
			data[0][4] = "Email";
			data[0][5] = "Mobile";
			
			while (rs.next())
			{
				data[i][0] = rs.getString("firstname");
				data[i][1] = rs.getString("lastname");
				data[i][2] = rs.getString("username");
				data[i][3] = rs.getString("gender");
				data[i][4] = rs.getString("email");
				data[i][5] = rs.getString("mobile");
				i++;
			}
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		return data;
	}

	public String getuserstatus(String uname) {
		String status = "";
		try {
			String sql = "select* from user_info where username='" + uname + "' ";

			stmt.executeQuery(sql);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				status = rs.getString("status");

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;

	}

	public int unaprovedusercounter()
	{
		int i = 0;
		try
		{
			String sql = "select* from user_info where status =0 ";
			stmt.executeQuery(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) 
			{
				i++;
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return i;
	}

	public String[] unaproveduser()
	{
		String[] ll = new String[100];
		try
		{
			String sql = "select* from user_info where status =0 ";
			stmt.executeQuery(sql);
			ResultSet rs = stmt.executeQuery(sql);
			int i = 0;
			while (rs.next()) 
			{
				s = rs.getString("username");
				ll[i] = s;
				i++;
			}
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		return ll;
	}

	public String[] services()
	{
		int size = 0;
		try
		{
			String sql1 = "select* from services";
			ResultSet rs1 = stmt.executeQuery(sql1);
			while (rs1.next()) 
			{
				size++;
			}
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		String[] ll = new String[size];
		try {
			String sql = "select* from services ";
			stmt.executeQuery(sql);
			ResultSet rs = stmt.executeQuery(sql);
			int i = 0;
			while (rs.next()) 
			{
				s = rs.getString("service");
				System.out.println(s);
				ll[i] = s;
				i++;
			}
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		return ll;
	}

	public String[] employees() 
	{
		int size = 0;
		try
		{
			String sql1 = "select* from user_info where status=5";
			ResultSet rs1 = stmt.executeQuery(sql1);
			while (rs1.next()) 
			{
				size++;
			}
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		String[] ll = new String[size];
		try 
		{
			String sql = "select* from user_info where status =5 ";
			stmt.executeQuery(sql);
			ResultSet rs = stmt.executeQuery(sql);
			int i = 0;
			while (rs.next()) 
			{
				s = rs.getString("username");
				ll[i] = s;
				i++;
			}
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		return ll;
	}

	public String[] aproveduser()
	{
		String[] ll = new String[100];
		try
		{
			String sql = "select* from user_info where status =5 ";
			stmt.executeQuery(sql);
			ResultSet rs = stmt.executeQuery(sql);
			int i = 0;
			while (rs.next())
			{
				int chk = 0;
				s = rs.getString("username");
				ll[i] = s;
				i++;
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return ll;
	}

	public void removeuser(String username) {
		try {
			String sql = "delete from user_info where username = ('" + username + "') ";

			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println("oo");
		}
	}

	public void aproveuser(String username) {
		try {
			String sql = "update user_info set status ='1' where username = ('" + username + "') ";

			stmt.executeUpdate(sql);

		} catch (Exception e) {
			
		}
	}

	public void query(String sql) {
		try {
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void insertdata(String username, String password, String age) {
		try {

			String sql = "INSERT INTO user_info(username, password, age,status) VALUES ('" + username + "','" + password
					+ "','" + age + "','0')";
			// String sql = "INSERT INTO user_info " +"VALUES ('xyz','1253','68')";
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void updatepassword(String username, String password)
	{
		try 
		{
			String sql = "update user_info set password = ('" + password + "') where username= ('" + username + "') ";
			stmt.executeUpdate(sql);
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	public boolean checkuser(String username)
	{
		boolean exist=false;
		try
		{
			String sql = "SELECT* FROM user_info WHERE username='" + username + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) 
			{
				exist=true;
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return exist;
	}

	public int logindata(String username, String password) 
	{
		int status = 0;
		try
		{
			l = 0;
			String sql = "SELECT* FROM user_info WHERE username ='" + username + "' and password='" + password + "'"; //= er ager username column name and + er moddher username  fun theke
			ResultSet rs = stmt.executeQuery(sql);//return na korle while loop e jabe na
			while (rs.next())
			{
				l++;
				status = rs.getInt("status");
				//s = rs.getString("username");
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		if (l == 1)
		{
				l = l + status;
		} 
		return l;
	}
	public boolean checkoldpassword(String username, String password) 
	{
		boolean matched=false;
		try
		{	
			String sql = "SELECT* FROM user_info WHERE username='" + username + "' and password='" + password + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				matched=true;
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return matched;
	}

	public String getinfo(String colm, String username)
	{
		try 
		{
			String sql = "SELECT* FROM user_info WHERE username='" + username + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) 
			{
				q = rs.getString(colm);
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return q;
	}
}