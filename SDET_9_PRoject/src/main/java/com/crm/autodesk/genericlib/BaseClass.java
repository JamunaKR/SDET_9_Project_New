package com.crm.autodesk.genericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Login;
/**
 * Base class having all the common test steps required for every testscript
 * @author Nitheesha
 *
 */
public class BaseClass {
	public FileUtility flib=new FileUtility();
	public WebDriverUtiles wlib=new WebDriverUtiles();
	public Login loginPage;
	public Home hp;
	public WebDriver driver;
	@BeforeSuite
	public void configBS() {
		System.out.println("connect to database\n configure extent report");
	}
	@BeforeTest
	public void configBT() {
		//used for cross browser exceution
	}
	/**
	 * Launching the browser in normal mode and entering the url 
	 * @throws Throwable
	 */
	@BeforeClass
	public void configBC() throws Throwable {
		if(flib.getPropertyKeyValue("browser").equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			wlib.waitForHTMLDOM(driver);
			driver.get(flib.getPropertyKeyValue("url"));
		}
	}
	/**
	 * login to Vtiger application
	 * @throws Throwable 
	 */
	@BeforeMethod
	public void configBM() throws Throwable {
		loginPage=new Login(driver);
		loginPage.loginToApp(flib.getPropertyKeyValue("username"),"manager");
	}
	
	
	/**
	 * logout from Vtiger application
	 */
	@AfterMethod
	public void configAM() {
		
		hp.logout();
	}
	
	/**
	 * close the browser
	 */
	@AfterClass
	public void configAC() {
		driver.quit();
	}
	
	@AfterTest
	public void configAT() {
		//close browser launched in cross browser testing
	}
	@AfterSuite
	public void configAS() {
		
		System.out.println("close connection to database\n flush extent report");
		
	}
	
}
