package com.crm.comcast.objectRepoUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOpportunity {
	@FindBy(xpath="//input[@name='potentialname']")
	private WebElement Opp_Name;

	@FindBy(xpath="//select[@name='related_to_type']")
	private WebElement related_To;

	@FindBy(xpath="//input[@name='assigntype' and @value='T']")
	private WebElement assigned_To;


	@FindBy(xpath="//select[@name='assigned_group_id']")
	private WebElement assigned_To_Drp;

	@FindBy(xpath="//select[@name='related_to_type']")
	private WebElement Related_To_Drp;
	
	public WebElement getClickFilter() {
		return ClickFilter;
	}

	@FindBy(linkText="Create Filter")
	private WebElement ClickFilter;

	@FindBy(xpath="//input[@value='U']")
	private WebElement Assign_To_User;

	public WebElement getAssign_To_User() {
		return Assign_To_User;
	}

	public WebElement getRelated_To_Drp() {
		return Related_To_Drp;
	}
	
	public WebElement getAssigned_To_Drp() {
		return assigned_To_Drp;
	}
	
	@FindBy(xpath="//img[@id='jscal_trigger_closingdate']")
	private WebElement cal;

	@FindBy(xpath="")
	private WebElement expected_close_date;

	@FindBy(xpath="//select[@name='sales_stage']")
	private WebElement sales_stage;

	@FindBy(xpath="(//img[@alt='Select'])[1]")
	private WebElement OrgLookUp;

	@FindBy(xpath="((//input[@class='crmbutton small save'])[1])")
	private WebElement ClickSave;

	@FindBy(xpath="((//input[@accesskey='X'])[1])")
	private WebElement ClickCancel;

	public WebElement getClickSave() {
		return ClickSave;
	}

	public CreateNewOpportunity(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpp_Name() {
		return Opp_Name;
	}

	public WebElement getRelated_To() {
		return related_To;
	}

	public WebElement getAssigned_To() {
		return assigned_To;
	}

	public WebElement getOrgLookUp() {
		return OrgLookUp;
	}

	public WebElement getExpected_close_date() {
		return expected_close_date;
	}

	public WebElement getSales_stage() {
		return sales_stage;
	}

	public WebElement getCal() {
		return cal;
	}

	public WebElement getClickCancel() {
		return ClickCancel;
	}
}
