package com.crm.autodesk.producttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.BaseClass;
import com.crm.autodesk.genericlib.ExcelUtility;
import com.crm.autodesk.genericlib.JavaUtils;
import com.crm.autodesk.objectrrepositorylib.CreateNewProduct;
import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.PRoductInfo;
import com.crm.autodesk.objectrrepositorylib.Products;
/**
 * 
 * @author Deepak
 *
 */
public class ProductTest extends BaseClass{

	
	@Test(groups = "smokeTest")
	public void createProductTest() throws Throwable {
		/* test Script data*/
		int randomNum = javaLib.generateRandomNum();
		String productNAme = excelLib.getExcelData("product", 1, 2)+ randomNum;
		
		/* step 2 : navigate to Product Page*/
		Home hp = new Home(driver);
		hp.getProductlnk().click();
		
		/* step 3 : naviagte to Product Page */ 
		Products prod = new Products(driver);
		prod.getCreateProductImg().click();
		
		/* step 4 : create New Product */
		CreateNewProduct cnp = new CreateNewProduct(driver);
		cnp.createProduct(productNAme);
		
		/*step 5 : verify */
		PRoductInfo prodinfo = new PRoductInfo(driver);
		String actVal = prodinfo.getSuccessFullMsg().getText();
		Assert.assertTrue(actVal.contains(productNAme));
		
		/*step 6 : navigate to Product Page */
		hp.getProductlnk().click();
		/*step 7 :  search by product name and verify*/
		prod.serachProduct("Product Name", productNAme);

		driver.findElement(By.linkText(productNAme)).click();
	}
	
	@Test(groups = "regressionTest")
	public void createProductWithUnitPRiceTest() throws Throwable {
		/* test Script data*/
		int randomNum = javaLib.generateRandomNum();
		String productNAme = excelLib.getExcelData("product", 4, 2)+ randomNum;
		String unitPRice = excelLib.getExcelData("product", 4, 3);
		
		/* step 2 : navigate to Product Page*/
		Home hp = new Home(driver);
		hp.getProductlnk().click();
		
		/* step 3 : naviagte to Product Page */ 
		Products prod = new Products(driver);
		prod.getCreateProductImg().click();
		
		/* step 4 : create New Product */
		CreateNewProduct cnp = new CreateNewProduct(driver);
		cnp.createProduct(productNAme, unitPRice);
		
		/*step 5 : verify */
		PRoductInfo prodinfo = new PRoductInfo(driver);
		String actVal = prodinfo.getSuccessFullMsg().getText();
		Assert.assertTrue(actVal.contains(productNAme));
		
	      String actPrice = prodinfo.getActunitPrice().getText();
		  Assert.assertEquals(actPrice, unitPRice);
	
	}

}
