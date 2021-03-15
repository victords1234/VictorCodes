package com.vtigercrm.genericutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.crm.comcast.objectRepoUtility.HomePage;
import com.crm.comcast.objectRepoUtility.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver staticdriver;
	public FileUtility fUtil=new FileUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public JavaUtility JUtil=new JavaUtility();
	public DataBaseUtility dbUtil=new DataBaseUtility();
	
	@BeforeSuite
	public void Bs()
	{
		System.out.println("--------------DB & Extend Report Confg----------------");
		dbUtil.connectToDB();
	}
	@Parameters("BROWSER")
	@BeforeClass
	public void Bc(String BROWSER) throws Throwable
	{
		System.out.println("------------Launch the Browser-----------------");
		//String browser = fUtil.getPropertyKeyValue("browser");
		String url = fUtil.getPropertyKeyValue("url");
		if(BROWSER.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Invalid Browser");
		}
		staticdriver = driver;
		wUtil.maximizeBrowser(driver);
		wUtil.waitForElement(driver);
		driver.get(url);
	}

	@BeforeMethod
	public void Bm()
	{
		System.out.println("-------------Login--------------------------");
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp();}
	@AfterMethod
	public void Am()
	{
		System.out.println("--------------Logut---------------");
		HomePage hp=new HomePage(driver);
		hp.logout(driver);
	}
	@AfterClass
	public void Ac()
	{
		System.out.println("-----------------Close the Browser------------");
		driver.close();}
	@AfterSuite
	public void As()
	{
		System.out.println("-------------Close DB and Extend Report------------");
		dbUtil.closeDB();
	}
}