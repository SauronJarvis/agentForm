package com.selenium.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;

import com.selenium.pages.AgentForm;
import com.selenium.setup.DriverSetup;
import com.selenium.setup.ExcelUtils;

public class TestAgentForm extends DriverSetup{
	
	WebDriver driver;
	AgentForm agentform;
	public static String invalidEmailText;
	public static String blankErrtextForEmail;
	public static String blankErrtext;
	public static String expectedblankErrtextforEmail;
	@BeforeClass
	public void setup()
	{
	driver = getDriver();
	}
	
	@Test(priority=1)
	public void testInvalidEmailId() throws Exception{
	ExcelUtils.setExcelFile();
	agentform =new AgentForm(driver);
	String firstName = ExcelUtils.getCellData(1,1);
	String lastName = ExcelUtils.getCellData(1,2);
	String username = ExcelUtils.getCellData(1,3);
	String password = ExcelUtils.getCellData(1,4);
	String phoneNumber = ExcelUtils.getCellData(1,5);
	String email = ExcelUtils.getCellData(1,6);
	agentform.setFirstName(firstName);
	agentform.setLastName(lastName);
	agentform.setUserName(username);
	agentform.setPassword(password);
	agentform.setPhoneNumber(phoneNumber);
	agentform.setEmail(email);
	agentform.submit();
	Thread.sleep(3000);;
	blankErrtextForEmail=agentform.getErrorMessageInvalidEmail();
	System.out.println("error message " + blankErrtextForEmail);
	expectedblankErrtextforEmail ="Enter a valid email id";
	if(blankErrtextForEmail.equalsIgnoreCase(expectedblankErrtextforEmail))
	{
		System.out.println("in Pass");
		ExcelUtils.setCellData("Passed", 1, 7);
	}
	else{
		ExcelUtils.setCellData("Failed", 1, 7);
	}
	
	}
	@Test(priority =2)
	public void testBlankForPasswordAndEmail() throws Exception{
	ExcelUtils.setExcelFile();
	agentform =new AgentForm(driver);
	String firstName = ExcelUtils.getCellData(2,1);
	String lastName = ExcelUtils.getCellData(2,2);
	String username = ExcelUtils.getCellData(2,3);
	String phoneNumber = ExcelUtils.getCellData(2,5);
	//String password = ExcelUtils.getCellData(2,4);
	//String email = ExcelUtils.getCellData(2,6);
	agentform.setFirstName(firstName);
	agentform.setLastName(lastName);
	agentform.setUserName(username);
	agentform.setPhoneNumber(phoneNumber);
	//agentform.setPassword(password);
	//agentform.setEmail(email);
	agentform.submit();
	Thread.sleep(3000);
	blankErrtext =agentform.getErrorMessage();
	System.out.println(blankErrtext);
	if(blankErrtext.equalsIgnoreCase("Password cannot be blank"+"\n"+ "Email cannot be blank"))
	//if(blankErrtext.contentEquals("phoneNumber cannot be blank Email cannot be blank"))// &&(blankErrtext.contains("Email cannot be blank")))
	{
		System.out.println("in Pass");
	ExcelUtils.setCellData("Passed", 2,7);
	}
	else{
		System.out.println("in Fail");
	ExcelUtils.setCellData("Failed",2,7);
	}
	}
	@AfterClass
	public void teardown()
	{
	driver.quit();
	}

}
