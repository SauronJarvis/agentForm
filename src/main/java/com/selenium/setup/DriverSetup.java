package com.selenium.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSetup {
	protected WebDriver driver;
	public static String baseUrl  = "http://apps.qa2qe.cognizant.e-box.co.in/Agent_Registration/";
	public WebDriver getDriver()
	{
	
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\sanarayanan\\Desktop\\Soundar\\Automation\\drivers\\gecko v 0.18\\geckodriver.exe");
	DesiredCapabilities capabilities=DesiredCapabilities.firefox();
	capabilities.setCapability("marionette", true);
	
	driver = new FirefoxDriver(capabilities);
	driver.navigate().to(DriverSetup.baseUrl);
	return driver;
	}
}
