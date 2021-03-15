package com.vtigercrm.genericutilities;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	public void waitForElement(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(IConstants.implicitlyWait,TimeUnit.SECONDS);
	}
	public void elementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, IConstants.implicitlyWait);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	public void invisibilityOfElement(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, IConstants.implicitlyWait);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public void visibilityOfElement(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, IConstants.explicitlyWait);
		wait.until(ExpectedConditions.visibilityOf(element)).click();
	}
	public void waitAndClick(WebDriver driver , String xpath) throws Throwable {
		int count = 0;
		while(count < 40) {
			try {
				driver.findElement(By.xpath(xpath)).click();
				break;
			}catch (Throwable e) {
				Thread.sleep(500);
				count++;
			}
		}
	}
	public void waitForAlertToDisplay(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, IConstants.explicitlyWait);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void selectDropDown(WebDriver driver, WebElement element, int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	public void selectDropDownByVal(WebDriver driver, WebElement element, String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	public void selectDropDown(WebDriver driver, WebElement element,  String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	public void switctToFrame(WebDriver driver, WebElement element,  String text, String index)
	{
		driver.switchTo().frame(index);}
	public void switctToFrame(WebDriver driver, WebElement element,  String text)
	{
		driver.switchTo().frame(text);
	}
	public void switctToFrame(WebDriver driver, WebElement element,  String text,int index)
	{
		driver.switchTo().frame(element);
	}
	public void switctToWindow(WebDriver driver, CharSequence partialPageTitle)
	{
		Set<String> windowIds = driver.getWindowHandles();
		for(String window:windowIds)
		{
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.contains(partialPageTitle))
			{
				break;
			}
		}

	}
	public void moveToEle(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	public void RightClick(WebElement element,WebDriver driver )
	{
		Actions act=new Actions(driver);
		act.contextClick(element).build().perform();
	}
	public void dragAndDrop(WebElement element,WebDriver driver, WebElement source, WebElement target )
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(source, target).build().perform();
	}
	public void dragAndDrop(WebElement element,WebDriver driver )
	{
		Actions act=new Actions(driver);
		act.clickAndHold(element).build().perform();
	}
	public void doubleClick(WebElement element,WebDriver driver )
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).build().perform();
	}
	public void scrollToElement(WebElement element,WebDriver driver )
	{
		int y = element.getLocation().getY();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+y+")");
	}
	public String takeScreenShot(WebDriver staticdriver, String method) throws IOException
	{
		JavaUtility jUtil=new JavaUtility();
		TakesScreenshot ts=(TakesScreenshot) staticdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String screenShotPath=System.getProperty("user.dir")+".\\Screenshot"+method+jUtil.getDateandTime()+".png";
		File dst=new File(screenShotPath);
		Files.copy(src, dst);
		return screenShotPath;

	}
	public void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
}
