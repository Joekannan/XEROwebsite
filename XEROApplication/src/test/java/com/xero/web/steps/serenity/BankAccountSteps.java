package com.xero.web.steps.serenity;

import com.xero.web.pages.BankAccountPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class BankAccountSteps extends ScenarioSteps {

	BankAccountPage bankAccountPage;
	
	@Step
	public void addAccount(String bank, String accountType) {
		try {
			bankAccountPage.clickAddBankAccount();
			bankAccountPage.enterBankName(bank);
			bankAccountPage.enterAccountName();
			bankAccountPage.enterAccountType(accountType);
			bankAccountPage.enterAccountNumber(accountType);
			bankAccountPage.clickContinue();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Step
	public void enterEmptyValues(String bank) {
		try {
			bankAccountPage.clickAddBankAccount();
			bankAccountPage.enterBankName(bank);
			bankAccountPage.clickContinue();			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Step
	public void enterDuplicateName(String bank) {
		try {
			bankAccountPage.clickAddBankAccount();
			bankAccountPage.enterBankName(bank);
			bankAccountPage.enterAccountName("Test");
			bankAccountPage.enterAccountType("Everyday (day-to-day)");
			bankAccountPage.clickContinue();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Step
	public void validateEmptyValueError() {
		try {
			bankAccountPage.validateAccountNameAndTypeError();
			bankAccountPage.enterAccountType("Other");
			bankAccountPage.clickContinue();
			bankAccountPage.validateAccountNameAndNumberError();
			bankAccountPage.enterAccountType("Credit Card");
			bankAccountPage.clickContinue();
			bankAccountPage.validateAccountNameAndNumberAndLastDigitError();			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Step
//	public void validateDuplicateNameError() {
//		try {
//			bankAccountPage.validateAccountNameAndTypeError();		
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
	@Step
	public void addMultipleAccount(String bank, String accountType) {
		try {
			bankAccountPage.clickAddBankAccount();
			bankAccountPage.enterBankName(bank);
			bankAccountPage.multipleAccount(accountType);
			bankAccountPage.clickContinue();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Step
	public void verifyAddedBank() {
		try {
			bankAccountPage.verifyAddedBank();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
