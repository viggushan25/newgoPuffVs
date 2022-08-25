package com.goPuff.practice;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.ecom.goPuff.POMrepositoryLib.Login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleLoginTest {
	public static void main(String[] args) {
		
//	WebDriver driver = null;
	String BROWSER = "crome";
	if (BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup(); // instead of sys.setprop
		//driver = new ChromeDriver();
	}
         //Login lg = new Login(driver);
       //  lg.loginToApp(BROWSER, BROWSER);
}
}
