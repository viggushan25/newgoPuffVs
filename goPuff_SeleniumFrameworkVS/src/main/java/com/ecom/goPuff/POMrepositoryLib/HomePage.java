package com.ecom.goPuff.POMrepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getRestButton() {
		return restButton;
	}

	public WebElement getHomeButton() {
		return homeButton;
	}

	public WebElement getOrderButton() {
		return orderButton;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}
	//public void logoutOfApplication() {
		//logoutButton.click();
	//}

	@FindBy(xpath="//a[text()='Restaurants ']")
	private WebElement restButton;
	
	@FindBy(linkText="Home ")
	private WebElement homeButton;
	
	@FindBy(linkText="My Orders")
	private WebElement orderButton;
	
	@FindBy(linkText="Logout")
	private WebElement logoutButton;
	
	
		
			
		
	
}
