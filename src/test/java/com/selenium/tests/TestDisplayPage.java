package com.selenium.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;

import com.selenium.pages.AgentForm;
import com.selenium.pages.DisplayAgent;
import com.selenium.setup.DriverSetup;
import com.selenium.setup.ExcelUtils;



public class TestDisplayPage extends DriverSetup{

	AgentForm agentForm;
	WebDriver driver ;
	DisplayAgent welcomepage;
	public static String titletxt;
	public static String nametxt;
	public static String unametxt;
	public static String phonenumbertxt;
	@BeforeClass
	public void setup()
	{
	driver =getDriver();
	}
	@Test(priority = 3)
	public void testForValidAgent() throws Exception{
	welcomepage = new DisplayAgent(driver);
	agentForm = new AgentForm(driver);
	ExcelUtils.setExcelFile();
	String firstName = ExcelUtils.getCellData(3,1);
	String lastName = ExcelUtils.getCellData(3,2);
	String username = ExcelUtils.getCellData(3,3);
	String password = ExcelUtils.getCellData(3,4);
	String phoneNumber = ExcelUtils.getCellData(3,5);
	String email = ExcelUtils.getCellData(3,6);
	agentForm.setFirstName(firstName);
	agentForm.setLastName(lastName);
	agentForm.setUserName(username);
	agentForm.setPassword(password);
	agentForm.setPhoneNumber(phoneNumber);
	agentForm.setEmail(email);
	agentForm.submit();
	Thread.sleep(3000);
	titletxt = welcomepage.getTitle();
	System.out.println("page Title " + titletxt);
	
	if(titletxt.equalsIgnoreCase("Registered Succesfully"))
	{
	System.out.println("in pass");
	nametxt = welcomepage.getName();
	unametxt = welcomepage.getUserName();
	phonenumbertxt = welcomepage.getNumber();
	
	System.out.println("Name: " + nametxt);
	System.out.println("Username: " + username);
	System.out.println("Phone: " + phoneNumber);
	ExcelUtils.setCellData("Passed", 3, 7);
	}
	else
	{
	System.out.println("in fail");
	ExcelUtils.setCellData("Failed",3, 7);
	}
	}
	@AfterClass
	public void teardown(){
	driver.quit();
	}

	
}
