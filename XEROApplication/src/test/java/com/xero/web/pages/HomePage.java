package com.xero.web.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.JSClickOnElement;
import net.thucydides.core.annotations.Step;

public class HomePage extends PageObject {
	
	@FindBy(linkText="Dashboard")
    public WebElementFacade lnkDashboard;
	
	@FindBy(linkText="Manage Bank Accounts")
    public WebElement lnkManageBankAccount;
	
	@FindBy(xpath=".//button[text()='Accounting']")
    public WebElementFacade btnAccounting;
	
	@FindBy(linkText="Bank accounts")
    public WebElementFacade lnkBankAccounts;
	
	@FindBy(linkText="Chart of accounts")
    public WebElementFacade lnkChartOfAccounts;
	public By lnkChartAccountBy = By.linkText("Chart of accounts");
	
	@FindBy(xpath=".//*[text()='Add Bank Account']")
    public static WebElementFacade btnAddBankAccount;
	
//############################################################################################################
//Function Name:		navigateFrom 
//Input Parameter:		moveFrom
//Output Parameter:		None 
//Description:			This function is used to navigate to Add Bank Account through various entry points
//Tester:				Nagajothi Kaliappan
//############################################################################################################
		
	public void navigateFrom(String moveFrom) {
		try {
			switch(moveFrom) {
				case "Dashboard  > Manage Bank Account":
					if(lnkDashboard.isCurrentlyVisible()) {
						clickOn(lnkDashboard);
						waitFor(ExpectedConditions.elementToBeClickable(lnkManageBankAccount));
						Actions action = new Actions(getDriver());
						action.moveToElement(lnkManageBankAccount).build().perform();
						JavascriptExecutor js = (JavascriptExecutor) getDriver();
						js.executeScript("arguments[0].scrollIntoView();", lnkManageBankAccount);
						clickOn(lnkManageBankAccount);
						waitFor(ExpectedConditions.elementToBeClickable(btnAddBankAccount));
					}
					break;
				case "Accounting > Bank Accounts":
					if(btnAccounting.isCurrentlyVisible()) {
						clickOn(btnAccounting);
						waitFor(ExpectedConditions.elementToBeClickable(lnkBankAccounts));
						clickOn(lnkBankAccounts);
						waitFor(ExpectedConditions.elementToBeClickable(btnAddBankAccount));
					}
					break;
				case "Accounting > Chart of accounts":
					if(btnAccounting.isCurrentlyVisible()) {
						clickOn(btnAccounting);
						waitFor(ExpectedConditions.elementToBeClickable(lnkChartOfAccounts));
						clickOn(lnkChartOfAccounts);
						waitFor(ExpectedConditions.elementToBeClickable(btnAddBankAccount));
					}
					break;
				default:
					break;
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//############################################################################################################
//Function Name:		verifyUserLoggedIn 
//Input Parameter:		None
//Output Parameter:		None 
//Description:			This function is used to verify the successful status of login
//Tester:				Nagajothi Kaliappan
//############################################################################################################
		
	public void verifyUserLoggedIn() {
		try {
			assertTrue(LoginPage.lblUserName.isCurrentlyVisible());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
