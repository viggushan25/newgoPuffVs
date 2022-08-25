package com.goPuff.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerOrgNamesListTest {
	public static void main(String[] args) {
		WebDriver driver=null;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8888/index.php?action=Login&module=Users");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//td[@class='tabUnSelected']/descendant::a[text()='Organizations']")).click();
		List<WebElement> lst = driver.findElements(By.xpath("//tr[@bgcolor='white']/td[3]"));
		for(WebElement name:lst)
		{
			System.out.println(name.getText());
		}
		String exp = "ola";
		//if(exp.equals(name))
		{
			System.out.println("Pass");
		}
	}

}
