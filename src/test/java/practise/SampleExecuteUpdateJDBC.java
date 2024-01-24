package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleExecuteUpdateJDBC {
	
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
		//executeUpdate() is used for all non select queries - create,insert,delete,truncate,drop,update
		int result=state.executeUpdate("insert into customer_info values(13,'batman','california');");
		if(result==1)
		{
			System.out.println("Data added");
		}
		else
		{
			System.out.println("Data not added");
		}
		
		//Step 5: Close the DB
		conn.close();
		

	}
}
