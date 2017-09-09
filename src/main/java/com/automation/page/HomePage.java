package com.automation.page;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
//	constructor
	public HomePage(WebDriver driverObject) {
		PageFactory.initElements(driverObject, this);
	}
	
//	instance variables - elements
	//WebElement signInLink = driver.findElement(By.id("globalMastheadSignIn"));
	@FindBy(xpath="//span[text()='Hello. Sign in']")
	WebElement signInLink; 
	
//	methods - action on the elements
	public void clickSignInLink() {
		signInLink.click();
	}
}

