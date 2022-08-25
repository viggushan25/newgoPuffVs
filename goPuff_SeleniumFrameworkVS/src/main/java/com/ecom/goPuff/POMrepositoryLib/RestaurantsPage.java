package com.ecom.goPuff.POMrepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RestaurantsPage {
	
	WebDriver driver;
	public RestaurantsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Eataly")
	private WebElement eatalyRest;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getEatalyRest() {
		return eatalyRest;
	}

	public WebElement getNanRest() {
		return nanRest;
	}

	@FindBy(linkText="Nan Xiang Xiao Long Bao")
	private WebElement nanRest;
	
	public void clickmethod(){
		
		
	}
	
}
