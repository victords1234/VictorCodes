package com.crm.vtiger;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.objectRepoUtility.HomePage;
import com.vtigercrm.genericutilities.BaseClass;
import com.vtigercrm.genericutilities.CreateProductPage;
import com.vtigercrm.genericutilities.ExcelUtility;
import com.vtigercrm.genericutilities.productsPage;

public class EditingInfoForProduct extends BaseClass{
@Test
public void ProdTC23() throws Throwable
{
	//Navigate to Products PageKNKLKN
	HomePage hp=new HomePage(driver);
	hp.getProductsLink().click();
	productsPage p=new productsPage(driver);
	p.getCreateProd().click();
	
	//Precondition: Product name should be present in List
	String PName = eUtil.ReadDataFromExcel("Sheet3",1,2)+JUtil.generateRandomNum();
	CreateProductPage cp=new CreateProductPage(driver);
	cp.getCreateNewProd().sendKeys(PName);
	cp.getSave().click();
	
	//Verify Product Name
	Thread.sleep(2000);
	Assert.assertTrue(PName.contains(p.getHeaderCheck().getText()));
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
