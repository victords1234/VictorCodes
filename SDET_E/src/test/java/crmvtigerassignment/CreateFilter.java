package crmvtigerassignment;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.comcast.objectRepoUtility.ContactsPage;
import com.crm.comcast.objectRepoUtility.CreateNewContactPage;
import com.crm.comcast.objectRepoUtility.CreateNewOpportunity;
import com.crm.comcast.objectRepoUtility.HomePage;
import com.crm.comcast.objectRepoUtility.NewCustomViewPage;
import com.crm.comcast.objectRepoUtility.OpportunitiesPage;
import com.crm.comcast.objectRepoUtility.OrganizationsPage;
import com.vtigercrm.genericutilities.BaseClass;

public class CreateFilter extends BaseClass {
@Test(groups="SmokeTest")
public void CreateFilterTC_26() throws Throwable
{
	//Precondition:Contact should be present
	HomePage hp=new HomePage(driver);
	hp.getContactsLink().click();
	ContactsPage con=new ContactsPage(driver);
	con.getCreateCon().click();
	CreateNewContactPage cp=new CreateNewContactPage(driver);
	String ln = eUtil.ReadDataFromExcel("Sheet2",2,6)+JUtil.generateRandomNum();
	cp.getLastName().sendKeys(ln);
	cp.getSaveCon().click();
	Thread.sleep(5000);
	
	//Create Opportunities with entering mandatory fields
	
	wUtil.elementToBeClickable(driver, hp.getCreateOpportunity());
	OpportunitiesPage op=new OpportunitiesPage(driver);
	wUtil.elementToBeClickable(driver, op.getClickOpp());
	CreateNewOpportunity c=new CreateNewOpportunity(driver);
	String opp_Name = eUtil.ReadDataFromExcel("Sheet2",1, 2);
	c.getOpp_Name().sendKeys(opp_Name);
	String co = eUtil.ReadDataFromExcel("Sheet2",2,5);
	wUtil.selectDropDown(driver, c.getRelated_To_Drp(), co);
	c.getOrgLookUp().click();
	wUtil.switctToWindow(driver,"module=Contacts&action");
	con.getSearch().sendKeys(ln);
	driver.findElement(By.xpath("//table/tbody//tr/td/a[.=' "+ln+"']")).click();
	wUtil.switctToWindow(driver,"module=Potentials&action");
	c.getAssign_To_User().click();
	c.getCal().click();
	String pros = eUtil.ReadDataFromExcel("Sheet2",2,3);
	wUtil.selectDropDown(driver, c.getSales_stage(), pros);
	c.getClickSave().click();
	
	//Create a View name with mandatory field
	wUtil.elementToBeClickable(driver, hp.getCreateOpportunity());
	c.getClickFilter().click();
	NewCustomViewPage ncp=new NewCustomViewPage(driver);
	String view_name = eUtil.ReadDataFromExcel("Sheet2",2,7);
	ncp.getViewName().sendKeys(view_name);
	ncp.getSaveFilter().click();
}
@Test(groups="SmokeTest")
public void CreateFilterTC_27() throws Throwable
{
	//Precondition:Contact should be present
	HomePage hp=new HomePage(driver);
	hp.getContactsLink().click();
	ContactsPage con=new ContactsPage(driver);
	con.getCreateCon().click();
	CreateNewContactPage cp=new CreateNewContactPage(driver);
	String ln = eUtil.ReadDataFromExcel("Sheet2",2,6)+JUtil.generateRandomNum();
	cp.getLastName().sendKeys(ln);
	cp.getSaveCon().click();
	Thread.sleep(5000);
	
	//Create Opportunities with entering mandatory fields
	
	wUtil.elementToBeClickable(driver, hp.getCreateOpportunity());
	OpportunitiesPage op=new OpportunitiesPage(driver);
	wUtil.elementToBeClickable(driver, op.getClickOpp());
	CreateNewOpportunity c=new CreateNewOpportunity(driver);
	String opp_Name = eUtil.ReadDataFromExcel("Sheet2",1, 2);
	c.getOpp_Name().sendKeys(opp_Name);
	String co = eUtil.ReadDataFromExcel("Sheet2",2,5);
	wUtil.selectDropDown(driver, c.getRelated_To_Drp(), co);
	c.getOrgLookUp().click();
	wUtil.switctToWindow(driver,"module=Contacts&action");
	con.getSearch().sendKeys(ln);
	driver.findElement(By.xpath("//table/tbody//tr/td/a[.=' "+ln+"']")).click();
	wUtil.switctToWindow(driver,"module=Potentials&action");
	c.getAssign_To_User().click();
	c.getCal().click();
	String pros = eUtil.ReadDataFromExcel("Sheet2",2,3);
	wUtil.selectDropDown(driver, c.getSales_stage(), pros);
	c.getClickSave().click();
	
	//Fill all mandatory fields in create filter and save
	wUtil.elementToBeClickable(driver, hp.getCreateOpportunity());
	c.getClickFilter().click();
	NewCustomViewPage ncp=new NewCustomViewPage(driver);
	String view_name = eUtil.ReadDataFromExcel("Sheet2",2,7);
	ncp.getViewName().sendKeys(view_name);
	ncp.getSaveFilter().click();
}
@Test
public void CreateFilterTC_28() throws Throwable
{
	//Precondition:Contact should be present
	HomePage hp=new HomePage(driver);
	hp.getContactsLink().click();
	ContactsPage con=new ContactsPage(driver);
	con.getCreateCon().click();
	CreateNewContactPage cp=new CreateNewContactPage(driver);
	String ln = eUtil.ReadDataFromExcel("Sheet2",2,6)+JUtil.generateRandomNum();
	cp.getLastName().sendKeys(ln);
	cp.getSaveCon().click();
	Thread.sleep(5000);
	
	//Create Opportunities with entering mandatory fields
	wUtil.elementToBeClickable(driver, hp.getCreateOpportunity());
	OpportunitiesPage op=new OpportunitiesPage(driver);
	wUtil.elementToBeClickable(driver, op.getClickOpp());
	CreateNewOpportunity c=new CreateNewOpportunity(driver);
	String opp_Name = eUtil.ReadDataFromExcel("Sheet2",1, 2);
	c.getOpp_Name().sendKeys(opp_Name);
	String co = eUtil.ReadDataFromExcel("Sheet2",2,5);
	wUtil.selectDropDown(driver, c.getRelated_To_Drp(), co);
	c.getOrgLookUp().click();
	wUtil.switctToWindow(driver,"module=Contacts&action");
	con.getSearch().sendKeys(ln);
	driver.findElement(By.xpath("//table/tbody//tr/td/a[.=' "+ln+"']")).click();
	wUtil.switctToWindow(driver,"module=Potentials&action");
	c.getAssign_To_User().click();
	c.getCal().click();
	String pros = eUtil.ReadDataFromExcel("Sheet2",2,3);
	wUtil.selectDropDown(driver, c.getSales_stage(), pros);
	c.getClickSave().click();
	
	//Without filling all the mandatory fields Click Save
	wUtil.elementToBeClickable(driver, hp.getCreateOpportunity());
	c.getClickFilter().click();
	NewCustomViewPage ncp=new NewCustomViewPage(driver);
	ncp.getSaveFilter().click();
}
}
