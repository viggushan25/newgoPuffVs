package com.goPuff.practice;

import org.testng.annotations.Test;

public class InvocationCountTest {

	
	@Test(invocationCount = 2)
	public void Verify_the_Phonenumber_textfield_with_ValidData()
	{
		System.out.println("Verifying the valid Phonenumber");
	}
	
	@Test(invocationCount = 5)
	public void Verify_the_Phonenumber_textfield_with_InvalidData()
	{
		System.out.println("Verifying invalid Phonenumber");
	}
	
	@Test(invocationCount = 3)
	public void Verify_and_test_Cuisines_using_Paypal_Payment_option()
	{
		System.out.println("Verifying ordering status using paypal");
	}


}
