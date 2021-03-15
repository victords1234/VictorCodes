

package crmvtigerassignment;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.objectRepoUtility.CreateNewOpportunity;
import com.crm.comcast.objectRepoUtility.CreateOrganisationPage;
import com.crm.comcast.objectRepoUtility.HomePage;
import com.crm.comcast.objectRepoUtility.OpportunitiesPage;
import com.crm.comcast.objectRepoUtility.OrganizationsPage;
import com.vtigercrm.genericutilities.BaseClass;
@Listeners(com.vtigercrm.genericutilities.ListenerImp.class)
public class CreateOpportunity extends BaseClass {
	/**
	 * 
	 * @throws Throwable
	 */
	@Test(/*retryAnalyzer=com.vtigercrm.genericutilities.RetryAnalyzer.class*/groups="smokeTest")
	public void CreateOpp_TC_24() throws Throwable{

		//Precondition:Organisation should be created
		HomePage hp=new HomePage(driver);
		wUtil.elementToBeClickable(driver, hp.getOrgLink());
		CreateOrganisationPage cop=new CreateOrganisationPage(driver);
		OrganizationsPage o=new OrganizationsPage(driver);
		o.getAddOrg().click();
		String org = eUtil.ReadDataFromExcel("Sheet2",1, 4)+JUtil.generateRandomNum();
		cop.getOrgName().sendKeys(org);
		wUtil.elementToBeClickable(driver, cop.getSaveOrg());

		//Verification of Organization created
		wUtil.visibilityOfElement(driver, o.getActOrgName());
		Assert.assertTrue(org.contains(o.getActOrgName().getText()));
		Thread.sleep(2000);

		//Create New Opportunity
		wUtil.elementToBeClickable(driver,hp.getCreateOpportunity());
		OpportunitiesPage op=new OpportunitiesPage(driver);
		wUtil.elementToBeClickable(driver, op.getClickOpp());

		//Entering Mandatory fields
		CreateNewOpportunity c=new CreateNewOpportunity(driver);
		String opp_Name = eUtil.ReadDataFromExcel("Sheet2",1, 2);
		c.getOpp_Name().sendKeys(opp_Name);
		c.getOrgLookUp().click();
		wUtil.switctToWindow(driver,"module=Accounts&action");
		o.getSearch().sendKeys(org);
		o.getClickSearch().click();
		WebElement searchOrg = driver.findElement(By.xpath("//table/tbody/tr/td/a[.='"+org+"']"));
		wUtil.visibilityOfElement(driver, searchOrg);
		wUtil.switctToWindow(driver,"module=Potentials&action");
		c.getAssigned_To().click();
		wUtil.selectDropDown(driver, c.getAssigned_To_Drp(),2);
		c.getCal().click();
		wUtil.selectDropDown(driver, c.getSales_stage(),9);

		//Without entering mandatory field click on Save button
		c.getOpp_Name().clear();
		c.getClickSave().click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();

		//Verification of Oportunities created
		Assert.assertTrue(opp_Name.contains(c.getOpp_Name().getText()));
	}
	@Test(groups="smokeTest")
	public void CreateOpp_25() throws Throwable
	{
		//Precondition:Organisation should be created
		HomePage hp=new HomePage(driver);
		wUtil.elementToBeClickable(driver, hp.getOrgLink());
		CreateOrganisationPage cop=new CreateOrganisationPage(driver);
		OrganizationsPage o=new OrganizationsPage(driver);
		o.getAddOrg().click();
		String org = eUtil.ReadDataFromExcel("Sheet2",1, 4)+JUtil.generateRandomNum();
		cop.getOrgName().sendKeys(org);
		wUtil.elementToBeClickable(driver, cop.getSaveOrg());
		Thread.sleep(2000);

		//Verification of Organization created
		wUtil.visibilityOfElement(driver, o.getActOrgName());
		Assert.assertTrue(org.contains(o.getActOrgName().getText()));

		//Create New Opportunity
		wUtil.elementToBeClickable(driver, hp.getCreateOpportunity());
		OpportunitiesPage op=new OpportunitiesPage(driver);
		wUtil.elementToBeClickable(driver, op.getClickOpp());

		//Entering Mandatory fields
		CreateNewOpportunity c=new CreateNewOpportunity(driver);
		String opp_Name = eUtil.ReadDataFromExcel("Sheet2",1, 2);
		c.getOpp_Name().sendKeys(opp_Name);
		c.getOrgLookUp().click();
		wUtil.switctToWindow(driver,"module=Accounts&action");
		o.getSearch().sendKeys(org);
		o.getClickSearch().click();
		driver.findElement(By.xpath("//table/tbody/tr/td/a[.='"+org+"']")).click();
		System.out.println(driver.getTitle());
		wUtil.switctToWindow(driver,"module=Potentials&action");
		c.getAssigned_To().click();
		wUtil.selectDropDown(driver, c.getAssigned_To_Drp(),2);
		c.getCal().click();
		wUtil.selectDropDown(driver, c.getSales_stage(),9);
		c.getClickCancel().click();
	}
}

