package com.ecom.goPuff.POMrepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	@FindBy(name = "username")
	private WebElement userNametbx;
	
	@FindBy(name = "firstname")
	private WebElement firstNametbx;
	
	@FindBy(name = "lastname")
	private WebElement lastNametbx;
	
	@FindBy(name = "email")
	private WebElement emailtbx;
	
	@FindBy(name = "phone")
	private WebElement phonetbx;
	
	@FindBy(name = "password")
	private WebElement passwordtbx;
	
	@FindBy(name = "cpassword")
	private WebElement confirmPasswordtbx;
	
	@FindBy(name = "address")
	private WebElement addresstbx;
	
	@FindBy(name = "submit")
	private WebElement registerbtn;
	
	public RegisterPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNametbx() {
		return userNametbx;
	}

	public WebElement getFirstNametbx() {
		return firstNametbx;
	}

	public WebElement getLastNametbx() {
		return lastNametbx;
	}

	public WebElement getEmailtbx() {
		return emailtbx;
	}

	public WebElement getPhonetbx() {
		return phonetbx;
	}

	public WebElement getPasswordtbx() {
		return passwordtbx;
	}

	public WebElement getConfirmPasswordtbx() {
		return confirmPasswordtbx;
	}

	public WebElement getAddresstbx() {
		return addresstbx;
	}

	public WebElement getRegisterbtn() {
		return registerbtn;
	}
	
	public void registerToApp(String username, String firstname,String lastName,String email,String phone,String password,String confirmpassword,String deliveryaddress)
	{
		userNametbx.sendKeys(username);
		firstNametbx.sendKeys(firstname);
		lastNametbx.sendKeys(lastName);
		emailtbx.sendKeys(email);
		phonetbx.sendKeys(phone);
		passwordtbx.sendKeys(password);
		confirmPasswordtbx.sendKeys(confirmpassword);
		addresstbx.sendKeys(deliveryaddress);
		registerbtn.click();
	}
	
	
	
	
	
	
	


}
