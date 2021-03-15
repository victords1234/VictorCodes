package com.crm.comcast.objectRepoUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
@FindBy(xpath="//img[@title='Create Opportunity...']")
private WebElement ClickOpp;

@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement expOpp;

@FindBy(xpath="(//select[@name='search_field'])[1]")
private WebElement inDropDown;


public WebElement getInDropDown() {
	return inDropDown;
}


public OpportunitiesPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

		
public WebElement getClickOpp() {
	
	return ClickOpp;
}
}
