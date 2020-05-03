package newAppium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection{

	public static void main(String[] args) throws ClassNotFoundException, SQLException{

		//Connection URL
		String dbUrl="jdbc:mysql://localhost:3306/Employeeportal";

		//DB username and password
		String Username="root";
		String Password="root";

		//Query to be used
		String query="select * from Employeeinfo where name='Anushka'";

		//Load my sql jdbc driver
		Class.forName("com.mysql.jdbc.Driver");

		//Connect DB
		Connection con=DriverManager.getConnection(dbUrl,Username,Password);

		//Create Statement Object
		Statement st=con.createStatement();

		//Send Query to DB
		ResultSet rs=st.executeQuery(query);

		//while loop to print the result
		while(rs.next()){
			String u_name= rs.getString(1);
			//prints the username
			System.out.println(u_name);
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
		}

		//close db connection
		con.close();
	}
}
