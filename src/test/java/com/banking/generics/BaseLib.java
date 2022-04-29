package com.banking.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLib 
{
	public WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser", "testurl"})
	public void setUp(String browserName, String url)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			Reporter.log("Chrome Launched", true);
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		Reporter.log(url+" Url Navigated", true);
    }
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		String scriptName = result.getMethod().getMethodName();
		if(result.isSuccess())   //true---->passs
		{
			Reporter.log(scriptName+" script is passed", true);
		}
		else   //false---->Fail
		{
			ScreenshotLib slib=new ScreenshotLib();
			slib.takeScreenshot(driver, scriptName);
			Reporter.log("Screenshot has been taken", true);
		}
		
		driver.quit();
		Reporter.log("Browser Closed", true);
	
	 }
	
}
