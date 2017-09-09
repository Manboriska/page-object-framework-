package com.automation.util;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class TestReporting {

	public static void main(String[] args) throws IOException {
		
		BrowserSelector browserObject = new BrowserSelector();
		
		WebDriver driver = browserObject.openBrowser("firefox");
		
		Reporting reporter = new Reporting();
		reporter.createReport("Test Report", driver);
		
		reporter.report("pass", "open browser - firefox", "browser is opened");
		
		driver.get("http://www.macys.com");
		
		if(driver.getCurrentUrl().contains("macys1")) {
			reporter.report("pass", "Navigate to http://www.macys.com url", "Navigated to URl");
		}
		else {
			reporter.report("fail", "Navigate to http://www.macys.com url", "Failed to navigate to URL");
		}
		
		reporter.generateReport();
		
		driver.quit();
		
	}

}
