package com.crm.comcast.objectRepoUtility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement username;
	
	@FindBy(xpath="//input[@name='user_password']")
	private WebElement password;
	
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public void LoginToApp()
	{
		username.sendKeys("admin");
		password.sendKeys("admin",Keys.ENTER);
	}
	public void LoginToApp(String Enter_UserName,String Enter_Password)
	{
		username.sendKeys(Enter_UserName);
		password.sendKeys(Enter_Password,Keys.ENTER);
	}
}
