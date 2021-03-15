package com.vtigercrm.genericutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement createNewProd;
			
			public WebElement getSave() {
		return Save;
	}

			@FindBy(xpath="(//input[@accesskey='S'])[1]")
			private WebElement Save;
			
			public WebElement getCreateNewProd() {
		return createNewProd;
	}

}
