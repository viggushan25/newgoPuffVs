package com.goPuff.myorders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ecom.goPuff.POMrepositoryLib.CheckoutPage;
import com.ecom.goPuff.POMrepositoryLib.EatalyDishPage;
import com.ecom.goPuff.POMrepositoryLib.HomePage;
import com.ecom.goPuff.POMrepositoryLib.LoginPage;
import com.ecom.goPuff.POMrepositoryLib.MyOrdersListPage;
import com.ecom.goPuff.POMrepositoryLib.RestaurantsPage;
import com.ecom.goPuff.genericutility.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.ecom.goPuff.genericutility.LisImpClass.class)
public class Verify_OrderList_on_myordersPage_and_CancelTheOrder_Test extends BaseClass 
{
	@ Test
	public void verify_OrderList_on_myordersPage_and_CancelTheOrder() throws Throwable	
	{
		
																		//public static void main(String[] args) throws IOException {
																	//WebDriver driver = null;
															
																	// step1:read all the necessary common data(property file)
															/*
																	FileInputStream fis = new FileInputStream("src\\test\\resources\\Data\\login.properties");
																	Properties prop = new Properties();
																	prop.load(fis);
																	String URL = prop.getProperty("url");
																	String BROWSER = prop.getProperty("browser");
																	String USERNAME = prop.getProperty("username");
																	String PASSWORD = prop.getProperty("password");
																	if (BROWSER.equalsIgnoreCase("chrome")) {
																		WebDriverManager.chromedriver().setup(); // instead of sys.setprop
																		driver = new ChromeDriver();
																	}
																		driver.manage().window().maximize();
																		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
																		driver.get(URL);
																		// Login
																		LoginPage log = new LoginPage(driver);
										 								log.getUserNamebtn().sendKeys(USERNAME);
																		log.getUserPasswordbtn().sendKeys(PASSWORD);
																		log.getLoginbtn().click(); */
			Thread.sleep(1000);
			HomePage home = new HomePage(driver);
			home.getRestButton().click();
			Thread.sleep(1000);
			RestaurantsPage restaurant = new RestaurantsPage(driver);
			restaurant.getEatalyRest().click();
			Thread.sleep(1000);
			EatalyDishPage eataly = new EatalyDishPage(driver);
			eataly.getCheesyMashedCart().click();
			eataly.getCheckout().click();
			Thread.sleep(1000);
			
			CheckoutPage checkoutPage=new CheckoutPage(driver);
			checkoutPage.getOrderButton().click();
			Thread.sleep(1000);
			String msg1 = ELib.getExcelData("Sheet1",5,0);
			WLib.swithToAlertWindowAndAccpect(driver, msg1);
			//System.out.println(msg1);
			String msg2 = ELib.getExcelData("Sheet1", 6, 0);
			WLib.swithToAlertWindowAndAccpect(driver, msg2);
			//System.out.println(msg2);
			Thread.sleep(1000);
			List<WebElement> allDish = driver.findElements(By.xpath("//td[@data-column='Item']/parent::tr/descendant::a"));
			//int count = allDish.size();
			//System.out.println(count);09
			//int size=count-1;
			String js = "window.scrollTo(0,document.body.scrollHeight)";
			Thread.sleep(1000);
			WLib.executeJavaScript(driver, js);
			Thread.sleep(1000);
			
			MyOrdersListPage listPage=new MyOrdersListPage(driver);
			listPage.clickonDeleteicon();
			String msg3 = ELib.getExcelData("Sheet1", 7, 0);
			//System.out.println(msg3);
			WLib.swithToAlertWindowAndAccpect(driver, msg3);
			
			Assert.fail();
			
			
	} //extra testscript to check failed testcases
			@Test
			public void verify_and_test_Cuisines_using_Paypal_Payment_option_Test() throws Throwable {
				HomePage homePage=new HomePage(driver);
				homePage.getRestButton().click();
				RestaurantsPage restaurantsPage=new RestaurantsPage(driver);
				
				restaurantsPage.getEatalyRest().click();
				EatalyDishPage dishPage=new EatalyDishPage(driver);
				dishPage.editQuantity();
				dishPage.getCheckout().click();
				
				
				CheckoutPage checkoutPage=new CheckoutPage(driver);
				checkoutPage.getPaypalPayment().click();
				checkoutPage.getOrderButton().click();
				
			
	}
}
