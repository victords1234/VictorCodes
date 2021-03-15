package com.crm.comcast.objectRepoUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomViewPage {
	@FindBy(xpath="//input[@name='viewName']")
	private WebElement ViewName;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement SaveFilter;
	
	@FindBy(xpath="//input[@class='crmbutton small cancel']")
	private WebElement CancelFilter;

	@FindBy(linkText="Organizations")
	private WebElement validateOrg;

public WebElement getValidateOrg() {
		return validateOrg;
	}


public WebElement getCancelFilter() {
		return CancelFilter;
	}


public WebElement getViewName() {
	return ViewName;
}

public WebElement getSaveFilter() {
	return SaveFilter;
}
public NewCustomViewPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

}
