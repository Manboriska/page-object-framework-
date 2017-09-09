package com.automation.page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Welcomepage {
 
 @FindBy(xpath = "//a[@id='nav-item-signout']/span")
 WebElement signOut;
 
 WebDriver driver;

 // constructor
 public Welcomepage(WebDriver driverObject) {
  driver = driverObject; 
  PageFactory.initElements(driverObject, this);
 }

 public void verifyLoginIsSuccessful() {
	 
	 WebElement welcomeMessageElement = driver.findElement(By.xpath("//a[@id='nav-link-accountList']/span[1]"));
		String welcomeMessageText = welcomeMessageElement.getText();

		assertTrue(welcomeMessageText.contains("Hello"));
 }
	 
  public void clicksignOut() {
	  WebElement welcome = driver.findElement(By.xpath("//a[@id='nav-link-accountList']/span[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(welcome).build().perform();
		signOut.click();
  } 
}