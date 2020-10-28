package com.xero.web.steps.serenity;

import com.xero.web.pages.HomePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class HomePageSteps extends ScenarioSteps {

	HomePage homePage;
	
	@Step
	public void traverseFrom(String from) {
		try {
			homePage.navigateFrom(from);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Step
	public void verifyLogin() {
		try {
			homePage.verifyUserLoggedIn();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
