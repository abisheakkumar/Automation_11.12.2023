package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleExecuteQueryJDBC {

	public static void main(String[] args) throws SQLException{
		
		//Create driver Object and import from Mysql
		Driver driverRef=new Driver();
		
		
		//Step 1: Register the database/Driver
		DriverManager.registerDriver(driverRef);
		
		//Step 2: get the connection with DB
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/m4db", "root", "root");
		
		//Step 3: issue Create Statement
		Statement state=conn.createStatement();
		
		//Step 4: execute a query
		//executeQuery() is used for Select queries
		ResultSet result=state.executeQuery("select * from customer_info");
		while(result.next())
		{
			System.out.println(result.getInt(1)+"-"+result.getString(2)+"-"+result.getString(3));
		}
		
		//Step 5: Close the DB
		conn.close();
		

	}

}
