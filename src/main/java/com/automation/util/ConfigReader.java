package com.automation.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ConfigReader {
	
	//locate the config.properties
		String configFilePath = "C:\\Training\\autoproject\\properties\\config.properties";
		Properties props;
		@Test
		public void readAndLoadPropertiesFile() throws IOException {
			//open the file
			FileInputStream fis = new FileInputStream(configFilePath);
			
			//creating properties object
			props = new Properties();
			
			//load the properties file
			props.load(fis);
		}
		
		public String getApplicationUrl() {
			//read property
			String value = props.getProperty("application.url");
			return value;
		}
		
		public String getFirefoxDriverPath() {
			//read property
			String value = props.getProperty("ff.driver.path");
			return value;
		}
		
		public String getChromeDriverPath() {
			//read property
			String value = props.getProperty("chrome.driver.path");
			return value;
		}
}

