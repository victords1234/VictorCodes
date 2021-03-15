package com.crm.vtiger;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.objectRepoUtility.HomePage;
import com.crm.comcast.objectRepoUtility.NewCustomViewPage;
import com.crm.comcast.objectRepoUtility.OrganizationsPage;
import com.vtigercrm.genericutilities.BaseClass;

public class FilterOrgByAllTest extends BaseClass {
@Test
public void orgTC24() throws AWTException
{
	
	//Navigate to Organization
	HomePage hp=new HomePage(driver);
	hp.getOrgLink().click();
	OrganizationsPage op=new OrganizationsPage(driver);
	op.getAddOrg().click();
	wUtil.selectDropDown(driver, op.getFilterDropDowwn(), 1);
	
	//navigate to Create Filter page
	op.getCreateFilter().click();
	
	//Validate Organization Page
	NewCustomViewPage cnp=new NewCustomViewPage(driver);
	Assert.assertTrue("Org".contains(cnp.getValidateOrg().getText()));
	
	}
}
