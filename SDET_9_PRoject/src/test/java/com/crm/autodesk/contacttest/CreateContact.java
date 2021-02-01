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
import com.crm.autodesk.objectrrepositorylib.ContactInfo;
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

	@Test(groups = "smokeTest")
	public void createContactTest() throws Throwable {
        int randomNum = javaLib.generateRandomNum();
		/* test Data */
		String contLastNAme = excelLib.getExcelData("contact", "tc_10", "Contact") + randomNum;

		/* step 2 : navigate to Organization page */
				Home hp = new Home(driver);
				hp.getContactLnk().click();

		/* step 3: navigate to create Contact page */
		    Contacts cp = new Contacts(driver);
		    cp.getCreateOrgImg().click();

		/* step 7 : creat new Contact with Org */
            CreateNewConatct cnc = new CreateNewConatct(driver);
            cnc.createContact(contLastNAme);
            
  		  /*verify */
		    ContactInfo info = new ContactInfo(driver);
		    String actSuccessfullMsg = info.getSuccessFullMSG().getText();
		    Assert.assertTrue(actSuccessfullMsg.contains(contLastNAme));
	}


	@Test(groups = "regressionTest")
	public void createContactWitORgTest() throws Throwable {
        int randomNum = javaLib.generateRandomNum();
		/* test Data */
		String orgName = excelLib.getExcelData("contact", "tc_01", "OrgName")+ randomNum;
		String orgType = excelLib.getExcelData("contact", "tc_01", "orgType");
		String orgIndustry = excelLib.getExcelData("contact", "tc_01", "Industry");
		String orgRating = excelLib.getExcelData("contact", "tc_01", "rating");
		String contLastNAme = excelLib.getExcelData("contact", "tc_01", "contactName") + randomNum;

		/* step 2 : navigate to Organization page */
				Home hp = new Home(driver);
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

  		  /*verify */
		    ContactInfo info1 = new ContactInfo(driver);
		    String actSuccessfullMsg1 = info1.getSuccessFullMSG().getText();
		    Assert.assertTrue(actSuccessfullMsg1.contains(contLastNAme));
	}

}
