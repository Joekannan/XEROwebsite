package com.xero.web.steps.serenity;

import com.xero.web.pages.LoginPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginSteps extends ScenarioSteps {
	
	LoginPage loginPage;
	
	@Step
	public void login(String email, String password) {
		try {
			loginPage.lanuchApplication();
			loginPage.enterUsername(email);
			loginPage.enterPassword(password);
			loginPage.clickLogin();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
