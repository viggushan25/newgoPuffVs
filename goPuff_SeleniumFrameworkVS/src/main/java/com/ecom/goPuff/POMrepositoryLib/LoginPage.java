package com.ecom.goPuff.POMrepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// Rule1: create seperate java class foe every page in application

	// Rule2: Identify all the elements using @findBy & @findBys ,findAll(declaration)

	@FindBy(name = "username")
	private WebElement userNamebtn;

	@FindBy(name = "password")
	private WebElement userPasswordbtn;

	@FindBy(id = "buttn")
	private WebElement loginbtn;

	// Rule3: execute all the elements and initialize the elements
	// pagefactory.initElements[initialization]
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Rule 4: Declare all the elements as private and provide getters method,business method for (utilizatiion)
	public WebElement getUserNamebtn() {
		return userNamebtn;
	}

	public WebElement getUserPasswordbtn() {
		return userPasswordbtn;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public void loginToApp(String userName, String password) {
		userNamebtn.sendKeys(userName);
		userPasswordbtn.sendKeys(password);
		loginbtn.click();

	}

}
