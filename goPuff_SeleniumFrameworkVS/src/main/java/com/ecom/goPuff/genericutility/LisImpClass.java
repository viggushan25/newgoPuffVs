package com.ecom.goPuff.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LisImpClass implements ITestListener {
	public void onTestFailure(ITestResult result){
		int ranNum = JavaUtility.getRanDomNumber();
		String testName=result.getMethod().getMethodName();
		System.out.println(testName+"i am listening");
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.sdriver);
		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("./screenshot/"+testName+ranNum+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		
	}

}
