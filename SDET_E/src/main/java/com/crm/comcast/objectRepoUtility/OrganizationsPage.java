package com.crm.comcast.objectRepoUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
@FindBy(name="search_text")
private WebElement search;

@FindBy(xpath="//img[@title='Create Organization...']")
private WebElement AddOrg;

@FindBy(linkText="Create Filter")
private WebElement CreateFilter;

@FindBy(xpath="//input[@name='search']")
private WebElement clickSearch;

public WebElement getFilterDropDowwn() {
	return filterDropDowwn;
}

@FindBy(name="viewname")
private WebElement filterDropDowwn;


public WebElement getClickSearch() {
	return clickSearch;
}

@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement actOrgName;

public WebElement getActOrgName() {
	return actOrgName;
}

public OrganizationsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getAddOrg() {
	return AddOrg;
}

public WebElement getCreateFilter() {
	return CreateFilter;
}

public WebElement getSearch() {
	return search;
}
}
