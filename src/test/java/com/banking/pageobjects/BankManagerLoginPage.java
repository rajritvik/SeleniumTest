package com.banking.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BankManagerLoginPage
{
	@FindBy(xpath="//button[text()='Bank Manager Login']")
	private WebElement bankMngrLoginBtn;
	
	
	public BankManagerLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBankMngrLoginBtn()
	{
		bankMngrLoginBtn.click();
	}
	
}
