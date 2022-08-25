package com.ecom.goPuff.genericutility;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ecom.goPuff.POMrepositoryLib.HomePage;
import com.ecom.goPuff.POMrepositoryLib.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	// Step1: Create Object for Utilities
	public WebDriverUtlity WLib = new WebDriverUtlity();
	public FileUtility FLib = new FileUtility();
	public JavaUtility JLib = new JavaUtility();
	public ExcelUtility ELib = new ExcelUtility();
	public DataBaseUtility DLib=new DataBaseUtility();

	@BeforeSuite
	public void configBS() {
		System.out.println("Connect to Database");
	}
//@Parameters("BROWSER")
	@BeforeClass
	public void configBC(/*String BROWSER*/) throws Throwable {
		System.out.println("Launch the Browser");
		String BROWSER = FLib.getPropertyKeyValue("browser");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			 WebDriverManager.chromedriver().setup(); // instead of sys.setprop
			driver = new ChromeDriver();
		}
		else if  (BROWSER.equalsIgnoreCase("firefox")) { 
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			}
		else {
			System.out.println("Please mention the correct browser");
		}
        
		sdriver=driver;
		WLib.waitForElementInDOM(driver);
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void configBM() throws Throwable {
		// Read the common data
		String UN = FLib.getPropertyKeyValue("username");
		String PWD = FLib.getPropertyKeyValue("password");
		String URL = FLib.getPropertyKeyValue("LOGINURL");

		// Navigate to application
		driver.get(URL);

		// Login to application
		LoginPage lg = new LoginPage(driver);
		lg.loginToApp(UN, PWD);
	}

	@AfterMethod
	public void configAM() {
		// Logout from application
		HomePage hm = new HomePage(driver);
		hm.getLogoutButton();

	}

	@AfterClass
	public void configAC() {
		System.out.println("Close the Browser");
		driver.quit();
	}

	@AfterSuite
	public void configAS() {
		System.out.println("Close the Database");
	}

}
