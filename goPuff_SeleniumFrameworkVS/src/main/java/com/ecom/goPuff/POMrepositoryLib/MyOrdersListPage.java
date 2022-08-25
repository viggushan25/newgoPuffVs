package com.ecom.goPuff.POMrepositoryLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrdersListPage {
	WebDriver driver;
	public WebElement getTrashBin() {
		return trashBin;
	}
	public MyOrdersListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebDriver getDriver() {
		return driver;
	}
	@FindBy(xpath="//section[@class='restaurants-page']/descendant::a[last()]")
	private WebElement trashBin;
	
	public void clickonDeleteicon(){
		driver.findElement(By.xpath("//section[@class='restaurants-page']/descendant::a[last()]")).click();
	}
	
	
	
}
