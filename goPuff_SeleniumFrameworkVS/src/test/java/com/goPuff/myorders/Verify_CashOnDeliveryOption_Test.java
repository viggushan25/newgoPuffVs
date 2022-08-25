package com.goPuff.myorders;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecom.goPuff.POMrepositoryLib.CheckoutPage;
import com.ecom.goPuff.POMrepositoryLib.EatalyDishPage;
import com.ecom.goPuff.POMrepositoryLib.HomePage;
import com.ecom.goPuff.POMrepositoryLib.LoginPage;
import com.ecom.goPuff.POMrepositoryLib.RestaurantsPage;
import com.ecom.goPuff.genericutility.ExcelUtility;
import com.ecom.goPuff.genericutility.FileUtility;
import com.ecom.goPuff.genericutility.JavaUtility;
import com.ecom.goPuff.genericutility.WebDriverUtlity;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify_CashOnDeliveryOption_Test {
	

	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
		FileUtility FLib = new FileUtility();
		ExcelUtility ELib = new ExcelUtility();
		WebDriverUtlity WLib = new WebDriverUtlity();
		JavaUtility JLib = new JavaUtility();

		// step1:read all the necessary common data(property file)

		/* FileInputStream fis = new FileInputStream("src\\test\\resources\\Data\\login.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String URL = prop.getProperty("url");
		String BROWSER = prop.getProperty("browser");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password"); */
		
		String LOGIN = FLib.getPropertyKeyValue("LOGINURL");
		String BROWSER = FLib.getPropertyKeyValue("browser");
		String USERNAME = FLib.getPropertyKeyValue("username");
		String PASSWORD = FLib.getPropertyKeyValue("password");
		
		
		String noOfItems = ELib.getExcelData("Sheet1", 1, 9);
		System.out.println(noOfItems);

		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); // instead of sys.setprop
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			WLib.waitForElementInDOM(driver);
			driver.get(LOGIN);
			
			LoginPage log = new LoginPage(driver);
			log.loginToApp(USERNAME, PASSWORD);
			
			/*
			driver.findElement(By.name("username")).sendKeys(USERNAME);
			driver.findElement(By.name("password")).sendKeys(PASSWORD);
			driver.findElement(By.id("buttn")).click(); */
			
			HomePage home = new HomePage(driver);
			home.getRestButton().click();
			
		/*	driver.findElement(By.xpath("//a[text()='Restaurants ']")).click();
			driver.findElement(By.xpath("//a[text()='View Menu']")).click();
			driver.findElement(By.name("quantity")).clear();
			driver.findElement(By.name("quantity")).sendKeys("10");
			driver.findElement(By.xpath("//a[text()='Cheesy Mashed Potato']/ancestor::div[@class='food-item']/descendant::input[@class='btn theme-btn']")).click();
			driver.findElement(By.xpath("//a[text()='Checkout']")).click();
			//driver.findElement(By.xpath("//span[text()='Cash on Delivery']/preceding-sibling::span[@class='custom-control-indicator']")).click();
			
			driver.findElement(By.xpath("//a[text()='Logout']")).click();
			*/
			
			
			RestaurantsPage rest = new RestaurantsPage(driver);
			rest.getEatalyRest().click();
			EatalyDishPage eataly = new EatalyDishPage(driver);
			Thread.sleep(2000);
			eataly.getPinkSpaghettiText().clear();
			Thread.sleep(2000);
			eataly.getPinkSpaghettiText().sendKeys(noOfItems);
			Thread.sleep(2000);
			eataly.getPinkSpaghettiCart().click();
			eataly.getCheckout().click();
			
			
			CheckoutPage check = new CheckoutPage(driver);
			check.getOrderButton().click();
			
			check.getCodPayment().click();
			System.out.println("Cod is getting clicked");
			String expectedMsg = "Do you want to confirm the order?";
			WLib.swithToAlertWindowAndAccpect(driver, expectedMsg);
			String confirmText = "Thank you. Your Order has been placed!";
			WLib.swithToAlertWindowAndAccpect(driver, confirmText);
			
			
			
	}
	}
}
