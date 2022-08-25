package com.goPuff.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDataBaseExecuteQueryTest {

	public static void main(String[] args) throws SQLException {
		//step1:create object of driver
		Driver driverRef = new Driver();
		Connection con=null;
		//step2:Register driver
		DriverManager.registerDriver(driverRef);
		//step3: establish the connection-provide database name
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers","root","root");
		//step4:create statement
		Statement statement = con.createStatement();
		//step5:execute the query-provide table name
		String query = "select * from customers;";
		String expData = "Kohli";
		ResultSet result = statement.executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String actData = result.getString(3);
			if(actData.equalsIgnoreCase(expData)) //to ignore uppercase and lowercase issue
			{
				System.out.println(actData);
				flag=true;   //flag rising
				break;
			}
			}
		if(flag)
		{
			System.out.println("data present");
		}
		else
		{
			System.out.println("data not present");
		}
		//step6:validate
		//step7:close connection
		con.close();
		
			
			
		}
		
		
		

	}


