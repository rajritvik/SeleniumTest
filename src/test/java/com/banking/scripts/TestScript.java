package com.banking.scripts;

import org.testng.annotations.Test;

import com.banking.generics.BaseLib;
import com.banking.pageobjects.AddCustomerTabPage;
import com.banking.pageobjects.BankManagerLoginPage;
import com.banking.pageobjects.CustomersTabPage;
import com.banking.pageobjects.OpenAccountTabPage;


public class TestScript extends BaseLib
{
	@Test
	public void script1() 
	{
		BankManagerLoginPage bp= new BankManagerLoginPage(driver);
		bp.clickOnBankMngrLoginBtn();
		AddCustomerTabPage act=new AddCustomerTabPage(driver);
		act.addCustomer(driver);
		OpenAccountTabPage oat=new OpenAccountTabPage(driver);
		oat.openAccount(driver);
		CustomersTabPage ct=new CustomersTabPage(driver);
		ct.searchCustomer(driver);
		
	}
	

}
