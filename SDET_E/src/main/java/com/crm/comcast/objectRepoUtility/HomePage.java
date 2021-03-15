package com.crm.comcast.objectRepoUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtigercrm.genericutilities.WebDriverUtility;

public class HomePage {
	@FindBy(linkText="Opportunities")
	private WebElement createOpportunity;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;

	public WebElement getProductsLink() {
		return productsLink;
	}
	@FindBy(xpath="//img[@title='Create Opportunity...']")
	private WebElement CreateNewOpportunity;
	
	@FindBy(xpath="((//a[.='Organizations'])[1])")
	private WebElement OrgLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutIcon;

	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement logoutbtn;
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getCreateOpportunity() {
		return createOpportunity;
	}
	public WebElement getLogOutbtn() {
		return logoutbtn;
	}
	public WebElement getLogoutIcon() {
		return logoutIcon;
	}

	//Homepage Objects
	
	public WebElement getOrgLink() {
		return OrgLink;
	}
	public void logout(WebDriver driver)
	{
		WebDriverUtility wUtil=new WebDriverUtility();
		wUtil.moveToEle(driver, logoutIcon);
		wUtil.elementToBeClickable(driver, logoutbtn);
	}
}

