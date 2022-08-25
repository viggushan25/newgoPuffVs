package com.goPuff.myorders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ecom.goPuff.POMrepositoryLib.RegisterPage;
import com.ecom.goPuff.genericutility.ExcelUtility;
import com.ecom.goPuff.genericutility.FileUtility;
import com.ecom.goPuff.genericutility.JavaUtility;
import com.ecom.goPuff.genericutility.WebDriverUtlity;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify_the_Phonenumber_textfield_with_InvalidData_Test {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
		FileUtility FLib=new FileUtility();
        ExcelUtility ELib=new ExcelUtility();
        WebDriverUtlity WLib=new WebDriverUtlity();
        JavaUtility JLib=new JavaUtility();

		// step1:read all the necessary common data(property file)

        String URL = FLib.getPropertyKeyValue("url");
        String BROWSER = FLib.getPropertyKeyValue("browser");
        String USERNAME=FLib.getPropertyKeyValue("username");
        String PASSWORD =FLib.getPropertyKeyValue("password");

		// step2:Launch the browser -RTP

		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); // instead of sys.setprop
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			WLib.waitForElementInDOM(driver);
			driver.get(URL);

			
			// Step3  to fetch all the details for register module from excel test data
			String username = ELib.getExcelData("sheet1", 2, 1)+JLib.getRanDomNumber();
			String firstname = ELib.getExcelData("sheet1", 2, 2);
			String Lastname = ELib.getExcelData("sheet1", 2, 3);
			String Emailaddress= JLib.getRanDomNumber()+ELib.getExcelData("sheet1", 2, 4);
			String password = ELib.getExcelData("sheet1", 2, 5);
			String confirmpassword = ELib.getExcelData("sheet1", 2, 6);
			String phonenumber = ELib.getExcelData("sheet1", 2, 7);
			String Deliveryaddress = ELib.getExcelData("sheet1", 2, 8);
			
			
			// step 4: To Register the application
			RegisterPage reg=new RegisterPage(driver);
			Thread.sleep(5000);
			reg.registerToApp(USERNAME, firstname, Lastname, Emailaddress, phonenumber, PASSWORD, confirmpassword, Deliveryaddress);
			System.out.println(username +" "+ firstname +"  "+ Lastname +"  "+Emailaddress + "  "+phonenumber +"  "+ password + "  "+confirmpassword + "  "+Deliveryaddress);

			
			
																							/*
																							driver.findElement(By.name("username")).sendKeys(username);
																							Thread.sleep(3000);
																							driver.findElement(By.name("firstname")).sendKeys(firstname);
																							Thread.sleep(3000);
																							driver.findElement(By.name("lastname")).sendKeys(Lastname);
																							Thread.sleep(3000);
																							driver.findElement(By.name("email")).sendKeys(Emailaddress);
																							Thread.sleep(3000);
																							driver.findElement(By.name("phone")).sendKeys(phonenumber);
																							Thread.sleep(3000);
																							driver.findElement(By.name("password")).sendKeys(password);
																							Thread.sleep(3000);
																							driver.findElement(By.name("cpassword")).sendKeys(confirmpassword);
																							Thread.sleep(3000);
																							driver.findElement(By.name("address")).sendKeys(Deliveryaddress);
																							Thread.sleep(3000);
																							driver.findElement(By.name("submit")).click();
																							Thread.sleep(3000);
																							// to press ok on alert popup
																							 */
																							 
			WLib.swithToAlertWindowAndAccpect(driver, Deliveryaddress);	
				
			driver.close();
			
			
			
			

		}
	}
}


