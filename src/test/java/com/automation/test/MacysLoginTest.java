package com.automation.test;

import org.testng.annotations.Test;

import com.automation.page.HomePage;
import com.automation.page.LoginPage;
import com.automation.page.Welcomepage;
import com.automation.util.BrowserSelector;
import com.automation.util.ConfigReader;
import com.automation.util.ExcelFileReader;
import com.automation.util.Reporting;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class MacysLoginTest {
	//Data provider
  @DataProvider(name="testdata")
  public Object[][] getTestDataForLogin() throws IOException {
	  ExcelFileReader excelFileReaderObj = new ExcelFileReader();
	  excelFileReaderObj.locateAndOpenExcelFile();
	  Object[][] testData = excelFileReaderObj.getTestData();
	  return testData;
  }
	
  @Test(dataProvider = "testdata")
  public void macysLoginScriptTest(String emailAdress, String passwordText) throws IOException {
	
	  //  a) open the browser - ff/chrome
	//	create the BrowserSelector object
	  BrowserSelector browserSelectorObject = new BrowserSelector();
	  WebDriver driver = browserSelectorObject.openBrowser("firefox");
	  
	  Reporting reporter = new Reporting();
	  reporter.createReport("Macys Login Functionality Test", driver);
	  
	  reporter.report("pass", "Open Browser", "Browser is opened");

	//b) navigate to www.macys.com
	//		Create configReader object
    //	read the app.url from config.properties file
    //		driver.get("http://www.macys.com")
	ConfigReader configReaderObj = new ConfigReader();
	configReaderObj.readAndLoadPropertiesFile();
	String appUrl = configReaderObj.getApplicationUrl();
	driver.get(appUrl);
	reporter.report("Pass", "Navigate URL - " + appUrl,  "URL is navigated successfully");
	
//	driver.navigate().refresh();
//	driver.findElement(By.xpath("//a[text()='Shipping To']")).click();
//	driver.findElement(By.id("shipToUS")).click();
	
	
	//c) click on "sign in" link
   //   create HomePage class object
   //	call clickSignInLink() method
	HomePage homePageObj = new HomePage(driver);
	homePageObj.clickSignInLink();
	reporter.report("pass", "Click Sign In link", "Sign link is clicked");
	
	
	//d) Enter email address, password, click sign in button
//		Read testdata from excel - create an object for ExcelFileReader and call the methods
//		create SignInPage class object
//		call submitLoginCredentials() method - use the test data
		
		LoginPage signInPageObj = new LoginPage(driver);
		signInPageObj.EnterLoginCredentials(emailAdress, passwordText);
		reporter.report("pass", "Enter email address: " + emailAdress + " Password: " + passwordText, "Login Details are entered");
	
	//e) Verify sign in successful
    //	create object for WelcomePage class
    //	call verifyLoginIsSuccessful() method
		Welcomepage welcomePageObj = new Welcomepage(driver);
		welcomePageObj.verifyLoginIsSuccessful();
		reporter.report("pass", "Verify login is successful", "Login functionality is working");
		
	//f) Click on "sign out" link
   //    call clicksignOut() method
		welcomePageObj.clicksignOut();
		reporter.report("pass", "Click sign out", "sign out is done");
		
	//g)  Repeat steps a to f for different users
//		use testng data provider annotation to repeat the steps a to f
		
		driver.quit();
		
		reporter.generateReport();
  }
}
