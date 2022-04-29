package com.banking.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountTabPage 
{
	@FindBy(xpath="//button[@ng-click='openAccount()']")
	private WebElement openAcntTabBtn;
	@FindBy(id="userSelect")
	private WebElement custDrpDwn;
	@FindBy(id="currency")
	private WebElement currencyDrpDwn;
	@FindBy(xpath="//button[text()='Process']")
	private WebElement processBtn;
	
	public OpenAccountTabPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void openAccount(WebDriver driver)
	{
		openAcntTabBtn.click();
		Select sel1=new Select(custDrpDwn);
		sel1.selectByValue("6");
		Select sel2=new Select(currencyDrpDwn);
		sel2.selectByValue("Rupee");
		processBtn.click();
		Alert alt=driver.switchTo().alert();
        alt.accept();
	}

}
