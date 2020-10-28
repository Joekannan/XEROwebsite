package com.xero.web.testrunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"com.xero.web.stepdefinition"}
		)

public class TestRunners {

}
