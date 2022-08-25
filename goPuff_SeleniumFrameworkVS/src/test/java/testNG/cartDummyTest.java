package testNG;

import org.testng.annotations.Test;

import com.ecom.goPuff.genericutility.BaseClass;

public class cartDummyTest  {
	@Test(groups="Smoke TestCase")
	public void verifyHomeOrder()
	{
		System.out.println("verified cart in cart page");
	}

}
