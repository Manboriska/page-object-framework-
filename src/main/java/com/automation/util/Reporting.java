package com.automation.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporting {

	String reportsFilePath = "C:\\Training\\autoproject\\properties\\reports\\ExecutionReport2.html";
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;

	// create the HTML report
	public void createReport(String testName, WebDriver driverObject) {
		report = new ExtentReports(reportsFilePath);
		logger = report.startTest(testName);
		driver = driverObject;
	}

	// report the step as pass/fail
	public void report(String status, String stepName, String actualResultDetails) {

		if (status.equalsIgnoreCase("pass")) {
			logger.log(LogStatus.PASS, stepName, actualResultDetails);
		} else if (status.equalsIgnoreCase("fail")) {

			// take screenshot of the current state of the application
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			String screenshotPath = "C:\\Training\\autoproject\\properties\\Reports\\screenshot.png";
			File screenshotFile = new File(screenshotPath);

			try {
				FileUtils.copyFile(src, screenshotFile);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// report the step as fail
			// embed the screenshot in the HTML report
			logger.log(LogStatus.FAIL, stepName, actualResultDetails + logger.addScreenCapture(screenshotPath));

		}
	}

	// generate the report
	public void generateReport() {
		report.endTest(logger);
		report.flush();
		report.close();
	}
}
