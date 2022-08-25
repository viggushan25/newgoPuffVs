package com.goPuff.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyOrdersTcTest {
	public static void main(String[] args) throws IOException {
		WebDriver driver = null;
		
		// step1:read all the necessary common data
		
		FileInputStream fis = new FileInputStream("./src/test/resources/Data/goPuff.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String URL = prop.getProperty("url");
		String BROWSER = prop.getProperty("browser");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		// step2:Launch the browser -RTP
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); //instead of sys.setprop
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("FIREFOX")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("invalid browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);

		// step3:login to the app
		
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("buttn")).click();

		// step4:navigate to Myorders link
		
		driver.findElement(By.linkText("My Orders")).click();
		 List<WebElement> text = driver.findElements(By.xpath("//td[@data-column='Item']"));
		 /*for(int i=0;i<text.size();i++)
		 {
			 String name = text.get(i).getText();
			 System.out.println(name);
		 }*/
		 for(WebElement name:text)
		 {
			 String item = name.getText();
			 System.out.println(item);
		 }
		 driver.close();
	}

}
