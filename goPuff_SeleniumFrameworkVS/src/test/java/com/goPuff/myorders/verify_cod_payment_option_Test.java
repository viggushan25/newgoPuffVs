package com.goPuff.myorders;

import org.testng.annotations.Test;

import com.ecom.goPuff.POMrepositoryLib.CheckoutPage;
import com.ecom.goPuff.POMrepositoryLib.EatalyDishPage;
import com.ecom.goPuff.POMrepositoryLib.HomePage;
import com.ecom.goPuff.POMrepositoryLib.RestaurantsPage;
import com.ecom.goPuff.genericutility.BaseClass;

public class verify_cod_payment_option_Test extends BaseClass
{
	@Test
	public void verify_cod_Payment_option_Test() throws Throwable {
		HomePage homePage=new HomePage(driver);
		homePage.getRestButton().click();
		RestaurantsPage restaurantsPage=new RestaurantsPage(driver);
		
		restaurantsPage.getEatalyRest().click();
		EatalyDishPage dishPage=new EatalyDishPage(driver);
		dishPage.editQuantity();
		dishPage.getCheckout().click();
		
		
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		//checkoutPage.getCodPayment().click();
		checkoutPage.getOrderButton().click();
		
		
		 
	}
}
