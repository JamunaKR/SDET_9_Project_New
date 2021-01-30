package com.crm.autodesk.contacttest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.BaseClass;
import com.crm.autodesk.genericlib.ExcelUtility;
import com.crm.autodesk.genericlib.FileUtility;
import com.crm.autodesk.genericlib.JavaUtils;
import com.crm.autodesk.genericlib.WebDriverUtiles;
import com.crm.autodesk.objectrrepositorylib.Contacts;
import com.crm.autodesk.objectrrepositorylib.CreateNewConatct;
import com.crm.autodesk.objectrrepositorylib.CreateNewOrganization;
import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Login;
import com.crm.autodesk.objectrrepositorylib.OrganizationInfo;
import com.crm.autodesk.objectrrepositorylib.Organizations;

/**
 * 
 * @author Deepak
 *
 */
public class CreateContact extends BaseClass{
	/* object  Creation*/
	JavaUtils jLib = new JavaUtils();
	ExcelUtility eLib = new ExcelUtility();

	@Test
	public void createContactWitORgTest() throws Throwable {

		/* Common Data */
		int randomNum = jLib.generateRandomNum();
//		String USERNAME = flib.getPropertyKeyValue("username");
//		String PASSWORD = flib.getPropertyKeyValue("password");
//		String URL = flib.getPropertyKeyValue("url");
//		String BROWSER = flib.getPropertyKeyValue("browser");

		/* test Data */
		String orgName = eLib.getExcelData("contact", "tc_01", "OrgName")+ randomNum;
		String orgType = eLib.getExcelData("contact", "tc_01", "orgType");
		String orgIndustry = eLib.getExcelData("contact", "tc_01", "Industry");
		String orgRating = eLib.getExcelData("contact", "tc_01", "rating");

		String contLastNAme = eLib.getExcelData("contact", "tc_01", "contactName") + randomNum;

		/* step 1 : login to APP */
//		WebDriver driver = null;
//		 if(BROWSER.equalsIgnoreCase("firefox")) {
//		    driver= new FirefoxDriver();  
//		 }else if(BROWSER.equalsIgnoreCase("chrome")) {
//			 driver = new ChromeDriver();
//		 }else if(BROWSER.equalsIgnoreCase("ie")) {
//			 driver = new InternetExplorerDriver();
//		 }
		
//		wlib.waitForHTMLDOM(driver);
//		driver.get(URL);

		/* step 1 : login to APP */
//		  Login lp = new Login(driver);
//		        lp.loginToApp(USERNAME, PASSWORD);

		/* step 2 : navigate to Organization page */
				hp = new Home(driver);
		        hp.getOrgLnk().click();

		/* step 3 : navigate ot create Org Page */
		   Organizations orgPage = new Organizations(driver);
		        orgPage.getCreateOrgImg().click();

		/* step 4 : create new Organization with inductry & type, rating */
		    CreateNewOrganization createOrgPage = new CreateNewOrganization(driver);
		    createOrgPage.creatOrganization(orgName, orgIndustry, orgType, orgRating);
		    
		  /*verify */
		    OrganizationInfo info = new OrganizationInfo(driver);
		    String actSuccessfullMsg = info.getSuccessFullMsg().getText();
		    Assert.assertTrue(actSuccessfullMsg.contains(orgName));

		/* step 5 :  navigate to Contact page */
		    hp.getContactLnk().click();

		/* step 6 : navigate to create Contact page */
		    Contacts cp = new Contacts(driver);
		    cp.getCreateOrgImg().click();

		/* step 7 : creat new Contact with Org */
            CreateNewConatct cnc = new CreateNewConatct(driver);
            cnc.createConatct(contLastNAme, orgName);

		 /* step 8 : verify */
		
		 /* step 9 : logout & close */
//            hp.logout();
//            driver.close();

		 

	}

}
