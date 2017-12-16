package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.setup.DriverSetup;

public class AgentForm extends DriverSetup{

	public AgentForm(WebDriver driver){
		this.driver =driver;
		PageFactory.initElements(driver,this);
		}
		@FindBy(xpath= ("//input[@name ='firstname']"))
		public WebElement fname;
		@FindBy(xpath= ("//input[@name ='lastname']"))
		public WebElement lname;
		@FindBy(xpath= ("//input[@name ='username']"))
		public WebElement uname;
		@FindBy(xpath= ("//input[@name ='password']"))
		public WebElement pass;
		@FindBy(xpath= ("//input[@name ='phonenumber']"))
		public WebElement  phno;
		@FindBy(xpath= ("//input[@name ='email']"))
		public WebElement mail;
		@FindBy(xpath= ("//input[@id ='submit']"))
		public WebElement submit;
		@FindBy(xpath= ("//input[@id ='reset']"))
		public WebElement reset;
		@FindBy(xpath= ("//input[@id ='message']"))
		public WebElement emessage;
		@FindBy(xpath="//div[@id='message']")
		public WebElement invalidEmailerrorMsg;
		public void setFirstName(String fnameTxt) throws InterruptedException{
		//waitforpage(2);
		fname.clear();
		fname.sendKeys(fnameTxt);
		}
		public void setLastName(String lnameTxt) throws InterruptedException{
		//waitforpage(2);
		lname.clear();
		lname.sendKeys(lnameTxt);
		}
		public void setUserName(String unameTxt) throws InterruptedException{
		//waitforpage(2);
		uname.clear();
		uname.sendKeys(unameTxt);
		}
		public void setPassword(String passwordTxt) throws InterruptedException{
		//waitforpage(2);
		pass.clear();
		pass.sendKeys(passwordTxt);
		}
		public void setPhoneNumber(String phoneNumberTxt) throws InterruptedException{
		//waitforpage(2);
		phno.clear();
		phno.sendKeys(phoneNumberTxt);
		}
		public void setEmail(String emailTxt) throws InterruptedException{
		//waitforpage(2);
		mail.clear();
		mail.sendKeys(emailTxt);
		}
		public void submit() throws InterruptedException{
		//waitforpage(2);
		submit.click();
		}
		public String getErrorMessage() throws InterruptedException{
		return invalidEmailerrorMsg.getText();			
		}
		public String getErrorMessageInvalidEmail() throws InterruptedException{
			return invalidEmailerrorMsg.getText();			
			}
	
}
