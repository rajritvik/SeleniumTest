package com.banking.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class CustomersTabPage 
{
	@FindBy(xpath="//button[@ng-click='showCust()']")
	private WebElement customersTabBtn;
	@FindBy(xpath="//input[@ng-model='searchCustomer']")
	private WebElement searchTxtBx;
	
	public CustomersTabPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void searchCustomer(WebDriver driver)
	{
		customersTabBtn.click();
		String expCust="Azhar";
		searchTxtBx.sendKeys(expCust);
		String actCust=driver.findElement(By.xpath("//table//a/ancestor::table//td[text()='"+expCust+"']")).getText();
		Assert.assertEquals(actCust, expCust);
		Reporter.log(expCust, true);
		
		
	}

}
