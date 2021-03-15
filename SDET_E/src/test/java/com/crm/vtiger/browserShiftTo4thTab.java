package com.crm.vtiger;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browserShiftTo4thTab {
	@Test
	public void Test() throws InterruptedException, Throwable
	{
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
		driver.manage().window().maximize();
		Dimension size2 = driver.manage().window().getSize();
		System.out.println(size2);
		WebElement title = driver.findElement(By.tagName("title"));
		System.out.println(title.getAttribute("textContent"));
		Thread.sleep(2000);
		driver.close();
	}
}
