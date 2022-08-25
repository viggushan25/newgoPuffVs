package com.goPuff.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopup_Test {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("https://www.goibibo.com/");
	Actions act=new Actions(driver);
	act.moveByOffset(10,10).click().perform();
	driver.findElement(By.xpath("//span[text()='From']/following-sibling::p[text()='Enter city or airport']")).click();
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("blr");
	driver.findElement(By.xpath("//span[class='autoCompleteTitle ' and contains(text(),'Bengaluru,India')]")).click();
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("ixe");
	driver.findElement(By.xpath("//span[@class='autoCompleteTitle ' and contains(text),'Mangalore, India')]")).click();
	// driver.findElement(By.xpath("//span[@aria-label='Next Month'")).click();
	//driver.findElement(By.xpath("//div[@aria-label='Sun Oct 02 2022']")).click();
	
	driver.findElement(By.xpath("//div{@class='sc-lbhJGD bHgpcs']/descendant::div[text()='August 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='25']")).click();
	
	
	
	
}
}


//NOT COMPLETED