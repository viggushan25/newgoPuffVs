package com.goPuff.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyOrdersTest {

	public static void main(String[] args) throws IOException {
		WebDriver driver=null;
		//create random number
		//Random ran=new Random();
		//step1:read all the necessary common data
		FileInputStream fis=new FileInputStream("./src/test/resources/Data/goPuff.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String URL = prop.getProperty("url");
		String BROWSER = prop.getProperty("browser");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		//step2:read the test data from excel sheet
		/*FileInputStream fileExcel=new FileInputStream("./src/test/resources/Data/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fileExcel);
		String orgName = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue(); */ 
		
		 //step3:Launch the browser  -RTP
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("FIREFOX")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(URL);
		
		//step4:login to the app
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("buttn")).click();
		
		//step5:navigate to Myorders link
		driver.findElement(By.linkText("My Orders")).click();
		//driver.findElement(By.linkText(" Lobster Thermidor")));
		
		//step6:delete the order info
		driver.findElement(By.xpath("//a[@href='delete_orders.php?order_del=51']")).click();
		
	//step7:logout of app
		//driver.findElement((By.class("nav-link active")).click;
		
		}
		
		

	}


