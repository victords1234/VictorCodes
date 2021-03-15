package com.crm.comcast.objectRepoUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtigercrm.genericutilities.WebDriverUtility;

public class CreateOrganisationPage {
@FindBy(xpath="//input[@name='accountname']")
private WebElement OrgName;

@FindBy(xpath="(//input[@class='crmbutton small save'])[1]")
private WebElement saveOrg;

public WebElement getOrgName() {
	
	return OrgName;
}

public WebElement getSaveOrg() {
	return saveOrg;
}
public CreateOrganisationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);}
}