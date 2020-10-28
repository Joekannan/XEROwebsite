package com.xero.web.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.commons.lang3.RandomStringUtils;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import groovy.time.Duration;
import groovy.transform.Undefined.EXCEPTION;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class BankAccountPage extends PageObject {
	public static String accountName;

	@FindBy(css="input[name*=searchfield]")
    public WebElementFacade txtSearchBank;
	
	public By lstBanks = By.xpath(".//div[contains(@id,'ba-banklist')]//li");
		
	@FindBy(css="input[name*=accountname]")
    public WebElementFacade txtAccountName;
	
	@FindBy(css="input[name*=accountname]")
    public List<WebElement> txtMultipleAccountNames;
	
	@FindBy(css="input[name*=accounttype]")
    public WebElementFacade txtAccountType;
	
	@FindBy(css="input[name*=accounttype]")
    public List<WebElement> txtMultipleAccountTypes;
	
	public By lstAccountType = By.xpath(".//li[@class='ba-combo-list-item']");	
	
	@FindBy(xpath=".//div[contains(@class,'invalid')]//input[contains(@id,'accountnumber')]")
    public WebElementFacade txtAccountNum;
	
	@FindBy(xpath=".//label[text()='Credit Card Number']//following::input[2]")
    public WebElementFacade txtCreditCardAccountNum;
	
	@FindBy(xpath=".//label[text()='Credit Card Number']//following::input[2]")
    public List<WebElement> txtMulitpleCreditCardAccountNum;
	
	@FindBy(xpath=".//span[contains(text(),'Add another')]")
    public WebElementFacade lnkAddAnotherAccount;
	
	@FindBy(xpath=".//span[contains(text(),'Continue')]")
    public WebElementFacade btnContinue;
	
	@FindBy(xpath=".//div[@class='bank']//a[contains(@class,'bank-name')]")
    public List<WebElement> lblAddedBankNames;
	
	@FindBy(css="div[data-ref=errorEl] ul li")
    public List<WebElement> lblError;
	
//############################################################################################################
//Function Name:		nameGenrator 
//Input Parameter:		None
//Output Parameter:		accountName Type String 
//Description:			This function is used to generate a random string to add in Account Name
//Tester:				Nagajothi Kaliappan
//############################################################################################################
	
	public static String nameGenrator() {
		accountName = "Business Saving Account " + RandomStringUtils.randomAlphabetic(3);
		System.out.println(accountName);
		return accountName;
	}
	
//############################################################################################################
//Function Name:		numGenerator 
//Input Parameter:		None
//Output Parameter:		num Type String 
//Description:			This function is used to generate a random numbers to add in Account Number and Last 4 digit field
//Tester:				Nagajothi Kaliappan
//############################################################################################################
		
	public static String numGenerator(int length) {
		boolean useLetters = false;
		boolean useNumbers = true;
		String num = RandomStringUtils.random(length, useLetters, useNumbers);
		System.out.println(num);
		return num;
	}
//############################################################################################################
//Function Name:		clickAddBankAccount 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to click the Add Bank Account from Accounting->Bank accounts and 
// 						Accounting > Chart of accounts
//Tester:				Nagajothi Kaliappan
//############################################################################################################
	
	public void clickAddBankAccount() {
		try {
			if(HomePage.btnAddBankAccount.isCurrentlyVisible()) {
				clickOn(HomePage.btnAddBankAccount);
				waitFor(ExpectedConditions.elementToBeClickable(txtSearchBank));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//############################################################################################################
//Function Name:		enterBankName 
//Input Parameter:		bankName
//Output Parameter:		None
//Description:			This function is used to update the bank name - this can be changed in cucumber feature file
//Tester:				Nagajothi Kaliappan
//############################################################################################################
		
	public void enterBankName(String bankName) {
		try {
			if(txtSearchBank.isCurrentlyVisible()) {
				typeInto(txtSearchBank, bankName);
				Thread.sleep(3000);
				int bankList = getDriver().findElements(lstBanks).size();
				List <WebElement> lstBanking = getDriver().findElements(lstBanks);
				if(bankList > 0) {
					for(WebElement lstBank : lstBanking) {
						if(lstBank.getText().equalsIgnoreCase(bankName)) {
							clickOn(lstBank);
							waitFor(ExpectedConditions.elementToBeClickable(txtAccountName));
							break;
						}
					}
					
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//############################################################################################################
//Function Name:		enterAccountName 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to enter account name using random string method
//Tester:				Nagajothi Kaliappan
//############################################################################################################
	
	public void enterAccountName() {
		try {
			if(txtAccountName.isCurrentlyVisible()) {
				typeInto(txtAccountName, nameGenrator());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//############################################################################################################
//Function Name:		enterAccountName 
//Input Parameter:		accName
//Output Parameter:		None
//Description:			This function is used to enter account name using user input
//Tester:				Nagajothi Kaliappan
//############################################################################################################
	public void enterAccountName(String accName) {
		try {
			if(txtAccountName.isCurrentlyVisible()) {
				typeInto(txtAccountName, accName);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//############################################################################################################
//Function Name:		enterAccountType 
//Input Parameter:		accountType
//Output Parameter:		None
//Description:			This function is used to select the type of account from the dropdown - values from cucumber feature file
//Tester:				Nagajothi Kaliappan
//############################################################################################################
	
	public void enterAccountType(String accountType) {
		try {
			if(txtAccountType.isCurrentlyVisible()) {
				clickOn(txtAccountType);
				waitFor(ExpectedConditions.elementToBeClickable(lstAccountType));
				int noOfAccountType = getDriver().findElements(lstAccountType).size();
				List <WebElement> lstAccountTypes = getDriver().findElements(lstAccountType);
				if(noOfAccountType > 0) {
					for(WebElement lstType : lstAccountTypes) {
						if(lstType.getText().equalsIgnoreCase(accountType)) {
							clickOn(lstType);
							break;
						}
					}	
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//############################################################################################################
//Function Name:		enterAccountNumber 
//Input Parameter:		accountType
//Output Parameter:		None
//Description:			This function is used to enter the account number using random num method based on the account type
//Tester:				Nagajothi Kaliappan
//############################################################################################################

	public void enterAccountNumber(String accountType) {
		try {
			switch(accountType) {
				case "Credit Card":
					typeInto(txtCreditCardAccountNum, numGenerator(4));
					break;
				case "Everyday (day-to-day)": 
				case "Loan": 
				case "Term Deposit": 
				case "Other":
					txtAccountType.sendKeys(Keys.TAB+numGenerator(15));
					break;
				default:
					break;
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//############################################################################################################
//Function Name:		clickContinue 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to click the continue button once account details are added
//Tester:				Nagajothi Kaliappan
//############################################################################################################
	public void clickContinue() {
		try {
			if(btnContinue.isCurrentlyEnabled()) {
				clickOn(btnContinue);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//############################################################################################################
//Function Name:		verifyAddedBank 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to verify the added bank under BankAccounts page
//Tester:				Nagajothi Kaliappan
//############################################################################################################
		
	public void verifyAddedBank() {
		try {
			int noOfBanks = lblAddedBankNames.size();
			if(noOfBanks > 0) {
				for(WebElement lblAddedbank : lblAddedBankNames) {
					if(lblAddedbank.getText().trim().contains(accountName)) {
						System.out.println(lblAddedbank.getText().trim());
						System.out.println(accountName);
						assertThat(lblAddedbank.getText().trim(), CoreMatchers.containsString(accountName.trim()));
					}
				}
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//############################################################################################################
//Function Name:		addAnotherAccount 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to click "Add Another account" link
//Tester:				Nagajothi Kaliappan
//############################################################################################################
		
	public void addAnotherAccount() {
		try {
			if(lnkAddAnotherAccount.isClickable()) {
				clickOn(lnkAddAnotherAccount);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

//############################################################################################################
//Function Name:		validateAccountNameAndTypeError 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to validate the error message when account name and type is missing
//Tester:				Nagajothi Kaliappan
//############################################################################################################
	
	public void validateAccountNameAndTypeError() {
		try {
			if(lblError.size() == 2) {
				assertEquals("Account Name required", lblError.get(0).getText());
				assertEquals("Account Type required", lblError.get(1).getText());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//############################################################################################################
//Function Name:		validateAccountNameAndNumberError 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to validate the error message when account name and number is missing
//Tester:				Nagajothi Kaliappan
//############################################################################################################
		
	public void validateAccountNameAndNumberError() {
		try {
			if(lblError.size() == 2) {
				assertEquals("Account Name required", lblError.get(0).getText());
				assertEquals("Account Number required", lblError.get(1).getText());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//############################################################################################################
//Function Name:		validateAccountNameAndNumberAndLastDigitError 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to validate the error message when account name and number 
//						and last 4 digit is missing
//Tester:				Nagajothi Kaliappan
//############################################################################################################
	
	public void validateAccountNameAndNumberAndLastDigitError() {
		try {
			if(lblError.size() == 3) {
				assertEquals("Account Name required", lblError.get(0).getText());
				assertEquals("Last 4 digits required", lblError.get(1).getText());
				assertEquals("Account Number required", lblError.get(2).getText());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//############################################################################################################
//Function Name:		multipleAccount 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to add multiple accounts for various and same account types
//Tester:				Nagajothi Kaliappan
//############################################################################################################

	public void multipleAccount(String accountTypes) {
		try {
			String[] types = accountTypes.split(",");
			JavascriptExecutor jse = (JavascriptExecutor)getDriver();
			for(int i=0; i <= types.length-1; i++) {
				typeInto(txtMultipleAccountNames.get(i), nameGenrator());
				Thread.sleep(1000);
				if(txtMultipleAccountTypes.size() > 0) {
					jse.executeScript("arguments[0].scrollIntoView();", txtMultipleAccountTypes.get(i));
					clickOn(txtMultipleAccountTypes.get(i));
				}
				
				List <WebElement> lstAccountTypes = getDriver().findElements(lstAccountType);
				if(lstAccountTypes.size() > 0) {
					for(WebElement lstType : lstAccountTypes) {
						if(lstType.getText().equalsIgnoreCase(types[i].trim())) {
							clickOn(lstType);
							break;
						}
						Thread.sleep(1000);
						lstAccountTypes = getDriver().findElements(lstAccountType);
					}	
				}
				System.out.println(types[i].trim());
				if(types[i].trim().equalsIgnoreCase("Credit Card")) {
					typeInto(txtMulitpleCreditCardAccountNum.get(i), numGenerator(4));
				}
				else {
					txtMultipleAccountTypes.get(i).sendKeys(Keys.TAB+numGenerator(15));
				}
				System.out.println("Add another account "+i);
				if(i < types.length-1) {
					addAnotherAccount();
				}
				
				System.out.println("clicked Add another account " + i + "time");
				txtMultipleAccountNames = getDriver().findElements(By.cssSelector("input[name*=accountname]"));
				txtMultipleAccountTypes = getDriver().findElements(By.cssSelector("input[name*=accounttype]"));
				txtMulitpleCreditCardAccountNum = getDriver().findElements(By.xpath(".//label[text()='Credit Card Number']//following::input[2]"));
				lstAccountTypes = getDriver().findElements(lstAccountType);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
