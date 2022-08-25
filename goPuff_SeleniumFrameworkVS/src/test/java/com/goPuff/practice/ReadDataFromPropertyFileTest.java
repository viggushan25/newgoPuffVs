package com.goPuff.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFileTest {

	public static void main(String[] args) throws IOException {
		//step1:use file input stream to load the property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Data\\goPuff.properties");
		//step2:create object of properties and load the file
		Properties prop = new Properties();
		prop.load(fis);
		//step3: provide the key to read the value
		String URL = prop.getProperty("url");
		System.out.println(URL);
		
		String USERNAME = prop.getProperty("username");
		System.out.println("Username is "+USERNAME);
		
		String PASSWORD = prop.getProperty("password");
		System.out.println("Password is "+PASSWORD);

		String BROWSER = prop.getProperty("browser");
		System.out.println("Browser is "+ BROWSER);

	}

}
