package com.crm.comcast.objectRepoUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement LastName;

	@FindBy(xpath="((//input[@value='  Save  '])[1])")
	private WebElement SaveCon;
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getLastName() {
		return LastName;
	}
	public WebElement getSaveCon() {
		return SaveCon;
	}



}
