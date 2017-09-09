package com.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	
	@FindBy(id = "ap_email")
	WebElement email;

	@FindBy(how = How.ID, using = "ap_password")
	WebElement password1;

	@FindBy(id = "signInSubmit")
	WebElement submit;

	// constructor
	public LoginPage(WebDriver driverObject) {
		PageFactory.initElements(driverObject, this);
	}

	// methods - action on the loginName element
	public void EnterLoginCredentials(String login, String password) {
		email.sendKeys(login);
		password1.sendKeys(password);
		submit.click();
	}
}
