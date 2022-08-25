package com.goPuff.myorders;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ecom.goPuff.POMrepositoryLib.RegisterPage;
import com.ecom.goPuff.genericutility.ExcelUtility;
import com.ecom.goPuff.genericutility.FileUtility;
import com.ecom.goPuff.genericutility.JavaUtility;
import com.ecom.goPuff.genericutility.WebDriverUtlity;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify_the_Phonenumber_textfield_with_ValidData_Test {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
        FileUtility FLib=new FileUtility();
        ExcelUtility ELib=new ExcelUtility();
        WebDriverUtlity WLib=new WebDriverUtlity();
        JavaUtility JLib=new JavaUtility();
        
        
																			        
																			        
	//step1:read all the necessary common data(property file)
																			
																			//		FileInputStream fis = new FileInputStream("src/test/resources/Data/goPuff.properties");
																			//		Properties prop = new Properties();
																			//		prop.load(fis);
																			//		String URL = prop.getProperty("url");
																			//		String BROWSER = prop.getProperty("browser");
																			//		String USERNAME = prop.getProperty("username");
																			//		String PASSWORD = prop.getProperty("password");
        
        String URL = FLib.getPropertyKeyValue("url");
        String BROWSER = FLib.getPropertyKeyValue("browser");
        String USERNAME=FLib.getPropertyKeyValue("username");
        String PASSWORD =FLib.getPropertyKeyValue("password");
        
        
        
		
		

		// step2:Launch the browser -RTP

		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); // instead of sys.setprop
			driver = new ChromeDriver();
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
			driver.manage().window().maximize();
			WLib.waitForElementInDOM(driver);
																				//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(URL);

																				// step3:Read the data from excel sheet
																				//FileInputStream fileExcel=new FileInputStream("src\\test\\resources\\Data\\Test data for  verifying registration details.xlsx");
																				//Workbook book = WorkbookFactory.create(fileExcel);
																				
																				// Steps to fetch all the details for register module from excel test data
																				/*String Username = book.getSheet("sheet1").getRow(1).getCell(1).toString();
																				String firstname = book.getSheet("sheet1").getRow(1).getCell(2).toString();
																				String Lastname = book.getSheet("sheet1").getRow(1).getCell(3).toString();
																				String Emailaddress = book.getSheet("sheet1").getRow(1).getCell(4).toString();
																				String password = book.getSheet("sheet1").getRow(1).getCell(5).toString();
																				String confirmpassword = book.getSheet("sheet1").getRow(1).getCell(6).toString();
																				String phonenumber = book.getSheet("sheet1").getRow(1).getCell(7).toString();
																				String Deliveryaddress = book.getSheet("sheet1").getRow(1).getCell(8).toString(); */
																				
			
			String username = ELib.getExcelData("sheet1", 1, 1)+JLib.getRanDomNumber();
			String firstname = ELib.getExcelData("sheet1", 1, 2);
			String Lastname = ELib.getExcelData("sheet1", 1, 3);
																				//String Emailaddress = ELib.getExcelData("sheet1", 1, 4);
			String Emailaddress= JLib.getRanDomNumber()+ELib.getExcelData("sheet1", 1, 4);
			String password = ELib.getExcelData("sheet1", 1, 5);
			String confirmpassword = ELib.getExcelData("sheet1", 1, 6);
			String phonenumber = ELib.getExcelData("sheet1", 1, 7);
			String Deliveryaddress = ELib.getExcelData("sheet1", 1, 8);
			
			
			
			
			// step 4: To Register the application
			RegisterPage reg=new RegisterPage(driver);
			reg.registerToApp(username, firstname, Lastname, Emailaddress, phonenumber, password, confirmpassword, Deliveryaddress);
			System.out.println(username +" "+ firstname +"  "+ Lastname +"  "+Emailaddress + "  "+phonenumber +"  "+ password + "  "+confirmpassword + "  "+Deliveryaddress);
			
																						
																						/* driver.findElement(By.name("username")).sendKeys(username);
																						Thread.sleep(1000);
																						driver.findElement(By.name("firstname")).sendKeys(firstname);
																						Thread.sleep(1000);
																						driver.findElement(By.name("lastname")).sendKeys(Lastname);
																						Thread.sleep(1000);
																						driver.findElement(By.name("email")).sendKeys(Emailaddress);
																						Thread.sleep(1000);
																						driver.findElement(By.name("phone")).sendKeys(phonenumber);
																						Thread.sleep(1000);
																						driver.findElement(By.name("password")).sendKeys(password);
																						Thread.sleep(1000);
																						driver.findElement(By.name("cpassword")).sendKeys(confirmpassword);
																						Thread.sleep(1000);
																						driver.findElement(By.name("address")).sendKeys(Deliveryaddress);
																						Thread.sleep(1000);
																						driver.findElement(By.name("submit")).click();
																						Thread.sleep(1000);
																			*/
																						// to press ok on alert popup
																						//Alert al = driver.switchTo().alert();
																						//System.out.println(al.getText());
																					//	al.accept();   
																						//WLib.swithToAlertWindowAndAccpect(driver, Deliveryaddress);
																						
			
			
			
			driver.close();
			

		}
	}

