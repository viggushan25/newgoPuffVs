package com.goPuff.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabaseExecuteUpdateTest 
{
	public static void main(String[] args) throws SQLException 
	{
		// step1:create object for Driver
		Driver driverRef = new Driver();
		Connection con = null;
		// step2:register the driver
		DriverManager.registerDriver(driverRef);
		// step3: Establish the connection (always provide db name)
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
		// step4: create statement
		Statement state = con.createStatement();
		// step5: Execute the query-provide table name
		String query = "insert into customers values(5,'MS','Dhoni','Ranchi');";
		int result = state.executeUpdate(query);
		System.out.println(result);
		// step6: validate
		if (result == 1)
		{
			System.out.println("data added successfully");
		} else {
			System.out.println("data not added");
		}
		// step7:closed connection
		con.close();
		System.out.println("Connection closed");
	}

}
