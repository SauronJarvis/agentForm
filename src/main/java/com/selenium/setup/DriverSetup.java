package com.selenium.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSetup {
	protected WebDriver driver;
	public static String baseUrl  = "http://apps.qa2qe.cognizant.e-box.co.in/Agent_Registration/";
	public WebDriver getDriver()
	{
	
<<<<<<< HEAD
	System.setProperty("webdriver.gecko.driver", "E:\\learn\\Selenium\\drivers\\geckodriver.exe");
=======
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\sanarayanan\\Desktop\\Soundar\\Automation\\drivers\\gecko v 0.18\\geckodriver.exe");
>>>>>>> 2627a4ea626d0f7f4c9b2f3335c2e3e605ef160f
	DesiredCapabilities capabilities=DesiredCapabilities.firefox();
	capabilities.setCapability("marionette", true);
	
	driver = new FirefoxDriver(capabilities);
	driver.navigate().to(DriverSetup.baseUrl);
	return driver;
	}
}
