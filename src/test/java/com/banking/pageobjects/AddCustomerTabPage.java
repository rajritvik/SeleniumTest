package com.banking.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerTabPage 
{
	@FindBy(xpath="//button[@ng-click='addCust()']")
	private WebElement addCustomerTabBtn;
	@FindBy(xpath="//input[@ng-model='fName']")
	private WebElement firstNameTxtBx;
	@FindBy(xpath="//input[@ng-model='lName']")
	private WebElement lastNameTxtBx;
	@FindBy(xpath="//input[@ng-model='postCd']")
	private WebElement postCodeTxtBx;
	@FindBy(xpath="//button[text()='Add Customer']")
	private WebElement addCustBtn;
	
	public AddCustomerTabPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addCustomer(WebDriver driver)
	{
		addCustomerTabBtn.click();
		firstNameTxtBx.sendKeys("Azhar");
		lastNameTxtBx.sendKeys("Khan");
		postCodeTxtBx.sendKeys("102001");
		addCustBtn.click();
		Alert alt=driver.switchTo().alert();
        alt.accept();
	}

}
