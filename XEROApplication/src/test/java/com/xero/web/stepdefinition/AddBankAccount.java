package com.xero.web.stepdefinition;

import com.xero.web.steps.serenity.BankAccountSteps;
import com.xero.web.steps.serenity.HomePageSteps;
import com.xero.web.steps.serenity.LoginSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AddBankAccount {
	
	@Steps
	LoginSteps loginSteps;
	
	@Steps
	HomePageSteps homePageSteps;
	
	@Steps
	BankAccountSteps bankAccountSteps;

	
	@Given("^Xero Account details to login \"([^\"]*)\" and \"([^\"]*)\"$")
	public void xero_Account_details_to_login_and(String email, String password) {
		loginSteps.login(email, password);
	}


	@Given("^Xero user on Dashboard$")
	public void xero_user_on_Dashboard() {
		homePageSteps.verifyLogin();
	}

	@When("^Xero user adds \"([^\"]*)\" Bank Account from \"([^\"]*)\" for \"([^\"]*)\"$")
	public void xero_user_adds_Bank_Account_from_for(String bank, String from, String accountType) {
		homePageSteps.traverseFrom(from);
		bankAccountSteps.addAccount(bank,accountType);
	}

	@Then("^the added account should be available at Bank Accounts$")
	public void the_added_account_should_be_available_at_Bank_Accounts() {
		bankAccountSteps.verifyAddedBank();
	}
	
	@When("^Xero user adds multiple \"([^\"]*)\" Bank Accounts from \"([^\"]*)\" for \"([^\"]*)\"$")
	public void xero_user_adds_multiple_Bank_Accounts_from_for(String bank, String from, String accountType) {
	    homePageSteps.traverseFrom(from);
		bankAccountSteps.addMultipleAccount(bank,accountType);
	}

	@When("^Xero user fails to update Account Name and Account Type and Account Number$")
	public void xero_user_fails_to_update_Account_Name_and_Account_Type_and_Account_Number() {
		homePageSteps.traverseFrom("Accounting > Bank Accounts");
		bankAccountSteps.enterEmptyValues("ANZ (NZ)");
	}

	@Then("^the appropriate \"([^\"]*)\" UI error should be displayed$")
	public void the_appropriate_UI_error_should_be_displayed(String error) {
		switch(error) {
			case "Missing":
				bankAccountSteps.validateEmptyValueError();
				break;
//			case "UniqueName":
//				bankAccountSteps.validateDuplicateNameError();
//				break;
			default:
				break;
		}
		
	}

	@When("^Xero user adds the existing Account Name$")
	public void xero_user_adds_the_existing_Account_Name() {
	}

}
