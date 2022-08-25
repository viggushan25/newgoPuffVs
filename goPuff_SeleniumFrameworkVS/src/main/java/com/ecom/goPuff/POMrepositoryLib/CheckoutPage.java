package com.ecom.goPuff.POMrepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	WebDriver driver;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCodPayment() {
		return codPayment;
	}

	public WebElement getPaypalPayment() {
		return paypalPayment;
	}

	public WebElement getOrderButton() {
		return orderButton;
	}

	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[text()='Cash on Delivery']/preceding::span[@class='custom-control-indicator']")
	private WebElement codPayment;
	
	@FindBy(xpath="//span[text()='Paypal ']/ancestor::li/descendant::span[@class='custom-control-indicator']")
	private WebElement paypalPayment;
	
	@FindBy(xpath="//input[@value='Order Now']")
	private WebElement orderButton;
}

