package com.ecom.goPuff.POMrepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.goPuff.genericutility.ExcelUtility;

public class EatalyDishPage {
	
	WebDriver driver;
	public EatalyDishPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Checkout")
	private WebElement checkout;
	
	@FindBy(xpath="//a[text()='Pink Spaghetti Gamberoni']/ancestor::div[@class='food-item']/descendant::input[@type='text']")
	private WebElement pinkSpaghettiText;
	
	@FindBy(xpath="//a[text()='Cheesy Mashed Potato']/ancestor::div[@class='food-item']/descendant::input[@type='text']")
	private WebElement cheesyMashedText;
	
	@FindBy(xpath="//a[text()='Crispy Chicken Strips']/ancestor::div[@class='food-item']/descendant::input[@type='text']")
	private WebElement crispyChickenText;
	
	@FindBy(xpath="//a[text()='Lemon Grilled Chicken And Pasta']/ancestor::div[@class='food-item']/descendant::input[@type='text']")
	private WebElement lemonChickenText;
	
	@FindBy(xpath="//a[text()='Pink Spaghetti Gamberoni']/ancestor::div[@class='food-item']/descendant::input[@type='submit']")
	private WebElement pinkSpaghettiCart;
	
	@FindBy(xpath="//a[text()='Cheesy Mashed Potato']/ancestor::div[@class='food-item']/descendant::input[@type='submit']")
	private WebElement cheesyMashedCart;
	
	@FindBy(xpath="//a[text()='Crispy Chicken Strips']/ancestor::div[@class='food-item']/descendant::input[@type='submit']")
	private WebElement crispyChickenCart;
	
	@FindBy(xpath="//a[text()='Lemon Grilled Chicken And Pasta']/ancestor::div[@class='food-item']/descendant::input[@type='submit']")
	private WebElement lemonChickenCart;

	public WebElement getCheckout() {
		return checkout;
	}
	
	public WebElement getPinkSpaghettiText() {
		return pinkSpaghettiText;
	}

	public WebElement getCheesyMashedText() {
		return cheesyMashedText;
	}

	public WebElement getCrispyChickenText() {
		return crispyChickenText;
	}

	public WebElement getLemonChickenText() {
		return lemonChickenText;
	}

	public WebElement getPinkSpaghettiCart() {
		return pinkSpaghettiCart;
	}

	public WebElement getCheesyMashedCart() {
		return cheesyMashedCart;
	}

	public WebElement getCrispyChickenCart() {
		return crispyChickenCart;
	}

	public WebElement getLemonChickenCart() {
		return lemonChickenCart;
	}
	
	
	public void editQuantity() throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		String Quantity=eLib.getExcelData("sheet1", 1, 9);
	pinkSpaghettiText.clear();
	pinkSpaghettiText.sendKeys(Quantity);
	pinkSpaghettiCart.click();
	}
}
