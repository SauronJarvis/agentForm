package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.setup.DriverSetup;

public class DisplayAgent extends DriverSetup
{

	public DisplayAgent(WebDriver driver)
	{
	this.driver =driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath =("//tbody/tr/td[2]"))
	public WebElement name;
	@FindBy(xpath =("//tbody/tr[2]/td[2]"))
	public WebElement uname;
	@FindBy(xpath =("//tbody/tr[3]/td[2]"))
	public WebElement phno;
	@FindBy(xpath =("//tbody/tr[4]/td[2]"))
	public WebElement mail;
	@FindBy(xpath = "//h2[text()='Registered Succesfully']")
	public WebElement h2;

	public String getTitle()
	{
	return h2.getText();
	}
	public String getName(){
	return name.getText();
	}
	public String getUserName(){
	return uname.getText();
	}
	public String getEmail(){
	return mail.getText();
	}
	public String getNumber(){
	return phno.getText();
	}
	
}
