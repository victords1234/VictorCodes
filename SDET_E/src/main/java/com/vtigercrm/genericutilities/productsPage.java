package com.vtigercrm.genericutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productsPage {
			public productsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


			public WebElement getCreateProd() {
				return createProd;
			}
			

			@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement createProd;
			
			@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement headerCheck;

			public WebElement getHeaderCheck() {
				return headerCheck;
			}
}
