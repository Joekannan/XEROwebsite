package com.xero.web.pages;

import net.serenitybdd.core.pages.WebElementFacade;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

public class LoginPage extends PageObject {

    @FindBy(name="userName")
    public WebElementFacade txtEmail;

    @FindBy(name="password")
    public WebElementFacade txtPassword;
    
    @FindBy(id="submitButton")
    public WebElementFacade btnLogin;

    @FindBy(xpath=".//button[@type='button']/div[@role='presentation']/abbr")
    public static WebElementFacade lblUserName;
    
    
  //############################################################################################################
  //Function Name:			lanuchApplication 
  //Input Parameter:		None
  //Output Parameter:		None 
  //Description:			This function is used to launch the AUT and maximize the window
  //Tester:					Nagajothi Kaliappan
  //############################################################################################################

    public void lanuchApplication() {
    	try {
    		open();
    		getDriver().manage().window().maximize();
    		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		String title= getDriver().getTitle();
    		assertEquals("Login | Xero Accounting Software", title.trim());
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
//############################################################################################################
//Function Name:		enterUsername 
//Input Parameter:		email
//Output Parameter:		None 
//Description:			This function is used to enter email at the login page
//Tester:				Nagajothi Kaliappan
//############################################################################################################

    public void enterUsername(String email) {
    	try {
    		typeInto(txtEmail, email);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
  //############################################################################################################
  //Function Name:			enterPassword 
  //Input Parameter:		pwd
  //Output Parameter:		None 
  //Description:			This function is used to enter password at the login page
  //Tester:					Nagajothi Kaliappan
  //############################################################################################################

    public void enterPassword(String pwd) {
    	try {
    		typeInto(txtPassword, pwd);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
//############################################################################################################
//Function Name:		clickLogin 
//Input Parameter:		pwd
//Output Parameter:		None 
//Description:			This function is used to click login button at the login page
//Tester:				Nagajothi Kaliappan
//############################################################################################################

    public void clickLogin() {
    	try {
    		clickOn(btnLogin);
        	waitFor(ExpectedConditions.visibilityOf(lblUserName));
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}